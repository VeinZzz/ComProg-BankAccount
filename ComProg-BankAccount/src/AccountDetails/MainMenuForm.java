import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuForm {
    private JPanel mainFrame;
    private JButton accountDetailsButton;
    private JButton depositWithdrawButton;
    private JButton transactionHistoryButton;
    private JLabel bankAccountTitle;
    private JButton signOutButton;
    private JLabel accountBalance;

    public MainMenuForm() {
        accountBalance.setOpaque(true);
        accountDetailsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // PLEASE INPUT NAME OF FORM HERE | THIS IS ACCOUNT DETAILS BUTTON, remove // once done
                // new AccountDetailsForm().setVisible(true);
                // 
            }
        });
        depositWithdrawButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // new DepositWithdrawForm().setVisible(true);
            }
        });
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() ->{
            JFrame frame = new JFrame("Bank Account Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new MainMenuForm().mainFrame);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(new Dimension(968, 555));
        });
    }
}
