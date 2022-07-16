abstract class Duck : QuackBehavior, FlyBehavior {

    fun Duck() {
    }

    abstract fun display()

    fun performFly() {
        fly()
    }

    fun performQuack() {
        quack()
    }

    fun swim() {
        println("오리는 물에 뜬다. 진짜 오리, 러버덕 둘 다..")
    }
}