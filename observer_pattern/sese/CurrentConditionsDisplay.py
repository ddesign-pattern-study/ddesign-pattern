from Interface import Observer, DisplayElement
from WeatherData import WeatherData

# 옵저버인 current conditions display 구현
class CurrentConditionsDisplay(Observer, DisplayElement):
    
    def CurrentConditionsDisplay(WeatherData):
        weatherData = weatherData()
        weatherData.registerObserver(self)

    def update(temperature):
        pass