class MiniDuckSimulator {

    fun main(){
        val mallardDuck = MallardDuck()
        mallardDuck.performQuack()
        mallardDuck.performFly()

        val modelDuck = ModelDuck()
        modelDuck.setFlyInterface(FlyNoWay())
        modelDuck.performFly()
        modelDuck.setFlyInterface(FlyRocketPowered())
        modelDuck.performFly()
    }
}