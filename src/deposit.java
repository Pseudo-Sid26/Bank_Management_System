import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class deposit extends JFrame implements ActionListener {
    JLabel title, depositAmount;
    JTextField depositAmountT;
    JButton deposit, back;
    String pinNumber;
    deposit (String pinNumber) {
        this.pinNumber = pinNumber;
        title = new JLabel("Virtual ATM");
        title.setBounds(660, 20, 650, 30);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setBackground(Color.LIGHT_GRAY);
        add(title);

        depositAmount = new JLabel("Enter the amount you want to deposit");
        depositAmount.setBounds(550, 260, 650, 35);
        depositAmount.setFont(new Font("Arial", Font.BOLD, 20));
        depositAmount.setForeground(Color.BLACK);
        add(depositAmount);

        depositAmountT = new JTextField();
        depositAmountT.setBounds(550, 360, 358, 30);
        depositAmountT.setFont(new Font("Arial", Font.ITALIC, 15));
        depositAmountT.setForeground(Color.BLACK);
        add(depositAmountT);

        deposit = new JButton("Deposit");
        deposit.setBounds(550, 430, 100, 30);
        deposit.setForeground(Color.BLUE);
        deposit.setFont(new Font("Raleway", Font.PLAIN, 18));
        deposit.addActionListener(this);
        add(deposit);

        back = new JButton("Back");
        back.setBounds(810, 430, 100, 30);
        back.setForeground(Color.RED);
        back.setFont(new Font("Raleway", Font.PLAIN, 18));
        back.addActionListener(this);
        add(back);


        getContentPane().setBackground(Color.WHITE);
        setTitle("Deposit");
        setSize(1500, 850);
        setLocation(20, 10);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit){
            String amount = depositAmountT.getText();
            Date date = new Date();
            if (amount.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else {
                try {
                    conn c = new conn();
                    String query = "insert into bank values('"+pinNumber+"','"+date+"','Deposit', '"+amount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amount+" Deposited Successfully !");
                    setVisible(false);
                    new transactions(pinNumber).setVisible(true);
                } catch(Exception e){
                    System.out.println(e);
                }

            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new transactions(pinNumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new deposit("");
    }
}
