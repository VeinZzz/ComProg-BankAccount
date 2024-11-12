import javax.swing.*;

public class DepositWithdrawScreen extends JFrame {
    public DepositWithdrawScreen() {
        setTitle("Deposit/Withdraw");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Deposit/Withdraw Screen", SwingConstants.CENTER);
        add(label);

        setVisible(true);
    }
}
