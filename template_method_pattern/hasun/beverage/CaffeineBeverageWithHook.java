package beverage;

// 후크(hoot)는 추상 클래스에서 선언되지만 기본적인 내용만 구현되어 있거나
// 아무 코드도 들어있지 않은 메소드
public abstract class CaffeineBeverageWithHook {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("물 끓이는 중");
    }

    void pourInCup() {
        System.out.println("컵에 따르는 중");
    }

    // 별 내용이 없는 기본 메소드를 구현
    // 이 메소드는 그냥 true만 리턴할 뿐
    // 다른 작업은 안함
    // 서브 클래스에서 오버라이드할 수 있음
    boolean customWantsCondiments() {
        return true;
    }
}
