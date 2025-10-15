package com.github.simonsagstetter;

import java.nio.CharBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PasswordGenerator {

    private static final SecureRandom rand = new SecureRandom();
    private static final int LENGTH = 15;
    private static final char[] LOWERCASE = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] DIGITS = "0123456789".toCharArray();
    private static final char[] SPECIAL_CHARS = PasswordValidator.allowedSpecialChars.toCharArray();
    private static final char[] ALL = concat(LOWERCASE, UPPERCASE, DIGITS, SPECIAL_CHARS);

    public static char[] concat(char[]... arrays){
        int length = 0;
        for(char[] array : arrays){
            length += array.length;
        }

        CharBuffer cb = CharBuffer.allocate(length);

        for(char[] array: arrays)cb.put(array);

        return cb.array();
    }

    public static String generateSecurePassword(){
        char[] passwordChars = new char[LENGTH];

        passwordChars[0] = LOWERCASE[rand.nextInt(LOWERCASE.length)];
        passwordChars[1] = UPPERCASE[rand.nextInt(UPPERCASE.length)];
        passwordChars[2] = DIGITS[rand.nextInt(DIGITS.length)];
        passwordChars[3] = SPECIAL_CHARS[rand.nextInt(SPECIAL_CHARS.length)];

        for(int i= 4; i < LENGTH; i++){
            passwordChars[i] = ALL[rand.nextInt(ALL.length)];
        }

        return String.valueOf(shuffle(passwordChars));
    }

    public static char[] shuffle(char[] array){
        char[] newArray = new char[array.length];
        List<Character> charList = new ArrayList<Character>();

        for(char c : array)charList.add(c);
        Collections.shuffle(charList, rand);
        for(int i=0; i < charList.size(); i++){
            newArray[i] = charList.get(i);
        }

        return newArray;
    }


}
