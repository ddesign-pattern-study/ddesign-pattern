from abc import *
from operator import truediv

class CaffeineBeverage (metaclass=ABCMeta):
    # 템플릿 메소드
    def PrepareRecipe(self):
        self.BoilWater()
        self.Brew()
        self.PourInCup()

        if self.CustomerWantsCondiments():
            self.AddCondiments()

        self.Serving()
        
    
    # 추상 메소드로 정의하는 부분
    # 사용처마다 알고리즘이 바뀔수 있는 부분
    # 서브 클래스에서 변경해서 사용한다!
    @abstractmethod
    def Brew(self):
        pass

    @abstractmethod
    def AddCondiments (self):
        pass

    # 일반 메소드로 정의하는 부분
    # 모든 곳에서 동일하게 사용되기때문에 추상 메소드로 정의할 필요가 없음
    def BoilWater (self):
        print("물을 끓이는 중입니다... 보글보글보글 삐이이익...")

    def PourInCup(self):
        print("음료를 컵에 따르는 중입니다...")
    
    def Serving(self):
        print("음료 나왔습니다!!!! (๑╹ワ╹)ノ")

    def CustomerWantsCondiments (self):
        return True 