package BankSystem;

import javax.swing.*;
import java.awt.event.*;

public class LogIn extends JFrame {
    JPanel logInPanel;         // Linked from GUI form
    private JPanel infoFields;         // Linked from GUI form
    private JTextField usernameField;  // Linked from GUI form
    private JPasswordField passwordField; // Linked from GUI form
    private JPanel btnPanel;           // Linked from GUI form
    private JButton logInBtn;          // Linked from GUI form
    private JButton signUpBtn;         // Linked from GUI form
    private JLabel logInLabel;         // Linked from GUI form

    public LogIn() {
        setTitle("Log In");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(logInPanel);  // Use logInPanel from LogIn.form
        pack();                     // Adjust window size to fit components
        setLocationRelativeTo(null); // Center the form on the screen
        setVisible(true);           // Display the form

        setupListeners();           // Setup button listeners
    }

    // Set up listeners for login and sign-up actions
    private void setupListeners() {
        // Log In button action
        logInBtn.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (authenticateUser(username, password)) {
                openMainMenu(); // Navigate to MainMenuForm if authentication is successful
            } else {
                JOptionPane.showMessageDialog(logInPanel, "Invalid username or password. Please try again.");
            }
        });

        // Sign Up button action
        signUpBtn.addActionListener(e -> openSignUpForm());
    }

    // Method to open the Main Menu form
    private void openMainMenu() {
        JFrame mainMenuFrame = new JFrame("Main Menu");
        MainMenuForm mainMenuForm = new MainMenuForm(); // Initialize MainMenuForm
        mainMenuFrame.setContentPane(mainMenuForm.getMainFrame()); // Set mainFrame as the content pane
        mainMenuFrame.setSize(968, 555); // Adjust size as needed
        mainMenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainMenuFrame.setLocationRelativeTo(null); // Center the window
        mainMenuFrame.setVisible(true);

        // Close the LogIn frame
        dispose();
    }

    // Method to open the Sign-Up form
    private void openSignUpForm() {
        JFrame signUpFrame = new JFrame("Sign Up");
        signUpFrame.setContentPane(new SignUp().signUpPanel); // Assuming signUpPanel is in SignUp
        signUpFrame.setSize(400, 300);
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpFrame.setLocationRelativeTo(null); // Center the frame
        signUpFrame.setVisible(true);

        // Close the LogIn frame
        dispose();
    }

    // Simple authentication method for testing purposes
    private boolean authenticateUser(String username, String password) {
        String testUsername = "testUser";
        String testPassword = "testPass";
        return username.equals(testUsername) && password.equals(testPassword);
    }
}
