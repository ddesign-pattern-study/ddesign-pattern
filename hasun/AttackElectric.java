package chapter1.Pockemon;

// 전기 공격
public class AttackElectric implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("전기공격 !!");
    }
}
