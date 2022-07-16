package chapter1.Pockemon;

public class Yadoran extends Pockemon {

    // 야도란은 물 타입
    public Yadoran() {
        attackBehavior = new AttackWater();
    }

    @Override
    public void growl() {
        System.out.println("윅크!");
    }
}
