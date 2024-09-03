import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transactions extends JFrame implements ActionListener {
    JLabel title,desc,transactionType;
    JButton deposit, withdrawl, miniStatement, pinChange, fastCash, balanceEnquiry, exit;
    String pinNumber;
    transactions(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        title = new JLabel("Virtual ATM");
        title.setBounds(660, 20, 650, 30);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setBackground(Color.LIGHT_GRAY);
        add(title);

        desc = new JLabel("Your transaction will be done from here");
        desc.setBounds(550, 60, 650, 30);
        desc.setFont(new Font("Arial", Font.PLAIN, 25));
        desc.setForeground(Color.GRAY);
        desc.setBackground(Color.LIGHT_GRAY);
        add(desc);

        transactionType = new JLabel("Please select your Transaction type");
        transactionType.setBounds(565, 300, 650, 35);
        transactionType.setFont(new Font("Arial", Font.BOLD, 25));
        transactionType.setForeground(Color.BLACK);
        add(transactionType);

        deposit = new JButton("Deposit");
        deposit.setBounds(565, 400, 200, 40);
        deposit.setForeground(Color.BLUE);
        deposit.setFont(new Font("Raleway", Font.PLAIN, 20));
        deposit.addActionListener(this);
        add(deposit);

        withdrawl = new JButton("Withdrawal");
        withdrawl.setBounds(780, 400, 200, 40);
        withdrawl.setForeground(Color.BLUE);
        withdrawl.setFont(new Font("Raleway", Font.PLAIN, 20));
        withdrawl.addActionListener(this);
        add(withdrawl);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(565, 450, 200, 40);
        miniStatement.setForeground(Color.BLUE);
        miniStatement.setFont(new Font("Raleway", Font.PLAIN, 20));
        miniStatement.addActionListener(this);
        add(miniStatement);

        pinChange = new JButton("PIN Change");
        pinChange.setBounds(780, 450, 200, 40);
        pinChange.setForeground(Color.BLUE);
        pinChange.setFont(new Font("Raleway", Font.PLAIN, 20));
        pinChange.addActionListener(this);
        add(pinChange);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(565, 500, 200, 40);
        fastCash.setForeground(Color.BLUE);
        fastCash.setFont(new Font("Raleway", Font.PLAIN, 20));
        fastCash.addActionListener(this);
        add(fastCash);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(780, 500, 200, 40);
        balanceEnquiry.setForeground(Color.BLUE);
        balanceEnquiry.setFont(new Font("Raleway", Font.PLAIN, 20));
        balanceEnquiry.addActionListener(this);
        add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(565, 550, 415, 40);
        exit.setForeground(Color.RED);
        exit.setFont(new Font("Raleway", Font.PLAIN, 18));
        exit.addActionListener(this);
        add(exit);


        getContentPane().setBackground(Color.WHITE);
        setTitle("Transaction Page");
        setSize(1500, 850);
        setLocation(20, 10);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        }else if (ae.getSource() == deposit){
            setVisible(false);
            new deposit(pinNumber).setVisible(true);
        }else if (ae.getSource() == withdrawl){
            setVisible(false);
            new withdrawl(pinNumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new fastCash(pinNumber).setVisible(true);
        } else if (ae.getSource() == pinChange){
            setVisible(false);
            new pinChange(pinNumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry){
            setVisible(false);
            new balanceEnquiry(pinNumber).setVisible(true);
        } else if (ae.getSource() == miniStatement) {
            new miniStatement(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
    new transactions("");
    }
}
