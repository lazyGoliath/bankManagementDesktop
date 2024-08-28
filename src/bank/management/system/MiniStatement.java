package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiniStatement extends JFrame implements ActionListener {

    String pin;
    JButton close;

    public MiniStatement(String pin) {

        this.pin = pin;
        System.out.println("Pin = "+pin);  //debug statement

        setTitle("Mini Statement");

        setLayout(null);

        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("Serif", Font.BOLD, 20));
        bank.setForeground(Color.BLACK);
        bank.setHorizontalAlignment(SwingConstants.CENTER);
        bank.setBounds(130, 20, 120, 20);
        add(bank);

        //display card number
        JLabel card = new JLabel();
        card.setFont(new Font("Serif", Font.BOLD, 20));
        card.setForeground(Color.BLACK);
        card.setBounds(20, 100, 400, 20);

        //printing card details
        //String mypin = "151515";
        try{
            String query = "select * from login where pinNum = '"+pin+"'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                String str = "XXXXXXXXXXXX"+rs.getString("cardNum").substring(12);
                System.out.println("CardNum = "+str);  //debug print
                card.setText("Card Number : "+str);
                add(card);
            }
        } catch (Exception e){
            Logger.getLogger(SignUpOne.class.getName()).log(Level.SEVERE, null, e);
        }

        JLabel text = new JLabel("TRANSACTIONS LIST : ");
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.BLACK);
        text.setBounds(30, 150, 200, 30);
        add(text);

        JLabel mini = new JLabel();
        mini.setFont(new Font("Raleway", Font.BOLD, 12));
        mini.setBounds(20,200, 400, 200);
        add(mini);

        JLabel bal = new JLabel();
        bal.setBounds(20, 450, 300, 30);
        bal.setFont(new Font("Raleway", Font.BOLD, 16));
        add(bal);

        //printing bank transaction table and calculating balance
        try{
            String query = "select * from bank where pin = '"+pin+"'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            String html = "";
            int balance = 0;
            while(rs.next()){
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");
                System.out.println(date+"\t"+type+"\t\t"+amount);  //debug
//                String html = String.format("<html>%s &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; %s &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; %s <br><br></html>",
//                        date, type, amount);
                html += String.format("<html>%s &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; %s &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; %s<br><br>",
                        date, type, amount);

                //calculating balance
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
            html += "</html>";
            System.out.println(html);  //debug
            mini.setText(html);
            bal.setText("Your current account balance is : "+balance);

        } catch (Exception e){
            Logger.getLogger(SignUpOne.class.getName()).log(Level.SEVERE, null, e);
        }

        close = new JButton("Close");
        close.setFont(new Font("Raleway", Font.BOLD, 20));
        close.setForeground(Color.BLACK);
        close.setBackground(Color.RED);
        close.setBounds(150, 520, 100, 30);
        close.addActionListener(this);
        add(close);


        setSize(400,600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == close){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
