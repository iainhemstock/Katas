package katas.passwordvalidator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NewPasswordValidatorTypeShould {

    @Mock private LengthValidator lengthValidator;
    @Mock private UppercaseValidator uppercaseValidator;
    @Mock private LowercaseValidator lowercaseValidator;
    @Mock private NumericalValidator numericalValidator;
    @Mock private NullValidator nullValidator;
    private NewPasswordValidator newPasswordValidator;

    @Before
    public void setUp() {
        List<PasswordValidatorType> validators = new ArrayList();
        validators.add(lengthValidator);
        validators.add(uppercaseValidator);
        validators.add(lowercaseValidator);
        validators.add(numericalValidator);
        validators.add(nullValidator);

        newPasswordValidator = new NewPasswordValidator(validators);
    }

    @Test
    public void validate_password_when_is_null() {
        String nullPassword = null;
        newPasswordValidator.isValid(nullPassword);
        verify(nullValidator).isValid(nullPassword);
    }

    @Test
    public void validate_password_of_eight_chars_in_length() {
        String passwordOfEightChars = "jacuzzis";
        newPasswordValidator.isValid(passwordOfEightChars);
        verify(lengthValidator).isValid(passwordOfEightChars);
    }

    @Test
    public void validate_password_containing_at_least_one_uppercase_letter() {
        String passwordContainingAtLeastOneUppercaseLetter = "duBlin";
        newPasswordValidator.isValid(passwordContainingAtLeastOneUppercaseLetter);
        verify(uppercaseValidator).isValid(passwordContainingAtLeastOneUppercaseLetter);
    }

    @Test
    public void validate_password_containing_at_least_one_lowercase_letter() {
        String passwordContainingAtLeastOneLowercaseLetter = "MANHATtAN";
        newPasswordValidator.isValid(passwordContainingAtLeastOneLowercaseLetter);
        verify(lowercaseValidator).isValid(passwordContainingAtLeastOneLowercaseLetter);
    }

    @Test
    public void validate_password_containing_at_least_one_numerical_digit() {
        String passwordContainingAtLeastOneNumericalDigit = "riv3r";
        newPasswordValidator.isValid(passwordContainingAtLeastOneNumericalDigit);
        verify(numericalValidator).isValid(passwordContainingAtLeastOneNumericalDigit);
    }

}
