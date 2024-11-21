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

    public static void showMenu() {
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));

        // Initialize arrays
        String[] taskNames = new String[numberOfTasks];
        String[] developers = new String[numberOfTasks];
        double[] durations = new double[numberOfTasks];
        String[] statuses = new String[numberOfTasks];

        int taskCounter = 0;

        while (true) {
            String[] options = {"Add Task", "Show Report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Menu", "Welcome to EasyKanban",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Add Task
                    if (taskCounter < numberOfTasks) {
                        taskNames[taskCounter] = JOptionPane.showInputDialog("Enter the task name:");
                        developers[taskCounter] = JOptionPane.showInputDialog("Enter the developer name:");
                        durations[taskCounter] = Double.parseDouble(JOptionPane.showInputDialog("Enter the task duration (hours):"));

                        String[] statusOptions = {"To Do", "Doing", "Done"};
                        statuses[taskCounter] = (String) JOptionPane.showInputDialog(null, "Select Task Status:",
                                "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

                        JOptionPane.showMessageDialog(null, "Task added successfully!");
                        taskCounter++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Task limit reached.");
                    }
                    break;

                case 1: // Show Report
                    StringBuilder report = new StringBuilder("Task Report:\n");
                    for (int i = 0; i < taskCounter; i++) {
                        report.append("Task ").append(i + 1).append(":\n")
                              .append("Name: ").append(taskNames[i]).append("\n")
                              .append("Developer: ").append(developers[i]).append("\n")
                              .append("Duration: ").append(durations[i]).append(" hours\n")
                              .append("Status: ").append(statuses[i]).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, report.toString());
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
