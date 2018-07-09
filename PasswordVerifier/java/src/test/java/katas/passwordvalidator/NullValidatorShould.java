package katas.passwordvalidator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class NullValidatorShould {

    private NullValidator validator;

    @Before
    public void setUp() {
        this.validator = new NullValidator();
    }

    @Test
    public void not_validate_a_null_password() {
        String nullPassword = null;
        assertThat(this.validator.isValid(nullPassword), is(equalTo(false)));
    }

    @Test
    public void validate_a_non_null_password() {
        String nonNullPassword = "";
        assertThat(this.validator.isValid(nonNullPassword), is(equalTo(true)));
    }

}
