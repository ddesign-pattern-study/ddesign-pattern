from abc import *

# 옵저버 클래스
class Observer (metaclass=ABCMeta):
    @abstractmethod
    def update(temp, humidity, pressure):
        pass

# 디스플레이 클래스
class DisplayElement (metaclass=ABCMeta):
    @abstractmethod
    def display(self):
        pass