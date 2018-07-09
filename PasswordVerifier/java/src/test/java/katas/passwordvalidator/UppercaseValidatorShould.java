package katas.passwordvalidator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class UppercaseValidatorShould {

    private UppercaseValidator validator;
    private String password;
    private Boolean result;

    public UppercaseValidatorShould(String password, Boolean result) {
        this.password = password;
        this.result = result;
    }

    @Before
    public void setUp() {
        this.validator = new UppercaseValidator();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "a", false },
                { "A", true },
                { "ab", false },
                { "Ab", true },
                { "aB", true },
                { "AB", true },
        });
    }
    @Test
    public void validate_password_containing_at_least_one_uppercase_letter() {
        assertThat(this.validator.isValid(password), is(equalTo(result)));
    }

}
