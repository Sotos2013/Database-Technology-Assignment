/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

public class CheckOut extends JFrame{
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1;
        private JButton btnCheckOut;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
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

	public CheckOut() throws SQLException {
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
                    cs = con.prepareCall("{ call GETCUSTOMERS(?)}");
                    cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                    cs.executeQuery();
                    ResultSet rs = (ResultSet) cs.getObject(1);
                    while(rs.next()){
                        combobox.addItem(rs.getString(2));
                    }
                }catch(Exception e){ }
                combobox.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnCheckOut.setEnabled(true);
                        Connection con;
                        CallableStatement cs;
                        try{
                            con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                            cs = con.prepareCall("{ call CHECKOUT(?,?)}");
                            cs.setString(1, (String)combobox.getSelectedItem());
                            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
                            cs.executeQuery();
                            ResultSet rs = (ResultSet) cs.getObject(2);
                            while(rs.next()){
                                t1.setText(rs.getString(1));
                            }
                        }catch(Exception ee){ }
                    }
                
                });
                combobox.setBounds(130, 82, 150, 20);
		contentPane.add(combobox);
                
                
                ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
                Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JButton l2 = new JButton(i6);
                l2.setBounds(290,82,20,20);
                add(l2);
                

		
		JLabel lblRoomNumber = new JLabel("Νο. δωματίου:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		contentPane.add(lblRoomNumber);
		
		t1 = new JTextField();
                t1.setText("");
                t1.setBounds(130, 132, 150, 20);
		contentPane.add(t1);
                t1.setEditable(false);
                
                
                
                
                
                
		
                
		btnCheckOut = new JButton("Check Out");
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