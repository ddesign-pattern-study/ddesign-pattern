from Beverage import CondimentDecorator

# 모카 데코레이터
class Mocha(CondimentDecorator):
    def Mocha(beverage):
        beverage = beverage
    
    def getDescription(self):
        return super().getDescription() + ", 모카"

    def cost(self):
        return super().cost() + .20

# 두유 데코레이터
# class Soy(CondimentDecorator):

# 휘핑크림 데코레이터
