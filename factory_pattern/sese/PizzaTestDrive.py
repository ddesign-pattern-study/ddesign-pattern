# 피자 주문 테스트
from PizzaStore import *
from Pizza import *

class PizzaTestDrive():
    # 뉴욕 지점
    nyStore = NYStylePizzaStore()
    nyStore.OrderPizza('cheese')

    # 시카고 지점
    chicagoStore = ChicagoStylePizzaStore()
    chicagoStore.OrderPizza('cheese')