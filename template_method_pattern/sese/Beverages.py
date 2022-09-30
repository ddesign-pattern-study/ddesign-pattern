from CaffeineBeverage import CaffeineBeverage

class Tea (CaffeineBeverage):
    # 추상 메소드로 만들었던 메소드들을 각 음료에 맞게 오버라이드
    def Brew(self):
        print("찻잎을 우려내는 중...")

    def AddCondiments(self):
        print("레몬을 추가하는 중...")

    def CustomerWantsCondiments(self):
        answer = self.GetUserInput()

        if answer == "Y":
            return True
        else:
            return False


    def GetUserInput(self):
        answer = None
        
        print("차에 레몬을 추가할까요??? (Y/N)?")

        bufferReader = input()

        try :
            answer = bufferReader
        except:
            print("문제가 생긴것 같네요...")
        
        return answer

class Caffee (CaffeineBeverage):
    # 추상 메소드로 만들었던 메소드들을 각 음료에 맞게 오버라이드
    def Brew(self):
        print("필터로 커피를 우려내는 중...")

    def AddCondiments(self):
        print("우유와 설탕을 추가하는 중...")

    def CustomerWantsCondiments(self):
        answer = self.GetUserInput()

        if answer == "Y":
            return True
        else:
            return False


    def GetUserInput(self):
        answer = None
        
        print("커피에 우유와 설탕을 추가할까요??? (Y/N)?")

        bufferReader = input()

        try :
            answer = bufferReader
        except:
            print("문제가 생긴것 같네요...")
        
        return answer