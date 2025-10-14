package com.github.simonsagstetter;

import java.util.Locale;
import java.util.Set;

public final class PasswordValidator {

    private static final int minLengthDefault = 8;
    private static final Set<String> commonPasswords = Set.of("12345678", "password", "qwertzui", "asdfghjk", "abcdefgh", "00000000");

    public static boolean hasMinLength(String password){
        return password != null && password.trim().length() >= minLengthDefault;
    }

    public static boolean containsDigit(String password){
        for(char c : password.toCharArray()){
            if(c >= '0' && c <= '9')return true;
        }
        return false;
    }

    public static boolean containsUpperAndLower(String password){
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
}
