package com.github.simonsagstetter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("isYes_ShouldReturnTrue_WhenCalledWithLowerCaseY: isYes should return true when called with an y")
    void isYes_ShouldReturnTrue_WhenCalledWithLowerCaseY(){
        assertTrue(Main.isYes("y"));
    }

    @Test
    @DisplayName("isYes_ShouldReturnTrue_WhenCalledWithUpperCaseS: isYes should return true when called with an Y")
    void isYes_ShouldReturnTrue_WhenCalledWithUpperCaseY(){
        assertTrue(Main.isYes("Y"));
    }

    @Test
    @DisplayName("isYes_ShouldReturnFalse_WhenCalledWithEmptyString: isYes should return false when called with an empty string")
    void isYes_ShouldReturnFalse_WhenCalledWithEmptyString(){
        assertFalse(Main.isYes(""));
    }

    @Test
    @DisplayName("isYes_ShouldReturnFalse_WhenCalledWithNull: isYes should return false when called with null")
    void isYes_ShouldReturnFalse_WhenCalledWithNull(){
        assertFalse(Main.isYes(null));
    }

    @Test
    @DisplayName("isYes_ShouldReturnFalse_WhenCalledWithAnything: isYes should return false when called with anything")
    void isYes_ShouldReturnFalse_WhenCalledWithAnything(){
        assertFalse(Main.isYes("asdalsdjosaj8saZ(7"));
    }
}