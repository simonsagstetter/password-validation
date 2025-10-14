package com.github.simonsagstetter;

public final class PasswordValidator {

    private static final int minLengthDefault = 8;

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

}
