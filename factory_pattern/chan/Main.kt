fun main() {
    val s :PhoneCorporation = SamsungGalaxySFactory()
    s.orderSmartPhones(4).firstOrNull()?.takePicture()
    println()
    val i :PhoneCorporation = AppleProFactory()
    i.orderSmartPhones(2).firstOrNull()?.sendMessage()
}