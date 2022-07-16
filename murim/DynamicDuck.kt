abstract class DynamicDuck {
    lateinit var flyBehavior: FlyBehavior
    lateinit var quackBehavior: QuackBehavior

    fun Duck() {
    }

    abstract fun display()

    fun performFly() {
        flyBehavior.fly()
    }

    fun performQuack() {
        quackBehavior.quack()
    }

    fun swim() {
        println("오리는 물에 뜬다. 진짜 오리, 러버덕 둘 다..")
    }

    fun setFlyInterface(flyBehavior: FlyBehavior){
        this.flyBehavior = flyBehavior
    }

    fun setQuackInterface(quackBehavior: QuackBehavior){
        this.quackBehavior = quackBehavior
    }
}