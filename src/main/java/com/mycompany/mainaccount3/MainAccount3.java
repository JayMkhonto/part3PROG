/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainaccount3;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class MainAccount3 {
    
    
     //declaration
        String firstName, lastName, username, password;
public class UserValidator {

    // Login method to validate username and password
    public static boolean login(String username, String password) {
        // Check if username and password match predefined credentials
        return "correctUsername".equals(username) && "correctPassword".equals(password);
    }

    // Method to validate the username format
    public static String validateUsername(String username) {
        if (username != null && username.contains("_") && username.length() <= 5) {
            String firstName = "Kyl";  // Example first name
            String lastName = "1";     // Example last name
            return "Welcome " + firstName + "," + lastName + " it is great to see you.";  // Success message
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
    }

    // Method to validate the password complexity
    public static String validatePassword(String password) {
        if (password != null 
            && password.length() >= 8 
            && password.matches(".*[A-Z].*")  // Contains at least one uppercase letter
            && password.matches(".*[a-z].*")  // Contains at least one lowercase letter
            && password.matches(".*\\d.*")    // Contains at least one number
            && password.matches(".*[!@#$%^&*].*")) {  // Contains at least one special character
            return "Password successfully captured";
        }
        return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
    }
}

    
    
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
            
        
        
        
        
        {
   //JOptionPane
   /*
   JOptionPane.showMessageDialog(null, "This is a useless title", "Welcome to Kanban", JOptionPane.PLAIN_MESSAGE);*/
   /*
     System.out.println(JOptionPane.showConfirmDialog(null, "Menu", "Welcome to Kanban", JOptionPane.YES_NO_CANCEL_OPTION));*/
   
   String[] responses = {"1.Add Tasks", "2.Show Report", "3.Quit"};
   JOptionPane.showOptionDialog(null, "Menu", "Welcome to EasyKanban", 
           JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
     
    int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));
        int taskCounter = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));

       

        


        while (true) {
            String option = JOptionPane.showInputDialog("Choose an option:\n1) Add tasks\n2) Show report\n3 Quit");
            switch (option) {
                case "1":
                    if (taskCounter < numberOfTasks) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Task limit reached.");
                    }
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case "3":
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
       


class Task {
    String name;
    String description;
    String developer;
    double duration;
    String id;
    String status;

    // Constructor
    public Task(String name, String description, String developer, double duration, String status) {
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.duration = duration;
        this.status = status;
        this.id = createTaskID(); // create ID when task is created
    }

    // Method to check if task description is valid
    public boolean checkTaskDescription() {
        return description.length() <= 50;
    }

    // Method to create and return the task ID
    public String createTaskID() {
        return name.substring(0, Math.min(2, name.length())).toUpperCase();
    }

    // Method to print the full task details
    public String printTaskDetails() {
        return "Status: " + status +
               "\nDeveloper: " + developer +
               "\nTask Name: " + name +
               "\nDescription: " + description +
               "\nTask ID: " + id +
               "\nDuration: " + duration + " hours";

        

    }
}
class TaskStatus {
    public static void main(String[] args) {
        String[] options = {"To Do", "Done", "Doing"};
        
        int choice = JOptionPane.showOptionDialog(null, 
            "Select Task Status:", 
            "Task Status Menu", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.INFORMATION_MESSAGE, 
            null, 
            options, 
            options[0]);

        if (choice >= 0) {
            String selectedStatus = options[choice];
            JOptionPane.showMessageDialog(null, "You selected: " + selectedStatus);
        } else {
            JOptionPane.showMessageDialog(null, "No selection made.");
        }
    }
}
        
     
            
            
            
        }

        }
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
