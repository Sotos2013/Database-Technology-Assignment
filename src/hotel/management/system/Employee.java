/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.MessageFormat;
public class Employee extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lID, lName, lSurname, lAge, lGender, lJob, lSalary ,lPhone, lEmail;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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

	public Employee() throws SQLException {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(430, 200, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		contentPane.add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
                                CallableStatement cs;
				try{
                                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                                    cs = con.prepareCall("{ call GETEMPLOYEE(?)}");
                                    cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                                    cs.executeQuery();
                                    ResultSet rs = (ResultSet) cs.getObject(1);
                                    table.setModel(DbUtils.resultSetToTableModel(rs));
                                    table.setEnabled(false);
                                    int trows = table.getRowCount();
                                    if(trows==0)
                                        JOptionPane.showMessageDialog(null, "Δεν υπάρχουν καταχωρημένοι Υπάλληλοι!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
			}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		btnLoadData.setBounds(350, 500, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
                
		JButton btnprint =new JButton("Εκτύπωση");
                btnprint.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                             MessageFormat header=new MessageFormat("Στοιχεία Υπαλλήλων");
                             MessageFormat footer=new MessageFormat("- {0} -");
                             try {
                                 table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                             } catch(Exception ae){ 
                                 System.err.println("Error printing: " + ae.getMessage());
                             }
                         }
                 });
                        
                        
                        
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
                btnprint.setBounds(800, 500, 120, 30);
                btnprint.setBackground(Color.BLACK);
                btnprint.setForeground(Color.WHITE);
		contentPane.add(btnprint);
                
		btnExit.setBounds(510, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		lID = new JLabel("ID");
		lID.setBounds(40, 11, 46, 14);
		contentPane.add(lID);
		
		lName = new JLabel("Όνομα");
		lName.setBounds(140, 11, 46, 14);
		contentPane.add(lName);
		
		lSurname = new JLabel("Επώνυμο");
		lSurname.setBounds(250, 11, 70, 14);
		contentPane.add(lSurname);
		
		lAge = new JLabel("Ηλικία");
		lAge.setBounds(360, 11, 86, 14);
		contentPane.add(lAge);
                
                lGender = new JLabel("Φύλο");
		lGender.setBounds(470, 11, 86, 14);
		contentPane.add(lGender);
                
                lJob = new JLabel("Έιδος Εργασίας");
		lJob.setBounds(550, 11, 100, 14);
		contentPane.add(lJob);
                
                lSalary = new JLabel("Μισθός");
		lSalary.setBounds(690, 11, 86, 14);
		contentPane.add(lSalary);
                
                lPhone = new JLabel("Τηλέφωνο");
		lPhone.setBounds(800, 11, 86, 14);
		contentPane.add(lPhone);
                
                lEmail = new JLabel("Gmail");
		lEmail.setBounds(910, 11, 86, 14);
		contentPane.add(lEmail);
                
                getContentPane().setBackground(Color.WHITE);
	}
}