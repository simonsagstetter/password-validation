# Passwort Validation
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

## Setup
*Tested with JDK Version 21 - Amazon Corretto*

- compile: `mvn clean compile`
- test: `mvn clean verify`
- build: `mvn clean package `

## CI Status

coming soon

## Usage (CLI)

coming soon

## Additional Information

coming soon