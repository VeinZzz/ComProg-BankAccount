package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuForm extends JFrame {
    public Container mainMenuPanel;
    private JPanel mainFrame;
    private JButton accountDetailsButton;
    private JButton depositWithdrawButton;
    private JButton transactionHistoryButton;
    private JLabel bankAccountTitle;
    private JButton signOutButton;
    private JLabel accountBalance;

    public MainMenuForm() {
        if (mainMenuPanel == null) {
            mainMenuPanel = new JPanel();
        }

        accountBalance.setOpaque(true);

        // Account Details Button - opens AccountDetails form
        accountDetailsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AccountDetails accountDetails = new AccountDetails();
                accountDetails.setVisible(true); // Make sure to set the form visible
                closeCurrentForm();
            }
        });

        // Transaction History Button - opens BalInquiry form
        transactionHistoryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new BalInquiry(); // Opens BalInquiry form
                closeCurrentForm();
            }
        });

        // Sign Out Button - opens LogIn form
        signOutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LogIn logIn = new LogIn();
                logIn.setVisible(true); // Make sure to set the form visible
                closeCurrentForm();
            }
        });

        mainMenuPanel = new JPanel();
    }

    // Method to close the current form
    private void closeCurrentForm() {
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainFrame);
        if (currentFrame != null) {
            currentFrame.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bank Account Management System");
            MainMenuForm mainMenuForm = new MainMenuForm();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(mainMenuForm.mainFrame);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(new Dimension(968, 555));
        });
    }

    public JPanel getMainFrame() {
        return mainFrame;
    }
}
