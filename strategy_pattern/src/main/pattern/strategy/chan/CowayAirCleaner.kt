package pattern.strategy.chan

import pattern.strategy.chan.filter.AbstractFilter
import pattern.strategy.chan.filter.FineDustFilter
import pattern.strategy.chan.humidifier.AbstractDehumidifier
import pattern.strategy.chan.humidifier.AbstractHumidifier
import pattern.strategy.chan.humidifier.LowGradeDehumidifier
import pattern.strategy.chan.humidifier.LowGradeHumidifier
import pattern.strategy.chan.notifier.AbstractNotifier
import pattern.strategy.chan.notifier.NoneNotifier

class CowayAirCleaner : AbstractAirCleaner() {

    override val modelName: String = "웅진 코웨이 공기청정기"
    override val filters: MutableList<AbstractFilter> = mutableListOf(FineDustFilter())
    override val dehumidifier: AbstractDehumidifier = LowGradeDehumidifier()
    override val humidifier: AbstractHumidifier = LowGradeHumidifier()
    override val notifier: AbstractNotifier = NoneNotifier()

}