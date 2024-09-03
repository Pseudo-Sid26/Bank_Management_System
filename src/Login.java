//package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login, clear, signUp;
    JTextField cardNumber;
    JPasswordField pinNumber;

    Login() {

        setTitle("Automated Teller Machine");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("asset/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(50, 50, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to the ATM");
        text.setBounds(550, 60, 500, 50);
        text.setFont(new Font("pop ins", Font.BOLD, 40));
        add(text);

        JLabel cardNo = new JLabel("Card Number :");
        cardNo.setBounds(500, 300, 500, 50);
        cardNo.setFont(new Font("pop ins", Font.BOLD, 20));
        add(cardNo);
        cardNumber = new JTextField();
        cardNumber.setBounds(650, 310, 300, 40);
        cardNumber.setFont(new Font("Arial", Font.BOLD, 15));
        add(cardNumber);

        JLabel cardPin = new JLabel("Card PIN :");
        cardPin.setBounds(500, 400, 500, 50);
        cardPin.setFont(new Font("pop ins", Font.BOLD, 20));
        add(cardPin);
        pinNumber = new JPasswordField();
        pinNumber.setBounds(650, 410, 300, 40);
        pinNumber.setFont(new Font("Arial", Font.BOLD, 15));
        add(pinNumber);

        login = new JButton("Login");
        login.setBounds(650, 480, 120, 35);
        login.setForeground(Color.BLUE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(828, 480, 120, 35);
        clear.setForeground(Color.BLUE);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("Sign Up");
        signUp.setBounds(650, 530, 300, 35);
        signUp.setForeground(Color.BLACK);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);
        setSize(1500, 850);
        setLocation(20, 10);
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardNumber.setText("");
            pinNumber.setText("");
        } else if (ae.getSource() == login) {
            conn c = new conn();
            String cardnumber = cardNumber.getText();
            String pinnumber = pinNumber.getText();
            String query = "select * from login where card_number = '"+cardnumber+"' and PIN_number = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new singUpOne().setVisible(true);

        }
    }

    public static void main (String[]args){
        new Login();
    }
}