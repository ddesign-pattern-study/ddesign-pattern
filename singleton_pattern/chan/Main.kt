import kotlin.concurrent.thread

infix fun Log.addLog(other: String) =
    this.addLog(other)

class Log {
    private var log: String = ""
    fun addLog(str: String) {
        log += str
    }
    fun printLog() {
        println(log)
        log = ""
    }
}

object Chocolate {

    private var empty: Boolean = true
        // @Synchronized 동시성 문제를 해결하기 위해서는 상황에 맞춰 필요한 스코프에서 sync 를 제어해야함
        // 함수 레벨에서 sync 를 걸어주거나 사용하는 property 레벨에서 걸어줘도 됨
        @Synchronized get() {
            log.get() addLog "\n\t초콜릿이 채워져있는가? ${if (!field) "네" else "아니오"}"
            return field
        }
        @Synchronized set
    private var boiled: Boolean = false
        get() {
            log.get() addLog "\n\t물이 끓고 있는가? ${if (field) "네" else "아니오"}"
            return field
        }
    private val log = ThreadLocal.withInitial(::Log) // thread local object

    // @Synchronized
    fun fill(threadInfo: String) {
        // synchronized(this) {
            log.get() addLog threadInfo
            log.get() addLog "\n\t< 재료 채우기 >"
            if (empty) {
                empty = false
                boiled = false
            }
            log.get().printLog()
        // }
    }

    fun drain(threadInfo: String) {
        log.get() addLog threadInfo
        log.get() addLog "\n\t< 초콜릿 비우기 >"
        if (!empty && boiled) {
            empty = true
        }
        log.get().printLog()
    }

    fun boil(threadInfo: String) {
        log.get() addLog threadInfo
        log.get() addLog "\n\t< 물 끓이기 >"
        if (!empty && !boiled) {
            boiled = true
        }
        log.get().printLog()
    }

}

class ChocolateNotObject private constructor(){

    private var empty: Boolean = true
        get() {
            log.get() addLog "\n\t초콜릿이 채워져있는가? ${if (!field) "네" else "아니오"}"
            return field
        }
    private var boiled: Boolean = false
        get() {
            log.get() addLog "\n\t물이 끓고 있는가? ${if (field) "네" else "아니오"}"
            return field
        }

    companion object {
        private val log = ThreadLocal.withInitial(::Log) // thread local object
        private lateinit var INSTANCE: ChocolateNotObject
        fun getInstance() : ChocolateNotObject =
            if(::INSTANCE.isInitialized.not()) {
                INSTANCE = ChocolateNotObject()
                INSTANCE
            } else
                INSTANCE
    }

    fun fill(threadInfo: String) {
        log.get() addLog threadInfo
        log.get() addLog "\n\t< 재료 채우기 >"
        if (empty) {
            empty = false
            boiled = false
        }
        log.get().printLog()
    }

    fun drain(threadInfo: String) {
        log.get() addLog threadInfo
        log.get() addLog "\n\t< 초콜릿 비우기 >"
        if (!empty && boiled) {
            empty = true
        }
        log.get().printLog()
    }

    fun boil(threadInfo: String) {
        log.get() addLog threadInfo
        log.get() addLog "\n\t< 물 끓이기 >"
        if (!empty && !boiled) {
            boiled = true
        }
        log.get().printLog()
    }

}

fun main() {
    // 싱글톤 패턴이라 하더라도 락이 걸려있지 않으면 초콜릿이 채워져 있지 않는 경우가 2번 이상 발생할 수 있다.
    // 즉, 생성은 한번만 되더라도 변수를 사용할 경우에 똑같은 동시성 문제가 생기게 된다.
    for (i in 0..100)
        thread(start = true) { // 동시성에대한 처리가 되어있어 초콜릿이 채워져있지 않는 경우가 딱 1번만 발생한다
            Chocolate.fill("Thread [$i]")
        }

    Thread.sleep(50)
    println("-----------------------------------------------------------------------------------------------------------------------------")
    println("-----------------------------------------------------------------------------------------------------------------------------")
    println("-----------------------------------------------------------------------------------------------------------------------------")
    println("-----------------------------------------------------------------------------------------------------------------------------")
//    // 확실히 일반 for 문에 비해 stream 은 아니오가 2번 이상 나오는 케이스가 별로 없다..! (느린게 체감이 되네요)
    (0..100).forEach { i ->
        thread(start = true) { // 동시성에 대한 처리가 되어있지 않아 초콜릿이 채워져있지 않는 경우가 2번 이상 발생할 수 있다.
            ChocolateNotObject.getInstance().fill("Thread Not Object [$i]")
        }
    }
}