# 서브시스템들

# amp
class Amplifier():
    def on():
        print("엠프가 켜졌습니다")
    def off():
        print("엠프가 꺼졌습니다")
    def setStreamingPlayer(connecter):
        print(f"엠프를 {connecter}와 연결합니다")
    def setSurroundSound():
        print("엠프를 서라운드 모드로 설정합니다(5.1 채널)")
    def setVolume(num):
        print(f"엠프 볼륨을 {num}로 설정합니다")
    

# tuner
class Tuner():
    def on():
        print("tuner가 켜졌습니다")
    def off():
        print("tune가 꺼졌습니다")

# screen
class Screen():
    def up():
        print("스크린이 올라갑니다")
    def down():
        print("스크린이 내려옵니다")

# popper
class PopcornPopper():
    def on():
        print("팝콘 기계가 켜졌습니다")
    def off():
        print("팝콘 기계가 꺼졌습니다")
    def pop():
        print("팝콘을 튀깁니다... 퍼벙퍼버벙")

# lights
class TheaterLights():
    def on():
        print("조명이 켜졌습니다")
    def off():
        print("조명이 꺼졌습니다")
    def dim(num):
        print(f"조명 밝기를 {num}% 로 설정합니다")

# projector
class Projector():
    def on():
        print("프로젝터가 켜졌습니다")
    def off():
        print("프로젝터가 꺼졌습니다")
    def tvMode():
        print("프로젝터를 TV 모드로 전환합니다")
    def wideScreenMode():
        print("프로젝터를 와이드 스크린 모드로 전환합니다")

#player
class StreamingPlayer():
    def on():
        print("스트리밍 플레이어가 켜졌습니다")
    def off():
        print("스트리밍 플레이어가 꺼졌습니다")
    def pause():
        print("스트리밍 플레이어를 일시중단합니다")
    def play(movie):
        print(f"스트리밍 플레이어에서 '{movie}'를 재생합니다")
    def setSurroundAudio():
        print("스트리밍 플레이어를 서라운드 오디오로 설정합니다")
    def setTwoChannelAudio():
        print("스트리밍 플레이어를 2채널 오디오로 전환합니다")
    def stop():
        print("스트리밍 플레이어를 멈춥니다")