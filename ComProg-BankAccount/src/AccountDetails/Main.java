package AccountDetails;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Run the Login form on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Bank Account Management System - Log In");
                frame.setContentPane(new LogIn().logInPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null); // Center the frame on the screen
                frame.setVisible(true);
            }
        });
    }
}
