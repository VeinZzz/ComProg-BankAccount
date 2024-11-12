package BankSystem;

import javax.swing.*;

public class HomeScreen extends JFrame {
    public HomeScreen() {
        setTitle("Home Screen");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Welcome to the Home Screen!", SwingConstants.CENTER);
        add(label);

        setVisible(true);
    }
}