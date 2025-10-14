package com.github.simonsagstetter;

public final class PasswordValidator {

    private static final int minLengthDefault = 8;

    public static boolean hasMinLength(String password){
        return password != null && password.trim().length() >= minLengthDefault;
    }

    public static boolean containsDigit(String password){
        for(char c : password.toCharArray()){
            if(c >= '0' && c <= '9')return true;
        }
        return false;
    }

}
