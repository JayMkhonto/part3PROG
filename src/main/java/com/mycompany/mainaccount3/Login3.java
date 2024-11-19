/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainaccount3;

/**
 *
 * @author RC_Student_lab
 */
public class Login3 {
    
    // Method to check if the username is valid
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if the password meets complexity rules
    public boolean checkPasswordComplexity(String password) {
        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Flags to track if password contains uppercase, number, and special character
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        // Special characters that we are looking for
        String specialChars = "!@#$%^&*()-_=+<>?";

        // Loop through each character in the password
        for (char c : password.toCharArray()) {
            // Check for capital letter
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            }
            // Check for number
            if (Character.isDigit(c)) {
                hasNumber = true;
            }
            // Check for special character
            if (specialChars.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }

        // Return true if all conditions are met, otherwise false
        return hasCapital && hasNumber && hasSpecialChar;
    }

    // Method to register a user
    public String registerUser(String username, String password) {
        // Check if the username is valid
        if (!checkUserName(username)) {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }

        // Check if the password meets complexity requirements
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }

        // If both username and password are valid, return success message
        return "User successfully registered!";
    }
}

