/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainaccount3;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class P3final {
    
    public static void main(String[] args) {
        // Prompt user for the number of tasks
        int taskCount = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));

        // Create arrays to hold task details
        String[] taskNames = new String[taskCount];
        String[] developers = new String[taskCount];
        String[] statuses = new String[taskCount];
        double[] durations = new double[taskCount];

        // Populate the arrays
        for (int i = 0; i < taskCount; i++) {
            JOptionPane.showMessageDialog(null, "Enter details for Task " + (i + 1));
            taskNames[i] = JOptionPane.showInputDialog("Enter task name:");
            developers[i] = JOptionPane.showInputDialog("Enter developer name:");
            durations[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter task duration (in hours):"));
            String[] statusOptions = {"To Do", "Doing", "Done"};
            statuses[i] = (String) JOptionPane.showInputDialog(
                null,
                "Select task status:",
                "Task Status",
                JOptionPane.QUESTION_MESSAGE,
                null,
                statusOptions,
                statusOptions[0]
            );
        }

        // Display the populated arrays
        StringBuilder taskReport = new StringBuilder("Task Report:\n");
        for (int i = 0; i < taskCount; i++) {
            taskReport.append("Task ").append(i + 1).append(":\n")
                      .append("Name: ").append(taskNames[i]).append("\n")
                      .append("Developer: ").append(developers[i]).append("\n")
                      .append("Duration: ").append(durations[i]).append(" hours\n")
                      .append("Status: ").append(statuses[i]).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, taskReport.toString());
    }
}
}