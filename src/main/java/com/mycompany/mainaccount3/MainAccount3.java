/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainaccount3;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class MainAccount3 {
    public static void main(String[] args) {
        // Create scanner
        Scanner scn = new Scanner(System.in);

        // Create variables to store user information
        String storedUsername = "";
        String storedPassword = "";
        String firstName = "";
        String lastName = "";

        //Creating Account (First part: Username and Password)
        System.out.print("Enter your username: ");
        String username = scn.nextLine();
        
        if (isUsernameValid(username)) {
            System.out.println("Username successfully captured");
            storedUsername = username; // Storing username
        } else {
            System.out.println("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return; // Exit if username invalid
        }

        System.out.print("Enter your password: ");
        String password = scn.nextLine();

        if (isPasswordValid(password)) {
            System.out.println("Password successfully captured");
            storedPassword = password; // Store password
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            return; // Exit if password invalid
        }

        // Prompt user first name and last name 
        System.out.print("Enter your first name: ");
        firstName = scn.nextLine();

        System.out.print("Enter your last name: ");
        lastName = scn.nextLine();

       

        // Login Process 
        System.out.print("\n--- Login Section ---\n");
        System.out.print("Enter your username to login: ");
        String loginUsername = scn.nextLine();
        
        System.out.print("Enter your password to login: ");
        String loginPassword = scn.nextLine();

        // Authenticate user
        if (loginUsername.equals(storedUsername) && loginPassword.equals(storedPassword)) {
            System.out.println("Welcome " + firstName + ", " + lastName + " it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }

    }

    
    
    
    // Method to check if the username is valid
    public static boolean isUsernameValid(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if the password is valid
    public static boolean isPasswordValid(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        String specialChars = "!@#$%^&*()-_=+<>?";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            }
            if (Character.isDigit(c)) {
                hasNumber = true;
            }
            if (specialChars.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }

        return hasCapital && hasNumber && hasSpecialChar;
    }
}
