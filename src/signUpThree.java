import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class signUpThree extends JFrame implements ActionListener{
    JLabel l1;
    JCheckBox atmCard,internetBanking,mobileBanking,chequeBook,statement;
    JButton submit, cancel;
    JRadioButton typeSaving,typeFd,typeCurrent,typeRecurring;
    String formNo;
    signUpThree(String formNo){
        this.formNo = formNo;
        l1 = new JLabel("Page 3: Account Details");
        l1.setBounds(490, 20, 500, 50);
        l1.setFont(new Font("Ariel", Font.BOLD, 40));
        add(l1);

        JLabel type = new JLabel("Account Type : ");
        type.setBounds(380, 150, 290, 30);
        type.setFont(new Font("San Sarif", Font.BOLD, 20));
        type.setForeground(Color.BLACK);
        add(type);
        typeSaving = new JRadioButton("Saving");
        typeSaving.setBounds(600, 150, 100, 30);
        typeSaving.setBackground(Color.WHITE);
        typeSaving.setFont(new Font("Arial", Font.ITALIC, 15));
        add(typeSaving);

        typeFd = new JRadioButton("Fixed Deposit");
        typeFd.setBounds(800, 150, 200, 30);
        typeFd.setBackground(Color.WHITE);
        typeFd.setFont(new Font("Arial", Font.ITALIC, 15));
        add(typeFd);

        typeCurrent = new JRadioButton("Current");
        typeCurrent.setBounds(600, 180, 200, 30);
        typeCurrent.setBackground(Color.WHITE);
        typeCurrent.setFont(new Font("Arial", Font.ITALIC, 15));
        add(typeCurrent);

        typeRecurring = new JRadioButton("Recurring Deposit");
        typeRecurring.setBounds(800, 180, 200, 30);
        typeRecurring.setBackground(Color.WHITE);
        typeRecurring.setFont(new Font("Arial", Font.ITALIC, 15));
        add(typeRecurring);

        ButtonGroup typeGrp = new ButtonGroup();
        typeGrp.add(typeSaving);
        typeGrp.add(typeFd);
        typeGrp.add(typeCurrent);
        typeGrp.add(typeRecurring);


        JLabel cardNo = new JLabel("Card Number : ");
        cardNo.setBounds(380, 250, 290, 30);
        cardNo.setFont(new Font("San Sarif", Font.BOLD, 20));
        cardNo.setForeground(Color.BLACK);
        add(cardNo);
        JLabel cardNumber = new JLabel("XXXX-XXXX-XXXX-1234");
        cardNumber.setBounds(600, 250, 290, 30);
        cardNumber.setFont(new Font("San Sarif", Font.ITALIC, 15));
        cardNumber.setForeground(Color.BLACK);
        add(cardNumber);
        JLabel cardDetail = new JLabel("16 digit card number");
        cardDetail.setBounds(380, 268, 290, 30);
        cardDetail.setFont(new Font("San Sarif", Font.PLAIN, 15));
        cardDetail.setForeground(Color.GRAY);
        add(cardDetail);


        JLabel pinNo = new JLabel("PIN : ");
        pinNo.setBounds(380, 315, 290, 30);
        pinNo.setFont(new Font("San Sarif", Font.BOLD, 20));
        pinNo.setForeground(Color.BLACK);
        add(pinNo);
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setBounds(600, 315, 290, 30);
        pinNumber.setFont(new Font("San Sarif", Font.ITALIC, 15));
        pinNumber.setForeground(Color.BLACK);
        add(pinNumber);
        JLabel pinDetails = new JLabel("4 digit card PIN");
        pinDetails.setBounds(380, 333, 290, 30);
        pinDetails.setFont(new Font("San Sarif", Font.PLAIN, 15));
        pinDetails.setForeground(Color.GRAY);
        add(pinDetails);

        JLabel services = new JLabel("Services Required : ");
        services.setBounds(380, 383, 290, 30);
        services.setFont(new Font("San Sarif", Font.BOLD, 20));
        services.setForeground(Color.BLACK);
        add(services);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setBounds(600, 383, 500, 30);
        atmCard.setFont(new Font("San Sarif", Font.ITALIC, 15));
        atmCard.setBackground(Color.WHITE);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBounds(600, 413, 500, 30);
        internetBanking.setFont(new Font("San Sarif", Font.ITALIC, 15));
        internetBanking.setBackground(Color.WHITE);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(600, 443, 500, 30);
        mobileBanking.setFont(new Font("San Sarif", Font.ITALIC, 15));
        mobileBanking.setBackground(Color.WHITE);
        add(mobileBanking);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBounds(600, 473, 500, 30);
        chequeBook.setFont(new Font("San Sarif", Font.ITALIC, 15));
        chequeBook.setBackground(Color.WHITE);
        add(chequeBook);

        statement = new JCheckBox("I hearby declares that the above entered details are correct to the best of my knowledge ");
        statement.setBounds(400, 610, 700, 30);
        statement.setFont(new Font("San Sarif", Font.PLAIN, 15));
        statement.setBackground(Color.WHITE);
        add(statement);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.RED);
        cancel.setFont(new Font("San Sarif", Font.BOLD, 15));
        cancel.setBounds(500, 680, 100, 40);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setForeground(Color.BLUE);
        submit.setFont(new Font("San Sarif", Font.BOLD, 15));
        submit.setBounds(750, 680, 100, 40);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);

        getContentPane().setBackground(Color.WHITE);
        setTitle("Sign Up Form");
        setSize(1500, 850);
        setLocation(20, 10);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String type = null;
            if (typeSaving.isSelected()){
                type = "Saving Account";
            } else if (typeCurrent.isSelected()) {
                type = "Current Account";
            }else if (typeFd.isSelected()) {
                type = "Fixed Deposit";
            }else if (typeRecurring.isSelected()) {
                type = "Recurring Deposit";
            }
            Random randomNo = new Random();
            String cardNumber = ""+Math.abs((randomNo.nextLong() % 90000000L)+4050936000000000L);

            String pinNumber = ""+Math.abs((randomNo.nextLong() % 9000L)+1000L);

            String facility = "";
            if (atmCard.isSelected()){
                facility = facility + "ATM Card";
            }
            else if (internetBanking.isSelected()){
                facility = facility + "Internet Banking";
            }
            else if (mobileBanking.isSelected()){
                facility = facility + "Mobile Banking";
            }
            else if(chequeBook.isSelected()){
                facility = facility + "Cheque Book";
            }

            try {
                if (type.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Account type is required");
                }
                else{
                    conn c = new conn();
                    String query1 = "insert into signupthree values ('"+formNo+"','"+type+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query2 = "insert into login values ('"+formNo+"','"+cardNumber+"','"+pinNumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card number : "+cardNumber+"\n"+"PIN : "+pinNumber);

                    setVisible(false);
                    new deposit(pinNumber).setVisible(true);
                }

            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new signUpThree("");
    }
}
