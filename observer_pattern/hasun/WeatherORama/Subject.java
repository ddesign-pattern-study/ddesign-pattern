package WeatherORama;

public interface Subject {
    public void registerObserver(Observer o);   // 옵저버 등록
    public void removeObserver(Observer o);     // 옵저버 제거
    public void notifyObserver();               // 상태 변경 시 옵저베에게 변경 내용 알림
}