package WeatherORama;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        // 디스플레이 코드
        System.out.println("기상 예보: ");
        if (lastPressure == currentPressure) {
            System.out.println("지금과 비슷할 것 같습니다.");
        } else if (lastPressure > currentPressure) {
            System.out.println("쌀쌀하며 비가 올 것 같습니다.");
        } else if (lastPressure < currentPressure) {
            System.out.println("날씨가 좋아지고 있습니다!");
        }
    }

    @Override
    public void update() {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    }
}
