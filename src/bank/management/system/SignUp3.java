package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUp3 extends JFrame implements ActionListener {

    String formno;
    JRadioButton r1,r2,r3,r4;  //type
    JCheckBox c1,c2,c3,c4,c5,c6,c7;  //services
    JButton submit, cancel;
    public SignUp3(String formno){

        this.formno = formno;

        setTitle("NEW USER APPLICATION FORM - PAGE 3");

        setLayout(null);

        //page head title
        JLabel header = new JLabel("Page 3 : Account Details");
        header.setFont(new Font("Raleway", Font.BOLD, 28));
        header.setForeground(Color.BLACK);
        header.setBounds(270, 40, 400, 40);
        add(header);

        //account type
        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setForeground(Color.BLACK);
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 20));
        r1.setBackground(Color.WHITE);
        r1.setBounds(110, 180, 200, 20);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 20));
        r2.setBackground(Color.WHITE);
        r2.setBounds(110, 220, 200, 20);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 20));
        r3.setBackground(Color.WHITE);
        r3.setBounds(350, 180, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 20));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 300, 20);
        add(r4);

        //card number
        JLabel cardNum = new JLabel("Card Number :");
        cardNum.setFont(new Font("Raleway", Font.BOLD, 24));
        cardNum.setForeground(Color.BLACK);
        cardNum.setBounds(100, 280, 200, 30);
        add(cardNum);

        JLabel cardAnnotation = new JLabel("Your 16 Digit Card Number");
        cardAnnotation.setFont(new Font("Raleway", Font.BOLD, 12));
        cardAnnotation.setForeground(Color.BLACK);
        cardAnnotation.setBounds(100, 305, 200, 30);
        add(cardAnnotation);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4136");
        number.setFont(new Font("Arial", Font.BOLD, 26));
        number.setForeground(Color.BLACK);
        number.setBounds(330, 285, 350, 30);
        add(number);

        //pin number
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        pin.setForeground(Color.BLACK);
        pin.setBounds(100, 360, 200, 30);
        add(pin);

        JLabel pinNum = new JLabel("XXXXXX");
        pinNum.setFont(new Font("Raleway", Font.BOLD, 24));
        pinNum.setForeground(Color.BLACK);
        pinNum.setBounds(330, 360, 350, 30);
        add(pinNum);

        JLabel pinAnnotation = new JLabel("Your 6 Digit Pin Number");
        pinAnnotation.setFont(new Font("Raleway", Font.BOLD, 12));
        pinAnnotation.setForeground(Color.BLACK);
        pinAnnotation.setBounds(100, 380, 200, 30);
        add(pinAnnotation);

        //services required
        JLabel service = new JLabel("Services Required :");
        service.setFont(new Font("Raleway", Font.BOLD, 24));
        service.setForeground(Color.BLACK);
        service.setBounds(100, 430, 250, 30);
        add(service);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 20));
        c1.setBackground(Color.WHITE);
        c1.setBounds(150, 480, 250, 20);
        add(c1);

        c2 = new JCheckBox("MOBILE BANKING");
        c2.setFont(new Font("Raleway", Font.BOLD, 20));
        c2.setBackground(Color.WHITE);
        c2.setBounds(150, 520, 250, 20);
        add(c2);

        c3 = new JCheckBox("CHEQUE BOOK");
        c3.setFont(new Font("Raleway", Font.BOLD, 20));
        c3.setBackground(Color.WHITE);
        c3.setBounds(150, 560, 250, 20);
        add(c3);

        c4 = new JCheckBox("INTERNET BANKING");
        c4.setFont(new Font("Raleway", Font.BOLD, 20));
        c4.setBackground(Color.WHITE);
        c4.setBounds(420, 480, 250, 20);
        add(c4);

        c5 = new JCheckBox("EMAIL & SMS ALERTS");
        c5.setFont(new Font("Raleway", Font.BOLD, 20));
        c5.setBackground(Color.WHITE);
        c5.setBounds(420, 520, 250, 20);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setFont(new Font("Raleway", Font.BOLD, 20));
        c6.setBackground(Color.WHITE);
        c6.setBounds(420, 560, 250, 20);
        add(c6);

        //footer rights checkbox
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD, 15));
        c7.setBackground(Color.WHITE);
        c7.setBounds(70, 660, 650, 20);
        add(c7);

        //submit button
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Raleway", Font.BOLD, 20));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 700, 150, 30);
        submit.addActionListener(this);
        add(submit);

        //cancel button
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Raleway", Font.BOLD, 20));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(405, 700, 150, 30);
        add(cancel);

        setSize(850,800);
        setLocation(500,100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            String type = null;
            if (r1.isSelected()) {
                type = "Savings Account";
            } else if (r2.isSelected()) {
                type = "Current Account";
            } else if (r3.isSelected()) {
                type = "Fixed Deposit Account";
            } else if (r4.isSelected()) {
                type = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNum = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinNum = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = " ";
            if (c1.isSelected()) {
                facility += "ATM CARD ";
            } else if (c2.isSelected()) {
                facility += "MOBILE BANKING ";
            } else if (c3.isSelected()) {
                facility += "CHEQUE BOOK ";
            } else if (c4.isSelected()) {
                facility += "INTERNET BANKING ";
            } else if (c5.isSelected()) {
                facility += "EMAIL & SMS ALERTS ";
            } else if (c6.isSelected()) {
                facility += "E-STATEMENT ";
            }

            //hitting an external database
            try {
                //checking if user input meets all criteria
                if (!c7.isSelected()) {  //if name text field is empty
                    JOptionPane.showMessageDialog(null, "Please accept terms and conditions before proceeding.");
                } else if (type == null) {
                    JOptionPane.showMessageDialog(null, "Please select type of account");
                } else if (facility.equals(" ")) {
                    JOptionPane.showMessageDialog(null, "Please select type of service you want");
                } else { //if all criteria met, pass data to a database
                    Conn c = new Conn();
                    //dml command
                    String query1 = "insert into signup3 values('" + type + "', '" + cardNum + "', '" + pinNum + "', '" + facility + "', '" + formno + "')";
                    String query2 = "insert into login values('"+ cardNum + "', '" + pinNum + "', '" + formno + "')";

                    int result1 = c.executeQuery(query1);
                    int result2 = c.executeQuery(query2);
                    if (result1 > 0 && result2 > 0) {
                        System.out.println("Query executed successfully");
                    } else {
                        System.out.println("Error executing query");
                    }

                    JOptionPane.showMessageDialog(null, "Account Created Successfully!!\n Card Number "+
                            cardNum+"\n Pin Number "+pinNum+"\n Moving you to Transactions Page.");
                    c.closeConnection();

                    new Transactions(pinNum).setVisible(true);
                }
            } catch (Exception e) {
                Logger.getLogger(SignUpOne.class.getName()).log(Level.SEVERE, null, e);
            }
        } else if(ae.getSource() == cancel){
            setVisible(false);
            new login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUp3("");
    }
}
