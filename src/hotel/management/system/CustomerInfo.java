/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.MessageFormat;

public class CustomerInfo extends JFrame {
	private JPanel contentPane;
	private JLabel lblId, lblNewLabel,lblGender, lblCountry, lblRoom, lblStatus, lblNewLabel_1, l1, lblNewLabel2;
	private JTable table;
        private JButton btnprint, btnExit, btnLoadData;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerInfo frame = new CustomerInfo();
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
	public CustomerInfo() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 950, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		btnExit = new JButton("Πίσω");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(350, 510, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		btnLoadData = new JButton("Φόρτωση");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            btnprint.setEnabled(true);
                            Connection con;
                            CallableStatement cs;
				try{
                                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                                    cs = con.prepareCall("{ call GETCUSTOMERS(?)}");
                                    cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                                    cs.executeQuery();
                                    ResultSet rs = (ResultSet) cs.getObject(1);
                                    table.setModel(DbUtils.resultSetToTableModel(rs));
                                    table.setEnabled(false);
                                    int trows = table.getRowCount();
                                    if(trows==0){
                                        JOptionPane.showMessageDialog(null, "Δεν υπάρχουν καταχωρημένοι πελάτες!","Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                                        btnprint.setEnabled(false);
                                    }                                   
                                }
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			
		});
                
                btnprint =new JButton("Εκτύπωση");
                btnprint.setEnabled(false);
                btnprint.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                             MessageFormat header=new MessageFormat("Στοιχεία Πελατών");
                             MessageFormat footer=new MessageFormat("- {0} -");
                             try {
                                 table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                             } catch(Exception ae){ 
                                 System.err.println("Error printing: " + ae.getMessage());
                             }
                         }
                 });
                
                
		btnLoadData.setBounds(200, 510, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
                
                btnprint.setBounds(500, 510, 120, 30);
                btnprint.setBackground(Color.BLACK);
                btnprint.setForeground(Color.WHITE);
		contentPane.add(btnprint);
		
		lblId = new JLabel("ID");
		lblId.setBounds(31, 11, 46, 14);
		contentPane.add(lblId);
                
                l1 = new JLabel("Αριθμός");
		l1.setBounds(110, 11, 46, 14);
		contentPane.add(l1);
		
		lblNewLabel = new JLabel("Όνομα");
		lblNewLabel.setBounds(210, 11, 65, 14);
		contentPane.add(lblNewLabel);
                
                lblNewLabel2 = new JLabel("Επώνυμο");
		lblNewLabel2.setBounds(300, 11, 65, 14);
		contentPane.add(lblNewLabel2);
		
		lblGender = new JLabel("Φύλο");
		lblGender.setBounds(400, 11, 46, 14);
		contentPane.add(lblGender);
		
		table = new JTable();
		table.setBounds(0, 40, 900, 450);
		contentPane.add(table);
		
		lblCountry = new JLabel("Χώρα");
		lblCountry.setBounds(510, 11, 46, 14);
		contentPane.add(lblCountry);
		
		lblRoom = new JLabel("Δωμάτιο");
		lblRoom.setBounds(610, 11, 50, 14);
		contentPane.add(lblRoom);
		
		lblStatus = new JLabel("Ημέρες διαμονής");
		lblStatus.setBounds(700, 11, 100, 14);
		contentPane.add(lblStatus);
		
		lblNewLabel_1 = new JLabel("Ποσό πληρωμής");
		lblNewLabel_1.setBounds(800, 11, 100, 14);
		contentPane.add(lblNewLabel_1);
                
                getContentPane().setBackground(Color.WHITE);
	}
}