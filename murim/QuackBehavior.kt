interface QuackBehavior {
    fun quack() {
        println("quack")
    }

    fun squeak() {
        println("squeak")
    }

    fun muteQuack() {
        println("muteQuack")
    }
}

class Quack : QuackBehavior {
    override fun quack() {
        println("꽉")
    }
}

class MuteQuack : QuackBehavior {
    override fun quack() {
        println("뮤트")
    }
}

class Squeck : QuackBehavior {
    override fun quack() {
        println("삑")
    }
}