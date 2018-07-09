package katas.passwordvalidator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FeatureValidatePassword {

    private static final String ONE_UPPERCASE_ONE_LOWERCASE_ONE_NUMBER_AND_AT_LEAST_8_CHARS = "r1vErd4nce";
    private NewPasswordValidator newPasswordValidator;

    @Before
    public void setUp() {
        List<PasswordValidatorType> validators = new ArrayList();
        validators.add(new NullValidator());
        validators.add(new LengthValidator());
        validators.add(new UppercaseValidator());
        validators.add(new LowercaseValidator());
        validators.add(new NumericalValidator());

        newPasswordValidator = new NewPasswordValidator(validators);
    }

    @Test
    public void validate_a_password() {
        String desiredPassword = ONE_UPPERCASE_ONE_LOWERCASE_ONE_NUMBER_AND_AT_LEAST_8_CHARS;
        assertThat(newPasswordValidator.isValid(desiredPassword), is(true));
    }

}
