package chapter1.Pockemon;

// 페어리 공격
public class AttackFairy implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("fairy attack~");
    }
}
