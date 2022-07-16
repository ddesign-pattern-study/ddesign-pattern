package pattern.strategy.chan

import pattern.strategy.chan.filter.AbstractFilter
import pattern.strategy.chan.humidifier.AbstractDehumidifier
import pattern.strategy.chan.humidifier.AbstractHumidifier
import pattern.strategy.chan.notifier.AbstractNotifier

/**
 * 공기 청정기
 *
 * 공통 속성 : 모델명, 필터 구성 (미세먼지 필터, 초미세먼지 필터, 탈취 필터)
 * 기능 : 공기 청정, 제습, 가습, 알림, 필터 교체
 *
 * 기능 중에서 인자로 넘어온 Air 의 상태 값을 변경시키는 부분에 대한 개선이 필요하다.
 * (순수 함수를 위해 참조 투명성과 치환 모델을 적용해야한다.)
 * ex) 공기청정기의 반환값(VO)을 가지고 공기의 상태를 업데이트
 *
 * 또한 Air 객체에 지나치게 의존적이다. 결합도를 낮춰야한다.
 */
abstract class AbstractAirCleaner {

    protected lateinit var air: Air
    abstract val modelName: String
    protected abstract val filters: MutableList<AbstractFilter>
    protected abstract val dehumidifier: AbstractDehumidifier
    protected abstract val humidifier: AbstractHumidifier
    protected abstract val notifier: AbstractNotifier

    fun cleanAir() { // 공기 청정 기능
        filters.forEach { it.clean(air) }
    }

    fun dehumidify() { // 제습 기능
        dehumidifier.dehumidify(air)
    }

    fun humidify() { // 가습 기능
        humidifier.humidify(air)
    }

    fun cleanerNotify() { // 알림 표시 기능
        println("\t1. 현재 미세먼지 수치 : ${air.figureOfFindDust}")
        println("\t2. 필터 정보")
        filters.forEach {
            println("\t\t[${it.filterName}]")
            println("\t\t\t사용량 (${it.checkUsage()})")
            if(it.isNeedReplacement())
                println("\t\t\t<<< 필터 교체가 필요합니다 >>>")
        }
        notifier.cleanerNotify(air)
        println()
    }

    fun replaceFilter(newFilter: AbstractFilter) { // 필터 교체
        val index = filters.indexOfFirst { it.filterName == newFilter.filterName }
        if(index != -1) {
            filters.removeAt(index)
            filters.add(index, newFilter)
            println("\t❇︎ ${newFilter.filterName}가 교체되었습니다.")
        } else
            println("\t교체할 필터와 동일한 필터가 없습니다.")
    }

    fun turnOn(inputAir: Air) {
        air = inputAir
        println("<${modelName}>가 동작합니다.")
        cleanAir()
        dehumidify()
        humidify()
    }

}