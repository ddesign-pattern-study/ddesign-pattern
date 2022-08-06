# 피자를 총괄하는 pizzaStore
from abc import *
from Pizza import *

class PizzaStore(metaclass=ABCMeta):
    def OrderPizza(self, type):
        pizza = self.CreatePizza(type)

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()

        return pizza

    @abstractmethod
    def CreatePizza(self, type):
        pass
    

# 뉴욕지점
class NYStylePizzaStore(PizzaStore):
    def CreatePizza(self, type):
        pizza = None

        if type == "cheese":
            pizza =  NYStyleCheesePizza()
        elif type == "veggie":
            pizza = NYStyleVeggiePizza
        elif type == "clam":
            pizza = NYStyleClamPizza
        elif type == "pepperoni":
            pizza =  NYStylePepperoniPizza
        else:
            pizza = None
        
        return pizza

# 시카고지점
class ChicagoStylePizzaStore(PizzaStore):
    def CreatePizza(self, type):
        pizza = None

        if type == "cheese":
            pizza =  ChicagoStyleCheesePizza()
        elif type == "veggie":
            pizza = ChicagoStyleVeggiePizza
        elif type == "clam":
            pizza = ChicagoStyleClamPizza
        elif type == "pepperoni":
            pizza =  ChicagoStylePepperoniPizza
        else:
            pizza = None
        
        return pizza