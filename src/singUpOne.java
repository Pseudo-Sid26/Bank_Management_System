//package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


class singUpOne extends JFrame implements ActionListener{
    long random;
    JTextField nameT, fnameT, emailT,addressT, cityT, stateT, pinCodeT;
    JDateChooser dobT;
    JRadioButton male, female, other, married, unmarried, otherRalation;
    JButton next;

    singUpOne(){
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+1000L);

        JLabel formNo = new JLabel("Application Form " + random);
        formNo.setBounds(490, 20, 430, 40);
        formNo.setFont(new Font("Ariel", Font.BOLD, 40));
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setBounds(550, 80, 290, 30);
        personalDetails.setFont(new Font("Poppins", Font.BOLD, 25));
        personalDetails.setForeground(Color.gray);
        add(personalDetails);

        JLabel name = new JLabel("Your Name : ");
        name.setBounds(380, 150, 290, 30);
        name.setFont(new Font("San Sarif", Font.BOLD, 20));
        name.setForeground(Color.BLACK);
        add(name);
        nameT = new JTextField();
        nameT.setBounds(600, 150, 400, 30);
        nameT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(nameT);

        JLabel fname = new JLabel("Father's Name : ");
        fname.setBounds(380, 200, 290, 30);
        fname.setFont(new Font("San Sarif", Font.BOLD, 20));
        fname.setForeground(Color.BLACK);
        add(fname);
        fnameT = new JTextField();
        fnameT.setBounds(600, 200, 400, 30);
        fnameT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(fnameT);

        JLabel dob = new JLabel("Date of Birth : ");
        dob.setBounds(380, 250, 290, 30);
        dob.setFont(new Font("San Sarif", Font.BOLD, 20));
        dob.setForeground(Color.BLACK);
        add(dob);
        dobT = new JDateChooser();
        dobT.setBounds(600, 250, 400, 30);
        dobT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(dobT);

        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(380, 300, 290, 30);
        gender.setFont(new Font("San Sarif", Font.BOLD, 20));
        gender.setForeground(Color.BLACK);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(600, 300, 80, 30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Arial", Font.ITALIC, 15));
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(700, 300, 80, 30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Arial", Font.ITALIC, 15));
        add(female);
        other = new JRadioButton("Other");
        other.setBounds(800, 300, 80, 30);
        other.setBackground(Color.WHITE);
        other.setFont(new Font("Arial", Font.ITALIC, 15));
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("E-mail Address : ");
        email.setBounds(380, 350, 290, 30);
        email.setFont(new Font("San Sarif", Font.BOLD, 20));
        email.setForeground(Color.BLACK);
        add(email);
        emailT = new JTextField();
        emailT.setBounds(600, 350, 400, 30);
        emailT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(emailT);

        JLabel maritalStatus = new JLabel("Marital Status : ");
        maritalStatus.setBounds(380, 400, 290, 30);
        maritalStatus.setFont(new Font("San Sarif", Font.BOLD, 20));
        maritalStatus.setForeground(Color.BLACK);
        add(maritalStatus);
        married = new JRadioButton("Married");
        married.setBounds(600, 400, 80, 30);
        married.setBackground(Color.WHITE);
        married.setFont(new Font("Arial", Font.ITALIC, 15));
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(700,400,100,30);
        unmarried.setBackground(Color.WHITE);
        unmarried.setFont(new Font("Arial", Font.ITALIC, 15));
        add(unmarried);
        otherRalation = new JRadioButton("Other");
        otherRalation.setBounds(800,400,100,30);
        otherRalation.setBackground(Color.WHITE);
        otherRalation.setFont(new Font("Arial", Font.ITALIC, 15));
        add(otherRalation);
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(otherRalation);

        JLabel address = new JLabel("Residential Address : ");
        address.setBounds(380, 450, 290, 30);
        address.setFont(new Font("San Sarif", Font.BOLD, 20));
        address.setForeground(Color.BLACK);

        add(address);
        addressT = new JTextField();
        addressT.setBounds(600, 450, 400, 30);
        addressT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(addressT);

        JLabel city = new JLabel("Residential City : ");
        city.setBounds(380, 500, 290, 30);
        city.setFont(new Font("San Sarif", Font.BOLD, 20));
        city.setForeground(Color.BLACK);
        add(city);
        cityT = new JTextField();
        cityT.setBounds(600, 500, 400, 30);
        cityT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(cityT);

        JLabel state = new JLabel("State : ");
        state.setBounds(380, 550, 290, 30);
        state.setFont(new Font("San Sarif", Font.BOLD, 20));
        state.setForeground(Color.BLACK);
        add(state);
        stateT = new JTextField();
        stateT.setBounds(600, 550, 400, 30);
        stateT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(stateT);

        JLabel pinCode = new JLabel("Pin Code : ");
        pinCode.setBounds(380, 600, 290, 30);
        pinCode.setFont(new Font("San Sarif", Font.BOLD, 20));
        pinCode.setForeground(Color.BLACK);
        add(pinCode);
        pinCodeT = new JTextField();
        pinCodeT.setBounds(600, 600, 400, 30);
        pinCodeT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(pinCodeT);

        next = new JButton("Next");
        next.setForeground(Color.BLUE);
        next.setFont(new Font("Rale way", Font.BOLD, 20));
        next.setBounds(900, 670, 100, 40);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setTitle("Sign Up Form");
        setSize(1500, 850);
        setLocation(20, 10);
        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        String formNo =  "" + random;
        String name = nameT.getText();
        String fname = fnameT.getText();
        String dob = ((JTextField)dobT.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }
        else if (female.isSelected()){
            gender = "Female";
        }
        else if (other.isSelected()){
            gender = "Other";
        }
        String email = emailT.getText();
        String maritalStatus = null;
        if (married.isSelected()){
            maritalStatus = "Married";
        }
        else if (unmarried.isSelected()){
            maritalStatus = "Unmarried";
        }
        else if (otherRalation.isSelected()){
            maritalStatus = "Other";
        }

        String address = addressT.getText();
        String city = cityT.getText();
        String state = stateT.getText();
        String pincode = pinCodeT.getText();

        try {
            if (name.isEmpty()){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else {
                conn c = new conn();
                String query = "insert into signup values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                conn.s.executeUpdate(query);
                setVisible(false);
                new singUpTwo(formNo).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new singUpOne();
    }
}
