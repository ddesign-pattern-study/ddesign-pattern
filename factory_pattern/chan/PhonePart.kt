interface Part {
    val name: String
    fun operate()
}

interface HardwarePart : Part {
    val hardwareNo: String
    fun getHardwareInfo() = "$name [${hardwareNo}]"

}

abstract class Ap : HardwarePart {
    override fun operate() {
        println("프로세싱")
    }
}

class Snapdragon : Ap() {
    override val name: String = "퀄컴 스냅드래곤"
    override val hardwareNo: String = "Q01"
}

class Exynos : Ap() {
    override val name: String = "삼성 엑시노스"
    override val hardwareNo: String = "S01"
}

class AppleSilicon : Ap() {
    override val name: String = "애플 실리콘"
    override val hardwareNo: String = "A01"
}

abstract class Display : HardwarePart {
    override fun operate() {
        println("디스플레이")
    }
}

class LgDisplay : Display() {
    override val name: String = "LG 디스플레이"
    override val hardwareNo: String = "L01"
}

class SamsumDisplay : Display() {
    override val name: String = "삼성 디스플레이"
    override val hardwareNo: String = "S01"
}

interface SoftwarePart : Part {
    val softwareVersion: String
    fun getSoftwareInfo() = "$name [${softwareVersion}]"
}

abstract class Os : SoftwarePart

abstract class Aos : Os() {
    override fun operate() {
        println("안드로이드")
    }
}

class Kitkat : Aos() {
    override val name: String = "킷캣"
    override val softwareVersion: String = "4.4"
}

class Lollipop : Aos() {
    override val name: String = "롤리팝"
    override val softwareVersion: String = "5.0"
}

abstract class Ios : Os() {
    override fun operate() {
        println("ios")
    }
}

class Ios5 : Ios() {
    override val name: String = "ios"
    override val softwareVersion: String = "5.0"
}