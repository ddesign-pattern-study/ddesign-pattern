from abc import *

# 울음소리에 대한 추상 클래스
class QuackBehavior(metaclass=ABCMeta):
    @abstractmethod
    def quack(self):
        pass

# 꽥 소리 구현
class Quack(QuackBehavior):
    def quack(self):
        print("꽥꽥!!!!!!")

# 못 우는 행동 구현
class MuteQuack(QuackBehavior):
    def quack(self):
        print("<<조용....>>")

# 삑 소리 구현
class Squeak(QuackBehavior):
    def quack(self):
        print("삑삑")