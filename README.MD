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

## Methods

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

## Setup
*Tested with JDK Version 21 - Amazon Corretto*

- compile: `mvn clean compile`
- test: `mvn clean verify`
- build: `mvn clean package `

## Usage (CLI)

coming soon

## Additional Information

coming soon