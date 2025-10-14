package com.github.simonsagstetter;

public final class PasswordValidator {

    public static boolean hasMinLength(String password, int min){
        return password != null && password.trim().length() >= min;
    }

}
