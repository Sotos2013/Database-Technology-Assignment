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

import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.MessageFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.table.TableColumn;
public class Employee extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JLabel lID, lName, lSurname, lAge, lGender, lJob, lSalary ,lPhone, lEmail;
        private JButton btnLoadData, btnprint, btnExit;

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
		setBounds(430, 200, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		contentPane.add(table);
		
		btnLoadData = new JButton("Φόρτωση");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            btnprint.setEnabled(true);
				Connection con;
                                CallableStatement cs;
				try{
                                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                                    cs = con.prepareCall("{ call GETEMPLOYEE(?)}");
                                    cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                                    cs.executeQuery();
                                    ResultSet rs = (ResultSet) cs.getObject(1);
                                    table.setModel(DbUtils.resultSetToTableModel(rs));
                                    TableColumn Column1 = table.getColumnModel().getColumn(0);
                                    TableColumn Column2 = table.getColumnModel().getColumn(1);
                                    TableColumn Column3 = table.getColumnModel().getColumn(2);
                                    TableColumn Column4 = table.getColumnModel().getColumn(3);
                                    TableColumn Column5 = table.getColumnModel().getColumn(4);
                                    TableColumn Column6 = table.getColumnModel().getColumn(5);
                                    TableColumn Column7 = table.getColumnModel().getColumn(6);
                                    TableColumn Column8 = table.getColumnModel().getColumn(7);
                                    TableColumn Column9 = table.getColumnModel().getColumn(8);
                                    Column1.setPreferredWidth(20);
                                    Column2.setPreferredWidth(50);
                                    Column3.setPreferredWidth(50);
                                    Column4.setPreferredWidth(5);
                                    Column5.setPreferredWidth(20);
                                    Column6.setPreferredWidth(100);
                                    Column7.setPreferredWidth(20);
                                    Column8.setPreferredWidth(70);
                                    Column9.setPreferredWidth(150);
                                    table.setEnabled(false);
                                    int trows = table.getRowCount();
                                    if(trows==0){
                                        JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές!","Ενημέρωση!", JOptionPane.ERROR_MESSAGE);
                                        btnprint.setEnabled(false);
                                    }
			}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		btnLoadData.setBounds(200, 500, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
                
		btnprint =new JButton("Εκτύπωση");
                btnprint.setEnabled(false);
                btnprint.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                             MessageFormat header=new MessageFormat("Στοιχεία Υπαλλήλων");
                             MessageFormat footer=new MessageFormat("- {0} -");
                             try {
                                 PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
                                attr.add(OrientationRequested.LANDSCAPE);
                                 table.print(JTable.PrintMode.FIT_WIDTH, header, footer, rootPaneCheckingEnabled, attr, rootPaneCheckingEnabled);
                             } catch(Exception ae){ 
                                 System.err.println("Αποτυχία Εκτύπωσης: " + ae.getMessage());
                             }
                         }
                 });
                        
                        
                        
		btnExit = new JButton("Πίσω");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
                btnprint.setBounds(600, 500, 120, 30);
                btnprint.setBackground(Color.BLACK);
                btnprint.setForeground(Color.WHITE);
		contentPane.add(btnprint);
                
		btnExit.setBounds(400, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		lID = new JLabel("ID");
		lID.setBounds(40, 11, 46, 14);
		contentPane.add(lID);
		
		lName = new JLabel("Όνομα");
		lName.setBounds(100, 11, 46, 14);
		contentPane.add(lName);
		
		lSurname = new JLabel("Επώνυμο");
		lSurname.setBounds(200, 11, 70, 14);
		contentPane.add(lSurname);
		
		lAge = new JLabel("Ηλικία");
		lAge.setBounds(300, 11, 86, 14);
		contentPane.add(lAge);
                
                lGender = new JLabel("Φύλο");
		lGender.setBounds(370, 11, 86, 14);
		contentPane.add(lGender);
                
                lJob = new JLabel("Έιδος Εργασίας");
		lJob.setBounds(450, 11, 100, 14);
		contentPane.add(lJob);
                
                lSalary = new JLabel("Μισθός");
		lSalary.setBounds(600, 11, 86, 14);
		contentPane.add(lSalary);
                
                lPhone = new JLabel("Τηλέφωνο");
		lPhone.setBounds(700, 11, 86, 14);
		contentPane.add(lPhone);
                
                lEmail = new JLabel("Email");
		lEmail.setBounds(800, 11, 86, 14);
		contentPane.add(lEmail);
                
                getContentPane().setBackground(Color.WHITE);
	}
}