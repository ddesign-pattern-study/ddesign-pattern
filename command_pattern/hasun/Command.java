// 커맨드 인터페이스 구현
// 커맨드 객체는 모두 같은 인터페이스를 구현한다
// 객체 마을 식당의 orderUp()
public interface Command {
    public void execute();
    public void undo();
}
