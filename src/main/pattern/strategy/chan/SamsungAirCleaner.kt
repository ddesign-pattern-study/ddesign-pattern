package pattern.strategy.chan

import pattern.strategy.chan.filter.AbstractFilter
import pattern.strategy.chan.filter.DeodorizationFilter
import pattern.strategy.chan.filter.FineDustFilter
import pattern.strategy.chan.filter.UltrafineDustFilter
import pattern.strategy.chan.humidifier.AbstractDehumidifier
import pattern.strategy.chan.humidifier.AbstractHumidifier
import pattern.strategy.chan.humidifier.HighGradeDehumidifier
import pattern.strategy.chan.humidifier.HighGradeHumidifier
import pattern.strategy.chan.notifier.AbstractNotifier
import pattern.strategy.chan.notifier.HumidityNotifier

class SamsungAirCleaner : AbstractAirCleaner() {

    override val modelName: String = "삼성 공기청정기"
    override val filters: MutableList<AbstractFilter> =
        mutableListOf(
            FineDustFilter(),
            UltrafineDustFilter(),
            DeodorizationFilter()
        )
    override val dehumidifier: AbstractDehumidifier = HighGradeDehumidifier()
    override val humidifier: AbstractHumidifier = HighGradeHumidifier()
    override val notifier: AbstractNotifier = HumidityNotifier()

}