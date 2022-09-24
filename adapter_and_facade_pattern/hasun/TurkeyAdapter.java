public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() { // 칠면조는 오리처럼 멀리 날지 못함.. 대신 5번 호출해서 더 멀리 움직이도록 함
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
