from abc import *
from ProvidedClass import *

class Command(metaclass=ABCMeta):

    @abstractmethod
    def execute(self):
        pass

    @abstractmethod
    def undo(self):
        pass

# 조명 커멘드 
# ON
class LightOnCommand(Command):
    def __init__(self):
        self.light = Light
    
    def execute(self):
        self.light.on()

    def undo(self):
        self.light.off()    
# OFF
class LightOffCommand(Command):
    def __init__(self):
        self.light = Light
    
    def execute(self):
        self.light.off()
    
    def undo(self):
        self.light.on()

# 오디오 커맨드
# ON
class StereoOnWithCDCommand(Command):
    def __init__(self):
        self.stereo = Stereo

    def execute(self):
        self.stereo.on()
        self.stereo.setCd()
        self.stereo.setVolume(11)

    def undo(self):
        self.stereo.off()
# OFF
class StereoOffWithCDCommand(Command):
    def __init__(self):
        self.stereo = Stereo
    
    def execute(self):
        self.stereo.off()

    def undo(self):
        self.stereo.on()

# 차고문 커맨드
# ON
class GarageDoorUpCommand(Command):
    def __init__(self):
        self.garageDoor = GarageDoor

    def execute(self):
        self.garageDoor.up()

    def undo(self):
        self.garageDoor.down()
# OFF
class GarageDoorDownCommand(Command):
    def __init__(self):
        self.garageDoor = GarageDoor
    
    def execute(self):
        self.garageDoor.down()

    def undo(self):
        self.garageDoor.up()

# 선풍기 커맨드
# ON
class CeilingFanOnCommand(Command):
    def __init__(self):
        self.ceilingFan = CeilingFan
    
    def execute(self):
        self.ceilingFan.on()

    def undo(self):
        self.ceilingFan.off()
# OFF
class CeilingFanOffCommand(Command):
    def __init__(self):
        self.ceilingFan = CeilingFan

    def execute(self):
        self.ceilingFan.off()

    def undo(self):
        self.ceilingFan.off()