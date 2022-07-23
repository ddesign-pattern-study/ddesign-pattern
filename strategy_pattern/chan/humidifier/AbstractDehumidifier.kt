package humidifier

import Air

/**
 * 제습 기능
 */
interface AbstractDehumidifier {

    fun dehumidify(air: Air)

}

/**
 * 고급 제습 기능
 */
class HighGradeDehumidifier : AbstractDehumidifier {

    override fun dehumidify(air: Air) {
        air.humidity -= 30
    }

}

/**
 * 저급 제습 기능
 */
class LowGradeDehumidifier : AbstractDehumidifier {

    override fun dehumidify(air: Air) {
        air.humidity -= 8
    }

}

/**
 * 기능이 없는 제습 구현 클래스
 */
class NoneDehumidifier : AbstractDehumidifier {

    // 해당 기능을 필요로 하지 않는 경우에 nullable 프로퍼티로 해야할지
    // 기능이 구현되지 않은 클래스를 만들어야할지 고민

    override fun dehumidify(air: Air) {
        // 제습 기능 없음
    }

}