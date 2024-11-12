package AccountDetails;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SignUp {
    private JPanel signUpPanel;
    private JLabel signUpLabel;
    private JPanel signUpForm;
    private JTextField nameField;
    private JLabel nameLabel;
    private JLabel contactLabel;
    private JTextField contactField;
    private JLabel birthLabel;
    private JFormattedTextField birthField;
    private JLabel cityLabel;
    private JComboBox<String> cityField;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JPasswordField reEnterField;
    private JLabel reEnterLabel;
    private JPanel signBtns;
    private JButton backBtn;
    private JButton signUpBtn;
    private JLabel messageLabel;

    public SignUp() {
        // Initialize the city dropdown with example cities
        cityField.addItem("New York");
        cityField.addItem("Los Angeles");
        cityField.addItem("Chicago");
        cityField.addItem("Houston");
        cityField.addItem("Phoenix");

        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get form inputs
                String fullName = nameField.getText();
                String contact = contactField.getText();
                String dateOfBirth = birthField.getText();
                String city = (String) cityField.getSelectedItem();
                String password = new String(passwordField.getPassword());
                String reEnteredPassword = new String(reEnterField.getPassword());

                // Validate inputs
                if (fullName.isEmpty() || contact.isEmpty() || dateOfBirth.isEmpty() || city.isEmpty() || password.isEmpty() || reEnteredPassword.isEmpty()) {
                    messageLabel.setText("Please fill out all fields.");
                    return;
                }

                if (!password.equals(reEnteredPassword)) {
                    messageLabel.setText("Passwords do not match. Please re-enter.");
                    return;
                }

                if (isUsernameTaken(fullName)) {
                    messageLabel.setText("Username already taken. Please choose another.");
                    return;
                }

                int accountNumber = generateUniqueAccountNumber();
                saveUser(fullName, password, accountNumber, contact, dateOfBirth, city);
                messageLabel.setText("Account created! Your Account Number: " + accountNumber);
            }
        });
    }

    private boolean isUsernameTaken(String username) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("users.txt"));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private int generateUniqueAccountNumber() {
        Random random = new Random();
        int accountNumber;
        Set<Integer> existingAccountNumbers = new HashSet<>();

        // Load all existing account numbers to avoid duplicates
        try {
            List<String> lines = Files.readAllLines(Paths.get("users.txt"));
            for (String line : lines) {
                String[] parts = line.split(",");
                existingAccountNumbers.add(Integer.parseInt(parts[2])); // Account number is the third element
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Generate a unique 6-digit account number
        do {
            accountNumber = 100000 + random.nextInt(900000); // Generates a random 6-digit number
        } while (existingAccountNumbers.contains(accountNumber));

        return accountNumber;
    }

    private void saveUser(String username, String password, int accountNumber, String contact, String dateOfBirth, String city) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(username + "," + password + "," + accountNumber + ",0.00," + contact + "," + dateOfBirth + "," + city);
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
