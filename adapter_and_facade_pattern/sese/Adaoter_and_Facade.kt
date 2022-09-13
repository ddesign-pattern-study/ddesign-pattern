/**
 * Adapter Pattern
 * 한 클래스의 인터페이스를 클라이언트에서 사용하려는 다른 인터페이스로 변환
 * Adapter 를 이용해 인터페이스 호환성 문제를 해결해 같이 쓸 수 없는 클래스들을 연결해 사용
 *
 * 용어정리
 * Target : 내가 사용하려고 하는 대상
 * Adapter : 내 의사와 관계 없이 제공 받은 대상
 *
 * 2가지 종류
 * 1) 객체 Adapter : Composition 을 사용
 * Adapter 뿐만 아니라 그 서브 클래스에 대해서도 Adapter 역할을 할 수 있다
 *
 * 2) Class Adapter : 다중 상속 사용(자바에서는 적용할 수 없음)
 * Adaptee 전체를 다시 구현하지 않아도 된다
 * Adaptee 행동을 오버라이드 할 수 있다.
 * 단, 특정 Adaptee 클래스에서만 적용된다는 단점이 있다.
 *
 * */

interface Duck {
    fun quack()
    fun fly()
}

// Duck 를 구현한 MallardDuck 클래스.
class MallardDuck(
    val duck: Duck
) : Duck {
    override fun quack() {
        println("Quack")
    }

    override fun fly() {
        println("I'm flying")
    }
}

// Adaptee 인터페이스. Duck 와 다른 메소드를 사용함.
interface Turkey {
    fun gobble()
    fun fly()
}

class WildTurkey : Turkey {
    override fun gobble() {
        println("Gobble gobble")
    }

    override fun fly() {
        println("I'm flying a short distance")
    }
}

// Adapter 클래스. turkey 객체를 Duck 객체로 변환.
class TurkeyAdapter(
    private val turkey: Turkey
) : Duck {

    override fun quack() {
        turkey.gobble()
    }

    override fun fly() {
        for (i in 0..5) {
            turkey.fly()
        }
    }
}

/**
 * Facade Pattern
 * 인터페이스를 단순화시키기 위해 인터페이스를 변경
 * (하나 이상의 클래스)의 복잡한 인터페이스를 깔끔하게 Facade 로 덮는 느낌
 *
 * 어떤 서브시스템의 일련의 인터페이스에 대한 통합된 인터페이스를 제공
 * Facade 에서 고수준 인터페이스를 정의하기 때문에 서브시스템을 더 쉽게 사용할 수 있다.
 *
 * */
class Amplifier() {
    fun on() {
        println("amplifier on")
    }

    fun setDvd(dvd: String) {
        println("select : $dvd")
    }

    fun setSurroundSound() {
        println("amplifier set surround sound mode")
    }

    fun setVolume(volume: Int) {
        println("amp set volume : $volume")
    }

    fun off() {
        println("amp off")
    }
}

class Tuner()
class DvdPlayer() {
    fun on() {
        println("Dvd Player on")
    }

    fun play(movie: String) {
        println("Dvd Player playing $movie")
    }

    fun stop() {
        println("Dvd Player stop")
    }

    fun eject() {
        println("Dvd Player eject")
    }

    fun off() {
        println("Dvd Player off")
    }
}

class CdPlayer()
class Projector() {
    fun on() {
        println("Projector on")
    }

    fun wideScreenMode() {
        println("Projector Wide Screen Mode")
    }

    fun off() {
        println("Projector off")
    }
}

class TheaterLights() {
    fun dim(num: Int) {
        println("light dim $num")
    }

    fun on() {
        println("light on")
    }
}

class Screen() {
    fun down() {
        println("Screen down")
    }

    fun up() {
        println("Screen up")
    }
}

class PopcornPopper() {
    fun on() {
        println("poper on")
    }

    fun pop() {
        println("poper pop")
    }

    fun off() {
        println("poper off")
    }
}

class HomeTheaterFacade(
    private val amp: Amplifier,
    private val tuner: Tuner,
    private val dvd: DvdPlayer,
    private val cd: CdPlayer,
    private val projector: Projector,
    private val lights: TheaterLights,
    private val screen: Screen,
    private val popper: PopcornPopper
) {

    fun watchMovie(movie: String) {
        println("Get ready to watch a movie...")
        popper.on()
        popper.pop()
        lights.dim(10)
        screen.down()
        projector.on()
        projector.wideScreenMode()
        amp.on()
        amp.setDvd(movie)
        amp.setSurroundSound()
        amp.setVolume(5)
        dvd.on()
        dvd.play(movie)
    }

    fun endMovie() {
        println("Shutting movie theater down...")
        popper.off()
        lights.on()
        screen.up()
        projector.off()
        amp.off()
        dvd.stop()
        dvd.eject()
        dvd.off()
    }
}

fun main() {
    // Adapter
    println("===================Adapter=====================")
    val wildTurkey = WildTurkey()

    wildTurkey.fly()
    wildTurkey.gobble()

    val duckFromTurkey = TurkeyAdapter(wildTurkey)

    duckFromTurkey.fly()
    duckFromTurkey.quack()

    val mallardDuck = MallardDuck(duckFromTurkey)

    mallardDuck.fly()
    mallardDuck.quack()

    println("===================Facade=====================")
    // Facade
    val homeTheater = HomeTheaterFacade(
        amp = Amplifier(),
        tuner = Tuner(),
        dvd = DvdPlayer(),
        cd = CdPlayer(),
        projector = Projector(),
        screen = Screen(),
        lights = TheaterLights(),
        popper = PopcornPopper()
    )
    homeTheater.watchMovie("Radiers of the Lost Ark")
    homeTheater.endMovie()
}
