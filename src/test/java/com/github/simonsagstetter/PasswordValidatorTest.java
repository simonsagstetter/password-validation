package com.github.simonsagstetter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {


    @Nested
    @DisplayName("all tests for method hasMinLength in PasswordValidator class")
    class hasMinLengthTest {

        @Test
        @DisplayName("should return false when called with a string that has only 7 characters")
        void hasMinLength_ShouldReturnFalse_WhenCalledWith7Chars(){
            String password = "BadPass";

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertFalse(hasMinLength);
        }

        @Test
        @DisplayName("should return true when called with a string that has 8 characters")
        void hasMinLength_ShouldReturnTrue_WhenCalledWith8Chars(){
            String password = "Passwords";

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertTrue(hasMinLength);
        }

        @Test
        @DisplayName("should return true when called with a string that has 9 characters")
        void hasMinLength_ShouldReturnTrue_WhenCalledWith9Chars(){
            String password = "Passwords";

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertTrue(hasMinLength);
        }

        @Test
        @DisplayName("should return false when called with an empty string")
        void hasMinLength_ShouldReturnFalse_WhenCalledWithEmptyString(){
            String password = "          ";

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertFalse(hasMinLength);
        }

        @Test
        @DisplayName("should return false when called with a string that has white spaces")
        void hasMinLength_ShouldReturnFalse_WhenCalledWithWhiteSpaces(){
            String password = "    test      ";

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertFalse(hasMinLength);
        }

        @Test
        @DisplayName("should return false when called with a string that is null")
        void hasMinLength_ShouldReturnFalse_WhenCalledWithNull(){
            String password = null;

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertFalse(hasMinLength);
        }

    }

    @Nested
    @DisplayName("all tests for method containsDigit in PasswordValidator class")
    class containsDigitTest {

        @Test
        @DisplayName("should return false when called with a string that does not contain a digit")
        void containsDigit_ShouldReturnFalse_WhenCalledWithNoDigit(){
            String password = "password";

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertFalse(containsDigit);
        }

        @Test
        @DisplayName("should return true when called with a string that does contain one digit")
        void containsDigit_ShouldReturnTrue_WhenCalledWith1Digit(){
            String password = "passw0rd";

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertTrue(containsDigit);
        }

        @Test
        @DisplayName("should return true when called with a string that does only contain digits")
        void containsDigit_ShouldReturnTrue_WhenCalledWithOnlyDigits(){
            String password = "123456";

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertTrue(containsDigit);
        }

        @Test
        @DisplayName("should return true when called with a string that does contain several digits")
        void containsDigit_ShouldReturnTrue_WhenCalledWithSeveralDigits(){
            String password = "pa55w0rd1";

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertTrue(containsDigit);
        }

        @Test
        @DisplayName("should return false when called with a string that does contain a unicode")
        void containsDigit_ShouldReturnFalse_WhenCalledWithUnicode(){
            String password = "Simon😀";

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertFalse(containsDigit);
        }

    }
}