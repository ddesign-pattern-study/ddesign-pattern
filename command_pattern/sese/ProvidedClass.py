# 협력사들에게 제공받은 클래스들
# 이 클래스들이 무슨 일을 하는지 전혀 알 필요 없음!

# 조명 제어 클래스
class Light():
    def on():
        print('조명이 켜졌습니다')
    def off():
        print('조명이 꺼졌습니다')

# 오디오 제어 클래스
class Stereo():
    def on():
        print('오디오가 켜졌습니다')
    def off():
        print('오디오가 꺼졌습니다')
    def setCd():
        print('CD setting')
    def setDvd():
        print('DVD setting')
    def setRadio():
        print('Radio setting')
    def setVolume(volumeNum):
        print(f'볼륨을 {volumeNum}으로 설정합니다')

# 차고문 제어 클래스
class GarageDoor():
    def up():
        print('차고문이 열렸습니다')
    def down():
        print('차고문이 닫혔습니다')

# 선풍기 제어 클래스
class CeilingFan():
    def on():
        print('선풍기가 켜졌습니다')
    def off():
        print('선풍기가 꺼졌습니다')