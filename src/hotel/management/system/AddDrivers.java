/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLIntegrityConstraintViolationException;

public class AddDrivers extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4, t5, t6, t7;
    private JComboBox comboBox, comboBox_1;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }


    public AddDrivers() {
        setBounds(450, 200, 1000, 500);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        
        JLabel l10 = new JLabel("Προσθήκη νέου οδηγού");
        l10.setFont(new Font("Arial", Font.BOLD, 18));
	l10.setBounds(194, 10, 1200, 22);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("ID:");
	l1.setForeground(Color.black);
	l1.setFont(new Font("Arial", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	contentPane.add(l1);
        
        
        t1 = new JTextField();
	t1.setBounds(174, 70, 156, 20);
	contentPane.add(t1);
        

	JLabel l2 = new JLabel("Όνομα:");
	l2.setForeground(Color.black);
	l2.setFont(new Font("Arial", Font.BOLD, 14));
	l2.setBounds(64, 110, 102, 22);
	contentPane.add(l2);
        
        t2 = new JTextField();
	t2.setBounds(174, 110, 156, 20);
	contentPane.add(t2);
        
        JLabel l8 = new JLabel("Επώνυμο:");
	l8.setForeground(Color.black);
	l8.setFont(new Font("Arial", Font.BOLD, 14));
	l8.setBounds(64, 150, 102, 22);
	contentPane.add(l8);
        
        t6 = new JTextField();
	t6.setBounds(174, 150, 156, 20);
	contentPane.add(t6);
        
        JLabel l9 = new JLabel("Ηλικία:");
	l9.setForeground(Color.black);
	l9.setFont(new Font("Arial", Font.BOLD, 14));
	l9.setBounds(64, 190, 102, 22);
	contentPane.add(l9);
        
        t7 = new JTextField();
	t7.setBounds(174, 190, 156, 20);
	contentPane.add(t7);


	JLabel l3 = new JLabel("Φύλο");
	l3.setForeground(Color.black);
	l3.setFont(new Font("Arial", Font.BOLD, 14));
	l3.setBounds(64, 230, 102, 22);
	contentPane.add(l3);
        
        comboBox = new JComboBox(new String[] { "Άνδρας", "Γυναίκα" });
	comboBox.setBounds(176, 230, 154, 20);
	contentPane.add(comboBox);

	JLabel l4 = new JLabel("Αυτοκίνητο:");
	l4.setForeground(Color.BLACK);
	l4.setFont(new Font("Arial", Font.BOLD, 14));
	l4.setBounds(64, 270, 102, 22);
	contentPane.add(l4);
        
        t3 = new JTextField();
	t3.setBounds(174, 270, 156, 20);
	contentPane.add(t3);


	
        JLabel l6 = new JLabel("Διαθεσιμότητα:");
	l6.setForeground(Color.BLACK);
	l6.setFont(new Font("Arial", Font.BOLD, 14));
	l6.setBounds(64, 310, 102, 22);
	contentPane.add(l6);
        
        comboBox_1 = new JComboBox(new String[] { "Διαθέσιμος/η", "Μη Διαθέσιμος/η" });
        comboBox_1.setBounds(176, 310, 154, 20);
        contentPane.add(comboBox_1);

	b1 = new JButton("Προσθήκη");
	b1.addActionListener(this);
	b1.setBounds(64, 380, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Πίσω");
	b2.addActionListener(this);
	b2.setBounds(198, 380, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                //Connect c = new Connect();
                int id;
                try {
                     id = Integer.parseInt(t1.getText());
                      
                     } catch (Exception z) { 
                         JOptionPane.showMessageDialog(this, "Το πεδίο 'ID' δέχεται μόνο ακέραιες τιμές!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                         t1.setText("");
                         return;
                }
                String name = t2.getText();
                String surname = t6.getText();
                int age;
                try {
                     age = Integer.parseInt(t7.getText());
                      
                     } catch (Exception z) { 
                         JOptionPane.showMessageDialog(this, "Το πεδίο 'Ηλικία' δέχεται μόνο ακέραιες τιμές!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                         t7.setText("");
                         return;
                }
                String gender = (String)comboBox.getSelectedItem();
                String car  = t3.getText();
                String availability = (String)comboBox_1.getSelectedItem();
                
                if(name.equals("")){
                    JOptionPane.showMessageDialog(this, "Το πεδίο 'Όνομα' δεν μπορεί να μείνει κενό!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                }
                else if(car.equals("")){
                    JOptionPane.showMessageDialog(this, "Το πεδίο 'Αυτοκίνητο' δεν μπορεί να μείνει κενό!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                }
                else if(surname.equals("")){
                    JOptionPane.showMessageDialog(this, "Το πεδίο 'Επώνυμο' δεν μπορεί να μείνει κενό!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Connection con;
                    CallableStatement cs;
                    try{
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
                        cs = con.prepareCall("{ call Add_Driver(?,?,?,?,?,?,?)}");
                        cs.setInt("Id", id);
                        cs.setString("Name", name);
                        cs.setString("Surname", surname);
                        cs.setInt("Age", age);
                        cs.setString("Sex", gender);
                        cs.setString("Car", car);
                        cs.setString("Availability", availability);
                        cs.executeUpdate();
                        if(comboBox.getSelectedItem().equals("Άνδρας")){
                            JOptionPane.showMessageDialog(null, "Ο "+name+" προστέθηκε στους οδηγούς!");
                            this.setVisible(false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Η "+name+" προστέθηκε στους οδηγούς!");
                            this.setVisible(false);
                        }
                    }
                    catch(SQLIntegrityConstraintViolationException ex){
                        JOptionPane.showMessageDialog(this, "Υπάρχει ήδη καταχωρημένος οδηγός με το ID που εισάγατε!","Πρόβλημα με τα στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                        t1.setText("");
                        
                    }
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
