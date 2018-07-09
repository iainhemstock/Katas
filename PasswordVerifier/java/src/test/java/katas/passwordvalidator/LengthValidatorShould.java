package katas.passwordvalidator;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class LengthValidatorShould {

    private LengthValidator lengthValidator;
    private String password;
    private Boolean result;

    @Before
    public void setUp() {
        this.lengthValidator = new LengthValidator();
    }

    public LengthValidatorShould(String password, Boolean result) {
        this.password = password;
        this.result = result;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "", false },
                { "j", false },
                { "ja", false },
                { "jac", false },
                { "jacu", false },
                { "jacuz", false },
                { "jacuzz", false },
                { "jacuzzi", false },
                { "jacuzzis", true },
                { "jacuzziss", true },
                { "jacuzzisss", true },
                { "jacuzzissss", true },
                { "jacuzzisssss", true },
                { "jacuzzissssss", true },
                { "jacuzzisssssss", true },
        });
    }
    @Test
    public void not_validate_password_with_length_less_than_minimum_required_length() {
        assertThat(this.lengthValidator.isValid(password), is(equalTo(result)));
    }

//    @Test
//    public void validate_password_with_length_equal_to_or_greater_than_minimum_required_length() {
//        assertThat(this.lengthValidator.isValid("jacuzzis"), is(VALID));
//        assertThat(this.lengthValidator.isValid("jacuzziss"), is(true));
//        assertThat(this.lengthValidator.isValid("jacuzzisss"), is(true));
//        assertThat(this.lengthValidator.isValid("jacuzzissss"), is(true));
//        assertThat(this.lengthValidator.isValid("jacuzzisssss"), is(true));
//        assertThat(this.lengthValidator.isValid("jacuzzissssss"), is(true));
//    }
}

