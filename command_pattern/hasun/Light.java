public class Light {
    String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " 조명이 켜졌습니다.");
    }

    public void off() {
        System.out.println(location + " 조명이 꺼졌습니다.");
    }
}
