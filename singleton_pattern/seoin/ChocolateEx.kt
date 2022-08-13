class ChocolateBoiler private constructor() {
    var isEmpty = true
        private set
    var isBoiled = false
        private set

    fun fill() {
				println("fill")
        if (isEmpty) {
            isEmpty = false
            isBoiled = false
        }
    }

    fun drain() {
				println("drain")
        if (isEmpty.not() && isBoiled) {
            isEmpty = true
        }
    }

    fun boil() {
				println("boil")
        if (isEmpty.not() && isBoiled.not()) {
            isBoiled = true
        }
    }

    companion object {
        private var uniqueInstance: ChocolateBoiler? = null
        fun getInstance(): ChocolateBoiler {
            if (uniqueInstance == null) {
                println("Chocolate Boiler의 uniqueInstance 만들기")
                uniqueInstance = ChocolateBoiler()
            }
            println("Chocolate Boiler의 인스턴스 반환")
            return uniqueInstance as ChocolateBoiler
        }
    }
}

fun main() {
    val boiler: ChocolateBoiler = ChocolateBoiler.getInstance()
    boiler.fill()
    boiler.boil()
    boiler.drain()

    // 이미 존재하는 인스턴스를 반환함
    val boiler2: ChocolateBoiler = ChocolateBoiler.getInstance()
}