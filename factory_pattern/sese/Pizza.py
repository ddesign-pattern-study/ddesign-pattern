# 피자를 만드는 pizza 클래스. 핏쟈핏쟈!!
from abc import *

class Pizza(metaclass=ABCMeta):
    def prepare(self):
        print('----------------------------------')
        print('주문: ', self.name)
        print('----------------------------------')
        print('도우 돌리는 중...')
        print('소스 뿌리는 중...')
        print('토핑 올리는 중...')
        print('----------------------------------')
        for topping in self.topping:
            print('토핑: ', topping)
        print('----------------------------------')
        
    def bake(self):
        print('175도에서 25분간 굽기...')

    def cut(self):
        print('피자를 사선으로 자르기')

    def box(self):
        print('상자에 피자 담기')
        print('-----준비완료---------------------')

    def getName(self):
        return self.name


# 뉴욕 스타일 치즈피자 클래스
class NYStyleCheesePizza(Pizza):
    def __init__(self):
        self.name = "뉴욕 스타일 소스와 치즈피자"
        self.dough = "씬 크러스트 도우"
        self.sauce = "마리나라 소스"
        self.topping = ['잘게 썬 레지아노 치즈']

# 시카고 스타일 치즈피자 클래스
class ChicagoStyleCheesePizza(Pizza):
    def __init__(self):
        self.name = "시카고 스타일 딥 디쉬 치즈피자"
        self.dough = "아주 두꺼운 크러스트 도우"
        self.sauce = "플럼 토마토 소스"
        self.topping = ['잘게 조각낸 모짜렐라 치즈']

    def cut(self):
        print("네모난 모양으로 피자 자르기")