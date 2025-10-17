package com.github.simonsagstetter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userChoice = "";
        ValidationResult result = new ValidationResult();
        do {
            System.out.print("Please enter your new password: ");
            String password = input.nextLine();

            result = PasswordValidator.isValid(password);

            if (result.getIsValid()) {
                System.out.println("The entered password is valid!");
            } else {
                System.out.println("The entered password is invalid!");

                if (result.hasReason()) {
                    System.out.println("Reasons:");
                    for (String reason : result.getReasons()) {
                        System.out.println("- " + reason);
                    }
                }
            }

            System.out.println();
            if(result.getIsValid()){
                System.out.print("Do you want to validate a new password? (y/n) ");
            }else {
                System.out.print("Do you want to try again? (y/n) ");
            }
            userChoice = input.nextLine();
            System.out.println();
        } while (isYes(userChoice));

        if(!result.getIsValid()){
            System.out.print("Would you prefer to generate a password? (y/n) ");
            userChoice = input.nextLine();

            if(isYes(userChoice)){
                System.out.println();
                String password = PasswordGenerator.generateSecurePassword();
                System.out.println("This is your new password: " + password);
                System.out.println();
            }
        }

        System.out.println("OK! Goodbye...");
    }

    public static boolean isYes(String s){
        if (s==null) return false;
        return s.equals("y") || s.equals("Y");
    }
}
