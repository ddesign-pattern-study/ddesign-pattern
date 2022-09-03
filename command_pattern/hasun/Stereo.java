public class Stereo {
    String location;
    Integer volume;

    public Stereo(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " 오디오 전원이 켜졌습니다.");
    }

    public void off() {
        System.out.println(location + " 오디오 전원이 꺼졌습니다.");
    }

    public void setCD() {
        System.out.println(location + " CD를 재생합니다.");
    }

    public void setDvd() {
        System.out.println(location + " Dvd를 재생합니다.");
    }

    public void setRadio() {
        System.out.println(location + " 라디오를 재생합니다.");
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
        System.out.println(location + " 오디오의 볼륨을 설정합니다. 현재 볼륨: " + volume);
    }
}
