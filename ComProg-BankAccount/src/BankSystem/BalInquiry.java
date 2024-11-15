package BankSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class BalInquiry extends JFrame {
    private JPanel mainPanel;
    private JPanel navPanel;
    private JLabel nameLabel;
    private JButton homeButton;
    private JLabel iconLabel;
    private JButton depositWithdrawButton;
    private JButton viewTransactionHisButton;
    private JButton manageAccountButton;
    private JButton signOutButton;
    private JLabel transactionHistoryLabel;
    private JLabel searchFilterLabel;
    private JLabel dateLabel;
    private JLabel withdrawDepositLabel;
    private JTable table1;
    private JPanel iconPanel;
    private JPanel filterPanel;
    private JPanel centerPanel;

    public BalInquiry() {
        setTitle("Transaction History");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Navigation panel setup
        navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        navPanel.setBackground(new Color(245, 245, 245));
        navPanel.setPreferredSize(new Dimension(200, getHeight()));

        iconPanel = new JPanel();
        iconPanel.setLayout(new BoxLayout(iconPanel, BoxLayout.Y_AXIS));
        iconPanel.setBackground(new Color(245, 245, 245));
        iconPanel.setPreferredSize(new Dimension(200, 120));

        iconLabel = new JLabel("Initials", SwingConstants.CENTER);
        iconLabel.setOpaque(true);
        iconLabel.setBackground(Color.decode("#c08552"));
        iconLabel.setForeground(Color.WHITE);
        iconLabel.setPreferredSize(new Dimension(80, 80));
        iconLabel.setMaximumSize(new Dimension(80, 80));
        iconLabel.setFont(new Font("Arial", Font.BOLD, 16));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel("Hi, User!", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        iconPanel.add(iconLabel);
        iconPanel.add(Box.createVerticalStrut(10));
        iconPanel.add(nameLabel);

        navPanel.add(iconPanel);
        navPanel.add(Box.createVerticalStrut(20));

        // Navigation buttons
        homeButton = createRoundedButton("Home", "home.png");
        depositWithdrawButton = createRoundedButton("Deposit/Withdraw", "deposit.png");
        viewTransactionHisButton = createRoundedButton("View Transaction History", "view.png");
        manageAccountButton = createRoundedButton("Manage Your Account", "manage.png");
        signOutButton = createRoundedButton("Sign Out", "signout.png");

        // Set up action listeners for navigation buttons
        homeButton.addActionListener(e -> openMainMenu());
        viewTransactionHisButton.addActionListener(e -> openBalInquiry());
        signOutButton.addActionListener(e -> openLogInForm());
        manageAccountButton.addActionListener(e -> openAccountDetailsForm());

        navPanel.add(homeButton);
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(depositWithdrawButton);
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(viewTransactionHisButton);
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(manageAccountButton);
        navPanel.add(Box.createVerticalGlue());
        navPanel.add(signOutButton);

        // Main content panel setup
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#f3e9dc"));
        mainPanel.setLayout(new BorderLayout());

        transactionHistoryLabel = new JLabel("Transaction History", SwingConstants.CENTER);
        transactionHistoryLabel.setOpaque(true);
        transactionHistoryLabel.setBackground(Color.decode("#c08552"));
        transactionHistoryLabel.setForeground(Color.WHITE);
        transactionHistoryLabel.setFont(new Font("Arial", Font.BOLD, 18));
        transactionHistoryLabel.setPreferredSize(new Dimension(0, 50));
        mainPanel.add(transactionHistoryLabel, BorderLayout.NORTH);

        // Filter and transaction table setup
        filterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        filterPanel.setBackground(Color.decode("#f3e9dc"));

        searchFilterLabel = createRoundedLabel("Search Filters");
        withdrawDepositLabel = createRoundedLabel("Withdraw/Deposit");
        dateLabel = createRoundedLabel("Date");

        filterPanel.add(searchFilterLabel);
        filterPanel.add(withdrawDepositLabel);
        filterPanel.add(dateLabel);

        String[] columnNames = {"Date/Type of Transaction", "Amount", "Previous Balance", "Updated Balance"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        table1 = new JTable(tableModel);
        table1.setRowHeight(30);
        table1.setGridColor(Color.decode("#c08552"));
        table1.getTableHeader().setReorderingAllowed(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table1.getColumnCount(); i++) {
            table1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        tableModel.addRow(new Object[]{"Nov. 6, 2024 - Withdraw", "1000 Php", "5000 Php", "4000 Php"});
        tableModel.addRow(new Object[]{"Nov. 7, 2024 - Deposit", "2000 Php", "4000 Php", "6000 Php"});

        JScrollPane scrollPane = new JScrollPane(table1);
        scrollPane.setPreferredSize(new Dimension(600, 200));

        centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(filterPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(navPanel, BorderLayout.WEST);       // Add navigation panel to the JFrame
        add(mainPanel, BorderLayout.CENTER);    // Add main panel to the JFrame

        setVisible(true);  // Display the JFrame
    }

    // Method to open MainMenuForm
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



    // Method to open BalInquiry (Transaction History)
    private void openBalInquiry() {
        new BalInquiry(); // Refresh or reopen BalInquiry
        dispose(); // Close the current BalInquiry window
    }

    // Method to open LogIn form
    private void openLogInForm() {
        JFrame balInquiryFrame = new JFrame("Transaction History");
        BalInquiry balInquiryForm = new BalInquiry(); // Initialize BalInquiry form
        balInquiryFrame.setContentPane(balInquiryForm.getContentPane()); // Set BalInquiry content pane
        balInquiryFrame.setSize(900, 600); // Adjust size as needed
        balInquiryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        balInquiryFrame.setLocationRelativeTo(null); // Center the window
        balInquiryFrame.setVisible(true);

        dispose();
    }

    private void openAccountDetailsForm() {
        JFrame accountDetailsFrame = new JFrame("Account Details");
        AccountDetails accountDetailsForm = new AccountDetails(); // Initialize AccountDetails form
        accountDetailsFrame.setContentPane(accountDetailsForm.getContentPane()); // Set AccountDetails content pane
        accountDetailsFrame.setSize(600, 400); // Adjust size as needed
        accountDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        accountDetailsFrame.setLocationRelativeTo(null); // Center the window
        accountDetailsFrame.setVisible(true);

        dispose(); // Close the BalInquiry window
    }

    private JButton createRoundedButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setForeground(Color.decode("#c08552"));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(160, 35));
        button.setIcon(new ImageIcon(iconPath));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        return button;
    }

    private JLabel createRoundedLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.decode("#c08552"));
        label.setForeground(Color.WHITE);
        label.setPreferredSize(new Dimension(160, 30));
        label.setFont(new Font("Arial", Font.BOLD, 14));
        return label;
    }
}
