package com.github.simonsagstetter;

public final class PasswordValidator {

    private static final int minLengthDefault = 8;
    private static final String[] digits = {"1", "2", "3" , "4", "5", "6", "7", "8", "9", "0"};

    public static boolean hasMinLength(String password){
        return password != null && password.trim().length() >= minLengthDefault;
    }

    public static boolean containsDigit(String password){
        for(String s : password.split("")){
            for(String d: digits){
                if(s.equals(d))return true;
            }
        }
        return false;
    }

}
