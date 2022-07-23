import filter.AbstractFilter
import filter.FineDustFilter
import humidifier.AbstractDehumidifier
import humidifier.AbstractHumidifier
import humidifier.LowGradeDehumidifier
import humidifier.LowGradeHumidifier
import notifier.AbstractNotifier
import notifier.NoneNotifier

class CowayAirCleaner : AbstractAirCleaner() {

    override val modelName: String = "웅진 코웨이 공기청정기"
    override val filters: MutableList<AbstractFilter> = mutableListOf(FineDustFilter())
    override val dehumidifier: AbstractDehumidifier = LowGradeDehumidifier()
    override val humidifier: AbstractHumidifier = LowGradeHumidifier()
    override val notifier: AbstractNotifier = NoneNotifier()

}