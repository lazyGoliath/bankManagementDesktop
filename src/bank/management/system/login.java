package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class login extends JFrame {

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
        JTextField cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        add(cardTextField);

        //making another label for pin number
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(120, 220, 250, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        add(pin);

        JTextField pinTextField = new JTextField();
        pinTextField.setBounds(300, 220, 250, 30);
        add(pinTextField);

        getContentPane().setBackground(Color.WHITE);  //set background color white


        setSize(800, 480);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new login();
    }
}
