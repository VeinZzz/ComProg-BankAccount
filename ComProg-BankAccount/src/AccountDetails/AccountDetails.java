package AccountDetails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AccountDetails {
    public JPanel mainPanel;
    private JPanel navPanel;
    private JButton homeButton;
    private JButton signOutButton;
    private JButton withdrawDepositButton;
    private JButton transactionHistoryButton;
    private JButton manageAccountButton;
    private JLabel accIcon;
    private JPanel accInfoPanel;
    private JLabel accHeading;
    private JTextField nameField;
    private JLabel nameLabel;
    private JLabel accTypeLabel;
    private JTextField accTypeField;
    private JTextField accNumField;
    private JTextField emailAddField; // Corrected email field
    private JPasswordField passwordField;
    private JTextField locationField;
    private JLabel accNumLabel;
    private JLabel emailAddLabel;
    private JLabel passwordLabel;
    private JLabel locationLabel;
    private JButton changeInfoBtn;
    private JButton deleteAccBtn;
    private JPanel accBtns;
    private JLabel navNameLabel;

    // Data file for account information
    private static final String DATA_FILE = "resources/AccInfo.txt";

    public AccountDetails() {
        initializeUI();
        initializeListeners();
        loadAccountData();
    }

    private void initializeUI() {
        // Set navigation panel background and styling
        navPanel.setBackground(new Color(242, 240, 255)); // Light purple
        homeButton.setBackground(Color.WHITE);
        withdrawDepositButton.setBackground(Color.WHITE);
        transactionHistoryButton.setBackground(Color.WHITE);
        manageAccountButton.setBackground(Color.WHITE);
        signOutButton.setBackground(Color.WHITE);

        // Set icons for navigation buttons (replace with actual icons if needed)
        homeButton.setIcon(new ImageIcon("icons/home.png")); // Use actual paths or icon objects
        withdrawDepositButton.setIcon(new ImageIcon("icons/deposit.png"));
        transactionHistoryButton.setIcon(new ImageIcon("icons/transaction.png"));
        manageAccountButton.setIcon(new ImageIcon("icons/manage.png"));
        signOutButton.setIcon(new ImageIcon("icons/signout.png"));

        // Set account info panel background and styling
        accInfoPanel.setBackground(new Color(252, 245, 237)); // Light beige
        accHeading.setFont(new Font("SansSerif", Font.BOLD, 18));
        accHeading.setForeground(new Color(160, 82, 45)); // Brown color
        accHeading.setText("Account Details");

        // Style labels
        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        Color labelColor = new Color(160, 82, 45);
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(labelColor);
        accNumLabel.setFont(labelFont);
        accNumLabel.setForeground(labelColor);
        accTypeLabel.setFont(labelFont);
        accTypeLabel.setForeground(labelColor);
        emailAddLabel.setFont(labelFont);
        emailAddLabel.setForeground(labelColor);
        passwordLabel.setFont(labelFont);
        passwordLabel.setForeground(labelColor);
        locationLabel.setFont(labelFont);
        locationLabel.setForeground(labelColor);

        // Style buttons in account section
        Color buttonColor = new Color(160, 82, 45);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 12);
        changeInfoBtn.setBackground(buttonColor);
        changeInfoBtn.setForeground(Color.WHITE);
        changeInfoBtn.setFont(buttonFont);
        deleteAccBtn.setBackground(buttonColor);
        deleteAccBtn.setForeground(Color.WHITE);
        deleteAccBtn.setFont(buttonFont);

        // Set main panel background
        mainPanel.setBackground(new Color(252, 245, 237)); // Match background color
    }

    private void loadAccountData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            Map<String, String> accountDetails = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    accountDetails.put(parts[0], parts[1]);
                }
            }
            // Assume account number is in accNumField to load details
            String accountNumber = accNumField.getText();
            if (accountDetails.containsKey(accountNumber)) {
                String[] details = accountDetails.get(accountNumber).split(",");
                nameField.setText(details[0]);
                accTypeField.setText(details[1]);
                emailAddField.setText(details[2]); // Updated to use emailAddField
                passwordField.setText(details[3]);
                locationField.setText(details[4]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeListeners() {
        changeInfoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleChangeInfo();
            }
        });

        deleteAccBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDeleteAccount();
            }
        });
    }

    private void handleChangeInfo() {
        String accountNumber = accNumField.getText();
        String newDetails = nameField.getText() + "," + accTypeField.getText() + "," +
                emailAddField.getText() + "," + new String(passwordField.getPassword()) + "," + // Updated to use emailAddField
                locationField.getText();

        try {
            updateAccountData(accountNumber, newDetails);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void updateAccountData(String accountNumber, String newDetails) throws IOException {
        File tempFile = new File("temp.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(accountNumber)) {
                    writer.write(accountNumber + ":" + newDetails);
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }
        }
        tempFile.renameTo(new File(DATA_FILE));
    }

    private void handleDeleteAccount() {
        String accountNumber = accNumField.getText();

        try {
            deleteAccountData(accountNumber);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteAccountData(String accountNumber) throws IOException {
        File tempFile = new File("temp.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (!parts[0].equals(accountNumber)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
        tempFile.renameTo(new File(DATA_FILE));
    }
}
