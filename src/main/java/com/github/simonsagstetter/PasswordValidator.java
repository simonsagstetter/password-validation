package com.github.simonsagstetter;

import java.util.Set;
import java.util.Locale;

public final class PasswordValidator{

    public static final int minLengthDefault = 8;
    public static final Set<String> commonPasswords = Set.of("12345678", "password", "qwertzui", "asdfghjk", "abcdefgh", "00000000");
    public static final String allowedSpecialChars = "!@#$%^&*()-_+=?.,;:";

    private PasswordValidator(){}

    public static boolean hasMinLength(String password){
        return password != null && password.trim().length() >= minLengthDefault;
    }

    public static boolean containsDigit(String password){
        if(password == null)return false;
        for(char c : password.toCharArray()){
            if(Character.isDigit(c))return true;
        }
        return false;
    }

    public static boolean containsUpperAndLower(String password){
        if(password == null)return false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;

        for(char c: password.toCharArray()){
            if(!hasLowerCase && Character.isLowerCase(c))hasLowerCase = true;
            else if(!hasUpperCase && Character.isUpperCase(c))hasUpperCase = true;
            if(hasLowerCase && hasUpperCase)return true;
        }

        return false;
    }

    public static boolean isCommonPassword(String password){
        if(password == null)return false;
        return commonPasswords.contains(password.trim().toLowerCase(Locale.ROOT));
    }

    public static boolean containsSpecialChar(String password){
        if(password == null)return false;

        for(char c : password.toCharArray()){
            if(!Character.isLetterOrDigit(c) && allowedSpecialChars.contains(String.valueOf(c))) return true;
        }

        return false;
    }

    public static ValidationResult isValid(String password){
        ValidationResult result = new ValidationResult();
        if(password == null)return result;

        if(isCommonPassword(password)) return result.addReason(Messages.IS_COMMON_PASSWORD(password), true);
        if(!hasMinLength(password))return result.addReason(Messages.NOT_HAS_MIN_LENGTH(password), true);

        int policyCount = 0;
        boolean hasDigit = containsDigit(password);
        boolean hasUpperLower = containsUpperAndLower(password);
        boolean hasSpecial = containsSpecialChar(password);

        if (hasDigit) policyCount++;
        if (hasUpperLower) policyCount++;
        if (hasSpecial) policyCount++;

        if (!hasDigit) result.addReason(Messages.NOT_CONTAINS_DIGIT(password));
        if (!hasUpperLower) result.addReason(Messages.NOT_CONTAINS_UPPER_AND_LOWER(password));
        if (!hasSpecial) result.addReason(Messages.NOT_CONTAINS_SPECIAL_CHAR(password));

        if (policyCount >= 2) {
            result.setIsValid(true);
            result.clearReasons();
        }

        return result;
    }
}
