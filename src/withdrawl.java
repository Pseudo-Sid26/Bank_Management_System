import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener {
    JLabel title, withdeawAmount;
    JButton withdraw, back;
    JTextField withdeawAmountT;
    String pinNumber;

    withdrawl(String pinNumber) {
        this.pinNumber = pinNumber;
        title = new JLabel("Virtual ATM");
        title.setBounds(660, 20, 650, 30);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setBackground(Color.LIGHT_GRAY);
        add(title);

        withdeawAmount = new JLabel("Enter the amount you want to Withdraw");
        withdeawAmount.setBounds(550, 260, 650, 35);
        withdeawAmount.setFont(new Font("Arial", Font.BOLD, 20));
        withdeawAmount.setForeground(Color.BLACK);
        add(withdeawAmount);

        withdeawAmountT = new JTextField();
        withdeawAmountT.setBounds(550, 360, 358, 30);
        withdeawAmountT.setFont(new Font("Arial", Font.ITALIC, 15));
        withdeawAmountT.setForeground(Color.BLACK);
        add(withdeawAmountT);

        back = new JButton("Back");
        back.setBounds(550, 460, 130, 30);
        back.setForeground(Color.RED);
        back.setFont(new Font("Raleway", Font.PLAIN, 18));
        back.addActionListener(this);
        add(back);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(780, 460, 130, 30);
        withdraw.setForeground(Color.BLUE);
        withdraw.setFont(new Font("Raleway", Font.PLAIN, 18));
        withdraw.addActionListener(this);
        add(withdraw);


        getContentPane().setBackground(Color.WHITE);
        setTitle("Withdraw");
        setSize(1500, 850);
        setLocation(20, 10);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new transactions(pinNumber).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            String amount = withdeawAmountT.getText();
            Date date = new Date();
            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else {
                conn c = new conn();
            }
            try {
                ResultSet rs = conn.s.executeQuery("Select * from bank where PIN_number = '" + pinNumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                String query = "insert into bank values('" + pinNumber + "','" + date + "','Withdraw', '" + amount + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdraw Successfully !");
                setVisible(false);
                new transactions(pinNumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


    public static void main(String[] args) {
        new withdrawl("");
    }
}