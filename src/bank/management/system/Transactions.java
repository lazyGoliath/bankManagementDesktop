package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    String pin;
    JButton deposit, withdraw, fastcash, pinCh, enquiry, miniSt, exit;

    public Transactions(String pin) {

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

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(220, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(new Color(74, 246, 38));
        atmPic.add(text);

        //deposit button
        deposit = new JButton("Deposit");
        deposit.setBounds(142, 420, 140, 25);
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
        withdraw = new JButton("Withdrawal");
        withdraw.setBounds(130, 455, 140, 25);
        withdraw.setFont(new Font("System", Font.BOLD, 16));
        withdraw.setForeground(new Color(74, 246, 38));
        withdraw.setOpaque(false);
        withdraw.setContentAreaFilled(false);
        withdraw.setBorderPainted(false);
        withdraw.addActionListener(this);
        atmPic.add(withdraw);

        //fast cash button
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(132, 492, 140, 25);
        fastcash.setFont(new Font("System", Font.BOLD, 16));
        fastcash.setForeground(new Color(74, 246, 38));
        fastcash.setOpaque(false);
        fastcash.setContentAreaFilled(false);
        fastcash.setBorderPainted(false);
        fastcash.addActionListener(this);
        atmPic.add(fastcash);

        //pin change button
        pinCh = new JButton("Change Pin");
        pinCh.setBounds(352, 420, 160, 25);
        pinCh.setFont(new Font("System", Font.BOLD, 16));
        pinCh.setForeground(new Color(74, 246, 38));
        pinCh.setOpaque(false);
        pinCh.setContentAreaFilled(false);
        pinCh.setBorderPainted(false);
        pinCh.addActionListener(this);
        atmPic.add(pinCh);

        //balance enquiry button
        enquiry = new JButton("Balance Enquiry");
        enquiry.setBounds(370, 455, 160, 25);
        enquiry.setFont(new Font("System", Font.BOLD, 16));
        enquiry.setForeground(new Color(74, 246, 38));
        enquiry.setOpaque(false);
        enquiry.setContentAreaFilled(false);
        enquiry.setBorderPainted(false);
        enquiry.addActionListener(this);
        atmPic.add(enquiry);

        //mini statement button
        miniSt = new JButton("Ministatement");
        miniSt.setBounds(367, 492, 150, 25);
        miniSt.setFont(new Font("System", Font.BOLD, 16));
        miniSt.setForeground(new Color(74, 246, 38));
        miniSt.setOpaque(false);
        miniSt.setContentAreaFilled(false);
        miniSt.setBorderPainted(false);
        miniSt.addActionListener(this);
        atmPic.add(miniSt);

        //exit button
        exit = new JButton("EXIT");
        exit.setBounds(240, 520, 150, 25);
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
        if(ae.getSource() == deposit) {
            System.out.println("Go to Deposit Page"); //debug statement
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            System.out.println("Go to Withdrawal Page");  //debug statement
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            System.out.println("Go to Fast Cash Page");  //debug statement
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == pinCh) {
            System.out.println("Go to Change Pin Page");  //debug statement
            setVisible(false);
            new PinChange(pin).setVisible(true);
        } else if (ae.getSource() == enquiry) {
            System.out.println("Go to Enquiry Page");  //debug statement
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new Transactions("");
    }
}
