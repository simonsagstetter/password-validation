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


}