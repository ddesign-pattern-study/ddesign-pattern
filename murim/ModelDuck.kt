class ModelDuck : DynamicDuck() {

    fun ModelDuck(){
        flyBehavior = FlyNoWay()
        quackBehavior = Quack()
    }
    override fun display(){
        println("저는 가짜오리")
    }
}