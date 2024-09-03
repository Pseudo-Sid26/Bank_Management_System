import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {
    JLabel title, desc, newPin, rePin;
    JPasswordField newPinT, rePinT;
    JButton change, back;
    String pinNumber;

    pinChange(String pinNumber) {
        this.pinNumber = pinNumber;


        title = new JLabel("Virtual ATM");
        title.setBounds(660, 20, 650, 30);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setBackground(Color.LIGHT_GRAY);
        add(title);

        desc = new JLabel("You can change your PIN here");
        desc.setBounds(580, 60, 650, 30);
        desc.setFont(new Font("Arial", Font.PLAIN, 25));
        desc.setForeground(Color.GRAY);
        desc.setBackground(Color.LIGHT_GRAY);
        add(desc);

        newPin = new JLabel("New PIN : ");
        newPin.setBounds(550, 250, 650, 30);
        newPin.setFont(new Font("Arial", Font.BOLD, 20));
        newPin.setForeground(Color.BLACK);
        add(newPin);

        newPinT = new JPasswordField();
        newPinT.setBounds(800, 250, 200, 30);
        newPinT.setFont(new Font("Arial", Font.PLAIN, 18));
        newPinT.setForeground(Color.BLACK);
        add(newPinT);

        rePin = new JLabel("Re-Enter New PIN : ");
        rePin.setBounds(550, 350, 650, 30);
        rePin.setFont(new Font("Arial", Font.BOLD, 20));
        rePin.setForeground(Color.BLACK);
        add(rePin);

        rePinT = new JPasswordField();
        rePinT.setBounds(800, 350, 200, 30);
        rePinT.setFont(new Font("Arial", Font.PLAIN, 18));
        rePinT.setForeground(Color.BLACK);
        add(rePinT);

        change = new JButton("Change");
        change.setBounds(810, 470, 110, 30);
        change.setFont(new Font("Arial", Font.PLAIN, 20));
        change.setForeground(Color.BLUE);
        change.addActionListener(this);
        add(change);

        back = new JButton("Back");
        back.setBounds(540, 470, 110, 30);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        back.setForeground(Color.RED);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setTitle("Change PIN");
        setSize(1500, 850);
        setLocation(20, 10);
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String nPin = newPinT.getText();
                String rPin = rePinT.getText();

                if (!nPin.equals(rPin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                    return;
                }
                if (nPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                    return;
                }
                if (rPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return;
                }
                conn c = new conn();
                String query1 = "update bank set PIN_number = '" + rPin + "' where PIN_number = '" + pinNumber + "'";
                String query2 = "update login set PIN_number = '" + rPin + "' where PIN_number = '" + pinNumber + "'";
                String query3 = "update signupthree set PIN_number = '" + rPin + "' where PIN_number = '" + pinNumber + "'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN changes successfully !");
                setVisible(false);
                new transactions(rPin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new pinChange("");
    }
}

