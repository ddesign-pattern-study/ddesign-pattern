package chapter1.Pockemon;

public abstract class Pockemon {
    AttackBehavior attackBehavior; // 포켓몬의 공격타입

    public Pockemon() {}

    // 공격
    public void performAttack() {
        attackBehavior.attack();
    }

    // 울음소리
    public abstract void growl();
}
