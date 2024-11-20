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
    public static void main(String[] args) {
        // Account creation logic
        String username = JOptionPane.showInputDialog("Enter your username:");
        if (!isUsernameValid(username)) {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return;
        }

        String password = JOptionPane.showInputDialog("Enter your password:");
        if (!isPasswordValid(password)) {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return;
        }

        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        JOptionPane.showMessageDialog(null, "Account created successfully!");

        // Login process
        String loginUsername = JOptionPane.showInputDialog("Enter your username to login:");
        String loginPassword = JOptionPane.showInputDialog("Enter your password to login:");

        if (loginUsername.equals(username) && loginPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + ", it is great to see you again!");
            showMenu(); // Call the task menu after successful login
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.");
        }
    }

    // Task menu method
    public static void showMenu() {
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));
        int taskCounter = 0;

        while (true) {
            String[] options = {"Add Task", "Show Report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Menu", "Welcome to EasyKanban",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Add Task
                    if (taskCounter < numberOfTasks) {
                        String taskName = JOptionPane.showInputDialog("Enter the task name:");
                        String taskDescription = JOptionPane.showInputDialog("Enter the task description:");
                        String developer = JOptionPane.showInputDialog("Enter the developer name:");
                        double duration = Double.parseDouble(JOptionPane.showInputDialog("Enter the task duration (hours):"));
                        String[] statusOptions = {"To Do", "Doing", "Done"};
                        String status = (String) JOptionPane.showInputDialog(null, "Select Task Status:",
                                "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

                        Task newTask = new Task(taskName, taskDescription, developer, duration, status);
                        if (!newTask.checkTaskDescription()) {
                            JOptionPane.showMessageDialog(null, "Task description must be 50 characters or less.");
                        } else {
                            taskCounter++;
                            JOptionPane.showMessageDialog(null, "Task added successfully!\n" + newTask.printTaskDetails());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Task limit reached.");
                    }
                    break;

                case 1: // Show Report
                    JOptionPane.showMessageDialog(null, "Report feature coming soon!");
                    break;

                case 2: // Quit
                    JOptionPane.showMessageDialog(null, "Exiting program.");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }

    // Task class
    static class Task {
        String name;
        String description;
        String developer;
        double duration;
        String id;
        String status;

        public Task(String name, String description, String developer, double duration, String status) {
            this.name = name;
            this.description = description;
            this.developer = developer;
            this.duration = duration;
            this.status = status;
            this.id = createTaskID();
        }

        public boolean checkTaskDescription() {
            return description.length() <= 50;
        }

        public String createTaskID() {
            return name.substring(0, Math.min(2, name.length())).toUpperCase() + ":" + developer.substring(developer.length() - 3).toUpperCase();
        }

        public String printTaskDetails() {
            return "Status: " + status +
                   "\nDeveloper: " + developer +
                   "\nTask Name: " + name +
                   "\nDescription: " + description +
                   "\nTask ID: " + id +
                   "\nDuration: " + duration + " hours";
        }
    }

    // Username validation
    public static boolean isUsernameValid(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Password validation
    public static boolean isPasswordValid(String password) {
        return password.length() >= 8 && 
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*].*");
    }
}


