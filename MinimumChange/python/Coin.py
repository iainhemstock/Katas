class Coin:
    __name = ''
    __value = 0
    __count = 0

    def __init__(self, name, value):
        self.__name = name
        self.__value = value
        self.__count = 0

    def value(self):
        return self.__value

    def name(self):
        return self.__name

    def count(self):
        return self.__count

    def increaseCount(self):
        self.__count += 1
