# Passwort Validation
[![Java CI with Maven](https://github.com/simonsagstetter/password-validation/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/simonsagstetter/password-validation/actions/workflows/ci.yml)

This repository contains a passwort validation feature which enforces a specific password policy.

## Policy

### Required Policy

- at least 8 characters
- at least 1 digit (0-9)
- Upper and lower case characters
- no common or weak passwords

### Bonus Policy

- at least 1 special character
- password meets the minimum x out of n different character groups

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
boolean isValid = PasswordValidator.isValid(password);
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

public class Main {
    public static void main(String[] args) {
        String password = "SecurePa55word!";
        boolean isValid = PasswordValidator.isValid(password);

        if(isValid){
            // do this
        }else {
            // do that
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
  - password meets the minimum 2 out 3 n different character groups when it is not a common password and it has the required minimum length
- PasswordGenerator
  - generates a secure and strong password that already fulfills the requirements set by basic + bonus password policy
- ParameterizedTest
  - values which were added to the invalid.csv or valid.csv inside `src/test/resources` will be included in the PasswordValidatorTest class 