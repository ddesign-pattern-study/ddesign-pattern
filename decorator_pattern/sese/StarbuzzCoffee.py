from HouseBlend import HouseBlend
from Condiment import *

# 주문하기
class StarbuzzCoffee():
    
    beverage2 = HouseBlend()
    beverage2 = Mocha(beverage2)
    print(beverage2.getDescription, " $", beverage2.cost)