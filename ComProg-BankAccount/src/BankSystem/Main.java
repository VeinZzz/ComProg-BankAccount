package BankSystem;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        // Run the Login form on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Bank Account Management System");
                frame.setContentPane(new LogIn().logInPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null); // Center the frame on the screen
                frame.setVisible(true);
            }
        });
    }
}
