package facade;

public class TheaterLights {
    public void dim(int i) {
        System.out.printf("조명 밝기를 %d로 설정합니다.\n", i);
    }

    public void on() {
        System.out.printf("조명이 켜졌습니다.");
    }
}
