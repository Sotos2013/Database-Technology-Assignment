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

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CheckOut() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(300,0,500,225);
                add(l1);
		
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);
		
		JLabel lblName = new JLabel("Number :");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);
                
                JComboBox combobox = new JComboBox();
                try{
                    Connect c = new Connect();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        combobox.addItem(rs.getString("Αριθμός_Εγγράφου"));
                    }
                }catch(Exception e){ }
                combobox.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      
                          
           if (combobox.getSelectedItem() != null) {
           try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",""); ) {
        String selectedRoom = (String) combobox.getSelectedItem();

        String sql = "SELECT * FROM room  JOIN customer ON room.Αριθμός_δωματίου = customer.Αριθμός_δωματίου WHERE room.Αριθμός_δωματίου = ?";
     
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, selectedRoom);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    t1.setText(rs.getString(1)); // Assuming that the first column should be displayed in t1
                    // You might want to adjust the column index or use column names based on your database schema
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Log or handle the exception appropriately
    }}
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
                
                /*c1.add(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent ae){
                        System.out.println("Hi");
                        try{
                            
                            Connect c = new Connect();
                            String id = c1.getSelectedItem();
                            ResultSet rs = c.s.executeQuery("select * from customer where ID = "+id);
                            
                            if(rs.next()){
                                System.out.println("clicked");
                                t1.setText(rs.getString("Αριθμός_δωματίου"));    
                            }
                        }catch(Exception e){ }
                    }
                });*/

		
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		contentPane.add(lblRoomNumber);
		
		t1 = new JTextField();
                t1.setText("");
                t1.setBounds(130, 132, 150, 20);
		contentPane.add(t1);
                //t1.setEditable(false);
                
                
                
                
                
                
		
                
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                String id_num = (String) combobox.getSelectedItem();
                                String s1 = t1.getText();
				String deleteSQL = "Delete from customer where Αριθμός_Εγγράφου = '"+id_num+"'";
                                String q2 = "update room set Διαθεσιμότητα = 'Διαθέσιμο' where Αριθμός_δωματίου = '"+s1+"'";
                                
                                
				Connect c = new Connect();

	    		try{
	    			
	    			
	    			c.s.executeUpdate(deleteSQL);
	    			c.s.executeUpdate(q2);
	    			JOptionPane.showMessageDialog(null, "Check Out Successful");
	    			new Reception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
			}
		});
		btnCheckOut.setBounds(50, 200, 100, 25);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);
		
		JButton btnExit = new JButton("Back");
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