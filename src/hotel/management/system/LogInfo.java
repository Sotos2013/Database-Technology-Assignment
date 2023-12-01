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
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;
import javax.swing.table.TableColumn;

public class LogInfo extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_1, l1, lblStatus, lblRoom, lblCountry, lblGender, lblNewLabel, lblId,lblpedio;
        private JButton btnDelData, btnExit, btnLoadData, btnprint;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInfo frame = new LogInfo();
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

	public LogInfo() throws SQLException {
		setBounds(530, 200, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                 setLocationRelativeTo(null);
        setResizable(false);

		
		btnExit = new JButton("Πίσω");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(450, 510, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		btnLoadData = new JButton("Φόρτωση");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            btnDelData.setEnabled(true);
                            btnprint.setEnabled(true);
                            Connection con;
                            CallableStatement cs;
				try{
                                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                                    cs = con.prepareCall("{ call GETLOG(?)}");
                                    cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                                    cs.executeQuery();
                                    ResultSet rs = (ResultSet) cs.getObject(1);
                                    table.setModel(DbUtils.resultSetToTableModel(rs));
                                    table.setEnabled(false);
                                    TableColumn Column1 = table.getColumnModel().getColumn(0);
                                    TableColumn Column2 = table.getColumnModel().getColumn(1);
                                    TableColumn Column3 = table.getColumnModel().getColumn(2);
                                    TableColumn Column4 = table.getColumnModel().getColumn(3);
                                    TableColumn Column5 = table.getColumnModel().getColumn(4);
                                    TableColumn Column6 = table.getColumnModel().getColumn(5);
                                    Column1.setPreferredWidth(200);
                                    Column2.setPreferredWidth(500);
                                    Column3.setPreferredWidth(300);
                                    Column4.setPreferredWidth(200);
                                    Column5.setPreferredWidth(400);
                                    Column6.setPreferredWidth(1500);
                                    int trows = table.getRowCount();
                                    if(trows==0){
                                        JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές!","Ενημέρωση!", JOptionPane.ERROR_MESSAGE);
                                        btnDelData.setEnabled(false);
                                        btnprint.setEnabled(false);
                                    }
                                }
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			
		});
                
                btnDelData = new JButton("Διαγραφή LOG");
		btnDelData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            Connection con;
                            CallableStatement cs, cs2;
				try{
                                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                                    cs = con.prepareCall("{ call DELLOG()}");
                                    cs.executeQuery();
                                    cs2 = con.prepareCall("{ call GETLOG(?)}");
                                    cs2.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                                    cs2.executeQuery();
                                    ResultSet rs = (ResultSet) cs2.getObject(1);
                                    table.setModel(DbUtils.resultSetToTableModel(rs));
                                    table.setEnabled(false);
                                    JOptionPane.showMessageDialog(null, "Το αρχείο LOG άδειασε!","Ενημέρωση", JOptionPane.INFORMATION_MESSAGE);
                                    btnDelData.setEnabled(false);
                                    btnprint.setEnabled(false);
                                }
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			
		});
                
                btnprint =new JButton("Εκτύπωση");
                btnprint.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                             MessageFormat header=new MessageFormat("Log File");
                             MessageFormat footer=new MessageFormat("- {0} -");
                             try {
                                PrinterJob printerJob = PrinterJob.getPrinterJob();
                                PageFormat pageFormat = printerJob.defaultPage();
                                pageFormat.setOrientation(PageFormat.LANDSCAPE);
                                 table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                             } catch(Exception ae){ 
                                 System.err.println("Error printing: " + ae.getMessage());
                             }
                         }
                 });
                
                
		btnLoadData.setBounds(300, 510, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
                
                btnDelData.setBounds(100, 510, 120, 30);
                btnDelData.setEnabled(false);
                btnDelData.setBackground(Color.BLACK);
                btnDelData.setForeground(Color.WHITE);
		contentPane.add(btnDelData);
                
                btnprint.setBounds(600, 510, 120, 30);
                btnprint.setEnabled(false);
                btnprint.setBackground(Color.BLACK);
                btnprint.setForeground(Color.WHITE);
		contentPane.add(btnprint);
		
		lblId = new JLabel("Αλλαγή");
		lblId.setBounds(15, 11, 55, 14);
		contentPane.add(lblId);
                
                l1 = new JLabel("Χρονοσήμανση");
		l1.setBounds(100, 11, 100, 14);
		contentPane.add(l1);
		
		lblNewLabel = new JLabel("Όνομα Χρήστη");
		lblNewLabel.setBounds(210, 11, 130, 14);
		contentPane.add(lblNewLabel);
		
		lblGender = new JLabel("Πίνακας");
		lblGender.setBounds(310, 11, 46, 14);
		contentPane.add(lblGender);
		
		table = new JTable();
		table.setBounds(0, 40, 900, 450);
		contentPane.add(table);
		
               
                lblpedio = new JLabel("Πρ. Κλειδί");
		lblpedio.setBounds(400, 11, 80, 14);
		contentPane.add(lblpedio);

                        
		lblCountry = new JLabel("Πληροφορία");
		lblCountry.setBounds(500, 11, 80, 14);
		contentPane.add(lblCountry);

                
                getContentPane().setBackground(Color.WHITE);
	}
}
