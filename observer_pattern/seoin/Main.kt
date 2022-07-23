interface Subject {
    fun registerObserver(o: Observer)
    fun removeObserver(o: Observer)
    fun notifyObserver()
}

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}

interface DisplayElement {
    fun display()
}

class WeatherData : Subject {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    private val observers: MutableList<Observer> = mutableListOf()

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObserver() {
        observers.map { it.update(temperature, humidity, pressure) }
    }

    private fun measurementsChanged() {
        notifyObserver()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
}

class CurrentConditionsDisplay(
    private var temperature: Float,
    private var humidity: Float,
    private val weatherData: WeatherData
) : Observer, DisplayElement {

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        display()
    }

    override fun display() {
        println("현재 상태 : 온도 " + temperature + "F, 습도 " + humidity + "%")
    }
}

fun main() {
    val temperature = 80f
    val humidity = 65f
    val weatherData = WeatherData()
    val currentDisplay = CurrentConditionsDisplay(temperature, humidity, weatherData)

    currentDisplay.display() // 현재 상태 : 온도 80.0F, 습도 65.0%

    // 현재 상태 : 온도 72.0F, 습도 65.0%
    weatherData.setMeasurements(72f, 65f, 30.4f)
    currentDisplay.display() // 현재 상태 : 온도 72.0F, 습도 65.0%

    // 현재 상태 : 온도 82.0F, 습도 70.0%
    weatherData.setMeasurements(82f, 70f, 29.2f)
    currentDisplay.display() // 현재 상태 : 온도 82.0F, 습도 70.0%

    // 현재 상태 : 온도 78.0F, 습도 90.0%
    weatherData.setMeasurements(78f, 90f, 29.2f)
    currentDisplay.display() // 현재 상태 : 온도 78.0F, 습도 90.0%
}
