/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class NewCustomer extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,t8;
        JComboBox comboBox,comboBox2;
        JComboBox c1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer frame = new NewCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewCustomer() throws SQLException {
		
                setBounds(530, 200, 550, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                   setLocationRelativeTo(null);
        setResizable(false);
              
		
		JLabel lblName = new JLabel("Καταχώρηση νέου πελάτη");
		lblName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);
                
                //1
                
                JLabel lblId = new JLabel("Έγγραφο Ταυτοποίησης :");
		lblId.setBounds(35, 76, 200, 14);
		contentPane.add(lblId);
                
                comboBox = new JComboBox(new String[] {"Ταυτότητα", "Δίπλωμα οδήγησης", "Διαβατήριο"});
		comboBox.setBounds(271, 73, 150, 20);
		contentPane.add(comboBox);
                
                //2
                
                JLabel l2 = new JLabel("Αριθμός Εγγράφου :");
		l2.setBounds(35, 111, 200, 14);
		contentPane.add(l2);
                
                t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
                
                //3
		
		JLabel lblName_1 = new JLabel("Όνομα :");
		lblName_1.setBounds(35, 151, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);
                
                //4
                
                JLabel lblName_2 = new JLabel("Επώνυμο :");
		lblName_2.setBounds(35, 191, 200, 14);
		contentPane.add(lblName_2);
		
		t8 = new JTextField();
		t8.setBounds(271, 191, 150, 20);
		contentPane.add(t8);
		t8.setColumns(10);

                //5
                
		JLabel lblGender = new JLabel("Φύλο :");
		lblGender.setBounds(35, 231, 200, 14);
		contentPane.add(lblGender);
                
                //G1 = new ButtonGroup();
                
                comboBox2 = new JComboBox(new String[] { "Άνδρας", "Γυναίκα" });
                comboBox2.setBackground(Color.WHITE);
                comboBox2.setBounds(271, 231, 150, 20);
                add(comboBox2);
                
                //6
                
		JLabel lblCountry = new JLabel("Χώρα διαμονής :");
		lblCountry.setBounds(35, 271, 200, 14);
		contentPane.add(lblCountry);
                t3 = new JTextField();
		t3.setBounds(271, 271, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
                
                
                //7
                
		JLabel lblReserveRoomNumber = new JLabel("Αριθμός Δωματίου :");
		lblReserveRoomNumber.setBounds(35, 314, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                c1 = new JComboBox();
                int Totalpay;
                try{
                    Connect c = new Connect();
                    ResultSet rs = c.s.executeQuery("select * from room where Διαθεσιμότητα = 'Διαθέσιμο'");
                    while(rs.next()){
                        c1.addItem(rs.getString(1));    
                    }
                }catch(Exception e){ }
                c1.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    try{
                        int totalpay;
                        Connect c = new Connect();
                        ResultSet rs = c.s.executeQuery("select Τιμή from room WHERE room.Αριθμός_δωματίου = '"+(String)c1.getSelectedItem()+"'");
                        while(rs.next()){
                            int price = Integer.parseInt(rs.getString(1));
                            int days = Integer.parseInt(t5.getText());
                            totalpay = price*days;
                            String tPay = String.valueOf(totalpay);
                            t6.setText(tPay);
                        }
                    }catch(Exception ee){ }
                    }
                
                });
                c1.setBounds(271, 314, 150, 20);
		contentPane.add(c1);
		
                //8
		JLabel lblCheckInStatus = new JLabel("Ημέρες Διαμονής :");
		lblCheckInStatus.setBounds(35, 356, 200, 14);
		contentPane.add(lblCheckInStatus);
		t5 = new JTextField();
		t5.setBounds(271, 356, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);
                
                //9
		JLabel lblDeposite = new JLabel("Ποσο Πληρωμής :");
		lblDeposite.setBounds(35, 399, 200, 14);
		contentPane.add(lblDeposite);
		t6 = new JTextField();
		t6.setBounds(271, 399, 150, 20);
		contentPane.add(t6);
		t6.setColumns(10);
                t6.setEnabled(false);
		

		JButton btnNewButton = new JButton("Προσθήκη");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try{
                                String id = (String)comboBox.getSelectedItem(); 
                                    String id_num =  t1.getText();
                                    String name =  t2.getText();
                                    String surname = t8.getText();
                                    String sex =  (String)comboBox2.getSelectedItem();
                                    String country =  t3.getText();
                                    String room_num = (String) c1.getSelectedItem();
                                    int days =  Integer.parseInt(t5.getText());
                                    int pay = Integer.parseInt(t6.getText());
	    			if(id_num.equals("")){
                                    JOptionPane.showMessageDialog(null, "Το πεδίο 'Αριθμός Εγγράφου' δεν μπορεί να μείνει κενό!",
                                    "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                                }
                                else if(name.equals("")){
                                    JOptionPane.showMessageDialog(null, "Το πεδίο 'Όνομα' δεν μπορεί να μείνει κενό!",
                                    "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                                }
                                else if(surname.equals("")){
                                    JOptionPane.showMessageDialog(null, "Το πεδίο 'Επώνυμο' δεν μπορεί να μείνει κενό!",
                                    "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                                }
                                else if(country.equals("")){
                                    JOptionPane.showMessageDialog(null, "Το πεδίο 'Χώρα' δεν μπορεί να μείνει κενό!",
                                    "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                                }
                                else{
                                    Connection con;
                                    CallableStatement cs;
                                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs", "iee2019187", "mydata");
                                    cs = con.prepareCall("{ call Add_Customer(?,?,?,?,?,?,?,?,?)}");
                                    cs.setString(1, id);
                                    cs.setString(2, id_num);
                                    cs.setString(3, name);
                                    cs.setString(4, surname);
                                    cs.setString(5, sex);
                                    cs.setString(6, country);
                                    cs.setString(7, room_num);
                                    cs.setInt(8, days);
                                    cs.setInt(9, pay);
                                    cs.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                                    new Reception().setVisible(true);
                                    setVisible(false);
                                }
	    		}catch(SQLException e1){
	    			JOptionPane.showMessageDialog(null, "Υπάρχει ήδη καταχωρημένος πελάτης με τον αριθμό εγγράφου που εισάγατε!","Πρόβλημα με τα στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                                t1.setText("");
	    		}
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Πίσω");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new Reception().setVisible(true);
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}