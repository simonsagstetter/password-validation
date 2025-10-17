package com.github.simonsagstetter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class MessagesTest {

    public static final String hasMinLengthExpected = " does not meet the required minimum length of " + PasswordValidator.minLengthDefault;
    public static final String containsDigitExpected = " does not contain a digit";
    public static final String containsUpperAndLowerExpected = " does not contain upper and lower case characters";
    public static final String isCommonPasswordExpected = " was identified as an unsecure password";
    public static final String containsSpecialCharExpected = " does not contain a special char from the allowed set (" + PasswordValidator.allowedSpecialChars + ")";

    @Test
    @DisplayName("NOT_HAS_MIN_LENGTH: should return a string the contains the passed string s")
    void NOT_HAS_MIN_LENGTH_ShouldReturnStringThatContainsPassedStringS_WhenCalledWithAnyString(){
        String s = "Pass";

        String expected = s + hasMinLengthExpected;

        String message = Messages.NOT_HAS_MIN_LENGTH(s);

        assertEquals(expected, message);
    }

    @Test
    @DisplayName("NOT_HAS_MIN_LENGTH: should return empty string when passed string null")
    void NOT_HAS_MIN_LENGTH_ShouldReturnEmptyString_WhenCalledWithNull(){
        String s = null;

        String message = Messages.NOT_HAS_MIN_LENGTH(s);

        assertTrue(message.isEmpty());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @CsvFileSource(files = "src/test/resources/valid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @DisplayName("NOT_HAS_MIN_LENGTH: should return a string the contains the passed string from csv file source")
    void NOT_HAS_MIN_LENGTH_ShouldReturnStringThatContainsPassedStringS_WhenCalledWithAnyStringFromCSVFileSource(String s){
        String expected = s + hasMinLengthExpected;

        String actual = Messages.NOT_HAS_MIN_LENGTH(s);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("NOT_CONTAINS_DIGIT: should return a string the contains the passed string s")
    void NOT_CONTAINS_DIGIT_ShouldReturnStringThatContainsPassedStringS_WhenCalledWithAnyString(){
        String s = "Password!";

        String expected = s + containsDigitExpected;

        String message = Messages.NOT_CONTAINS_DIGIT(s);

        assertEquals(expected, message);
    }

    @Test
    @DisplayName("NOT_CONTAINS_DIGIT: should return empty string when passed string null")
    void NOT_CONTAINS_DIGIT_ShouldReturnEmptyString_WhenCalledWithNull(){
        String s = null;

        String message = Messages.NOT_CONTAINS_DIGIT(s);

        assertTrue(message.isEmpty());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @CsvFileSource(files = "src/test/resources/valid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @DisplayName("NOT_CONTAINS_DIGIT: should return a string the contains the passed string from csv file source")
    void NOT_CONTAINS_DIGIT_ShouldReturnStringThatContainsPassedStringS_WhenCalledWithAnyStringFromCSVFileSource(String s){
        String expected = s + containsDigitExpected;

        String actual = Messages.NOT_CONTAINS_DIGIT(s);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("NOT_CONTAINS_UPPER_AND_LOWER: should return a string the contains the passed string s")
    void NOT_CONTAINS_UPPER_AND_LOWER_ShouldReturnStringThatContainsPassedStringS_WhenCalledWithAnyString(){
        String s = "password!";

        String expected = s + containsUpperAndLowerExpected;

        String message = Messages.NOT_CONTAINS_UPPER_AND_LOWER(s);

        assertEquals(expected, message);
    }

    @Test
    @DisplayName("NOT_CONTAINS_UPPER_AND_LOWER: should return empty string when passed string null")
    void NOT_CONTAINS_UPPER_AND_LOWER_ShouldReturnEmptyString_WhenCalledWithNull(){
        String s = null;

        String message = Messages.NOT_CONTAINS_UPPER_AND_LOWER(s);

        assertTrue(message.isEmpty());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @CsvFileSource(files = "src/test/resources/valid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @DisplayName("NOT_CONTAINS_UPPER_AND_LOWER: should return a string the contains the passed string from csv file source")
    void NOT_CONTAINS_UPPER_AND_LOWER_ShouldReturnStringThatContainsPassedStringS_WhenCalledWithAnyStringFromCSVFileSource(String s){
        String expected = s + containsUpperAndLowerExpected;

        String actual = Messages.NOT_CONTAINS_UPPER_AND_LOWER(s);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("IS_COMMON_PASSWORD: should return a string the contains the passed string s")
    void IS_COMMON_PASSWORD_ShouldReturnStringThatContainsPassedStringS_WhenCalledWithAnyString(){
        String s = "password!";

        String expected = s + isCommonPasswordExpected;

        String message = Messages.IS_COMMON_PASSWORD(s);

        assertEquals(expected, message);
    }

    @Test
    @DisplayName("IS_COMMON_PASSWORD: should return empty string when passed string null")
    void IS_COMMON_PASSWORD_ShouldReturnEmptyString_WhenCalledWithNull(){
        String s = null;

        String message = Messages.IS_COMMON_PASSWORD(s);

        assertTrue(message.isEmpty());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @CsvFileSource(files = "src/test/resources/valid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @DisplayName("IS_COMMON_PASSWORD: should return a string the contains the passed string from csv file source")
    void IS_COMMON_PASSWORD_ShouldReturnStringThatContainsPassedStringS_WhenCalledWithAnyStringFromCSVFileSource(String s){
        String expected = s + isCommonPasswordExpected;

        String actual = Messages.IS_COMMON_PASSWORD(s);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("NOT_CONTAINS_SPECIAL_CHAR: should return a string the contains the passed string s")
    void NOT_CONTAINS_SPECIAL_CHAR_ShouldReturnStringThatContainsPassedStringS_WhenCalledWithAnyString(){
        String s = "password!";

        String expected = s + containsSpecialCharExpected;

        String message = Messages.NOT_CONTAINS_SPECIAL_CHAR(s);

        assertEquals(expected, message);
    }

    @Test
    @DisplayName("NOT_CONTAINS_SPECIAL_CHAR: should return empty string when passed string null")
    void NOT_CONTAINS_SPECIAL_CHAR_ShouldReturnEmptyString_WhenCalledWithNull(){
        String s = null;

        String message = Messages.NOT_CONTAINS_SPECIAL_CHAR(s);

        assertTrue(message.isEmpty());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @CsvFileSource(files = "src/test/resources/valid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @DisplayName("NOT_CONTAINS_SPECIAL_CHAR: should return a string the contains the passed string from csv file source")
    void NOT_CONTAINS_SPECIAL_CHAR_ShouldReturnStringThatContainsPassedStringS_WhenCalledWithAnyStringFromCSVFileSource(String s){
        String expected = s + containsSpecialCharExpected;

        String actual = Messages.NOT_CONTAINS_SPECIAL_CHAR(s);

        assertEquals(expected, actual);
    }
}