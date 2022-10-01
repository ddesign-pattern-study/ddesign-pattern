package beverage;

// 커피를 만드는 Coffee 클래스
public class Coffee extends CaffeineBeverage {
    @Override
    void addCondiments() {
        System.out.println("설탕과 우유를 추가하는 중");
    }

    @Override
    void brew() {
        System.out.println("필터로 커피를 우려내는 중");
    }
}
