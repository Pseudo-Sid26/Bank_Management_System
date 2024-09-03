import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class miniStatement extends JFrame implements ActionListener {
    JLabel title, cardNo, mini, balance;
    String pinNumber;

    miniStatement(String pinNumber) {
        this.pinNumber = pinNumber;

        title = new JLabel("Indian Bank");
        title.setBounds(90, 20, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setBackground(Color.LIGHT_GRAY);
        add(title);

        cardNo = new JLabel();
        cardNo.setBounds(20, 100, 370, 20);
        add(cardNo);

        mini = new JLabel();
        mini.setBounds(20, 130, 370, 200);
        add(mini);

        balance = new JLabel("balance");
        balance.setBounds(20, 500, 370, 20);
        add(balance);

        try {
            conn c = new conn();
            ResultSet rs = conn.s.executeQuery("select * from login where PIN_number = '" + pinNumber + "'");
            while (rs.next()) {
                cardNo.setText("Card Number : " + rs.getString("card_number").substring(0, 4) + "XXXXXXXX" + rs.getString("card_number").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            conn c = new conn();
            int bal = 0;

            ResultSet rs = conn.s.executeQuery("select * from bank where PIN_number = '" + pinNumber + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current Account Balance : ₹ " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(350, 600);
        setLocation(50, 50);
        setTitle("Mini Statement");
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        new miniStatement("");
    }
}
