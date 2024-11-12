package BankSystem;

import javax.swing.*;
import java.awt.event.*;

public class LogIn {
    JPanel logInPanel;
    private JPanel infoFields;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel btnPanel;
    private JButton logInBtn;
    private JButton signUpBtn;
    private JLabel logInLabel;

    public LogIn() {
        setupListeners();
    }


    private void setupListeners() {
        // Initialize login button action
        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticateUser(username, password)) {
                    openMainMenu();
                } else {
                    JOptionPane.showMessageDialog(logInPanel, "Invalid username or password. Please try again.");
                }
            }
        });

        // Initialize sign-up button action
        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSignUpForm();
            }
        });
    }

    private void openMainMenu() {
        // Open MainMenuForm
        JFrame mainMenuFrame = new JFrame("Main Menu");
        MainMenuForm mainMenuForm = new MainMenuForm(); // Ensure MainMenuForm initializes mainMenuPanel
        if (mainMenuForm.mainMenuPanel != null) {
            mainMenuFrame.setContentPane(mainMenuForm.mainMenuPanel);
        } else {
            throw new IllegalStateException("MainMenuPanel is null. Ensure it is initialized in MainMenuForm.");
        }
        mainMenuFrame.setSize(600, 400);
        mainMenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainMenuFrame.setLocationRelativeTo(null); // Center the frame
        mainMenuFrame.setVisible(true);

        // Close the LogIn frame
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(logInPanel);
        if (topFrame != null) {
            topFrame.dispose();
        }
    }

    private void openSignUpForm() {
        JFrame signUpFrame = new JFrame("Sign Up");
        signUpFrame.setContentPane(new SignUp().signUpPanel); // Assuming signUpPanel is in SignUp
        signUpFrame.setSize(400, 300);
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpFrame.setLocationRelativeTo(null); // Center the frame
        signUpFrame.setVisible(true);

        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(logInPanel);
        if (topFrame != null) {
            topFrame.dispose();
        }
    }

    // Hard-coded authentication for testing
    private boolean authenticateUser(String username, String password) {
        String testUsername = "testUser";
        String testPassword = "testPass";
        return username.equals(testUsername) && password.equals(testPassword);
    }
}
