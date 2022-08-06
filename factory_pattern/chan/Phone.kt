interface Phone {
    fun call() { println("<< call >>") }
}

interface MobilePhone : Phone {
    fun takePicture()  { println("<< 사진 촬영 >>") }
    fun setAlarm() { println("<< 알람 >>") }
    fun sendMessage() { println("<< 메세지 전송 >>") }
    fun useInternet() { println("<< 인터넷 사용 >>") }
}

interface SmartPhone : MobilePhone {
    fun useThirdPartyApp() { println("<< 인터넷 사용 >>") }
    fun corpName(): String
}

class SamsungPhone : SmartPhone {
    override fun corpName(): String = "삼성폰"
}

class ApplePhone : SmartPhone {
    override fun corpName(): String = "애플폰"
}