package katas.passwordvalidator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Parameterized.class)
public class NumericalValidatorShould {

    private NumericalValidator validator;
    private String password;
    private Boolean result;

    public NumericalValidatorShould(String password, Boolean result) {
        this.password = password;
        this.result = result;
    }

    @Before
    public void setUp() {
        this.validator = new NumericalValidator();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {  "a", false },
                {  "2", true },
                {  "2a", true },
                {  "a2", true },
                {  "ab", false },
                {  "23", true }
        });
    }
    @Test
    public void validate_password_containing_at_least_one_numerical_digit() {
        assertThat(this.validator.isValid(password), is(equalTo(result)));
    }
}
