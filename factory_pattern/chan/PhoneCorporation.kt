abstract class PhoneCorporation {

    fun orderSmartPhones(count: Int): List<SmartPhone> =
        getFactory()
            .supply(count)
            .also {
                if(it.isNotEmpty())
                    println("${it[0].corpName()} ${it.size} 개 공급")
            }

    protected abstract fun getFactory(): PhoneFactory

}

abstract class PhoneFactory : PhoneCorporation() {
    private fun make(count: Int): List<SmartPhone> {
        setPart()
        manufacture()
        inspect()
        test()
        return take(count)
    }

    open fun supply(count: Int): List<SmartPhone> = make(count)

    abstract fun setPart()
    abstract fun manufacture()
    abstract fun inspect()
    abstract fun test()
    abstract fun take(count: Int): List<SmartPhone>
}

class SamsungGalaxySFactory : PhoneFactory() {
    override fun setPart() {
        println("Galaxy S 시리즈 부품 세팅")
        val parts: PhonePartFactoryType = SamsungFactoryType.SERIES_S
        println(
            parts.partFactory.getPartInfo()
        )

    }
    override fun manufacture() { println("S 시리즈 제조 공정") }
    override fun inspect() { println("제품 검수") }
    override fun test() { println("테스트") }
    override fun take(count: Int): List<SmartPhone> =
        (1..count).map { SamsungPhone() }

    override fun getFactory(): PhoneFactory = PhoneCorporationType.SAMSUNG_S.factory
}

class AppleProFactory : PhoneFactory() {
    override fun setPart() {
        println("IPhone Pro 시리즈 부품 세팅")
        val parts: PhonePartFactoryType = AppleFactoryType.SERIES_PRO
        println(
            parts.partFactory.getPartInfo()
        )
    }
    override fun manufacture() { println("Pro 시리즈 제조 공정") }
    override fun inspect() { println("제품 검수") }
    override fun test() { println("테스트") }
    override fun take(count: Int): List<SmartPhone> =
        (1..count).map { ApplePhone() }

    override fun getFactory(): PhoneFactory = PhoneCorporationType.APPLE_PRO_MAX.factory
}

interface PhoneFactoryType {
    val factory: PhoneFactory
}

enum class PhoneCorporationType(override val factory: PhoneFactory) : PhoneFactoryType {
    SAMSUNG_S(SamsungGalaxySFactory()),
    SAMSUNG_FOLD(SamsungGalaxySFactory()),
    APPLE_PRO(AppleProFactory()),
    APPLE_PRO_MAX(AppleProFactory());
}

interface PhonePartFactory {
    fun factoryName(): String
    fun ap(): Ap
    fun display(): Display
    fun os(): Os
    fun getPartInfo(): String =
        """
            |   - ${ap().getHardwareInfo()}
            |   - ${display().getHardwareInfo()}
            |   - ${os().getSoftwareInfo()}
            """.trimMargin("|")
}

interface PhonePartFactoryType {
    val partFactory: PhonePartFactory
}

enum class SamsungFactoryType(override val partFactory: PhonePartFactory) : PhonePartFactoryType {
    SERIES_S(GalaxySFactory()),
    SERIES_FOLD(GalaxyFoldFactory())
}

class GalaxySFactory : PhonePartFactory {
    override fun factoryName(): String = "갤럭시 S 시리즈 부품 공장"
    override fun ap(): Ap = Exynos()
    override fun display(): Display = SamsumDisplay()
    override fun os(): Os = Kitkat()
}

class GalaxyFoldFactory : PhonePartFactory {
    override fun factoryName(): String = "갤럭시 Fold 시리즈 부품 공장"
    override fun ap(): Ap = Snapdragon()
    override fun display(): Display = SamsumDisplay()
    override fun os(): Os = Lollipop()
}

enum class AppleFactoryType(override val partFactory: PhonePartFactory) : PhonePartFactoryType {
    SERIES_PRO(IPhonePro()),
    SERIES_PRO_MAX(IPhoneProMax())
}

class IPhonePro : PhonePartFactory {
    override fun factoryName(): String = "아이폰 Pro 시리즈 부품 공장"
    override fun ap(): Ap = AppleSilicon()
    override fun display(): Display = LgDisplay()
    override fun os(): Os = Ios5()
}

class IPhoneProMax : PhonePartFactory {
    override fun factoryName(): String = "아이폰 Pro Max 시리즈 부품 공장"
    override fun ap(): Ap = AppleSilicon()
    override fun display(): Display = LgDisplay()
    override fun os(): Os = Ios5()
}