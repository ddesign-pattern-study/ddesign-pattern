public class CeilingFan {
    String location;
    Speed speed;

    public CeilingFan(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " 선풍기가 켜졌습니다.");
    }

    public void off() {
        System.out.println(location + " 선풍기가 꺼졌습니다.");
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public enum Speed {
        SLOW, HIGH
    }
}
