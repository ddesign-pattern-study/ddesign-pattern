# 홈 시어터 퍼사드
## 퍼사드에서 서브시스템이 있는 모든 구성 요소에 접근할 수 있도록 구성해야 함

from SubSystem import *

class HomeTheaterFacade ():
    def __init__(self):
        self.amp = Amplifier
        self.tuner = Tuner
        self.player = StreamingPlayer
        self.projector = Projector
        self.screen = Screen
        self.lights = TheaterLights
        self.popper = PopcornPopper

    def WatchMovie(self, movie):
        print("------영화 볼 준비 중...------")
        self.popper.on()
        self.popper.pop()
        self.lights.dim(10)
        self.screen.down()
        self.projector.on()
        self.projector.wideScreenMode()
        self.amp.on()
        self.amp.setStreamingPlayer("플레이어")
        self.amp.setSurroundSound()
        self.amp.setVolume(5)
        self.player.on()
        self.player.play(movie)
        print("--------영화 볼 준비 완료!-------")

    def EndMovie(self):
        print("------홈시어터를 끄는 중...------")
        self.popper.off()
        self.lights.on()
        self.screen.up()
        self.projector.off()
        self.amp.off()
        self.player.stop()
        self.player.off()
        print("------바이바이...-----")


##테스트
class HomeTheaterTestDrive():
    homeTheater = HomeTheaterFacade()

    homeTheater.WatchMovie("인디아나 존스: 레이더스")
    homeTheater.EndMovie()