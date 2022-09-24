package facade;

public class HomeTheaterFacade {
    Amplifier amp;
    Tuner tuner;
    StreamingPlayer player;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;

    public HomeTheaterFacade(Amplifier amp,
                             Tuner tuner,
                             StreamingPlayer player,
                             Projector projector,
                             TheaterLights lights,
                             Screen screen,
                             PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.player = player;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        System.out.println("영화 볼 준비 중");
        // 팝콘 기계를 켜고 팝콘을 튀기기 시작합니다.
        popper.on();
        popper.pop();

        // 조명 밝기를 10%로 줄입니다.
        lights.dim(10);

        // 스크린을 내립니다.
        screen.down();

        // 프로젝터를 켜고 와이드 스크린 모드로 전환합니다.
        projector.on();
        projector.wideScreenMode();

        // 앰프를 켜고 입력을 스트리밍 플레이어로 설정하고
        amp.on();
        amp.setStreamingPlayer(player);
        // 서라운드 모드를 선택하고 볼륨을 5로 설정합니다.
        amp.setSurroundSound();
        amp.setVolume(5);

        // 스트리밍 플레이어를 켜고
        player.on();
        // 마침내 영화를 재생합니다
        player.play(movie);
    }

    public void endMovie() {
        System.out.println("홈시어터를 끄는 중");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        player.stop();
        player.off();
    }
}
