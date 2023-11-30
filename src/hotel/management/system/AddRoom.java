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

public class AddRoom extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t2,t4;
    private JComboBox comboBox, comboBox_2, comboBox_3;
    JButton b1,b2;

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }


    public AddRoom() {
        setBounds(450, 200, 500, 450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
       
        
        JLabel l10 = new JLabel("Προσθήκη Δωματίων");
        l10.setFont(new Font("Arial", Font.BOLD, 18));
	l10.setBounds(150, 10, 400, 22);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("No. Δωματίου:");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Arial", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	contentPane.add(l1);
        
        
        t4 = new JTextField();
	t4.setBounds(174, 70, 156, 20);
	contentPane.add(t4);
        

	JLabel l2 = new JLabel("Διαθεσιμότητα:");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Arial", Font.BOLD, 14));
	l2.setBounds(64, 110, 102, 22);
	contentPane.add(l2);
        
        comboBox = new JComboBox(new String[] { "Διαθέσιμο", "Μη Διαθέσιμο" });
	comboBox.setBounds(176, 110, 154, 20);
	contentPane.add(comboBox);


	JLabel l3 = new JLabel("Καθαρισμός:");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 150, 102, 22);
	contentPane.add(l3);
        
        comboBox_2 = new JComboBox(new String[] { "Καθαρό", "Μη Καθαρό" });
	comboBox_2.setBounds(176, 150, 154, 20);
	contentPane.add(comboBox_2);

	JLabel l4 = new JLabel("Τιμή:");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Arial", Font.BOLD, 14));
	l4.setBounds(64, 190, 102, 22);
	contentPane.add(l4);
        
        t2 = new JTextField();
	t2.setBounds(174, 190, 156, 20);
	contentPane.add(t2);

        JLabel l5 = new JLabel("Κρεβάτια:");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 230, 102, 22);
	contentPane.add(l5);


        comboBox_3 = new JComboBox(new String[] { "Μονόκλινο", "Δίκλινο"});
	comboBox_3.setBounds(176, 230, 154, 20);
	contentPane.add(comboBox_3);

	

	

	b1 = new JButton("Προσθήκη");
	b1.addActionListener(this);
	b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Πίσω");
	b2.addActionListener(this);
	b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                int room_num;
                try {
                     room_num = Integer.parseInt(t4.getText());
                      
                     } catch (Exception z) { 
                         JOptionPane.showMessageDialog(this, "Το πεδίο 'Αριθμός Δωματίου' δέχεται μόνο ακέραιες τιμές!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                         t4.setText("");
                         return;
                }
                String availability = (String)comboBox.getSelectedItem();
                String clean = (String)comboBox_2.getSelectedItem();
                int price;
                try {
                     price = Integer.parseInt(t2.getText());
                      
                     } catch (Exception z) { 
                         JOptionPane.showMessageDialog(this, "Το πεδίο 'Τιμή' δέχεται μόνο ακέραιες τιμές!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                         t2.setText("");
                         return;
                }
                String bednum = (String)comboBox_3.getSelectedItem();
                    Connection con;
                    CallableStatement cs;
                    try{
                        con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs", "iee2019187", "mydata");
                        cs = con.prepareCall("{ call Add_Room(?,?,?,?,?)}");
                        cs.setInt("RoomNum", room_num);
                        cs.setString("Availability", availability);
                        cs.setString("Clean", clean);
                        cs.setInt("Price", price);
                        cs.setString("BedNum", bednum);
                        cs.executeUpdate();
                        String s_room = Integer.toString(room_num);
                        JOptionPane.showMessageDialog(null, " Το δωμάτιο με αριθμό "+room_num+" προστέθηκε στα δωμάτια!");
                        this.setVisible(false);
                    }
                    catch(SQLIntegrityConstraintViolationException ex){
                        JOptionPane.showMessageDialog(this, "Υπάρχει ήδη καταχωρημένο δωμάτιο με τον αριθμό δωματίου που εισάγατε!","Πρόβλημα με τα στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                        t4.setText("");
                        
                    }
                
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
}
