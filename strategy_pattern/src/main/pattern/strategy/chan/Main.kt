package pattern.strategy.chan

import pattern.strategy.chan.filter.DeodorizationFilter

fun main() {

    val air = Air()
    val cowayAirCleaner = CowayAirCleaner()
    cowayAirCleaner.turnOn(air)
    cowayAirCleaner.cleanerNotify()

    val lgAirCleaner = LGAirCleaner()
    lgAirCleaner.turnOn(air)
    lgAirCleaner.cleanerNotify()

    val samsumAirCleaner = SamsungAirCleaner()
    samsumAirCleaner.turnOn(air)
    samsumAirCleaner.cleanerNotify()
    samsumAirCleaner.replaceFilter(
        DeodorizationFilter()
    )

}