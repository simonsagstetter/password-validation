package com.github.simonsagstetter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {


    @Nested
    @DisplayName("hasMinLengthTest: all tests for method hasMinLength in PasswordValidator class")
    class hasMinLengthTest {

        @Test
        @DisplayName("hasMinLength_ShouldReturnFalse_WhenCalledWith7Chars: should return false when called with a string that has only 7 characters")
        void hasMinLength_ShouldReturnFalse_WhenCalledWith7Chars(){
            String password = "BadPass";

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertFalse(hasMinLength);
        }

        @Test
        @DisplayName("hasMinLength_ShouldReturnTrue_WhenCalledWith8Chars: should return true when called with a string that has 8 characters")
        void hasMinLength_ShouldReturnTrue_WhenCalledWith8Chars(){
            String password = "Passwords";

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertTrue(hasMinLength);
        }

        @Test
        @DisplayName("hasMinLength_ShouldReturnTrue_WhenCalledWith9Chars: should return true when called with a string that has 9 characters")
        void hasMinLength_ShouldReturnTrue_WhenCalledWith9Chars(){
            String password = "Passwords";

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertTrue(hasMinLength);
        }

        @Test
        @DisplayName("hasMinLength_ShouldReturnFalse_WhenCalledWithEmptyString: should return false when called with an empty string")
        void hasMinLength_ShouldReturnFalse_WhenCalledWithEmptyString(){
            String password = "          ";

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertFalse(hasMinLength);
        }

        @Test
        @DisplayName("hasMinLength_ShouldReturnFalse_WhenCalledWithWhiteSpaces: should return false when called with a string that has white spaces")
        void hasMinLength_ShouldReturnFalse_WhenCalledWithWhiteSpaces(){
            String password = "    test      ";

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertFalse(hasMinLength);
        }

        @Test
        @DisplayName("hasMinLength_ShouldReturnFalse_WhenCalledWithNull: should return false when called with a string that is null")
        void hasMinLength_ShouldReturnFalse_WhenCalledWithNull(){
            String password = null;

            boolean hasMinLength = PasswordValidator.hasMinLength(password);

            assertFalse(hasMinLength);
        }

    }

    @Nested
    @DisplayName("containsDigitTest: all tests for method containsDigit in PasswordValidator class")
    class containsDigitTest {

        @Test
        @DisplayName("containsDigit_ShouldReturnFalse_WhenCalledWithNoDigit: should return false when called with a string that does not contain a digit")
        void containsDigit_ShouldReturnFalse_WhenCalledWithNoDigit(){
            String password = "password";

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertFalse(containsDigit);
        }

        @Test
        @DisplayName("containsDigit_ShouldReturnTrue_WhenCalledWith1Digit: should return true when called with a string that does contain one digit")
        void containsDigit_ShouldReturnTrue_WhenCalledWith1Digit(){
            String password = "passw0rd";

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertTrue(containsDigit);
        }

        @Test
        @DisplayName("containsDigit_ShouldReturnTrue_WhenCalledWithOnlyDigits: should return true when called with a string that does only contain digits")
        void containsDigit_ShouldReturnTrue_WhenCalledWithOnlyDigits(){
            String password = "123456";

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertTrue(containsDigit);
        }

        @Test
        @DisplayName("containsDigit_ShouldReturnTrue_WhenCalledWithSeveralDigits: should return true when called with a string that does contain several digits")
        void containsDigit_ShouldReturnTrue_WhenCalledWithSeveralDigits(){
            String password = "pa55w0rd1";

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertTrue(containsDigit);
        }

        @Test
        @DisplayName("containsDigit_ShouldReturnFalse_WhenCalledWithUnicode: should return false when called with a string that does contain a unicode")
        void containsDigit_ShouldReturnFalse_WhenCalledWithUnicode(){
            String password = "Simon😀";

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertFalse(containsDigit);
        }

        @Test
        @DisplayName("containsDigit_ShouldReturnFalse_WhenCalledWithEmptyString: should return false when called with an empty string")
        void containsDigit_ShouldReturnFalse_WhenCalledWithEmptyString(){
            String password = "          ";

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertFalse(containsDigit);
        }


        @Test
        @DisplayName("containsDigit_ShouldReturnFalse_WhenCalledWithNull: should return false when called with a string that is null")
        void containsDigit_ShouldReturnFalse_WhenCalledWithNull(){
            String password = null;

            boolean containsDigit = PasswordValidator.containsDigit(password);

            assertFalse(containsDigit);
        }

    }

    @Nested
    @DisplayName("containsUpperAndLowerTest: all tests for method containsUpperAndLower in PasswordValidator class")
    class containsUpperAndLowerTest {

        @Test
        @DisplayName("containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyLowercase: should return false when called with a lowercase only string")
        void containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyLowercase(){
            String password = "password";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertFalse(containsUpperAndLower);
        }

        @Test
        @DisplayName("containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyUppercase: should return false when called with a uppercase only string")
        void containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyUppercase(){
            String password = "PASSWORD";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertFalse(containsUpperAndLower);
        }

        @Test
        @DisplayName("containsUpperAndLower_ShouldReturnTrue_WhenCalledWithOneUppercase: should return true when called with a one uppercase string")
        void containsUpperAndLower_ShouldReturnTrue_WhenCalledWithOneUppercase(){
            String password = "Password";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertTrue(containsUpperAndLower);
        }

        @Test
        @DisplayName("containsUpperAndLower_ShouldReturnTrue_WhenCalledWithOneLowercase: should return true when called with a one lowercase string")
        void containsUpperAndLower_ShouldReturnTrue_WhenCalledWithOneLowercase(){
            String password = "PAsSWORD";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertTrue(containsUpperAndLower);
        }

        @Test
        @DisplayName("containsUpperAndLower_ShouldReturnTrue_WhenCalledWithMixedCase: should return true when called with a mixed case string")
        void containsUpperAndLower_ShouldReturnTrue_WhenCalledWithMixedCase(){
            String password = "PassWorD";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertTrue(containsUpperAndLower);
        }

        @Test
        @DisplayName("containsUpperAndLower_ShouldReturnTrue_WhenCalledWithMixedAndSpecial: should return true when called with a mixed case and special character string")
        void containsUpperAndLower_ShouldReturnTrue_WhenCalledWithMixedAndSpecial(){
            String password = "Passwörd";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertTrue(containsUpperAndLower);
        }

        @Test
        @DisplayName("containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyLowerSpecial: should return false when called with a lower only and special character string")
        void containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyLowerSpecial(){
            String password = "passwörd";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertFalse(containsUpperAndLower);
        }

        @Test
        @DisplayName("containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyUpperSpecial: should return false when called with a upper only and special character string")
        void containsUpperAndLower_ShouldReturnFalse_WhenCalledWithOnlyUpperSpecial(){
            String password = "PASSWÖRD";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertFalse(containsUpperAndLower);
        }

        @Test
        @DisplayName("containsUpperAndLower_ShouldReturnFalse_WhenCalledWithEmptyString: should return false when called with an empty string")
        void containsUpperAndLower_ShouldReturnFalse_WhenCalledWithEmptyString(){
            String password = "          ";

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertFalse(containsUpperAndLower);
        }

        @Test
        @DisplayName("containsUpperAndLower_ShouldReturnFalse_WhenCalledWithNull: should return false when called with a string that is null")
        void containsUpperAndLower_ShouldReturnFalse_WhenCalledWithNull(){
            String password = null;

            boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);

            assertFalse(containsUpperAndLower);
        }

    }

    @Nested
    @DisplayName("isCommonPasswordTest: all tests for method containsUpperAndLower in PasswordValidator class")
    class isCommonPasswordTest {

        @Test
        @DisplayName("isCommonPassword_ShouldReturnFalse_WhenCalledWithUncommonString: should return false when called with as string that is not in commonPasswords list")
        void isCommonPassword_ShouldReturnFalse_WhenCalledWithUncommonString(){
            String password = "Unc0MM3nSecr3T";

            boolean isCommonPassword = PasswordValidator.isCommonPassword(password);

            assertFalse(isCommonPassword);
        }

        @Test
        @DisplayName("isCommonPassword_ShouldReturnTrue_WhenCalledWithCommonString: should return true when called with as string that is in commonPasswords list")
        void isCommonPassword_ShouldReturnTrue_WhenCalledWithCommonString(){
            String password = "12345678";

            boolean isCommonPassword = PasswordValidator.isCommonPassword(password);

            assertTrue(isCommonPassword);
        }

        @Test
        @DisplayName("isCommonPassword_ShouldReturnTrue_WhenCalledWithCommonStringWithWhiteSpaces: should return true when called with as string that is in commonPasswords list with whitespaces")
        void isCommonPassword_ShouldReturnTrue_WhenCalledWithCommonStringWithWhiteSpaces(){
            String password = "    12345678    ";

            boolean isCommonPassword = PasswordValidator.isCommonPassword(password);

            assertTrue(isCommonPassword);
        }

        @Test
        @DisplayName("isCommonPassword_ShouldReturnTrue_WhenCalledWithCommonStringMixedCase: should return true when called with as string that is in commonPasswords list with mixed case")
        void isCommonPassword_ShouldReturnTrue_WhenCalledWithCommonStringMixedCase(){
            String password = "PaSswoRd";

            boolean isCommonPassword = PasswordValidator.isCommonPassword(password);

            assertTrue(isCommonPassword);
        }

        @Test
        @DisplayName("isCommonPassword_ShouldReturnTrue_WhenCalledWithEmptyString: should return false when called with a empty string")
        void isCommonPassword_ShouldReturnTrue_WhenCalledWithEmptyString(){
            String password = "    ";

            boolean isCommonPassword = PasswordValidator.isCommonPassword(password);

            assertFalse(isCommonPassword);
        }

        @Test
        @DisplayName("isCommonPassword_ShouldReturnTrue_WhenCalledWithNull: should return false when called with null")
        void isCommonPassword_ShouldReturnTrue_WhenCalledWithNull(){
            String password = null;

            boolean isCommonPassword = PasswordValidator.isCommonPassword(password);

            assertFalse(isCommonPassword);
        }

    }

    @Nested
    @DisplayName("containsSpecialCharTest: all tests for method containsSpecialChar in PasswordValidator class")
    class containsSpecialCharTest {

        @Test
        @DisplayName("containsSpecialChar_ShouldReturnFalse_WhenCalledWithoutSpecialChars: should return false when called without a special character")
        void containsSpecialChar_ShouldReturnFalse_WhenCalledWithoutSpecialChars(){
            String password = "Password1";

            boolean containsSpecialChar = PasswordValidator.containsSpecialChar(password);

            assertFalse(containsSpecialChar);
        }

        @Test
        @DisplayName("containsSpecialChar_ShouldReturnTrue_WhenCalledWithAllowedSpecialChar: should return true when called with a allowed special character")
        void containsSpecialChar_ShouldReturnTrue_WhenCalledWithAllowedSpecialChar(){
            String password = "Password!$";

            boolean containsSpecialChar = PasswordValidator.containsSpecialChar(password);

            assertTrue(containsSpecialChar);
        }

        @Test
        @DisplayName("containsSpecialChar_ShouldReturnFalse_WhenCalledWithNotAllowedSpecialChar: should return false when called with a not allowed  special character")
        void containsSpecialChar_ShouldReturnFalse_WhenCalledWithNotAllowedSpecialChar(){
            String password = "Password'";

            boolean containsSpecialChar = PasswordValidator.containsSpecialChar(password);

            assertFalse(containsSpecialChar);
        }

        @Test
        @DisplayName("containsSpecialChar_ShouldReturnFalse_WhenCalledWithEmptyString: should return false when called with a empty string")
        void containsSpecialChar_ShouldReturnFalse_WhenCalledWithEmptyString(){
            String password = "           ";

            boolean containsSpecialChar = PasswordValidator.containsSpecialChar(password);

            assertFalse(containsSpecialChar);
        }

        @Test
        @DisplayName("containsSpecialChar_ShouldReturnFalse_WhenCalledWithNull: should return false when called with null")
        void containsSpecialChar_ShouldReturnFalse_WhenCalledWithNull(){
            String password = null;

            boolean containsSpecialChar = PasswordValidator.containsSpecialChar(password);

            assertFalse(containsSpecialChar);
        }

    }

    @Nested
    @DisplayName("isValidTest: all tests for method isValid in PasswordValidator class")
    class isValidTest {

        @Test
        @DisplayName("isValid_ShouldReturnTrue_WhenCalledWithPolicy: should return true when called with a string the meets the policy")
        void isValid_ShouldReturnTrue_WhenCalledWithPolicy(){
            String password = "Passw0rd!";

            ValidationResult result= PasswordValidator.isValid(password);

            assertTrue(result.getIsValid());
            assertFalse(result.hasReason());
        }

        @Test
        @DisplayName("isValid_ShouldReturnTrue_WhenCalledWithVeryLongPassword: should return true when called with a a very long string the meets the policy")
        void isValid_ShouldReturnTrue_WhenCalledWithVeryLongPassword(){
            String password = "12345678PasswordIsVeryL0ng987654321$%";

            ValidationResult result= PasswordValidator.isValid(password);

            assertTrue(result.getIsValid());
            assertFalse(result.hasReason());
        }

        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithoutMinLength: should return false when called with a string that does not have minimum length")
        void isValid_ShouldReturnFalse_WhenCalledWithoutMinLength(){
            String password = "Pass1";

            ValidationResult result= PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.hasMinLengthExpected
            ));

            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
            assertEquals(expectedReasons, result.getReasons());
        }

        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithoutDigit: should return false when called with a string that does not have a digit")
        void isValid_ShouldReturnFalse_WhenCalledWithoutDigit(){
            String password = "Password";

            ValidationResult result = PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.isCommonPasswordExpected
            ));

            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
            assertEquals(expectedReasons, result.getReasons());
        }

        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithoutUpperAndLowerCase: should return false when called with a string that does not have a upper and lower case")
        void isValid_ShouldReturnFalse_WhenCalledWithoutUpperAndLowerCase(){
            String password = "passw0rd";

            ValidationResult result = PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.containsUpperAndLowerExpected,
                    password + MessagesTest.containsSpecialCharExpected
            ));

            assertEquals(expectedReasons, result.getReasons());
            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
        }

        @Test
        @DisplayName("containsSpecialChar_ShouldReturnFalse_WhenCalledWithCommonPassword: should return false when called with a common password")
        void containsSpecialChar_ShouldReturnFalse_WhenCalledWithCommonPassword(){
            String password = "12345678";

            ValidationResult result = PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.isCommonPasswordExpected
            ));

            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
            assertEquals(expectedReasons, result.getReasons());
        }

        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithCaseMismatchingCommonPassword: should return false when called with a case mismatching common password")
        void isValid_ShouldReturnFalse_WhenCalledWithCaseMismatchingCommonPassword(){
            String password = "PASSWORD";

            ValidationResult result = PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.isCommonPasswordExpected
            ));

            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
            assertEquals(expectedReasons, result.getReasons());
        }

        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithZeroRequirement: should return false when called without min length, digit and upper lower case")
        void isValid_ShouldReturnFalse_WhenCalledWithZeroRequirement(){
            String password = "pass";

            ValidationResult result = PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.hasMinLengthExpected
            ));

            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
            assertEquals(expectedReasons, result.getReasons());
        }

        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithDigitsAndLowercase: should return false when called with only digits and lowercase")
        void isValid_ShouldReturnFalse_WhenCalledWithDigitsAndLowercase(){
            String password = "123456password";

            ValidationResult result = PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.containsUpperAndLowerExpected,
                    password + MessagesTest.containsSpecialCharExpected
            ));

            assertEquals(result.getReasons(), expectedReasons);
            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
        }

        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithDigitsAndUppercase: should return false when called with only digits and uppercase")
        void isValid_ShouldReturnFalse_WhenCalledWithDigitsAndUppercase(){
            String password = "123456PASSWORD";

            ValidationResult result = PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.containsUpperAndLowerExpected,
                    password + MessagesTest.containsSpecialCharExpected
            ));

            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
            assertEquals(expectedReasons, result.getReasons());
        }

        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithWhiteSpaces: should return false when called whit short string and leading and ending white spaces")
        void isValid_ShouldReturnFalse_WhenCalledWithWhiteSpaces(){
            String password = "    pass     ";

            ValidationResult result = PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.hasMinLengthExpected
            ));

            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
            assertEquals(expectedReasons, result.getReasons());
        }

        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithNotAllowedSpecialChar: should return false when called with a not allowed special char")
        void isValid_ShouldReturnFalse_WhenCalledWithNotAllowedSpecialChar(){
            String password = "Password'";

            ValidationResult result = PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.containsDigitExpected,
                    password + MessagesTest.containsSpecialCharExpected
            ));

            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
            assertEquals(expectedReasons, result.getReasons());
        }

        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithAllowedSpecialCharMismatchingPolicy: should return false when called with allowed special char but does not meet policy")
        void isValid_ShouldReturnFalse_WhenCalledWithAllowedSpecialCharMismatchingPolicy(){
            String password = "password!%";

            ValidationResult result = PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.containsDigitExpected,
                    password + MessagesTest.containsUpperAndLowerExpected
            ));

            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
            assertEquals(expectedReasons, result.getReasons());
        }


        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithEmptyString: should return false when called with a empty string")
        void isValid_ShouldReturnFalse_WhenCalledWithEmptyString(){
            String password = "           ";

            ValidationResult result = PasswordValidator.isValid(password);
            ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                    password + MessagesTest.hasMinLengthExpected
            ));

            assertTrue(result.hasReason());
            assertFalse(result.getIsValid());
            assertEquals(expectedReasons, result.getReasons());
        }

        @Test
        @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithNull: should return false when called with null")
        void isValid_ShouldReturnFalse_WhenCalledWithNull(){
            String password = null;

            ValidationResult result = PasswordValidator.isValid(password);

            assertFalse(result.hasReason());
            assertFalse(result.getIsValid());
        }

    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @DisplayName("isValid_ShouldReturnFalse_WhenCalledWithInvalidPasswordList: testing invalid passwords from csv source")
    void isValid_ShouldReturnFalse_WhenCalledWithInvalidPasswordList(String password){
        ValidationResult result = PasswordValidator.isValid(password);

        ArrayList<String> expectedReasons = new ArrayList<String>(List.of(
                password + MessagesTest.hasMinLengthExpected,
                password + MessagesTest.isCommonPasswordExpected,
                password + MessagesTest.containsDigitExpected,
                password + MessagesTest.containsUpperAndLowerExpected,
                password + MessagesTest.containsSpecialCharExpected
        ));

        boolean hasAtLeastOneReason = false;

        for(int i=0; i < result.getReasons().size(); i++){
            if(expectedReasons.contains(result.getReasons().get(i))){
                hasAtLeastOneReason = true;
                break;
            }
        }

        assertTrue(hasAtLeastOneReason);
        assertFalse(result.getIsValid());
        assertTrue(result.hasReason());

    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/valid.csv", useHeadersInDisplayName = true, delimiter = ',', quoteCharacter = '"')
    @DisplayName("isValid_ShouldReturnTrue_WhenCalledWithValidPasswordList: testing valid passwords from csv source")
    void isValid_ShouldReturnTrue_WhenCalledWithValidPasswordList(String password){
        ValidationResult result = PasswordValidator.isValid(password);
        assertTrue(result.getIsValid());
        assertFalse(result.hasReason());
    }
}