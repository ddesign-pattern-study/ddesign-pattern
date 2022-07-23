package humidifier

import Air

/**
 * 가습 기능
 */
interface AbstractHumidifier {

    fun humidify(air: Air)

}

/**
 * 고급 가습 기능
 */
class HighGradeHumidifier : AbstractHumidifier {

    override fun humidify(air: Air) {
        air.humidity += 40
    }

}

/**
 * 저급 가습 기능
 */
class LowGradeHumidifier : AbstractHumidifier {

    override fun humidify(air: Air) {
        air.humidity += 20
    }

}

/**
 * 기능이 없는 가습 구현 클래스
 */
class NoneHumidifier : AbstractHumidifier {

    override fun humidify(air: Air) {
        // 기능 없음
    }

}