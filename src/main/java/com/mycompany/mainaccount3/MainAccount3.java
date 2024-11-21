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
    // Arrays to store task information
    static String[] taskNames;
    static String[] developers;
    static double[] durations;
    static String[] statuses;
    static Task[] tasks; // Array to hold Task objects

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
        taskNames = new String[numberOfTasks];
        developers = new String[numberOfTasks];
        durations = new double[numberOfTasks];
        statuses = new String[numberOfTasks];
        tasks = new Task[numberOfTasks]; // Initialize the tasks array

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
                            tasks[taskCounter] = newTask; // Store task in the tasks array
                            taskNames[taskCounter] = taskName; // Store task name
                            developers[taskCounter] = developer; // Store developer
                            durations[taskCounter] = duration; // Store duration
                            statuses[taskCounter] = status; // Store status
                            taskCounter++;
                            JOptionPane.showMessageDialog(null, "Task added successfully!\n" + newTask.printTaskDetails());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Task limit reached.");
                    }
                    break;

                case 1: // Show Report
                    StringBuilder taskReport = new StringBuilder("Task Report:\n");
                    for (int i = 0; i < taskCounter; i++) {
                        taskReport.append("Task ").append(i + 1).append(":\n")
                                  .append("Name: ").append(taskNames[i]).append("\n")
                                  .append("Developer: ").append(developers[i]).append("\n")
                                  .append("Duration: ").append(durations[i]).append(" hours\n")
                                  .append("Status: ").append(statuses[i]).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, taskReport.toString());
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
        private String taskName;
        private String taskDescription;
        private String developer;
        private double duration;
        private String status;

        // Constructor
        public Task(String taskName, String taskDescription, String developer, double duration, String status) {
            this.taskName = taskName;
            this.taskDescription = taskDescription;
            this.developer = developer;
            this.duration = duration;
            this.status = status;
        }

        // Check if the task description is valid (<= 50 characters)
        public boolean checkTaskDescription() {
            return this.taskDescription.length() <= 50;
        }

        // Print the details of the task
        public String printTaskDetails() {
            return "Task Name: " + this.taskName + "\n" +
                   "Developer: " + this.developer + "\n" +
                   "Duration: " + this.duration + " hours\n" +
                   "Status: " + this.status + "\n" +
                   "Description: " + this.taskDescription;
        }

        // Getters for the Task properties
        public String getTaskName() {
            return taskName;
        }

        public String getDeveloper() {
            return developer;
        }

        public double getDuration() {
            return duration;
        }

        public String getStatus() {
            return status;
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
