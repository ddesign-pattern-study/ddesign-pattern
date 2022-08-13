# 싱글턴 패턴(Singleton pattern)
# 클래스 인스턴스를 하나만 만들고, 그 인스턴스로의 전역 접근을 제공함

class ChocolateBoiler():

    def __new__(cls, *args, **kwargs):
        # 초콜렛 보일러 클래스 객체에 uniqueInstance 속성이 없다면, 객체 생성 후 .uniqueInstance 로 바인딩
        if not hasattr(cls, "uniqueInstance"):
            print("새로운 초콜렛 보일러 인스턴스 생성!")
            cls.uniqueInstance = super().__new__(cls)
        return cls.uniqueInstance
    
    def __init__(self, data):
        # 생성된 객체를 초기화 하는 __init__
        cls = type(self)
        if not hasattr(cls, "_init"):
            print("생성된 객체 초기화")
            self.empty = True
            self.boiled = False
            cls._init = True
    
    def Fill(self):
        if self.IsEmpty():
            self.empty = False
            self.boiled = False

    def Drain(self):
        if (not self.IsEmpty()) and self.IsBoiled():
            self.empty = True

    def Boil(self):
        if (not self.IsEmpty()) and self.IsBoiled():
            self.boiled = True

    def IsEmpty(self):
        return self.empty
    
    def IsBoiled(self):
        return self.boiled


factory1 = ChocolateBoiler(1)
factory2 = ChocolateBoiler(2)

print(factory1)
print(factory2)