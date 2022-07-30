from abc import *

# 음료 추상 클래스
class Beverage(metaclass=ABCMeta):
    def getDescription(self):
        description = "제목없음"
        return description
    
    @abstractmethod
    def cost(self):
        pass

# 첨가물 추상 클래스(데코레이터 클래스)
class CondimentDecorator(Beverage):
    def __init__(self, beverage):
        self.beverage = beverage

    @abstractmethod
    def getDescription(self):
        pass
