package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpTwo extends JFrame implements ActionListener {

    JComboBox<String> religion, category, incomecat, educational, occu;
    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton sno, syes, eyes, eno;
    String formno;

    public SignUpTwo(String formno){
        this.formno = formno;

        setTitle("NEW USER APPLICATION FORM - PAGE 2");

        setLayout(null);

        //page header
        JLabel additionalDetails = new JLabel("Page 2 : ADDITIONAL DETAILS");
        additionalDetails.setBounds(260,80,400,30);
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(additionalDetails);

        //religion
        JLabel rel = new JLabel("Religion :");
        rel.setBounds(100,140,150,30);
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        add(rel);

        String[] valReligion = {"Hindu", "Muslim", "Christian", "Sikh", "Punjabi", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBackground(Color.WHITE);
        add(religion);

        //category
        JLabel cat = new JLabel("Category :");
        cat.setBounds(100,190,150,30);
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        add(cat);

        String[] valCategory = {"General", "SC", "ST", "OBC", "EWS", "Other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300,190,400,30);
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBackground(Color.WHITE);
        add(category);

        //income
        JLabel income = new JLabel("Income : ");
        income.setBounds(100,240,150,30);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        add(income);

        String[] incomecategory = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomecat = new JComboBox<>(incomecategory);
        incomecat.setBounds(300,240,400,30);
        incomecat.setFont(new Font("Arial",Font.BOLD,20));
        incomecat.setForeground(Color.BLACK);
        add(incomecat);

        //educational qualification
        JLabel education = new JLabel("Educational");
        education.setBounds(100,290,200,30);
        education.setFont(new Font("Raleway",Font.BOLD,20));
        add(education);

        JLabel education1 = new JLabel("Qualifications : ");
        education1.setBounds(100,315,200,30);
        education1.setFont(new Font("Raleway",Font.BOLD,20));
        add(education1);

        String[] eduVal = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        educational = new JComboBox<>(eduVal);
        educational.setBounds(300,310,400,30);
        educational.setFont(new Font("Arial",Font.BOLD,20));
        educational.setForeground(Color.BLACK);
        add(educational);

        //occupation
        JLabel occupation = new JLabel("Occupation : ");
        occupation.setBounds(100,375,150,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        add(occupation);

        String[] occuVal = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occu = new JComboBox<>(occuVal);
        occu.setBounds(300,375,400,30);
        occu.setFont(new Font("Raleway",Font.BOLD,20));
        add(occu);

        //pan number
        JLabel pan = new JLabel("Pan Number : ");
        pan.setBounds(100,430,150,30);
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        add(pan);

        panTextField = new JTextField();
        panTextField.setBounds(300,430,400,30);
        panTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(panTextField);

        //aadhar number
        JLabel aadhar = new JLabel("Aadhar Number : ");
        aadhar.setBounds(100,490,150,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setBounds(300,490,400,30);
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadharTextField);

        //senior citizen
        JLabel isSenior = new JLabel("Senior Citizen :");
        isSenior.setBounds(100,540,150,30);
        isSenior.setFont(new Font("Raleway",Font.BOLD,20));
        add(isSenior);

        syes = new JRadioButton("YES");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        syes.setFont(new Font("Arial",Font.BOLD,20));
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(430,540,100,30);
        sno.setBackground(Color.WHITE);
        sno.setFont(new Font("Arial",Font.BOLD,20));
        add(sno);

        ButtonGroup group = new ButtonGroup();
        group.add(syes);
        group.add(sno);

        //existing account
        JLabel exists = new JLabel("Existing Account :");
        exists.setBounds(100,590,175,30);
        exists.setFont(new Font("Raleway",Font.BOLD,20));
        add(exists);

        eyes = new JRadioButton("YES");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        eyes.setFont(new Font("Arial",Font.BOLD,20));
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(430,590,100,30);
        eno.setBackground(Color.WHITE);
        eno.setFont(new Font("Arial",Font.BOLD,20));
        add(eno);

        ButtonGroup egroup = new ButtonGroup();
        egroup.add(syes);
        egroup.add(sno);


        setSize(850,800);
        setVisible(true);
        setLocation(500,100);
        getContentPane().setBackground(Color.WHITE);

        next = new JButton("Next");
        next.setBounds(360, 700, 150, 30);
        next.setBackground(Color.GREEN);
        next.setFont(new Font("Arial",Font.PLAIN,28));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
    }

    public void actionPerformed(ActionEvent ae){
        //collecting user data from form together
        String sReligion = Objects.requireNonNull(religion.getSelectedItem()).toString();
        String sCategory = Objects.requireNonNull(category.getSelectedItem()).toString();
        String sIncome = Objects.requireNonNull(incomecat.getSelectedItem()).toString();
        String sEducation = Objects.requireNonNull(educational.getSelectedItem()).toString();
        String sOccupation = Objects.requireNonNull(occu.getSelectedItem()).toString();

        String isSenior = null;
        if(syes.isSelected()){
            isSenior = "YES";
        } else if(sno.isSelected()){
            isSenior = "NO";
        }

        String isExisting = null;
        if(eyes.isSelected()){
            isExisting = "YES";
        } else if(sno.isSelected()){
            isExisting = "NO";
        }

        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();


        //hitting external database
        try {
            //checking if user input meet all criteria
            if(pan.isEmpty()){  //if name text field is empty
                JOptionPane.showMessageDialog(null, "Please enter your pan number");
            } else if(aadhar.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter your Aadhar Number");
            } else { //if all criteria met, pass data to database
                Conn c = new Conn();
                String query = "insert into signup2 values('"+formno+"', '"+sReligion+"', '"+sCategory+"', '"+sEducation+"', '"+sIncome+"', '"+sOccupation+"', '"+isSenior+"', '"+isExisting+"', '"+pan+"', '"+aadhar+"')";
                int result = c.executeQuery(query);
                if (result > 0) {
                    System.out.println("Query executed successfully");
                } else {
                    System.out.println("Error executing query");
                }

                //if successful hit to the database, then move to next form
                setVisible(false);
                new SignUp3(formno).setVisible(true);

                c.closeConnection();
            }

        } catch (Exception e) {
            Logger.getLogger(SignUpOne.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
