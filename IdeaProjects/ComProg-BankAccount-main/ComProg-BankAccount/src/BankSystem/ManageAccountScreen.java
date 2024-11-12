package BankSystem;

import javax.swing.*;

public class ManageAccountScreen extends JFrame {
    public ManageAccountScreen() {
        setTitle("Manage Your Account");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Manage Your Account Screen", SwingConstants.CENTER);
        add(label);

        setVisible(true);
    }
}