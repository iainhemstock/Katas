package katas.passwordvalidator;

public class NullValidator implements PasswordValidatorType {

    @Override
    public boolean isValid(String password) {
        if (password == null) return false;
        return true;
    }

}
