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
 
    // Variables to store the registered username and password
    private String registeredUsername;
    private String registeredPassword;

    // Method to check if the username is valid
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if the password meets complexity rules
    public boolean checkPasswordComplexity(String password) {
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

    // Method to register the user and store the username and password
    public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }

        // Store the registered username and password
        registeredUsername = username;
        registeredPassword = password;

        return "User successfully registered!";
    }

    // Method to verify the login details (username and password)
    public boolean loginUser(String username, String password) {
        // Check if the entered username and password match the stored values
        return registeredUsername != null && registeredPassword != null &&
               registeredUsername.equals(username) && registeredPassword.equals(password);
    }
}