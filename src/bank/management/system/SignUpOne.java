package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame {

    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;

    public SignUpOne(){
        setTitle("New User Sign Up");

        setLayout(null);

        //generating a random form number
        Random ran = new Random();
        long randomNum = Math.abs((ran.nextLong() % 9000L) + 1000L);

        System.out.println(randomNum);

        //form number
        JLabel formNum = new JLabel("APPLICATION NUMBER: "+randomNum);
        formNum.setBounds(140,20,600,40);
        formNum.setFont(new Font("Raleway",Font.BOLD,38));
        add(formNum);

        //page header
        JLabel header = new JLabel("Page 1: PERSONAL DETAILS");
        header.setBounds(260,80,400,30);
        header.setFont(new Font("Raleway",Font.BOLD,22));
        add(header);

        //name
        JLabel name = new JLabel("Name:");
        name.setBounds(100,140,150,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300,140,400,30);
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(nameTextField);

        //father's name
        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(100,190,150,30);
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300,190,400,30);
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(fnameTextField);

        //date of birth
        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setBounds(100,240,150,30);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setFont(new Font("Arial",Font.BOLD,14));
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        //gender
        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(100,290,150,30);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        add(gender);

        //add male radio button
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(300,290,80,30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Raleway",Font.BOLD,16));
        add(male);

        //add female radio button
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Raleway",Font.BOLD,16));
        add(female);

        //group radio buttons together do only 1 can be selected at a time
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        //email
        JLabel email = new JLabel("Email: ");
        email.setBounds(100,340,150,30);
        email.setFont(new Font("Raleway",Font.BOLD,20));
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(300,340,400,30);
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(emailTextField);

        //marital status
        JLabel isMarried = new JLabel("Marital Status: ");
        isMarried.setBounds(100,390,150,30);
        isMarried.setFont(new Font("Raleway",Font.BOLD,20));
        add(isMarried);

        JRadioButton married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        married.setFont(new Font("Arial",Font.BOLD,16));
        add(married);

        JRadioButton notMarried = new JRadioButton("Not Married");
        notMarried.setBounds(430,390,120,30);
        notMarried.setBackground(Color.WHITE);
        notMarried.setFont(new Font("Arial",Font.BOLD,16));
        add(notMarried);

        JRadioButton other = new JRadioButton("Other");
        other.setBounds(580,390,80,30);
        other.setBackground(Color.WHITE);
        other.setFont(new Font("Raleway",Font.BOLD,16));
        add(other);

        ButtonGroup group = new ButtonGroup();
        group.add(married);
        group.add(notMarried);
        group.add(other);

        //address
        JLabel address = new JLabel("Address: ");
        address.setBounds(100,440,150,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(300,440,400,30);
        addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(addressTextField);

        //city
        JLabel city = new JLabel("City: ");
        city.setBounds(100,490,150,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(300,490,400,30);
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(cityTextField);

        //state
        JLabel state = new JLabel("State: ");
        state.setBounds(100,540,150,30);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300,540,400,30);
        stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(stateTextField);

        //pincode
        JLabel pincode = new JLabel("Pin Code: ");
        pincode.setBounds(100,590,150,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300,590,400,30);
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(pincodeTextField);

        setSize(850,800);
        setVisible(true);
        setLocation(500,100);
        getContentPane().setBackground(Color.WHITE);

        JButton next = new JButton("Next");
        next.setBounds(360, 700, 150, 30);
        next.setBackground(Color.GREEN);
        next.setFont(new Font("Arial",Font.PLAIN,28));
        next.setForeground(Color.WHITE);
        add(next);
    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}
