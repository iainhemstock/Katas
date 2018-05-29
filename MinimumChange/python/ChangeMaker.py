from Coin import Coin
import re
# ==================================================================================================
class ChangeMaker:
    def makeChange(self, input):
        if not self.__isValidInput(input):
            raise ValueError('input is not valid!')

        if self.__containsPenceChar(input):
            withoutPence = self.__stripPenceChar(input)
            input = self.__convertToInt(withoutPence)
        elif self.__containsPoundChar(input):
            withoutPound = self.__stripPoundChar(input)
            withoutPound = self.__convertAmountToPennies(float(withoutPound))
            input = self.__convertToInt(withoutPound)

        return self.__makeChangeFromPennies(input)
    # ----------------------------------------------------------------------------------------------
    def __isValidInput(self, input):
        regexStrPoundWithOptionalTwoDigitFrationalPart = "(^£[0-9]+(\.[0-9]{2})?$)"
        regexStrPennies = "^[0-9]+p$"
        regexIntPennies = "^[0-9]+$"
        regex = '(' + regexStrPoundWithOptionalTwoDigitFrationalPart + '|' \
                    + regexStrPennies + '|' \
                    + regexIntPennies + ')'
        matchObj = re.search(regex, str(input))
        if matchObj == None: return False
        return True
    # ----------------------------------------------------------------------------------------------
    def __convertAmountToPennies(self, amount):
        return amount * 100
    # ----------------------------------------------------------------------------------------------
    def __convertToInt(self, input):
        return int(input)
    # ----------------------------------------------------------------------------------------------
    def __stripPoundChar(self, input):
        return input.split('£')[1]
    # ----------------------------------------------------------------------------------------------
    def __containsPoundChar(self, input):
        regex = "£{1}"
        matchObj = re.search(regex, str(input))
        if matchObj == None:
            return False;
        return True
    # ----------------------------------------------------------------------------------------------
    def __stripPenceChar(self, input):
        return input.split('p')[0]
    # ----------------------------------------------------------------------------------------------
    def __containsPenceChar(self, input):
        regex = "p{1}"
        matchObj = re.search(regex, str(input))
        if matchObj == None:
            return False
        return True
    # ----------------------------------------------------------------------------------------------
    def __makeChangeFromPennies(self, input):
        coins = [
            Coin("£2", 200),
            Coin("£1", 100),
            Coin("50p", 50),
            Coin("20p", 20),
            Coin("10p", 10),
            Coin("5p", 5),
            Coin("2p", 2),
            Coin("1p", 1)
        ]
        statements = []
        statements = self.__findCoinCountForEachCoin(input, coins, statements)
        # statements = self.__createCoinStatements(coins)
        return self.__buildOutputString(statements)
    # ----------------------------------------------------------------------------------------------
    def __findCoinCountForEachCoin(self, input, coins, statements):
        for coin in coins:
            while input >= coin.value():
                coin.increaseCount()
                input -= coin.value()
            if coin.count() != 0:
                statements.append(str(coin.count()) + ' x ' + coin.name() + ' coin')
        return statements
    # ----------------------------------------------------------------------------------------------
    # def __createCoinStatements(self, coins):
    #     statements = []
    #     for coin in coins:
    #         if coin.count() != 0:
    #             statements.append(str(coin.count()) + ' x ' + coin.name() + ' coin')
    #     return statements
    # ----------------------------------------------------------------------------------------------
    def __buildOutputString(self, statements):
        ret = ''
        sep = ', '
        for i, statement in enumerate(statements):
            if i >= len(statements) - 2: sep = ''
            ret += statement + sep
            if (i + 2 == len(statements)):
                ret += ' and '
        return ret
