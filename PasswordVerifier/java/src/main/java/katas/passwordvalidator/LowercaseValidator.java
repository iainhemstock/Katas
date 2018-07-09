package katas.passwordvalidator;

public class LowercaseValidator implements PasswordValidatorType {

    @Override
    public boolean isValid(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) return true;
        }
        return false;
    }

}
