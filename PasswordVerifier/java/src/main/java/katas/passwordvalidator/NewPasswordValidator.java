package katas.passwordvalidator;

import java.util.ArrayList;
import java.util.List;

public class NewPasswordValidator {

    private List<PasswordValidatorType> validators;

    public NewPasswordValidator(List<PasswordValidatorType> validators) {
        this.validators = validators;
    }

    public boolean isValid(String desiredPassword) {
        List<Boolean> results = new ArrayList<Boolean>();
        for (PasswordValidatorType validator : this.validators) {
            Boolean result = validator.isValid(desiredPassword);
            results.add(result);
        }

        for (Boolean result : results) {
            if (result == false) return false;
        }

        return true;
    }
}
