abstract class Character(
    private var weaponBehavior: WeaponBehavior
) {
    open fun fight() {}

    fun useWeapon() {
        weaponBehavior.useWeapon()
    }

    fun setWeapon(w: WeaponBehavior) {
        weaponBehavior = w
    }
}

class Queen() : Character(
    weaponBehavior = AxeBehavior()
) {
    override fun fight() {
        println("queen")
    }
}

interface WeaponBehavior {
    fun useWeapon() {}
}

class AxeBehavior() : WeaponBehavior {
    override fun useWeapon() {
        println("this is axe")
    }
}

class SwordBehavior() : WeaponBehavior {
    override fun useWeapon() {
        println("this is sword")
    }
}

class KnifeBehavior() : WeaponBehavior {
    override fun useWeapon() {
        println("this is knife")
    }
}

class BowAndArrowBehavior() : WeaponBehavior {
    override fun useWeapon() {
        println("this is bow and arrow")
    }
}

fun main() {
    val queen = Queen()
    queen.fight()
    queen.useWeapon()
    queen.setWeapon(KnifeBehavior())
    queen.useWeapon()
}
