package facade;

public class StreamingPlayer {
    String movie;

    public void on() {
        System.out.println("스트리밍 플레이어가 켜졌습니다.");
    }

    public void play(String movie) {
        this.movie = movie;
        System.out.printf("스트리밍 플레이어에서 \"%s\"를 재생합니다.\n", movie);
    }

    public void off() {
        System.out.println("스트리밍 플레이어가 꺼졌습니다.");
    }

    public void stop() {
        System.out.printf("스트리밍 플레이어에서 \"%s\" 재생을 종료합니다.", movie);
    }
}
