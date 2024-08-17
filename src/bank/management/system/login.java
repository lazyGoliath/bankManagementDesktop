package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   //interface to add actions to buttons

public class login extends JFrame implements ActionListener {

    //globally define constructor buttons
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    public login(){
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);  //disable JFrame default layout of centre aligning objects

        //adds big raw icon image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));

        //image object of ImageIcon object i1 fot resizing and customizing the image
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        //converting modified image object i2 back to imageIcon object
        ImageIcon i3 = new ImageIcon(i2);

        //to add content on JFrame
        JLabel image = new JLabel(i3);

        image.setBounds(70, 10, 100, 100);  //set up a custom layout
        add(image);  //inserts image object on frame

        //making another label for welcome text
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);

        //making another label for card number
        JLabel cardno = new JLabel("Card No:");
        cardno.setBounds(120, 150, 150, 30);
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardno);

        //adding input box for the same
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(cardTextField);

        //making another label for pin number
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(120, 220, 250, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(pinTextField);

        //add a sign in button
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);  //set button background color
        login.setForeground(Color.WHITE);  //set font color
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);  //set but`ton background color
        clear.setForeground(Color.WHITE);  //set font color
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.GREEN);  //set but`ton background color
        signup.setForeground(Color.WHITE);  //set font color
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);  //set background color white


        setSize(800, 480);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    //@Important
    //added to override actionPerformed() abstract method defined in ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if(e.getSource() == signup){

        } else if(e.getSource() == login){

        }
    }

    public static void main(String[] args) {
        new login();
    }
}
