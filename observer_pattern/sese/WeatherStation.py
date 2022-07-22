from WeatherData import WeatherData
from CurrentConditionsDisplay import CurrentConditionsDisplay

# 테스트용 기상 스테이션
class WeatherStation():

    def main(self):
        weatherData = WeatherData()
        currentDisplay = CurrentConditionsDisplay()

        weatherData.setMeasurements(80, 65, 30.4)
        weatherData.setMeasurements(82, 70, 29.2)
        weatherData.setMeasurements(78, 90, 29.7)
