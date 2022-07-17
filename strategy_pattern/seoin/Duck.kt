abstract class Duck(
    var flyBehavior: FlyBehavior,
    var quackBehavior: QuackBehavior
) {
    open fun display() {}

    fun swim() {
        println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠.")
    }

    fun performQuack() {
        quackBehavior.quack() // quackBehavior 로 참조되는 객체에 그 행동 위임
    }

    fun performFly() {
        flyBehavior.fly()
    }

    @JvmName("setFlyBehavior1")
    fun setFlyBehavior(fb: FlyBehavior) {
        flyBehavior = fb
    }

    @JvmName("setQuackBehavior1")
    fun setQuackBehavior(qb: QuackBehavior) {
        quackBehavior = qb
    }
}

class MallardDuck() : Duck(
    quackBehavior = Quack(),
    flyBehavior = FlyWithWings()
) {
    override fun display() {
        println("저는 물오리입니다.")
    }
}

class ModelDuck() : Duck(
    flyBehavior = FlyNoWay(),
    quackBehavior = Quack()
) {
    override fun display() {
        println("저는 모형 오리입니다")
    }
}

interface FlyBehavior {
    fun fly() {}
}

interface QuackBehavior {
    fun quack() {}
}

class FlyWithWings() : FlyBehavior {
    override fun fly() {
        println("날고 있어요 !")
    }
}

class FlyNoWay() : FlyBehavior {
    override fun fly() {
        println("저는 못 날아요!")
    }
}

class FlyRocketPowered() : FlyBehavior {
    override fun fly() {
        println("로켓 추진으로 날아갑니다.")
    }
}

class Quack() : QuackBehavior {
    override fun quack() {
        println("꽥")
    }
}

class MuteQuack() : QuackBehavior {
    override fun quack() {
        println("<< 조용 ~ >>")
    }
}

class Squeak() : QuackBehavior {
    override fun quack() {
        println("삑")
    }
}

fun main() {
    val mallard: Duck = MallardDuck()
    mallard.performQuack()
    mallard.performFly()

    val model: Duck = ModelDuck()
    model.performFly()
    model.setFlyBehavior(FlyRocketPowered())
    model.performFly()
}
