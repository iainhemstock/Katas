import unittest

#===================================================================================================
# Honorifics
#===================================================================================================
class Honorifics:
    __known_honorifics = [ "Mr.", "Mrs."]

    def containsHonorific(self, namePart):
        for hon in self.__known_honorifics:
            if namePart == hon: return True
        return False
#===================================================================================================
# NameInverter
#===================================================================================================
class NameInverter:
    def __init__(self):
        self.honorifics = Honorifics()

    def invert(self, name):
        inverted = ""
        nameParts = name.split()
        if len(nameParts) == 1: inverted = name
        if len(nameParts) >= 2:
            if (self.honorifics.containsHonorific(nameParts[0])):
                self.__removeHonorific(nameParts)
            postnominals = self.__findAndMergePostnominals(nameParts)
            inverted = self.__constructInvertedName(nameParts[0], nameParts[1], postnominals)
        return inverted

    def __constructInvertedName(self, first, last, postnominals):
        return last + ", " + first + postnominals

    def __removeHonorific(self, nameParts):
        nameParts.pop(0)

    def __findAndMergePostnominals(self, nameParts):
        postnominals = ""
        for i in range(2, len(nameParts)):
            postnominals += " " + nameParts[i]
        return postnominals
#===================================================================================================
# NameInverterShould
#===================================================================================================
class NameInverterShould(unittest.TestCase):
    def setUp(self):
        self.inverter = NameInverter()

    def test_return_empty_string_when_given_name_is_empty(self):
        self.assertEqual(self.inverter.invert(""), "")

    def test_return_same_name_when_single_name_is_given(self):
        self.assertEqual(self.inverter.invert("John"), "John")
        self.assertEqual(self.inverter.invert("Jane"), "Jane")

    def test_return_lastname_comma_firstname(self):
        self.assertEqual(self.inverter.invert("John Smith"), "Smith, John")
        self.assertEqual(self.inverter.invert("Jane Doe"), "Doe, Jane")

    def test_return_lastname_comma_firstname_ignoring_honorific(self):
        self.assertEqual(self.inverter.invert("Mr. John Smith"), "Smith, John")
        self.assertEqual(self.inverter.invert("Mrs. Jane Doe"), "Doe, Jane")

    def test_return_lastname_comma_firstname_single_postnominal(self):
        self.assertEqual(self.inverter.invert("John Smith Sr."), "Smith, John Sr.")

    def test_return_lastname_comma_firstname_multiple_postnominals(self):
        self.assertEqual(self.inverter.invert("John Smith Sr. PhD."), "Smith, John Sr. PhD.")
