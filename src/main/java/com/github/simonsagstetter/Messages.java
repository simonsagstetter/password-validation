package com.github.simonsagstetter;

public final class Messages {

    private Messages(){}

    public static String NOT_HAS_MIN_LENGTH(String s) {
        return s != null ? s + " does not meet the required minimum length of " + PasswordValidator.minLengthDefault : "";
    }

    public static String NOT_CONTAINS_DIGIT(String s) {
        return s != null ? s + " does not contain a digit" : "";
    }

    public static String NOT_CONTAINS_UPPER_AND_LOWER(String s) {
        return s != null ? s + " does not contain upper and lower case characters" : "";
    }

    public static String IS_COMMON_PASSWORD(String s) {
        return s != null ? s + " was identified as an unsecure password" : "";
    }

    public static String NOT_CONTAINS_SPECIAL_CHAR(String s) {
        return s != null ? s + " does not contain a special char from the allowed set (" + PasswordValidator.allowedSpecialChars + ")" : "";
    }

}
