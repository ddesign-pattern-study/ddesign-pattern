from Interface import Observer

# 주제인 WeatherData 구현
class WeatherData():
    
    # 옵저버를 저장하는 list
    def __init__(self):
        self._observers = []

    # 옵저버 등록
    def registerObserver(self, Observer):
        observer = Observer()
        self._observers.append(observer)

    # 옵저버 제거
    def removeObserver(self, Observer):
        observer = Observer()
        self._observers.remove(observer)
    
    # 옵저버에게 알림
    def notifyObservers(self):
        for observer in self._observers:
            observer.update(self)

    # 측정값 변화 감지
    def measurementsChanged(self):
        self.notifyObservers()

    # 측정값 설정
    def setMeasurements(temperature, humidity, pressure):
        self.measurementsChanged()