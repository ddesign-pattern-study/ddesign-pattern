package chapter1.Pockemon;

// 물공격
public class AttackWater implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("물 공격~");
    }
}
