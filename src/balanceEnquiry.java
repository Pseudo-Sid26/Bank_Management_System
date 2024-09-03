import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceEnquiry extends JFrame implements ActionListener {
    JLabel title, desc, text;
    JButton back;
    String pinNumber;

    balanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        title = new JLabel("Virtual ATM");
        title.setBounds(660, 20, 650, 30);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setBackground(Color.LIGHT_GRAY);
        add(title);

        desc = new JLabel("You can check your account balance here");
        desc.setBounds(530, 120, 650, 30);
        desc.setFont(new Font("Arial", Font.PLAIN, 25));
        desc.setForeground(Color.GRAY);
        desc.setBackground(Color.LIGHT_GRAY);
        add(desc);

        back = new JButton("Back");
        back.setBounds(680, 470, 110, 30);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        back.setForeground(Color.RED);
        back.addActionListener(this);
        add(back);

        conn c = new conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("Select * from bank where PIN_number = '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        text = new JLabel("Your current Account Balance : ₹ "+balance);
        text.setBounds(580, 320, 500, 30);
        text.setFont(new Font("Arial", Font.BOLD, 20));
        text.setForeground(Color.BLACK);
        add(text);

        setSize(900, 500);
        setLocation(300, 150);

        getContentPane().setBackground(Color.WHITE);
        setTitle("Balance Enquiry");
        setSize(1500, 850);
        setLocation(20, 10);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new transactions(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}
