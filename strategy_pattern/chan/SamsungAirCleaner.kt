import filter.AbstractFilter
import filter.DeodorizationFilter
import filter.FineDustFilter
import filter.UltrafineDustFilter
import humidifier.AbstractDehumidifier
import humidifier.AbstractHumidifier
import humidifier.HighGradeDehumidifier
import humidifier.HighGradeHumidifier
import notifier.AbstractNotifier
import notifier.HumidityNotifier

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