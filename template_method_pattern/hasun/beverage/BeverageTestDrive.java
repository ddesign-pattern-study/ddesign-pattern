package beverage;

public class BeverageTestDrive {
    public static void main(String[] args) {
        TeaWithHook teaHook = new TeaWithHook();
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();

        System.out.println("\n홍차 준비 중...");
        teaHook.prepareRecipe();

        System.out.println("\n커피 준비 중...");
        coffeeWithHook.prepareRecipe();
    }
}
