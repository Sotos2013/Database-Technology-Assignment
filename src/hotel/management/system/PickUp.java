/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;



import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.MessageFormat;

public class PickUp extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTable table;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickUp frame = new PickUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PickUp() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                   setLocationRelativeTo(null);
        setResizable(false);
		
		
		JLabel lblPickUpService = new JLabel("Υπηρεσία παραλαβής πελάτη");
		lblPickUpService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPickUpService.setBounds(90, 11, 300, 25);
		contentPane.add(lblPickUpService);
		
		JLabel lblTypeOfCar = new JLabel("Τύπος αυτοκινήτου");
		lblTypeOfCar.setBounds(32, 97, 89, 14);
		contentPane.add(lblTypeOfCar);

		
                c1 = new Choice();
                Connection con;
                CallableStatement cs;
                c1.add("Όλα");
                try{
                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs", "iee2019187", "mydata");
                    cs = con.prepareCall("{ call GETDRIVER(?)}");
                    cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                    cs.executeQuery();
                    ResultSet rs = (ResultSet) cs.getObject(1);
                    while(rs.next()){
                        c1.add(rs.getString(6));    
                    }
                }catch(Exception e){ }
                c1.setBounds(123, 94, 150, 25);
		contentPane.add(c1);

                
		
		JLabel lblInfo = new JLabel("Ονομα");
		lblInfo.setBounds(24, 208, 46, 14);
		contentPane.add(lblInfo);
		
		JButton btnRegister = new JButton("Εμφάνιση");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            Connection con;
                            CallableStatement cs;
                            try{
                                if(c1.getSelectedItem()!="Όλα"){
                                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs", "iee2019187", "mydata");
                                    cs = con.prepareCall("{ call GET_DRIVER_CAR(?,?)}");
                                    cs.setString(1, c1.getSelectedItem());
                                    cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
                                    cs.executeQuery();
                                    ResultSet rs = (ResultSet) cs.getObject(2);
                                    table.setModel(DbUtils.resultSetToTableModel(rs));
                                }
                                else{
                                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs", "iee2019187", "mydata");
                                    cs = con.prepareCall("{ call GETDRIVER(?)}");
                                    cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                                    cs.executeQuery();
                                    ResultSet rs = (ResultSet) cs.getObject(1);
                                    table.setModel(DbUtils.resultSetToTableModel(rs));
                                }
                            }catch (SQLException ss){
                                ss.printStackTrace();
                            }
			}
		});
                JButton btnprint =new JButton("Εκτύπωση");
               btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
		MessageFormat header=new MessageFormat("Στοιχεία παραλαβής πελατών");
                MessageFormat footer=new MessageFormat("- {0} -");
            try 
            {

                table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            }

            catch(Exception ae)
            { 
                System.err.println("Error printing: " + ae.getMessage());

                }
        }
			
		});
		
		   btnprint.setBounds(620, 500, 120, 30);
                btnprint.setBackground(Color.BLACK);
                btnprint.setForeground(Color.WHITE);
		contentPane.add(btnprint);
                
		btnRegister.setBounds(200, 500, 120, 30);
                btnRegister.setBackground(Color.BLACK);
                btnRegister.setForeground(Color.WHITE);
		contentPane.add(btnRegister);
		
		JButton btnExit = new JButton("Πίσω");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(380, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(0, 233, 800, 250);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Ηλικία");
		lblNewLabel.setBounds(165, 208, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGender = new JLabel("Φύλο");
		lblGender.setBounds(264, 208, 46, 14);
		contentPane.add(lblGender);
		
		JLabel lblTypeOfDriver = new JLabel("Εταιρία");
		lblTypeOfDriver.setBounds(366, 208, 80, 14);
		contentPane.add(lblTypeOfDriver);
		
		JLabel lblDateOfThe = new JLabel("Μάρκα");
		lblDateOfThe.setBounds(486, 208, 105, 14);
		contentPane.add(lblDateOfThe);
	
		JLabel lblAirport = new JLabel("Διαθεσιμότητα");
		lblAirport.setBounds(600, 208, 86, 14);
		contentPane.add(lblAirport);
		
		JLabel lblAvailable = new JLabel("Τοποθεσία");
		lblAvailable.setBounds(700, 208, 73, 14);
		contentPane.add(lblAvailable);
                
                
                
                getContentPane().setBackground(Color.WHITE);
	}
}