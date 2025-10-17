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