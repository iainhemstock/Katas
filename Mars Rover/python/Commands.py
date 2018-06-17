class CommandFactory():
    def get(self, type):
        if type == 'M': return MoveCommand()
        if type == 'R': return RotateRightCommand()
        if type == 'L': return RotateLeftCommand()

class Command():
    def execute(self, buggy):
        raise NotImplementedError('')

class MoveCommand(Command):
    def execute(self, buggy):
        buggy.move()

class RotateRightCommand(Command):
    def execute(self, buggy):
        buggy.rotate()
        buggy.rotate()
        buggy.rotate()

class RotateLeftCommand(Command):
    def execute(self, buggy):
        buggy.rotate()
