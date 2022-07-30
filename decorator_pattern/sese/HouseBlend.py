from Beverage import Beverage

# 에스프레소
class HouseBlend(Beverage):
    # beverage에서 상속받은 description
    def HouseBlend(self):
        super().getDescription = "하우스 블랜드 커피"
    
    def cost():
        return 0.89