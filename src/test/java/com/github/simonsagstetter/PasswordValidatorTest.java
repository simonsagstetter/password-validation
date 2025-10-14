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

    @Nested
    @DisplayName("all tests for method containsUpperAndLower in PasswordValidator class")
    class containsUpperAndLowerTest {

        @Test
        @DisplayName("should return false when called with a lowercase only string")
        void containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyLowercase(){
            String password = "password";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertFalse(containsUpperAndLower);
        }

        @Test
        @DisplayName("should return false when called with a uppercase only string")
        void containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyUppercase(){
            String password = "PASSWORD";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertFalse(containsUpperAndLower);
        }

        @Test
        @DisplayName("should return true when called with a one uppercase string")
        void containsUpperAndLower_ShouldReturnTrue_WhenCalledWithOneUppercase(){
            String password = "Password";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertTrue(containsUpperAndLower);
        }

        @Test
        @DisplayName("should return true when called with a one lowercase string")
        void containsUpperAndLower_ShouldReturnTrue_WhenCalledWithOneLowercase(){
            String password = "PAsSWORD";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertTrue(containsUpperAndLower);
        }

        @Test
        @DisplayName("should return true when called with a mixed case string")
        void containsUpperAndLower_ShouldReturnTrue_WhenCalledWithMixedCase(){
            String password = "PassWorD";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertTrue(containsUpperAndLower);
        }

        @Test
        @DisplayName("should return true when called with a mixed case and special character string")
        void containsUpperAndLower_ShouldReturnTrue_WhenCalledWithMixedAndSpecial(){
            String password = "Passwörd";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertTrue(containsUpperAndLower);
        }

        @Test
        @DisplayName("should return false when called with a lower only and special character string")
        void containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyLowerSpecial(){
            String password = "passwörd";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertFalse(containsUpperAndLower);
        }

        @Test
        @DisplayName("should return false when called with a upper only and special character string")
        void containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyUpperSpecial(){
            String password = "PASSWÖRD";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertFalse(containsUpperAndLower);
        }

    }
}