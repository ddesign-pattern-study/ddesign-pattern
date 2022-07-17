package chapter1.Pockemon;

public class Pikachu extends Pockemon {

    // 피카츄는 전기 타입
    public Pikachu() {
        attackBehavior = new AttackElectric();
    }

    @Override
    public void growl() {
        System.out.println("츄-피카츄");
    }
}
