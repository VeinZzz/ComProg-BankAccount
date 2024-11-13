package BankSystem;

import javax.swing.*;
import java.awt.event.*;

public class LogIn extends JFrame {
    JPanel logInPanel;
    private JPanel infoFields;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel btnPanel;
    private JButton logInBtn;
    private JButton signUpBtn;
    private JLabel logInLabel;

    public LogIn() {
        logInPanel.setSize(600, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(logInPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        setupListeners();
    }

    private void setupListeners() {

        logInBtn.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (authenticateUser(username, password)) {
                openMainMenu();
            } else {
                JOptionPane.showMessageDialog(logInPanel, "Invalid username or password. Please try again.");
            }
        });


        signUpBtn.addActionListener(e -> openSignUpForm());
    }


    private void openMainMenu() {

        dispose();

        JFrame mainMenuFrame = new JFrame("Main Menu");
        MainMenuForm mainMenuForm = new MainMenuForm();
        mainMenuFrame.setContentPane(mainMenuForm.getMainFrame());
        mainMenuFrame.setSize(968, 555);
        mainMenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainMenuFrame.setLocationRelativeTo(null);
        mainMenuFrame.setVisible(true);
    }


    private void openSignUpForm() {
        JFrame signUpFrame = new JFrame("Sign Up");
        signUpFrame.setContentPane(new SignUp().signUpPanel);
        signUpFrame.setSize(400, 300);
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpFrame.setLocationRelativeTo(null);
        signUpFrame.setVisible(true);


        dispose();
    }


    private boolean authenticateUser(String username, String password) {
        String testUsername = "testUser";
        String testPassword = "testPass";
        return username.equals(testUsername) && password.equals(testPassword);
    }
}
