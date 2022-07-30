
abstract class Beverage {
    abstract fun getDescription(): String
    abstract fun cost(): Double
}

abstract class CondimentDecorator() : Beverage() {
    abstract fun addCoffeeSyrup(): String
    abstract fun addCost(): Double
}

class Espresso : Beverage() {
    override fun getDescription(): String = "에스프레소"
    override fun cost(): Double = 1.99
}

class HouseBlend : Beverage() {
    override fun getDescription(): String = "하우스 블렌드 커피"
    override fun cost(): Double = .89
}

class HazelNutSyrup(
    private val beverage: Beverage
) : CondimentDecorator() {
    override fun addCoffeeSyrup(): String = " with 헤이즐넛 시럽 &"
    override fun addCost(): Double = .20

    override fun getDescription(): String = beverage.getDescription() + addCoffeeSyrup()
    override fun cost(): Double = beverage.cost() + addCost()
}

class VanillaSyrup(
    private val beverage: Beverage
) : CondimentDecorator() {
    override fun addCoffeeSyrup(): String = " with 바닐라 시럽 &"
    override fun addCost(): Double = .5

    override fun getDescription(): String = beverage.getDescription() + addCoffeeSyrup()
    override fun cost(): Double = beverage.cost() + addCost()
}

fun main() {
    val espressoWithVanillaSyrup: Beverage = VanillaSyrup(Espresso())
    println("${espressoWithVanillaSyrup.getDescription().trimEnd('&')} $${espressoWithVanillaSyrup.cost()}")

    val houseBlendWithHazelNutAndVanillaSyrup: Beverage = VanillaSyrup(HazelNutSyrup(HouseBlend()))
    println("${houseBlendWithHazelNutAndVanillaSyrup.getDescription().trimEnd('&')} $${houseBlendWithHazelNutAndVanillaSyrup.cost()}")
}
