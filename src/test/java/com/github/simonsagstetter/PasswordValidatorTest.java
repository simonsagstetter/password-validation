package com.github.simonsagstetter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void hasMinLength_ShouldReturnFalse_WhenCalledWith7Chars(){
        String password = "BadPass";

        boolean hasMinLength = PasswordValidator.hasMinLength(password);

        assertFalse(hasMinLength);
    }

    @Test
    void hasMinLength_ShouldReturnTrue_WhenCalledWith8Chars(){
        String password = "Passwords";

        boolean hasMinLength = PasswordValidator.hasMinLength(password);

        assertTrue(hasMinLength);
    }

    @Test
    void hasMinLength_ShouldReturnTrue_WhenCalledWith9Chars(){
        String password = "Passwords";

        boolean hasMinLength = PasswordValidator.hasMinLength(password);

        assertTrue(hasMinLength);
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenCalledWithEmptyString(){
        String password = "          ";

        boolean hasMinLength = PasswordValidator.hasMinLength(password);

        assertFalse(hasMinLength);
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenCalledWithWhiteSpaces(){
        String password = "    test      ";

        boolean hasMinLength = PasswordValidator.hasMinLength(password);

        assertFalse(hasMinLength);
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenCalledWithNull(){
        String password = null;

        boolean hasMinLength = PasswordValidator.hasMinLength(password);

        assertFalse(hasMinLength);
    }

}