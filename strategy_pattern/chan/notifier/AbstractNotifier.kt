package notifier

import Air

/**
 * 알림 기능
 */
interface AbstractNotifier {

    fun cleanerNotify(air: Air)

}

/**
 * 습도 알림 기능
 */
class HumidityNotifier : AbstractNotifier {

    override fun cleanerNotify(air: Air) {
        println("\t3. 현재 습도 :${air.humidity}%")
    }

}

/**
 * 온도 알림 기능
 */
class TemperatureNotifier : AbstractNotifier {

    override fun cleanerNotify(air: Air) {
        println("\t3. 현재 온도 : 38도")
    }

}

class NoneNotifier : AbstractNotifier {

    override fun cleanerNotify(air: Air) {
        // 기능 없음
    }

}