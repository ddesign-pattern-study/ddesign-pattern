from Duck import Duck
from FlyBehavior import *
from QuackBehavior import *

# 고무 오리 구현
class RubberDuck(Duck):
    # 나는 행동이랑 삑삑소리 받아오기
    def __init__(self):
        self.fly_behavior = FlyNoWay()
        self.quack_behavior = Squeak()

    def display(self):
        print("나는야 고무오리")

RubberDuck().display()
RubberDuck().performFly()
RubberDuck().performQuack()
RubberDuck().swim()