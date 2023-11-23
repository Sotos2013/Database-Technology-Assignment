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
public class Employee extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lID, lName, lSurname, lAge, lGender, lJob, lSalary ,lPhone, lEmail;

	/**
	 * Launch the application.
	 */
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
	public void close()
	{
		this.dispose();
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Employee() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				try{
                                    Connect c = new Connect();
                                    String displayCustomersql = "select * from employee";
                                    ResultSet rs = c.s.executeQuery(displayCustomersql);
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
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
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