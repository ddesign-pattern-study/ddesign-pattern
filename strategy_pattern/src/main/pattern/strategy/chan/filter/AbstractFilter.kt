package pattern.strategy.chan.filter

import pattern.strategy.chan.Air

/**
 * 필터
 *
 * 필터와 같이 상태 값을 가지는 경우에는 abstract 가 적절해 보인다
 *
 * 필터의 경우에는 책임사슬패턴이..필요할까?
 */
abstract class AbstractFilter {
    abstract val filterName: String // 필터 이름
    protected var usage: Int = 0 // 필터 사용량
    abstract fun clean(air: Air) // 공기 청정 알고리즘
    abstract fun isNeedReplacement(): Boolean // 교체 필요 여부
    fun checkUsage(): Int = usage // 사용량 확인
    protected fun useFilter(consumeVal: Int) { usage += consumeVal } // 필터 사용
}