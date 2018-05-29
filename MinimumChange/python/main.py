from unittest import TestCase
from ChangeMaker import ChangeMaker
# ==================================================================================================
#
# ==================================================================================================
class ChangeMakerShould(TestCase):
    def setUp(self):
        self.cm = ChangeMaker()
    # ----------------------------------------------------------------------------------------------
    def test_find_minimum_coins_for_int_pennies_amount(self):
        self.assertEqual(self.cm.makeChange(1), '1 x 1p coin')
        self.assertEqual(self.cm.makeChange(2), '1 x 2p coin')
        self.assertEqual(self.cm.makeChange(5), '1 x 5p coin')
        self.assertEqual(self.cm.makeChange(8), '1 x 5p coin, 1 x 2p coin and 1 x 1p coin')
        self.assertEqual(self.cm.makeChange(10), '1 x 10p coin')
        self.assertEqual(self.cm.makeChange(20), '1 x 20p coin')
        self.assertEqual(self.cm.makeChange(50), '1 x 50p coin')
        self.assertEqual(self.cm.makeChange(100), '1 x £1 coin')
        self.assertEqual(self.cm.makeChange(200), '1 x £2 coin')
        self.assertEqual(self.cm.makeChange(300), '1 x £2 coin and 1 x £1 coin')
        self.assertEqual(self.cm.makeChange(388), '1 x £2 coin, 1 x £1 coin, 1 x 50p coin, '
                                                    '1 x 20p coin, 1 x 10p coin, 1 x 5p coin, '
                                                    '1 x 2p coin and 1 x 1p coin')
        self.assertEqual(self.cm.makeChange(400), '2 x £2 coin')
        self.assertEqual(self.cm.makeChange(600), '3 x £2 coin')
    # ----------------------------------------------------------------------------------------------
    def test_find_minimum_coins_for_string_pennies_amount(self):
        self.assertEqual(self.cm.makeChange("50p"), '1 x 50p coin')
        self.assertEqual(self.cm.makeChange("75p"), '1 x 50p coin, 1 x 20p coin and 1 x 5p coin')
        self.assertEqual(self.cm.makeChange("200p"), '1 x £2 coin')
    # ----------------------------------------------------------------------------------------------
    def test_find_minimum_coins_for_string_pound_amount(self):
        self.assertEqual(self.cm.makeChange('£1'), '1 x £1 coin')
        self.assertEqual(self.cm.makeChange('£2'), '1 x £2 coin')
        self.assertEqual(self.cm.makeChange('£3'), '1 x £2 coin and 1 x £1 coin')
        self.assertEqual(self.cm.makeChange('£7'), '3 x £2 coin and 1 x £1 coin')
    # ----------------------------------------------------------------------------------------------
    def test_find_minimum_coins_for_string_pound_and_pennies_amount(self):
        self.assertEqual(self.cm.makeChange('£0.10'), '1 x 10p coin')
        self.assertEqual(self.cm.makeChange('£2.10'), '1 x £2 coin and 1 x 10p coin')
        self.assertEqual(self.cm.makeChange('£1.18'), '1 x £1 coin, 1 x 10p coin, '
                                                        '1 x 5p coin, 1 x 2p coin and 1 x 1p coin')
    # ----------------------------------------------------------------------------------------------
    def test_raise_exception_on_invalid_input(self):
        with self.assertRaises(ValueError):
            self.cm.makeChange("£1p")
            self.cm.makeChange("2£2")
            self.cm.makeChange("20pp")
            self.cm.makeChange("-45p")
            self.cm.makeChange("£45£")
            self.cm.makeChange("4.2.")
            self.cm.makeChange("2£0p")
            self.cm.makeChange("£00.1")
