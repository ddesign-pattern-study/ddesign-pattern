package chapter1.Pockemon;

public class Ppippi extends Pockemon {

    // 삐삐는 페어리 타입
    public Ppippi() {
        attackBehavior = new AttackFairy();
    }

    @Override
    public void growl() {
        System.out.println("삐 삐삐!");
    }
}
