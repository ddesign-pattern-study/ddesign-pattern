from abc import *

# 나는 행동에 대한 추상 클래스
class FlyBehavior(metaclass=ABCMeta):
    @abstractmethod
    def fly(self):
        pass

# 날개로 나는 행동 구현
class FlyWithWings(FlyBehavior):
    def fly(self):
        print("날고있어요!!!!")

# 못 나는 행동 구현
class FlyNoWay(FlyBehavior):
    def fly(self):
        print("못 날아요..꽥")