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
    // Method to check if username is valid
    public boolean checkUserName(String username) {
        
        // Check if username has a underscore and has 5+ characters
        return username.contains("_") && username.length() <= 5;
    }
   
    // Method to check if password meets complexity rules
    public boolean checkPasswordComplexity(String password) {
        
        
        // Check if password at least 8 characters long
        if (password.length() < 8) {
            return false;
        }
   

        // tracking if password has uppercase, number, and special character
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        // Special characters 
        String specialChars = "!@#$%^&*()-_=+<>?";

        // Looping each character in the password
        for (char c : password.toCharArray()) {
            // looking capital letter
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            }
            //looking for number
            if (Character.isDigit(c)) {
                hasNumber = true;
            }
            // looking for special character
            if (specialChars.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }

        // true if all conditions are met, otherwise false
        return hasCapital && hasNumber && hasSpecialChar;
    }
}
