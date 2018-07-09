package katas.passwordvalidator;

public class LengthValidator implements PasswordValidatorType {

    public static final int MINIMUM_REQUIRED_LENGTH = 8;

    @Override
    public boolean isValid(String password) {
        if (password.length() >= MINIMUM_REQUIRED_LENGTH) return true;
        return false;
    }

}
