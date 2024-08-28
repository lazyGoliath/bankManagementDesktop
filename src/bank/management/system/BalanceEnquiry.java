package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pin;
    JButton back;

    public BalanceEnquiry(String pin) {

        this.pin = pin;
        System.out.println("Pin = "+pin);  //debug statement

        setTitle("BALANCE ENQUIRY");

        setUndecorated(true);  //removes any border title

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmPic = new JLabel(i3);
        atmPic.setBounds(0, 0, 900, 900);
        add(atmPic);

        JLabel text = new JLabel("Your Current Account Balance is :");
        text.setBounds(170, 350, 400, 35);
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setForeground(new Color(74, 246, 38));
        atmPic.add(text);

        //calculate balance
        System.out.println("Pin = "+pin);  //debug statement
        String query = "select * from bank where pin = '"+pin+"'";
        int balance = 0;
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);

            //find total bank balance from bank table

            while(rs.next()){
                System.out.println("Type: " + rs.getString("type"));  //debug statement
                System.out.println("Amount: " + rs.getString("amount"));  //debug statement

                if(rs.getString("type").equals("Deposit")){
                    //fetch data from bank table under amount column
                    System.out.println("Table transaction Amount = "+rs.getString("amount"));  //debug statement
                    balance += Integer.parseInt(rs.getString("amount"));
                    System.out.println("Balance (deposit): " + balance);  //debug statement
                } else if(rs.getString("type").equals("Withdraw")){
                    System.out.println("Table transaction Amount = "+rs.getString("amount"));  //debug statement
                    balance -= Integer.parseInt(rs.getString("amount"));
                    System.out.println("Balance (deposit): " + balance);  //debug statement
                }
            }

            System.out.println("Balance = "+balance);  //debug statement
        } catch (Exception e){
            Logger.getLogger(SignUpOne.class.getName()).log(Level.SEVERE, null, e);
        }

        JLabel bal = new JLabel("Rs. "+balance);
        bal.setBounds(290, 400, 400, 35);
        bal.setFont(new Font("System", Font.BOLD, 26));
        bal.setForeground(new Color(74, 246, 38));
        atmPic.add(bal);

        //back button
        back = new JButton("BACK");
        back.setBounds(250, 480, 150, 25);
        back.setFont(new Font("System", Font.BOLD, 20));
        back.setForeground(new Color(74, 246, 38));
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.addActionListener(this);
        atmPic.add(back);


        setSize(900, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args){

        new BalanceEnquiry("");
    }
}
