package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PinChange extends JFrame implements ActionListener {

    String pin;
    JPasswordField newPin, newPin1;
    JButton change, back;

    public PinChange(String pin){
        this.pin = pin;

        setTitle("change pin");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmPic = new JLabel(i3);
        atmPic.setBounds(0, 0, 900, 900);
        add(atmPic);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 290, 400, 20);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(new Color(74, 246, 38));
        atmPic.add(text);

        JLabel pinText = new JLabel("Enter your New-Pin : ");
        pinText.setBounds(170, 340, 160, 20);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setForeground(new Color(74, 246, 38));
        atmPic.add(pinText);

        newPin = new JPasswordField();
        newPin.setBounds(370, 340, 140, 20);
        newPin.setFont(new Font("System", Font.BOLD, 16));
        newPin.setOpaque(false);
//        newPin.setContentAreaFilled(false);
//        newPin.setBorderPainted(false);
        newPin.addActionListener(this);
        newPin.setForeground(new Color(74, 246, 38));
        atmPic.add(newPin);

        JLabel repinText = new JLabel("Re-Enter your New-Pin : ");
        repinText.setBounds(170, 390, 400, 20);
        repinText.setFont(new Font("System", Font.BOLD, 16));
        repinText.setForeground(new Color(74, 246, 38));
        atmPic.add(repinText);

        newPin1 = new JPasswordField();
        newPin1.setBounds(370, 390, 140, 20);
        newPin1.setFont(new Font("System", Font.BOLD, 16));
        newPin1.setOpaque(false);
//        newPin1.setContentAreaFilled(false);
//        newPin1.setBorderPainted(false);
        newPin1.addActionListener(this);
        newPin1.setForeground(new Color(74, 246, 38));
        atmPic.add(newPin1);

        //change button
        change = new JButton("CHANGE");
        change.setBounds(382, 490, 130, 25);
        change.setFont(new Font("System", Font.BOLD, 20));
        change.setForeground(new Color(74, 246, 38));
        change.setOpaque(false);
        change.setContentAreaFilled(false);
        change.setBorderPainted(false);
        change.addActionListener(this);
        atmPic.add(change);

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
        if(ae.getSource() == change){
            String npin = String.valueOf(newPin.getPassword());
            String rpin = String.valueOf(newPin1.getPassword());

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "New-Pin Does Not Match");
            } else if (npin.equals(" ") || rpin.equals(" ")) {
                JOptionPane.showMessageDialog(null, "Please Enter a valid Pin");
            } else {
                //need to create 3 separate queries for each table and update pin value
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"'";
                String query2 = "update signup3 set pinNum = '"+rpin+"' where pinNum = '"+pin+"'";
                String query3 = "update login set pinNum = '"+rpin+"' where pinNum = '"+pin+"'";
                try{
                    Conn c = new Conn();
                    int[] results = new int[3];
                    results[0] = c.s.executeUpdate(query1);
                    results[1] = c.s.executeUpdate(query2);
                    results[2] = c.s.executeUpdate(query3);

                    for(int i=0; i<3; i++) {
                        try{
                            if (results[i] > 0) {
                                System.out.println("Query " + (i+1) + " executed successfully");
                            }
                        } catch(Exception e1){
                            System.out.println("Error executing query " + (i + 1) + ": " + e1.getMessage());
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Pin Changed Successfully \n Moving back to Transactions page.");
                    //if successful hit to the database, then move back to transaction page
                    setVisible(false);
                    System.out.println("Moved back to transactions page.");
                    new Transactions(rpin).setVisible(true);

                    c.closeConnection();
                } catch (Exception e) {
                    Logger.getLogger(SignUpOne.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {

        new PinChange("");

    }
}
