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
import java.sql.*;	
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.MessageFormat;

public class LogInfo extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JLabel lblId;
	private JLabel lblNewLabel;
	private JLabel lblGender;
	private JTable table;
	private JLabel lblCountry;
	private JLabel lblRoom;
	private JLabel lblStatus;
	private JLabel lblNewLabel_1;
        private JButton btnDelData;
        private JButton btnprint;

	/**
	 * Launch the application.
	 */
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
	public void close()
	{
		this.dispose();
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public LogInfo() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btnExit = new JButton("Πίσω");
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
		
		JButton btnLoadData = new JButton("Φόρτωση");
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
                            CallableStatement cs;
				try{
                                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                                    cs = con.prepareCall("{ call DELLOG()}");
                                    cs.executeQuery();
                                    String displayCustomersql = "select * from change_tracking";
                                    ResultSet rs = cs.executeQuery(displayCustomersql);
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
		
		lblId = new JLabel("ID");
		lblId.setBounds(31, 11, 46, 14);
		contentPane.add(lblId);
                
                JLabel l1 = new JLabel("Αριθμός");
		l1.setBounds(150, 11, 46, 14);
		contentPane.add(l1);
		
		lblNewLabel = new JLabel("Όνομα");
		lblNewLabel.setBounds(270, 11, 65, 14);
		contentPane.add(lblNewLabel);
		
		lblGender = new JLabel("Φύλο");
		lblGender.setBounds(360, 11, 46, 14);
		contentPane.add(lblGender);
		
		table = new JTable();
		table.setBounds(0, 40, 900, 450);
		contentPane.add(table);
		
		lblCountry = new JLabel("Χώρα");
		lblCountry.setBounds(480, 11, 46, 14);
		contentPane.add(lblCountry);
		
		lblRoom = new JLabel("Δωμάτιο");
		lblRoom.setBounds(580, 11, 50, 14);
		contentPane.add(lblRoom);
		
		lblStatus = new JLabel("Check-in");
		lblStatus.setBounds(680, 11, 100, 14);
		contentPane.add(lblStatus);
		
		lblNewLabel_1 = new JLabel("Κατάθεση");
		lblNewLabel_1.setBounds(800, 11, 100, 14);
		contentPane.add(lblNewLabel_1);
                
                getContentPane().setBackground(Color.WHITE);
	}
}
