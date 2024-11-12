import javax.swing.*;

public class TransactionHistoryScreen extends JFrame {
    public TransactionHistoryScreen() {
        setTitle("Transaction History");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Transaction History Screen", SwingConstants.CENTER);
        add(label);

        setVisible(true);
    }
}