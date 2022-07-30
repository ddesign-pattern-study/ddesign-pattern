interface Beverage {
    val description: String
    fun cost(): Double
}

open class CondimentDecorator(
    private val beverage: Beverage
) : Beverage by beverage {
    override val description: String = beverage.description

    override fun cost(): Double {
        return beverage.cost()
    }
}

class Espresso(
    override val description: String = "에스프레소"
) : Beverage {

    override fun cost(): Double {
        return 1.99
    }
}

class HouseBlend(
    override val description: String = "하우스 블렌드 커피"
) : Beverage {

    override fun cost(): Double {
        return .89
    }
}

class Mocha(
    beverage: Beverage
) : CondimentDecorator(beverage) {

    override val description: String = getDescriptions()

    private fun getDescriptions(): String {
        return super.description + ", 모카"
    }

    override fun cost(): Double {
        return super.cost() + .20
    }
}

class Whip(
    beverage: Beverage
) : CondimentDecorator(beverage) {

    override val description: String = getDescriptions()

    private fun getDescriptions(): String {
        return super.description + ", 휘핑"
    }

    override fun cost(): Double {
        return super.cost() + .5
    }
}

fun main() {
    val beverage: Beverage = Espresso()
    println("${beverage.description} $${beverage.cost()}")

    var beverage2: Beverage = HouseBlend()
    beverage2 = Mocha(beverage2)
    beverage2 = Mocha(beverage2)
    beverage2 = Whip(beverage2)
    println("${beverage2.description} $${beverage2.cost()}")
}
