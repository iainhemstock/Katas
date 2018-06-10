class MarsRover():
    def execute(self, commands):
        direction = 'N'
        for cammand in commands:
            if direction == 'W': direction = 'N'
            elif direction == 'S': direction = 'W'
            elif direction == 'E': direction = 'S'
            elif direction == 'N': direction = 'E'

        return '0:0:' + direction
