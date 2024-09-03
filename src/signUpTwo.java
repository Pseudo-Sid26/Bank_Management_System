//package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class singUpTwo extends JFrame implements ActionListener{
    long random;
    JTextField panNoT, aadhaarNoT;
    JComboBox religionT, categoryT, incomeT, qualificationT,occupationT;
    JRadioButton seniorCitizenYes,seniorCitizenNo, existingAccountYes,existingAccountNo;
    JButton next;
    String formNo;

    singUpTwo(String formNo){
        this.formNo = formNo;

        setTitle("New Account Application Form - Page 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setBounds(550, 40, 400, 30);
        additionalDetails.setFont(new Font("Poppins", Font.BOLD, 25));
        additionalDetails.setForeground(Color.gray);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion : ");
        religion.setBounds(380, 150, 290, 30);
        religion.setFont(new Font("San Sarif", Font.BOLD, 20));
        religion.setForeground(Color.BLACK);
        add(religion);
        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian","Other"};
        religionT = new JComboBox(valReligion);
        religionT.setBounds(600, 150, 400, 30);
        religionT.setFont(new Font("Arial", Font.ITALIC, 15));
        religionT.setBackground(Color.WHITE);
        add(religionT);

        JLabel category = new JLabel("Category : ");
        category.setBounds(380, 200, 290, 30);
        category.setFont(new Font("San Sarif", Font.BOLD, 20));
        category.setForeground(Color.BLACK);
        add(category);
        String[] valCategory = {"General", "OBC", "SC", "ST","Other"};
        categoryT = new JComboBox(valCategory);
        categoryT.setBounds(600, 200, 400, 30);
        categoryT.setFont(new Font("Arial", Font.ITALIC, 15));
        categoryT.setBackground(Color.WHITE);
        add(categoryT);

        JLabel income = new JLabel("Income : ");
        income.setBounds(380, 250, 290, 30);
        income.setFont(new Font("San Sarif", Font.BOLD, 20));
        income.setForeground(Color.BLACK);
        add(income);
        String[] valIncome = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomeT = new JComboBox(valIncome);
        incomeT.setBackground(Color.WHITE);
        incomeT.setBounds(600, 250, 400, 30);
        incomeT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(incomeT);

        JLabel educational = new JLabel("Educational");
        educational.setBounds(380, 300, 290, 30);
        educational.setFont(new Font("San Sarif", Font.BOLD, 20));
        educational.setForeground(Color.BLACK);
        add(educational);
        JLabel qualification = new JLabel("Qualification : ");
        qualification.setBounds(380, 322, 290, 30);
        qualification.setFont(new Font("San Sarif", Font.BOLD, 20));
        qualification.setForeground(Color.BLACK);
        add(qualification);
        String[] valEducation = {"Non-Graduate", "Under-Graduate", "Post-Graduate", "Ph.D", "Other"};
        qualificationT = new JComboBox(valEducation);
        qualificationT.setBackground(Color.WHITE);
        qualificationT.setBounds(600, 310, 400, 30);
        qualificationT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(qualificationT);

        JLabel occupation = new JLabel("Occupation : ");
        occupation.setBounds(380, 370, 290, 30);
        occupation.setFont(new Font("San Sarif", Font.BOLD, 20));
        occupation.setForeground(Color.BLACK);
        add(occupation);
        String[] valoccupation = {"Salaried", "Self-Employed", "Businessman", "Retired", "Student", "Others"};
        occupationT = new JComboBox(valoccupation);
        occupationT.setBounds(600, 370, 400, 30);
        occupationT.setBackground(Color.WHITE);
        occupationT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(occupationT);

        JLabel panNo = new JLabel("PAN No. : ");
        panNo.setBounds(380, 420, 290, 30);
        panNo.setFont(new Font("San Sarif", Font.BOLD, 20));
        panNo.setForeground(Color.BLACK);
        add(panNo);
        panNoT = new JTextField();
        panNoT.setBounds(600, 420, 400, 30);
        panNoT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(panNoT);

        JLabel aadhaarNo = new JLabel("Aadhaar No. : ");
        aadhaarNo.setBounds(380, 470, 290, 30);
        aadhaarNo.setFont(new Font("San Sarif", Font.BOLD, 20));
        aadhaarNo.setForeground(Color.BLACK);
        add(aadhaarNo);
        aadhaarNoT = new JTextField();
        aadhaarNoT.setBounds(600, 470, 400, 30);
        aadhaarNoT.setFont(new Font("Arial", Font.ITALIC, 15));
        add(aadhaarNoT);

        JLabel seniorCitizen = new JLabel("Senior Citizen : ");
        seniorCitizen.setBounds(380, 520, 290, 30);
        seniorCitizen.setFont(new Font("San Sarif", Font.BOLD, 20));
        seniorCitizen.setForeground(Color.BLACK);
        add(seniorCitizen);
        seniorCitizenYes = new JRadioButton("Yes");
        seniorCitizenYes.setBounds(600, 520, 80, 30);
        seniorCitizenYes.setBackground(Color.WHITE);
        seniorCitizenYes.setFont(new Font("Arial", Font.ITALIC, 15));
        add(seniorCitizenYes);
        seniorCitizenNo = new JRadioButton("No");
        seniorCitizenNo.setBounds(700, 520, 80, 30);
        seniorCitizenNo.setBackground(Color.WHITE);
        seniorCitizenNo.setFont(new Font("Arial", Font.ITALIC, 15));
        add(seniorCitizenNo);
        ButtonGroup seniorCitizenGrp = new ButtonGroup();
        seniorCitizenGrp.add(seniorCitizenYes);
        seniorCitizenGrp.add(seniorCitizenNo);

        JLabel exixtingAccount = new JLabel("Existing Account : ");
        exixtingAccount.setBounds(380, 570, 290, 30);
        exixtingAccount.setFont(new Font("San Sarif", Font.BOLD, 20));
        exixtingAccount.setForeground(Color.BLACK);
        add(exixtingAccount);
        existingAccountYes = new JRadioButton("Yes");
        existingAccountYes.setBounds(600, 570, 80, 30);
        existingAccountYes.setFont(new Font("Arial", Font.ITALIC, 15));
        existingAccountYes.setBackground(Color.WHITE);
        add(existingAccountYes);
        existingAccountNo = new JRadioButton("No");
        existingAccountNo.setBounds(700, 570, 80, 30);
        existingAccountNo.setFont(new Font("Arial", Font.ITALIC, 15));
        existingAccountNo.setBackground(Color.WHITE);
        add(existingAccountNo);
        ButtonGroup existingAccountGrp = new ButtonGroup();
        existingAccountGrp.add(existingAccountYes);
        existingAccountGrp.add(existingAccountNo);

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
        String religion = (String) religionT.getSelectedItem();
        String category = (String) categoryT.getSelectedItem();
        String income = (String) incomeT.getSelectedItem();
        String educational = (String) qualificationT.getSelectedItem();
        String occupation = (String) occupationT.getSelectedItem();

        String seniorCitizen = null;
        if (seniorCitizenYes.isSelected()){
            seniorCitizen = "Yes";
        }
        else if (seniorCitizenNo.isSelected()){
            seniorCitizen = "No";
        }

        String existingAccount = null;
        if (existingAccountYes.isSelected()){
            existingAccount = "Yes";
        }
        else if (existingAccountNo.isSelected()){
            existingAccount = "No";
        }

        String panNo = panNoT.getText();
        String aadhaar = aadhaarNoT.getText();

        try {
                conn c = new conn();
                String query = "insert into signuptwo values('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+educational+"','"+occupation+"','"+panNo+"','"+aadhaar+"','"+seniorCitizen+"','"+existingAccount+"')";
                conn.s.executeUpdate(query);

                setVisible(false);
                new signUpThree(formNo).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new singUpTwo("");
    }
}