package pattern.strategy.chan.filter

import pattern.strategy.chan.Air

class DeodorizationFilter : AbstractFilter() {

    override val filterName: String = "탈취 필터"

    override fun clean(air: Air) {
        val consumeVal = air.figureOfSmell * 10
        air.figureOfSmell -= consumeVal
        useFilter(consumeVal)
    }

    override fun isNeedReplacement(): Boolean = usage > 300

}