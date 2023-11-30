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

public class DelEmployee extends JFrame{
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1;
        private JButton btnCheckOut;
        Choice c1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelEmployee frame = new DelEmployee();
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

	public DelEmployee() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 400, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                setLocationRelativeTo(null);
                setResizable(false);
		
                
            
		
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCheckOut.setBounds(110, 11, 140, 35);
		contentPane.add(lblCheckOut);
		
		JLabel lblName = new JLabel("Αριθμός:");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);
                
                JComboBox combobox = new JComboBox();
                Connection con;
                CallableStatement cs;
                try{
                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                    cs = con.prepareCall("{ call GETEMPLOYEE(?)}");
                    cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                    cs.executeQuery();
                    ResultSet rs = (ResultSet) cs.getObject(1);
                    while(rs.next()){
                        combobox.addItem(rs.getString(1));
                    }
                }catch(Exception e){ }
                combobox.setBounds(130, 82, 150, 20);
		contentPane.add(combobox);
                
		btnCheckOut = new JButton("Διαγραφή");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Connection c;
                            CallableStatement s;
                                String id_num = (String) combobox.getSelectedItem();
                                String s1 = t1.getText();
                                try{
                                    c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs", "iee2019187", "mydata");                        
                                    s = c.prepareCall("{ call DEL_CUSTOMER(?,?)}");
                                    s.setString(1, id_num);
                                    s.setString(2, s1);
                                    s.executeQuery();
                                    JOptionPane.showMessageDialog(null, "Check Out Successful");
                                    new Reception().setVisible(true);
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
		
		JButton btnExit = new JButton("Πίσω");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
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
