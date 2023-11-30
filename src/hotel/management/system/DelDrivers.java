/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class DelDrivers extends JFrame{
	private JPanel contentPane;
        private JButton btnCheckOut, btnExit;
        private JComboBox combobox;
        private JLabel lblDelEmployee, lblID;
        
        

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelDrivers frame = new DelDrivers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	public DelDrivers() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 400, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                setLocationRelativeTo(null);
                setResizable(false);
		
                
            
		
		lblDelEmployee = new JLabel("Διαγραφή Οδηγού ");
		lblDelEmployee.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDelEmployee.setBounds(110, 11, 200, 35);
		contentPane.add(lblDelEmployee);
		
		lblID = new JLabel("ID:");
		lblID.setBounds(20, 85, 80, 14);
		contentPane.add(lblID);
                
                combobox = new JComboBox();
                Connection con;
                CallableStatement cs;
                try{
                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                    cs = con.prepareCall("{ call GETDRIVER(?)}");
                    cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                    cs.executeQuery();
                    ResultSet rs = (ResultSet) cs.getObject(1);
                    while(rs.next()){
                        combobox.addItem(rs.getString(1));
                    }
                }catch(Exception e){ }
                combobox.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnCheckOut.setEnabled(true);
                    }
                
                });
                combobox.setBounds(130, 82, 150, 20);
		contentPane.add(combobox);
                
		btnCheckOut = new JButton("Διαγραφή");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Connection c;
                            CallableStatement s;
                                int id_num = Integer.parseInt((String) combobox.getSelectedItem());
                                
                                try{
                                    c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs", "iee2019187", "mydata");                        
                                    s = c.prepareCall("{ call DEL_DRIVER(?)}");
                                    s.setInt(1, id_num);
                                    s.executeQuery();
                                    JOptionPane.showMessageDialog(null, "Ο οδηγός με ID "+id_num+" διαγράγηκε επιτυχώς!");
                                    setVisible(false);
                                }catch(SQLException e1){
                                    System.out.println(e1.getMessage());
                                }
			}
		});
		btnCheckOut.setBounds(50, 200, 100, 25);
                btnCheckOut.setEnabled(false);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);
		
		btnExit = new JButton("Πίσω");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                setVisible(false);
			}
		});
		btnExit.setBounds(160, 200, 100, 25);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                
                getContentPane().setBackground(Color.WHITE);
	}

}
