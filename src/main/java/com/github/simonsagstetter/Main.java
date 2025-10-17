package com.github.simonsagstetter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userChoice = "";
        do {
            System.out.print("Please enter your new password: ");
            String password = input.nextLine();

            ValidationResult result = PasswordValidator.isValid(password);

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
        } while (userChoice.equals("y") || userChoice.equals("Y"));

        System.out.println("OK! Goodbye...");
    }
}
