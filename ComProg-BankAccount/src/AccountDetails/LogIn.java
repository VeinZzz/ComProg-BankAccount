package AccountDetails;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LogIn {
    JPanel logInPanel;
    private JPanel infoFields;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel btnPanel;
    private JButton logInBtn;
    private JButton signUpBtn;
    private JLabel logInLabel;
    private JLabel messageLabel; // To show login status messages

    public LogIn() {
        // Initialize login button action
        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticateUser(username, password)) {
                    messageLabel.setText("Login successful! Welcome, " + username + "!");
                    // Here you can proceed to open the main application/dashboard for the user
                } else {
                    messageLabel.setText("Invalid username or password. Please try again.");
                }
            }
        });

        // Initialize sign-up button action
        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Transition to the SignUp form
                new SignUp(); // Assuming SignUp is a separate form
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(logInPanel);
                if (topFrame != null) {
                    topFrame.dispose(); // Close the current login window if necessary
                }
            }
        });
    }

    private boolean authenticateUser(String username, String password) {
        try {
            // Read each line in users.txt to find a matching username and password
            List<String> lines = Files.readAllLines(Paths.get("users.txt"));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length < 4) continue; // Skip malformed lines

                String storedUsername = parts[0];
                String storedPassword = parts[1];

                if (storedUsername.equals(username) && storedPassword.equals(password)) {
                    return true; // Authentication successful
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false; // Authentication failed
    }
}
