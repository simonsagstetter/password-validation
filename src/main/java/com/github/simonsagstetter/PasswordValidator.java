package com.github.simonsagstetter;

import java.util.Locale;

public final class PasswordValidator {

    private static final int minLengthDefault = 8;
    private static final String[] commonPasswords = { "12345678", "password", "qwertzui", "asdfghjk", "abcdefgh", "00000000"};

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
        String normalizedString = password.trim().toLowerCase(Locale.ROOT);
        for(String commonPassword : commonPasswords){
            if(commonPassword.equals(normalizedString))return true;
        }
        return false;
    }
}
