class MallardDuck : Duck() {

    fun MallardDuck(){
        var quickBehavior = quack()
        var flyBehavior = flyWithWings()
    }

    override fun display(){
        println("저는 물오리")
    }
}