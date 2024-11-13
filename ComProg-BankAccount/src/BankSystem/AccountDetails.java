package BankSystem;

import javax.swing.*;

public class AccountDetails extends JFrame {
    private JPanel mainPanel;
    private JPanel navPanel;
    private JLabel navNameLabel;
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
    private JLabel emailAddLabel;
    private JTextField emailAddField;
    private JLabel locationLabel;
    private JTextField locationField;
    private JLabel accNumLabel;
    private JTextField accNumField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JPanel accBtns;
    private JButton changeInfoBtn;
    private JButton deleteAccBtn;

    public AccountDetails() {
        setTitle("Account Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mainPanel);  // Set mainPanel from the GUI form as content pane
        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);           // Display the form

        setupListeners(); // Setup button listeners as needed
    }

    // Setup button listeners
    private void setupListeners() {
        // Sign Out button action
        signOutButton.addActionListener(e -> {
            dispose();   // Close the AccountDetails window
        });

        // Home button action to go back to Main Menu
        homeButton.addActionListener(e -> {
            openMainMenu(); // Call method to open MainMenuForm
        });

        // Transaction History button action to open BalInquiry form
        transactionHistoryButton.addActionListener(e -> {
            openBalInquiry(); // Call method to open BalInquiry form
        });

        // Example actions for other buttons
        changeInfoBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Change Info button clicked!");
        });

        deleteAccBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this account?",
                    "Delete Account", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Account deleted!");
            }
        });
    }

    // Method to open the MainMenuForm
    private void openMainMenu() {
        JFrame mainMenuFrame = new JFrame("Main Menu");
        MainMenuForm mainMenuForm = new MainMenuForm(); // Initialize MainMenuForm
        mainMenuFrame.setContentPane(mainMenuForm.getMainFrame()); // Set mainFrame as the content pane
        mainMenuFrame.setSize(968, 555); // Adjust size as needed
        mainMenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainMenuFrame.setLocationRelativeTo(null); // Center the window
        mainMenuFrame.setVisible(true);

        dispose(); // Close the AccountDetails window
    }

    // Method to open the BalInquiry form (Transaction History)
    private void openBalInquiry() {
        JFrame balInquiryFrame = new JFrame("Transaction History");
        BalInquiry balInquiryForm = new BalInquiry(); // Initialize BalInquiry form
        balInquiryFrame.setContentPane(balInquiryForm.getContentPane()); // Set BalInquiry content pane
        balInquiryFrame.setSize(900, 600); // Adjust size as needed
        balInquiryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        balInquiryFrame.setLocationRelativeTo(null); // Center the window
        balInquiryFrame.setVisible(true);

        dispose(); // Close the AccountDetails window
    }
}
