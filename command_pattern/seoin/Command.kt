interface Command {
    fun execute()
}

class NoCommand : Command {
    override fun execute() {}
}

//
// This is the invoker
//
class RemoteControl() {
    var onCommands: Array<Command?>
    var offCommands: Array<Command?>

    init {
        onCommands = arrayOfNulls<Command>(7)
        offCommands = arrayOfNulls<Command>(7)
        val noCommand: Command = NoCommand()
        for (i in 0..6) {
            onCommands[i] = noCommand
            offCommands[i] = noCommand
        }
    }

    fun setCommand(slot: Int, onCommand: Command?, offCommand: Command?) {
        onCommands[slot] = onCommand
        offCommands[slot] = offCommand
    }

    fun onButtonWasPushed(slot: Int) {
        onCommands[slot]?.execute()
    }

    fun offButtonWasPushed(slot: Int) {
        offCommands[slot]?.execute()
    }

    override fun toString(): String {
        val stringBuff = StringBuffer()
        stringBuff.append("\n------ Remote Control -------\n")
        
        // 아래 의존성 추가해야 kotlin reflect 에러 없음
        // runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.6.21")
        for (i in onCommands.indices) {
            stringBuff.append(
                "[slot " + i + "] " + onCommands[i]!!::class +
                    "    " + offCommands[i]!!::class + "\n"
            )
        }
        return stringBuff.toString()
    }
}

class Light(
    val location: String
) {

    fun on() {
        println("$location light is on")
    }

    fun off() {
        println("$location light is off")
    }
}

class LightOnCommand(
    val light: Light
) : Command {
    override fun execute() {
        light.on()
    }
}

class LightOffCommand(
    private var light: Light
) : Command {

    fun lightOff(light: Light) {
        this.light = light
    }

    override fun execute() {
        light.off()
    }
}

class Stereo(
    val location: String
) {
    fun on() {
        println("$location stereo is on")
    }

    fun off() {
        println("$location stereo is off")
    }

    fun setCD() {
        println("$location stereo is set for CD input")
    }

    fun setDVD() {
        println("$location stereo is set for DVD input")
    }

    fun setRadio() {
        println("$location stereo is set for Radio")
    }

    fun setVolume(volume: Int) {
        // code to set the volume
        // valid range: 1-11 (after all 11 is better than 10, right?)
        println("$location stereo volume set to $volume")
    }
}

class StereoOnWithCDCommand(
    private var stereo: Stereo
) : Command {

    override fun execute() {
        stereo.on()
        stereo.setCD()
        stereo.setVolume(11)
    }
}

class StereoOffCommand(
    val stereo: Stereo
) : Command {
    override fun execute() {
        stereo.off()
    }
}

fun main() {
    val remoteControl = RemoteControl()
    val livingRoomLight = Light("Living Room")
    val stereo = Stereo("Living Room")
    val livingRoomLightOn = LightOnCommand(livingRoomLight)
    val livingRoomLightOff = LightOffCommand(livingRoomLight)
    val stereoOnWithCD = StereoOnWithCDCommand(stereo)

    val stereoOff = StereoOffCommand(stereo)
    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff)
    remoteControl.setCommand(3, stereoOnWithCD, stereoOff)

    println(remoteControl)
    remoteControl.onButtonWasPushed(0)
    remoteControl.offButtonWasPushed(0)
    remoteControl.onButtonWasPushed(1)
    remoteControl.offButtonWasPushed(1)
    remoteControl.onButtonWasPushed(2)
    remoteControl.offButtonWasPushed(2)
    remoteControl.onButtonWasPushed(3)
    remoteControl.offButtonWasPushed(3)
}
