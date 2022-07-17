from abc import *

# 추상 클래스로 duck class 구현
class Duck(metaclass=ABCMeta):
    @abstractmethod
    def display(self):
        pass

    # 나는 행동 상속
    def performFly(self):
        self.fly_behavior.fly()
    
    # 우는 행동 상속
    def performQuack(self):
        self.quack_behavior.quack()

    def swim(self):
        print("모든 오리는 수영할 줄 압니다. 둥둥둥...")

