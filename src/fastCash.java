import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {
    JLabel title,desc,transactionType;
    JButton hundred, fiveHundred, thousand, twoThousand, fiveThousand, tenThousand, back;
    String pinNumber;
    fastCash(String pinNumber){
        this.pinNumber = pinNumber;
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

        transactionType = new JLabel("Select your amount to withdrawal");
        transactionType.setBounds(610, 300, 650, 35);
        transactionType.setFont(new Font("Arial", Font.BOLD, 20));
        transactionType.setForeground(Color.BLACK);
        add(transactionType);

        hundred = new JButton("₹ 100");
        hundred.setBounds(565, 400, 200, 40);
        hundred.setForeground(Color.BLUE);
        hundred.setFont(new Font("Raleway", Font.ITALIC, 18));
        hundred.addActionListener(this);
        add(hundred);

        fiveHundred = new JButton("₹ 500");
        fiveHundred.setBounds(780, 400, 200, 40);
        fiveHundred.setForeground(Color.BLUE);
        fiveHundred.setFont(new Font("Raleway", Font.ITALIC, 18));
        fiveHundred.addActionListener(this);
        add(fiveHundred);

        thousand = new JButton("₹ 1000");
        thousand.setBounds(565, 450, 200, 40);
        thousand.setForeground(Color.BLUE);
        thousand.setFont(new Font("Raleway", Font.ITALIC, 18));
        thousand.addActionListener(this);
        add(thousand);

        twoThousand = new JButton("₹ 2000");
        twoThousand.setBounds(780, 450, 200, 40);
        twoThousand.setForeground(Color.BLUE);
        twoThousand.setFont(new Font("Raleway", Font.ITALIC, 18));
        twoThousand.addActionListener(this);
        add(twoThousand);

        fiveThousand = new JButton("₹ 5000");
        fiveThousand.setBounds(565, 500, 200, 40);
        fiveThousand.setForeground(Color.BLUE);
        fiveThousand.setFont(new Font("Raleway", Font.ITALIC, 18));
        fiveThousand.addActionListener(this);
        add(fiveThousand);

        tenThousand = new JButton("₹ 10000");
        tenThousand.setBounds(780, 500, 200, 40);
        tenThousand.setForeground(Color.BLUE);
        tenThousand.setFont(new Font("Raleway", Font.ITALIC, 18));
        tenThousand.addActionListener(this);
        add(tenThousand);

        back = new JButton("Exit");
        back.setBounds(565, 550, 415, 40);
        back.setForeground(Color.RED);
        back.setFont(new Font("Raleway", Font.ITALIC, 18));
        back.addActionListener(this);
        add(back);


        getContentPane().setBackground(Color.WHITE);
        setTitle("Fast Cash");
        setSize(1500, 850);
        setLocation(20, 10);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(2);
            conn c= new conn();
            try{
                ResultSet rs = c.s.executeQuery("Select * from bank where PIN_number = '" + pinNumber + "'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values ('"+pinNumber+"', '"+date+"','Withdrawal', '"+amount+"')";
                JOptionPane.showMessageDialog(null, "₹ "+amount+" Debited Successfully !");
                c.s.executeUpdate(query);
                setVisible(false);
                new transactions(pinNumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new fastCash(" ");
    }
}
