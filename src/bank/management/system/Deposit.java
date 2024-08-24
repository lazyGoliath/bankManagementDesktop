package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    String pin;

    public Deposit(String pin){

        this.pin = pin;

        setTitle("Deposit");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmPic = new JLabel(i3);
        atmPic.setBounds(0, 0, 900, 900);
        add(atmPic);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(170, 300, 400, 20);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(new Color(74, 246, 38));
        atmPic.add(text);

        //amount text field
        amount = new JTextField();
        amount.setBounds(200, 345, 250, 20);
        amount.setFont(new Font("System", Font.BOLD, 16));
        amount.setForeground(Color.BLACK);
        amount.setBackground(Color.GRAY);
        atmPic.add(amount);

        //deposit button
        deposit = new JButton("Deposit");
        deposit.setBounds(382, 490, 130, 25);
        deposit.setFont(new Font("System", Font.BOLD, 20));
        deposit.setForeground(new Color(74, 246, 38));
        deposit.setOpaque(false);
        deposit.setContentAreaFilled(false);
        deposit.setBorderPainted(false);
        deposit.addActionListener(this);
        atmPic.add(deposit);

        //back button
        back = new JButton("Go Back");
        back.setBounds(383, 525, 130, 25);
        back.setFont(new Font("System", Font.BOLD, 20));
        back.setForeground(new Color(74, 246, 38));
        back.setOpaque(false);
        back.setContentAreaFilled(false);

        back.setBorderPainted(false);
        back.addActionListener(this);
        atmPic.add(back);

        setSize(900,900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(" ")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else{
                try{
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pin+"','"+date+"','Deposit', '"+number+"')";
                    int result = c.executeQuery(query);
                    if (result > 0) {
                        System.out.println("Query executed successfully");
                    } else {
                        System.out.println("Error executing query");
                    }

                    JOptionPane.showMessageDialog(null, "Deposited Rs "+number+" Successfully \n Moving back to Transactions page.");
                    //if successful hit to the database, then move back to transaction page
                    setVisible(false);
                    System.out.println("Moved back to transactions page.");
                    new Transactions(pin).setVisible(true);

                    c.closeConnection();
                } catch (Exception e) {
                    Logger.getLogger(SignUpOne.class.getName()).log(Level.SEVERE, null, e);
                }

            }
        } else if(ae.getSource() == back){
            System.out.println("Go Back to Transactions Page");
            setVisible(false);
            new Transactions("").setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
