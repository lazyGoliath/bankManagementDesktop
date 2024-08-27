package bank.management.system;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FastCash extends JFrame implements ActionListener {

    String pin;
    JButton deposit, withdraw, fastcash, pinCh, enquiry, miniSt, exit;

    public FastCash(String pin) {

        this.pin = pin;
        System.out.println("Pin = "+pin);  //debug statement

        setTitle("Transactions");

        setUndecorated(true);  //removes any border title

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmPic = new JLabel(i3);
        atmPic.setBounds(0, 0, 900, 900);
        add(atmPic);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(220, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(new Color(74, 246, 38));
        atmPic.add(text);

        //deposit button
        deposit = new JButton("Rs. 100");
        deposit.setBounds(140, 420, 140, 25);
        deposit.setFont(new Font("System", Font.BOLD, 16));
        deposit.setForeground(new Color(74, 246, 38));

        //deposit.setBackground(Color.BLACK);
        //make button transparent
        deposit.setOpaque(false);
        deposit.setContentAreaFilled(false);
        deposit.setBorderPainted(false);

        deposit.addActionListener(this);
        atmPic.add(deposit);

        //withdrawal button
        withdraw = new JButton("Rs. 500");
        withdraw.setBounds(140, 455, 140, 25);
        withdraw.setFont(new Font("System", Font.BOLD, 16));
        withdraw.setForeground(new Color(74, 246, 38));
        withdraw.setOpaque(false);
        withdraw.setContentAreaFilled(false);
        withdraw.setBorderPainted(false);
        withdraw.addActionListener(this);
        atmPic.add(withdraw);

        //fast cash button
        fastcash = new JButton("Rs. 1,000");
        fastcash.setBounds(132, 492, 140, 25);
        fastcash.setFont(new Font("System", Font.BOLD, 16));
        fastcash.setForeground(new Color(74, 246, 38));
        fastcash.setOpaque(false);
        fastcash.setContentAreaFilled(false);
        fastcash.setBorderPainted(false);
        fastcash.addActionListener(this);
        atmPic.add(fastcash);

        //pin change button
        pinCh = new JButton("Rs. 2,000");
        pinCh.setBounds(380, 420, 160, 25);
        pinCh.setFont(new Font("System", Font.BOLD, 16));
        pinCh.setForeground(new Color(74, 246, 38));
        pinCh.setOpaque(false);
        pinCh.setContentAreaFilled(false);
        pinCh.setBorderPainted(false);
        pinCh.addActionListener(this);
        atmPic.add(pinCh);

        //balance enquiry button
        enquiry = new JButton("Rs. 5,000");
        enquiry.setBounds(380, 455, 160, 25);
        enquiry.setFont(new Font("System", Font.BOLD, 16));
        enquiry.setForeground(new Color(74, 246, 38));
        enquiry.setOpaque(false);
        enquiry.setContentAreaFilled(false);
        enquiry.setBorderPainted(false);
        enquiry.addActionListener(this);
        atmPic.add(enquiry);

        //mini statement button
        miniSt = new JButton("Rs. 10,000");
        miniSt.setBounds(390, 492, 150, 25);
        miniSt.setFont(new Font("System", Font.BOLD, 16));
        miniSt.setForeground(new Color(74, 246, 38));
        miniSt.setOpaque(false);
        miniSt.setContentAreaFilled(false);
        miniSt.setBorderPainted(false);
        miniSt.addActionListener(this);
        atmPic.add(miniSt);

        //exit button
        exit = new JButton("BACK");
        exit.setBounds(255, 520, 150, 25);
        exit.setFont(new Font("System", Font.BOLD, 20));
        exit.setForeground(new Color(74, 246, 38));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.addActionListener(this);
        atmPic.add(exit);


        setSize(900, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText();  //Rs. 1,000
            System.out.println("Amount = "+amount);  //debug statement
            amount = amount.substring(4);  //1,000
            amount = amount.replace(",","");  //1000

            System.out.println("Fine tuned Amount = "+amount);  //debug statement
            String query = "select * from bank where pin = '"+pin+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                //find total bank balance from bank table
                int balance = 0;
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
                System.out.println("Withdraw amount = "+Integer.parseInt(amount));  //debug statement

                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }

                //add current withdrawal transaction to the records
                Date date = new Date();
                String query1 = "insert into bank values('"+pin+"','"+date+"','Withdraw', '"+amount+"')";

                int result = c.executeQuery(query1);
                if (result > 0) {
                    System.out.println("Query executed successfully");
                } else {
                    System.out.println("Error executing query");
                }

                JOptionPane.showMessageDialog(null, "Withdrawn Rs "+amount+" Successfully \nMoving back to Transactions page.");
                //if successful hit to the database, then move back to transaction page
                setVisible(false);
                System.out.println("Moved back to transactions page.");
                new Transactions(pin).setVisible(true);

                c.closeConnection();
            } catch (Exception e){
                Logger.getLogger(SignUpOne.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public static void main(String[] args) {

        new FastCash("");
    }
}
