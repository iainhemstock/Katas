package katas.passwordvalidator;

import java.text.StringCharacterIterator;

public class UppercaseValidator implements PasswordValidatorType {

    @Override
    public boolean isValid(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

}
