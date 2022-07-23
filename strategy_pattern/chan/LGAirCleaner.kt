import filter.AbstractFilter
import filter.FineDustFilter
import filter.UltrafineDustFilter
import humidifier.AbstractDehumidifier
import humidifier.AbstractHumidifier
import humidifier.HighGradeDehumidifier
import humidifier.HighGradeHumidifier
import notifier.AbstractNotifier
import notifier.TemperatureNotifier

class LGAirCleaner : AbstractAirCleaner() {

    override val modelName: String = "LG 공기 청정기"
    override val filters: MutableList<AbstractFilter> =
        mutableListOf(
            FineDustFilter(),
            UltrafineDustFilter()
        )
    override val dehumidifier: AbstractDehumidifier = HighGradeDehumidifier()
    override val humidifier: AbstractHumidifier = HighGradeHumidifier()
    override val notifier: AbstractNotifier = TemperatureNotifier()

}