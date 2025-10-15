package com.github.simonsagstetter;

import java.util.Set;
import java.util.Locale;

public final class PasswordValidator {

    private static final int minLengthDefault = 8;
    private static final Set<String> commonPasswords = Set.of("12345678", "password", "qwertzui", "asdfghjk", "abcdefgh", "00000000");
    private static final String allowedSpecialChars = "!@#$%^&*()-_+=?.,;:";

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

    public static boolean isValid(String password){
        if(isCommonPassword(password))return false;

        int fulfilledPolicyCount = 0;

        if(hasMinLength(password))++fulfilledPolicyCount;
        if(containsDigit(password))++fulfilledPolicyCount;
        if(containsUpperAndLower(password) && ++fulfilledPolicyCount >=3)return true;

        return containsSpecialChar(password) && ++fulfilledPolicyCount >= 3;
    }
}
