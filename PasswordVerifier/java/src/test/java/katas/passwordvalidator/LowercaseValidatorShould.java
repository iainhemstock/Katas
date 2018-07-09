package katas.passwordvalidator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Parameterized.class)
public class LowercaseValidatorShould {

    private LowercaseValidator validator;
    private String password;
    private Boolean result;

    @Before
    public void setUp() {
        this.validator = new LowercaseValidator();
    }

    public LowercaseValidatorShould(String password, Boolean result) {
        this.password = password;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { "A", false },
            { "a", true },
            { "aB", true },
            { "bA", true },
            { "AB", false },
            { "ab", true }
        });
    }

    @Test
    public void validate_password_containing_at_least_one_lowercase_letter() {
        assertThat(this.validator.isValid(password), is(equalTo(result)));
    }

}
