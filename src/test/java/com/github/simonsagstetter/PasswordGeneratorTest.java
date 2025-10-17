package com.github.simonsagstetter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {

    @DisplayName("generateSecurePassword_ShouldReturnValidPassword_WhenCalled: should always return valid password when called")
    @RepeatedTest(200)
    void generateSecurePassword_ShouldReturnValidPassword_WhenCalled(){
        String password = PasswordGenerator.generateSecurePassword();

        ValidationResult result = PasswordValidator.isValid(password);

        assertFalse(result.hasReason());
        assertTrue(result.getIsValid());
    }

    @Test
    @DisplayName("concat_ShouldReturnOneCorrectCharArray_WhenCalledWithNCharArrays: should return one correct ordered and concatenated char array when called with n char arrays")
    void concat_ShouldReturnOneCorrectCharArray_WhenCalledWithNCharArrays(){
        char[] a = new char[]{'a', 'B'};
        char[] b = new char[]{'1', '2'};
        char[] c = new char[]{'%', '&'};

        char[] expected = new char[]{'a', 'B', '1', '2', '%', '&'};

        char[] actual = PasswordGenerator.concat(a,b,c);

        assertArrayEquals(actual, expected);
    }

    @Test
    @DisplayName("shuffle_ShouldReturnDifferentOrder_WhenCalledWithCharArray: should return a different order when called with char array")
    void shuffle_ShouldReturnDifferentOrder_WhenCalledWithCharArray(){
        char[] array = new char[]{'a', 'B', '1', '2', '%', '&'};

        char[] actual = PasswordGenerator.shuffle(array);

        boolean isEqual = Arrays.equals(array, actual);
        assertFalse(isEqual);
    }

}