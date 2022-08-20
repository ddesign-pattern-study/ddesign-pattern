from distutils.dir_util import remove_tree
from Commands import *

# 리모컨
class RemoteController():
    onCommands = [None] * 7
    offCommands = [None] * 7
    undoCommand = None

    def __init__(self):
        noCommand = 'Nocommand'
        for i in range(7):
            self.onCommands[i] = noCommand
            self.offCommands[i] = noCommand
        self.undoCommand = noCommand

    # 슬롯번호와 그 슬롯에 저장할 ON/OFF 커맨드 객체를 전달받음
    def SetCommand (self, slotNum, onCommand, offCommand):
        self.onCommands[slotNum] = onCommand
        self.offCommands[slotNum] = offCommand

    # 사용자가 ON/OFF 버튼을 누르면 각 버튼에 해당하는 메소드를 호출
    def OnButtonWasPushed (self, slotNum):
        self.onCommands[slotNum].execute()
        self.undoCommand = self.onCommands[slotNum]

    def OffButtonWasPushed (self, slotNum):
        self.offCommands[slotNum].execute()
        self.undoCommand = self.offCommands[slotNum]

    # 되돌리기 버튼을 누르면 undo 메소드호출
    def undoButtonWasPushed (self):
        self.undoCommand.undo()

    # 리모컨 세팅 상태 출력
    def RemoteSettingList(self):
        print('-----------------------리모컨-----------------------')
        for i in range(len(self.onCommands)):
            print('[slot ' + str(i+1) + '] ' +
                self.onCommands[i].__class__.__name__ + "      " +
                self.offCommands[i].__class__.__name__)

# 리모컨 테스트
class RemoteLoader():
    remoteController = RemoteController()

    lightOn = LightOnCommand()
    lightOff = LightOffCommand()
    stereoOn = StereoOnWithCDCommand()
    stereoOff = StereoOffWithCDCommand()
    ceilingFanOn = CeilingFanOnCommand()
    ceilingFanOff = CeilingFanOffCommand()
    garageDoorOn = GarageDoorUpCommand()
    garageDoorOff = GarageDoorDownCommand()

    remoteController.SetCommand(0, lightOn, lightOff)
    remoteController.SetCommand(1, stereoOn, stereoOff)
    remoteController.SetCommand(2, ceilingFanOn, ceilingFanOff)
    remoteController.SetCommand(3, garageDoorOn, garageDoorOff)

    remoteController.RemoteSettingList()

    print('----------------------------------------------------')
    print('------------------버튼 동작 테스트------------------')

    remoteController.OnButtonWasPushed(0)
    remoteController.OffButtonWasPushed(0)
    remoteController.OnButtonWasPushed(3)
    print('---실행취소하기---')
    remoteController.undoButtonWasPushed()
    remoteController.OffButtonWasPushed(3)
    remoteController.OnButtonWasPushed(1)
    remoteController.OffButtonWasPushed(1)
    remoteController.OnButtonWasPushed(2)
    print('---실행취소하기---')
    remoteController.undoButtonWasPushed()
    remoteController.OffButtonWasPushed(2)



## 간단한 스위치
# class SimpleRemoteController():
#     slot = None
    
#     def setCommand(self, command):
#         self.slot = command

#     def buttonWasPressed(self):
#         self.slot.execute()

## 간단한 스위치 객체를 활용한 조명 켜기 테스트
# class RemoteControlTest():
#     remote = SimpleRemoteController()
#     lightOn = LightOnCommand()

#     remote.setCommand(lightOn)
#     remote.buttonWasPressed()

