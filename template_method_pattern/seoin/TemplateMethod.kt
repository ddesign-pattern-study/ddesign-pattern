import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

class TemplateMethod {
}


abstract class CaffeineBeverage {
    // prepareRecipe 가 음료를 준비하는 알고리즘의 템플릿 메소드
    // 어떤 메소드는 서브 클래스로, 서브 클래스에서 구현해야 하는 경우는 메소드를 abstract 로 선언함
    // 추상 메서드 : 서브 클래스가 알고리즘의 특정 단계를 꼭 제공해야 할 때
    fun prepareRecipe() {
        boilWater() // 물 끓이기
        brew() // 우리기
        pourInCup() // 컵에 붓기
        addCondiments() // 첨가물 넣기

        if (customerWantsCondiments()) {
            addCondiments()
        }
    }

    abstract fun brew()
    abstract fun addCondiments()

    fun boilWater() {
        println("물 끓이는 중")
    }

    fun pourInCup() {
        println("컵에 따르는 중")
    }

    // hook : 서브 클래스가 알고리즘의 특정 단계를 선택적으로 제공할 때
    // 추상 클래스에 선언된, 아무 코드도 들어가지 않은 메소드
    // 필요한 경우에만 구현 클래스에서 오버라이드해 수정한다.
    fun hook() {}

    // 손님이 첨가물을 넣어 달라고 했을 때만 (customerWantsCondiments 가 true 를 리턴할 때만) 첨가물을 추가하도록 코드를 수정
    // 필요한 경우에만 서브클래스에서 오버라이드해 첨가물을 추가할지 여부를 입력받는 코드로 수정하여 사용할 수 있다.
    open fun customerWantsCondiments(): Boolean {
        return false
    }
}

class Coffee : CaffeineBeverage() {
    override fun brew() {
        println("커피 우리는 중")
    }

    override fun addCondiments() {
        println("설탕과 커피를 추가하는 중")
    }

}


class CoffeeWithHook : CaffeineBeverage() {
    override fun brew() {
        println("커피 우리는 중")
    }

    override fun addCondiments() {
        println("설탕과 커피를 추가하는 중")
    }

    override fun customerWantsCondiments(): Boolean {
        val answer = userInput
        return answer.lowercase(Locale.getDefault()).startsWith("y")
    }

    val userInput: String
        get() {
            var answer: String? = null
            println("커피에 우유와 설탕을 넣어 드릴까요? (y/n)? ")
            val `in` = BufferedReader(InputStreamReader(System.`in`))
            try {
                answer = `in`.readLine()
            } catch (ioe: IOException) {
                println("입력 오류")
            }
            return answer ?: "no"
        }
}


class Tea : CaffeineBeverage() {
    override fun brew() {
        println("차를 우리는 중")
    }

    override fun addCondiments() {
        println("레몬을 추가하는 중")
    }
}

class TeaWithHook : CaffeineBeverage() {
    override fun brew() {
        println("차를 우리는 중")
    }

    override fun addCondiments() {
        println("레몬을 추가하는 중")
    }

    override fun customerWantsCondiments(): Boolean {
        val answer = userInput
        return answer.lowercase(Locale.getDefault()).startsWith("y")
    }

    val userInput: String
        get() {
            var answer: String? = null
            println("커피에 우유와 설탕을 넣어 드릴까요? (y/n)? ")
            val `in` = BufferedReader(InputStreamReader(System.`in`))
            try {
                answer = `in`.readLine()
            } catch (ioe: IOException) {
                println("입력 오류")
            }
            return answer ?: "no"
        }
}


fun main() {
    val tea = Tea()
    val coffee = Coffee()
    println("\nMaking tea...")

    tea.prepareRecipe()

    println("\nMaking coffee...")

    coffee.prepareRecipe()

    val teaHook = TeaWithHook()
    val coffeeHook = CoffeeWithHook()

    println("\nMaking tea...")
    teaHook.prepareRecipe()
    println("\nMaking coffee...")
    coffeeHook.prepareRecipe()
}