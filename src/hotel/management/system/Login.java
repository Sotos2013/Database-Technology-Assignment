/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.security.MessageDigest;

public class Login extends JFrame implements ActionListener{
  
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    Login(){
           
        super("Σύνδεση");

        setLayout(null);

        l1 = new JLabel("Όνομα Χρήστη:");
        l1.setBounds(10,20,100,30);
        add(l1);
        
        l2 = new JLabel("Κωδικός Πρόσβασης:");
        l2.setBounds(10,70,100,30);
        add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/keylogin.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(400,30,150,150);
        add(l3);


        b1 = new JButton("Σύνδεση");
        b1.setBounds(40,180,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Ακύρωση");
        b2.setBounds(180,180,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);
        
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(600,350);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Connect c1 = new Connect();
                String u = t1.getText();
                String v = t2.getText();
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(v.getBytes());
                StringBuilder hexString = new StringBuilder();
                for (byte b : hash) {
                    hexString.append(String.format("%02x", b));
                }
                String q = "select * from login where username='"+u+"' and password='"+hexString+"'";

                ResultSet rs = c1.s.executeQuery(q); 
                if(rs.next()){ 
                    new Dashboard().setVisible(true);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Λανθασμένα στοιχεία σύνδεσης!");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==b2.getAction()){
            System.exit(0);
        }
    }
    public static void main(String[] arg){
        new Login();
    }
}
