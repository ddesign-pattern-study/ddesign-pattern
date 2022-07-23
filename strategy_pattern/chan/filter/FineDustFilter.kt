package filter
import Air

class FineDustFilter : AbstractFilter() {

    override val filterName: String = "미세먼지 필터"

    override fun clean(air: Air) {
        val consumeVal = 10
        air.figureOfFindDust -= consumeVal
        useFilter(consumeVal)
    }

    override fun isNeedReplacement(): Boolean = usage > 800

}