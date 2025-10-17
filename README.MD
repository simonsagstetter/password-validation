# Password Validation
[![Java CI with Maven](https://github.com/simonsagstetter/password-validation/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/simonsagstetter/password-validation/actions/workflows/ci.yml)

A Java library for password security, featuring a validator that checks whether a string complies with a strict password policy, and a PasswordGenerator that automatically creates secure, policy-compliant passwords.
## Policy

### Required Policy

- at least 8 characters
- at least 1 digit (0-9)
- Upper and lower case characters
- no common or weak passwords

### Bonus Policy

- at least 1 special character
- password complies to a minimum of 2 out of 3 policies

## PasswordValidator Methods

### `hasMinLength()`

```java
string password = "password";
boolean hasMinLength = PasswordValidator.hasMinLength(password);
```

### `containsDigit()`

```java
string password = "passw0rd";
boolean containsDigit = PasswordValidator.containsDigit(password);
```

### `containsUpperAndLower()`

```java
string password = "PasswÖrD";
boolean containsUpperAndLower = PasswordValidator.containsUpperAndLower(password);
```

### `isCommonPassword()`

```java
string password = "12345678";
boolean isCommonPassword = PasswordValidator.isCommonPassword(password);
```

### `containsSpecialChar()`

```java
string password = "Pa$$w00rd";
boolean containsSpecialChar = PasswordValidator.containsSpecialChar(password);
```

### `isValid()`

```java
string password = "Passw0rd";
ValidationResult result = PasswordValidator.isValid(password);
```

## PasswordGenerator Methods (Bonus)

### `generateSecurePassword()`

```java
// Generates a 15 character strong password that automatically applies to the password policy
string password = PasswordGenerator.generateSecurePassword();
```

## Setup
*Tested with JDK Version 21 - Amazon Corretto*

- compile: `mvn clean compile`
- test: `mvn clean verify`
- build: `mvn clean package `

#### Manual Compilation

 - compile: `javac src/main/java/com/github/simonsagstetter/** -d out`
 - execute: `java -cp out com.github.simonsagstetter.Main`

## Usage

### Package
```java
package com.github.simonsagstetter;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        String password = "SecurePa55word!";
        
        ValidationResult result = PasswordValidator.isValid(password);
        
        boolean isValid = result.getIsValid();
        ArrayList<String> reasons = result.getReasons();

        if (result.getIsValid()) {
            // process
        } else {
            for (String reason : result.getReasons()) {
                System.out.println(reason);
            }
        }

        // or check for reasons
        if (result.hasReason()) {
            for (String reason : result.getReasons()) {
                System.out.println(reason);
            }
        }

        // or use a generated secure password - no validation necessary
        String generatedPassword = PasswordGenerator.generateSecurePassword();
    }
}
```
### CLI
*Comile and execute com.github.simonsagstetter.Main class*
```shell
    # enter a password and hit enter
    Please enter your new password: <yourpassword>
    
    # Check for errors
    The entered password is invalid!
    Reasons:
    - <yourpassword> was identified as an unsecure password
    - <yourpassword> does not meet the required minimum length of 8
    - <yourpassword> does not contain a digit
    - <yourpassword> does not contain upper and lower case characters
    - <yourpassword> does not contain a special char from the allowed set (!@#$%^&*()-_+=?.,;:)d
    
    # type in y or Y to try again or hit any key to exit
    Do you want to try again? (y/n) <your-choice>
    
    OK! Goodbye...
```

#### Example

```shell
    Please enter your new password: 12345678
    The entered password is invalid!
    Reasons:
    - 12345678 was identified as an unsecure password
    
    Do you want to try again? (y/n) y
    
    Please enter your new password: 123456789password
    The entered password is invalid!
    Reasons:
    - 123456789password does not contain upper and lower case characters
    - 123456789password does not contain a special char from the allowed set (!@#$%^&*()-_+=?.,;:)
    
    Do you want to try again? (y/n) y
    
    Please enter your new password: SafePassword
    The entered password is invalid!
    Reasons:
    - SafePassword does not contain a digit
    - SafePassword does not contain a special char from the allowed set (!@#$%^&*()-_+=?.,;:)
    
    Do you want to try again? (y/n) y
    
    Please enter your new password: password!
    The entered password is invalid!
    Reasons:
    - password! does not contain a digit
    - password! does not contain upper and lower case characters
    
    Do you want to try again? (y/n) y
    
    Please enter your new password: S3curePassw000rd!
    The entered password is valid!
    
    Do you want to validate a new password? (y/n) n
    
    OK! Goodbye...
```

## Additional Information

This project includes the following bonus packages:

- Bonus Policy
  - at least 1 special character from allowed scope `!@#$%^&*()-_+=?.,;:`
  - password complies to a minimum of 2 out of 3 policies as long as it is not a common password or is less than 8 characters
- PasswordGenerator
  - generates a secure and strong password that already fulfills the requirements set by basic + bonus password policy
- ParameterizedTest
  - values which were added to the invalid.csv or valid.csv inside `src/test/resources` will be included in the PasswordValidatorTest class 
- ValidationResult
  - PasswordValidator.isValid() returns a ValidationResult class instance that contains the result of the validation
  - `ValidationResult.getIsValid()` returns a `boolean` 
  - `ValidationResult.getReasons()` returns a `ArrayList<String>` which contain reasons why the validation failed
  - Check for reasons by calling `ValidationResult.hasReason()`
- CLI Tool - check out the [Usage](#CLI) section for more information