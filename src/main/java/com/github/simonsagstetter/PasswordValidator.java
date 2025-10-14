package com.github.simonsagstetter;

public final class PasswordValidator {

    private static final int minLengthDefault = 8;

    public static boolean hasMinLength(String password){
        return password != null && password.trim().length() >= minLengthDefault;
    }

}
