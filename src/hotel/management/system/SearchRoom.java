/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchRoom extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTextField txt_Type;
	private JTable table;
        Choice c1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRoom frame = new SearchRoom();
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

	public SearchRoom() throws SQLException {
		setBounds(530, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchForRoom = new JLabel("Αναζήτηση Δωματίου");
		lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForRoom.setBounds(250, 11, 186, 31);
		contentPane.add(lblSearchForRoom);
		
		JLabel lblRoomAvailable = new JLabel("Τύπος δωματίου:");
		lblRoomAvailable.setBounds(50, 73, 96, 14);
		contentPane.add(lblRoomAvailable);
		
		JLabel lblRoomType = new JLabel("Νο. Δωματίου");
		lblRoomType.setBounds(23, 162, 96, 14);
		contentPane.add(lblRoomType);
		
		JLabel lblRoomAvailable_1 = new JLabel("Διαθεσιμότητα");
		lblRoomAvailable_1.setBounds(175, 162, 120, 14);
		contentPane.add(lblRoomAvailable_1);
		
		JLabel lblPrice_1 = new JLabel("Τιμή");
		lblPrice_1.setBounds(458, 162, 46, 14);
		contentPane.add(lblPrice_1);
                
                JLabel l1 = new JLabel("Τύπος Δωματίου");
		l1.setBounds(580, 162, 96, 14);
		contentPane.add(l1);
		
		JCheckBox checkRoom = new JCheckBox("Εμφάνιση μόνο των διαθεσίμων");
		checkRoom.setBounds(400, 69, 205, 23);
                checkRoom.setBackground(Color.WHITE);
		contentPane.add(checkRoom);
		
		
                c1 = new Choice();
                c1.add("Μονόκλινο");
                c1.add("Δίκλινο");
                c1.setBounds(153, 70, 120, 20);
		contentPane.add(c1);
		
		JButton btnSearch = new JButton("Αναζήτηση");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Connection con;
                            CallableStatement cs;
                            try{			
                                con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                                cs = con.prepareCall("{ call SEARCH_ROOM(?,?)}");
                                cs.setString(1, c1.getSelectedItem());
                                cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
                                cs.executeQuery();
                                ResultSet rs = (ResultSet) cs.getObject(2);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				int trows = table.getRowCount();
                                    if(trows==0){
                                        JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές!","Ενημέρωση!", JOptionPane.ERROR_MESSAGE);
                                    }
                                    else if(checkRoom.isSelected()){
                                        cs = con.prepareCall("{ call SEARCH_FREE_ROOM(?,?)}");
                                        cs.setString(1, c1.getSelectedItem());
                                        cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
                                        cs.executeQuery();
                                        ResultSet rs2 = (ResultSet) cs.getObject(2);
					table.setModel(DbUtils.resultSetToTableModel(rs2));
                                        int trows2 = table.getRowCount();
                                        if(trows2==0){
                                            JOptionPane.showMessageDialog(null, "Δεν υπάρχουν ελέυθερα δωμάτια!","Ενημέρωση!", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
				
				
                            }catch (SQLException ss){
				ss.printStackTrace();
                            }
			}
		});
		btnSearch.setBounds(200, 400, 120, 30);
                btnSearch.setBackground(Color.BLACK);
                btnSearch.setForeground(Color.WHITE);
		contentPane.add(btnSearch);
		
		JButton btnExit = new JButton("Πίσω");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(380, 400, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(0, 187, 700, 300);
		contentPane.add(table);
		
		JLabel lblCleanStatus = new JLabel("Καθάρισμα");
		lblCleanStatus.setBounds(306, 162, 96, 14);
		contentPane.add(lblCleanStatus);
                
                getContentPane().setBackground(Color.WHITE);
	}
}