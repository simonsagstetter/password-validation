package com.github.simonsagstetter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationResultTest {


    @Test
    @DisplayName("getIsValid_ShouldReturnFalse_WhenCalledWithNewInstance: getIsValid() should return false when called with new instance")
    void getIsValid_ShouldReturnFalse_WhenCalledWithNewInstance(){
        ValidationResult r = new ValidationResult();
        assertFalse(r.getIsValid());
    }

    @Test
    @DisplayName("hasReason_ShouldReturnFalse_WhenCalledWithNewInstance: hasReason() should return false when called with new instance")
    void hasReason_ShouldReturnFalse_WhenCalledWithNewInstance(){
        ValidationResult r = new ValidationResult();
        assertFalse(r.hasReason());
    }

    @Test
    @DisplayName("toString_ShouldReturnInstance_WhenCalledWithNewInstance: toString() should return a string the contains the instance when called with a new instance")
    void toString_ShouldReturnInstance_WhenCalledWithNewInstance(){
        ValidationResult r = new ValidationResult();

        String expected = "ValidationResult{isValid=false, reasons=[]}";

        assertEquals(expected, r.toString());
    }

    @Test
    @DisplayName("getIsValid_ShouldReturnFalse_WhenSetIsValidCalledWithFalse: getIsValid() should return false when setIsValid() is called with false")
    void getIsValid_ShouldReturnFalse_WhenSetIsValidCalledWithFalse(){
        ValidationResult r = new ValidationResult();
        r.setIsValid(false);
        assertFalse(r.getIsValid());
    }

    @Test
    @DisplayName("getIsValid_ShouldReturnTrue_WhenSetIsValidCalledWithTrue: getIsValid() should return true when setIsValid() is called with true")
    void getIsValid_ShouldReturnTrue_WhenSetIsValidCalledWithTrue(){
        ValidationResult r = new ValidationResult();
        r.setIsValid(true);
        assertTrue(r.getIsValid());
    }

    @Test
    @DisplayName("hasReason_ShouldReturnFalse_WhenCalledOnNewInstance: hasReason() should return false when called on new instance")
    void hasReason_ShouldReturnFalse_WhenCalledOnNewInstance(){
        ValidationResult r = new ValidationResult();

        assertFalse(r.hasReason());
    }

    @Test
    @DisplayName("hasReason_ShouldReturnTrue_WhenAddReasonCalledWithNewReason: hasReason() should return true when addReason() called with new reason")
    void hasReason_ShouldReturnTrue_WhenAddReasonCalledWithNewReason(){
        ValidationResult r = new ValidationResult();
        r.addReason("reason");

        assertTrue(r.hasReason());
    }

    @Test
    @DisplayName("addReason_ShouldReturnNewPointerToObjectInstance_WhenCalledWithReasonAndTrue: addReason() should return new pointer to object instance when called with a reason and true")
    void addReason_ShouldReturnNewPointerToObjectInstance_WhenCalledWithReasonAndTrue(){
        ValidationResult r = new ValidationResult();
        ValidationResult returnValue = r.addReason("reason", true);

        assertEquals(r, returnValue);
    }

    @Test
    @DisplayName("getReasons_ShouldReturnReasonList_WhenCalled: getReasons() should return a ArrayList of strings when called")
    void getReasons_ShouldReturnReasonList_WhenCalled(){
        ValidationResult r = new ValidationResult();
        r.addReason("reason");
        ArrayList<String> expectedReasons = new ArrayList<String>(List.of("reason"));

        assertEquals(expectedReasons, r.getReasons());
    }

    @Test
    @DisplayName("getReasons_ShouldReturnReasonEmptyList_WhenCalled: getReasons() should return a empty ArrayList when called")
    void getReasons_ShouldReturnReasonEmptyList_WhenCalled(){
        ValidationResult r = new ValidationResult();
        ArrayList<String> expectedReasons = new ArrayList<String>();

        assertEquals(expectedReasons, r.getReasons());
    }

    @Test
    @DisplayName("clearReasons_ShouldEmptyReasonList_WhenCalled: clearReasons() should empty reasons ArrayList when called")
    void clearReasons_ShouldEmptyReasonList_WhenCalled(){
        ValidationResult r = new ValidationResult();
        r.addReason("reason");
        r.clearReasons();
        ArrayList<String> expectedReasons = new ArrayList<String>();
        assertEquals(expectedReasons, r.getReasons());
    }


}