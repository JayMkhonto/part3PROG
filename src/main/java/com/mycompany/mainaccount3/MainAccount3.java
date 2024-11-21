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
        
  
        
        
        
        
        
      
    // Define the size of initial test data
    int testDataCount = 3;
    taskNames = new String[testDataCount];
    developers = new String[testDataCount];
    durations = new double[testDataCount];
    statuses = new String[testDataCount];
    tasks = new Task[testDataCount];

    // Populate test data
    taskNames[0] = "Create Login";
    developers[0] = "Mike Smith";
    durations[0] = 5;
    statuses[0] = "To Do";
    tasks[0] = new Task(taskNames[0], "Create a login system", developers[0], durations[0], statuses[0]);

    taskNames[1] = "Create Add Features";
    developers[1] = "Edward Harrison";
    durations[1] = 8;
    statuses[1] = "Doing";
    tasks[1] = new Task(taskNames[1], "Add task functionality", developers[1], durations[1], statuses[1]);

    taskNames[2] = "Create Reports";
    developers[2] = "Samantha Paulson";
    durations[2] = 2;
    statuses[2] = "Done";
    tasks[2] = new Task(taskNames[2], "Testing all modules", developers[2], durations[2], statuses[2]);
    
    taskNames[3] = "Add Arrays";
    developers[3] = "Glenda Oberholzer";
    durations[3] = 9;
    statuses[3] = "Doing";
    tasks[3] = new Task(taskNames[1], "Add task functionality", developers[1], durations[1], statuses[1]);
    
    
    
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
            String[] options = {
                "Add Task", 
                "Show Report", 
                "Display Tasks with Status Done", 
                "Display Task with Longest Duration", 
                "Search Task by Name", 
                "Search Tasks by Developer", 
                "Delete Task by Name", 
                "Quit"
            };
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

                case 2: // Display Tasks with Status "Done"
                    StringBuilder doneTasks = new StringBuilder("Tasks with status 'Done':\n");
                    for (int i = 0; i < taskCounter; i++) {
                        if (statuses[i].equals("Done")) {
                            doneTasks.append("Task Name: ").append(taskNames[i])
                                     .append(", Developer: ").append(developers[i])
                                     .append(", Duration: ").append(durations[i]).append(" hours\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, doneTasks.length() > 0 ? doneTasks.toString() : "No tasks with 'Done' status.");
                    break;

                case 3: // Display Task with Longest Duration
                    double longestDuration = 0;
                    int longestIndex = -1;
                    for (int i = 0; i < taskCounter; i++) {
                        if (durations[i] > longestDuration) {
                            longestDuration = durations[i];
                            longestIndex = i;
                        }
                    }
                    if (longestIndex != -1) {
                        JOptionPane.showMessageDialog(null, "Task with Longest Duration:\n" +
                                "Task Name: " + taskNames[longestIndex] + "\n" +
                                "Developer: " + developers[longestIndex] + "\n" +
                                "Duration: " + durations[longestIndex] + " hours");
                    }
                    break;

                case 4: // Search Task by Name
                    String searchName = JOptionPane.showInputDialog("Enter task name to search:");
                    boolean found = false;
                    for (int i = 0; i < taskCounter; i++) {
                        if (taskNames[i].equalsIgnoreCase(searchName)) {
                            JOptionPane.showMessageDialog(null, "Task Found:\n" +
                                    "Task Name: " + taskNames[i] + "\n" +
                                    "Developer: " + developers[i] + "\n" +
                                    "Status: " + statuses[i]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Task not found.");
                    }
                    break;

                case 5: // Search Tasks by Developer
                    String searchDeveloper = JOptionPane.showInputDialog("Enter developer name to search:");
                    StringBuilder developerTasks = new StringBuilder("Tasks assigned to " + searchDeveloper + ":\n");
                    found = false;
                    for (int i = 0; i < taskCounter; i++) {
                        if (developers[i].equalsIgnoreCase(searchDeveloper)) {
                            developerTasks.append("Task Name: ").append(taskNames[i])
                                          .append(", Status: ").append(statuses[i]).append("\n");
                            found = true;
                        }
                    }
                    JOptionPane.showMessageDialog(null, found ? developerTasks.toString() : "No tasks found for this developer.");
                    break;

                case 6: // Delete Task by Name
                    String deleteName = JOptionPane.showInputDialog("Enter task name to delete:");
                    found = false;
                    for (int i = 0; i < taskCounter; i++) {
                        if (taskNames[i].equalsIgnoreCase(deleteName)) {
                            // Shift all tasks after the deleted task left
                            for (int j = i; j < taskCounter - 1; j++) {
                                taskNames[j] = taskNames[j + 1];
                                developers[j] = developers[j + 1];
                                durations[j] = durations[j + 1];
                                statuses[j] = statuses[j + 1];
                            }
                            taskCounter--;
                            JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Task not found.");
                    }
                    break;

                case 7: // Quit
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
