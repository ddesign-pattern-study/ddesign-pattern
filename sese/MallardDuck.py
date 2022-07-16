from Duck import Duck
from FlyBehavior import *
from QuackBehavior import *

# 청둥 오리 구현
class MallardDuck(Duck):
    # 나는 행동이랑 삑삑소리 받아오기
    def __init__(self):
        self.fly_behavior = FlyWithWings()
        self.quack_behavior = Quack()

    def display(self):
        print("나는야 청둥오리라네")

MallardDuck().display()
MallardDuck().performFly()
MallardDuck().performQuack()
MallardDuck().swim()