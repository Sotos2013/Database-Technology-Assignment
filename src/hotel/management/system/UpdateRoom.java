
package hotel.management.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

public class UpdateRoom extends JFrame {
	private JPanel contentPane;
	private JTextField txt_Ava, txt_Status;
        private JFormattedTextField txtPrice;
        Choice c1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRoom frame = new UpdateRoom();
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

	public UpdateRoom() throws SQLException {
		setBounds(530, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                setLocationRelativeTo(null); 
                setResizable(false);
                
              
             
              
             
		
		JLabel lblUpdateRoomStatus = new JLabel("Ενημέρωση δωμάτιου");
		lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateRoomStatus.setBounds(85, 11, 206, 34);
		contentPane.add(lblUpdateRoomStatus);
		
		JLabel lblNewLabel = new JLabel("Αριθμός Δωματίου:");
		lblNewLabel.setBounds(27, 87, 90, 14);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                Connection con;
                CallableStatement cs;
                try{
                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                    cs = con.prepareCall("{ call GET_AV_ROOM(?)}");
                    cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                    cs.executeQuery();
                    ResultSet rs = (ResultSet) cs.getObject(1);
                    while(rs.next()){
                        c1.add(rs.getString(1));    
                    }
                }catch(Exception e){ }
                c1.setBounds(160, 84, 140, 20);
		contentPane.add(c1);
		
		JLabel lblAvailability = new JLabel("Διαθεσιμότητα:");
		lblAvailability.setBounds(27, 187, 90, 14);
		contentPane.add(lblAvailability);
		
		JLabel lblCleanStatus = new JLabel("Κατάσταση:");
		lblCleanStatus.setBounds(27, 240, 90, 14);
		contentPane.add(lblCleanStatus);
		
		
		txt_Ava = new JTextField();
		txt_Ava.setBounds(160, 184, 140, 20);
		contentPane.add(txt_Ava);
		txt_Ava.setColumns(10);
		
		txt_Status = new JTextField();
		txt_Status.setBounds(160, 237, 140, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);
                
                NumberFormat format = NumberFormat.getInstance();
                NumberFormatter formatter = new NumberFormatter(format);
                formatter.setValueClass(Integer.class);
                formatter.setMinimum(0);
                formatter.setMaximum(Integer.MAX_VALUE);
                formatter.setAllowsInvalid(false);
                formatter.setCommitsOnValidEdit(true);
                txtPrice = new JFormattedTextField();
		txtPrice.setBounds(160, 130, 140, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
                
                JButton b1 = new JButton("Έλεγχος");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Connection con;
                            CallableStatement cs;
                            try{
                                con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs","iee2019187", "mydata");
                                cs = con.prepareCall("{ call SEARCH_ROOM_NUM(?,?)}");
                                cs.setInt(1, Integer.parseInt(c1.getSelectedItem()));
                                cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
                                cs.executeQuery();
                                ResultSet rs1 = (ResultSet) cs.getObject(2);
                                while(rs1.next()){
                                    txt_Ava.setText(rs1.getString(2)); 
                                    txt_Status.setText(rs1.getString(3));
                                    txtPrice.setText(rs1.getString(4));
                                }
                            }catch(Exception ee){}
                        }
		});
		b1.setBounds(120, 315, 89, 23);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		
		JButton btnUpdate = new JButton("Ενημέρωση");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
                            Connection con;
                            CallableStatement cs;
				try{
                                    con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs", "iee2019187", "mydata");
                                    cs =con.prepareCall("{ call UPDATE_ROOM(?,?,?,?)}");
                                    cs.setString(1, txtPrice.getText());
                                    cs.setString(2, txt_Status.getText());
                                    cs.setString(3, txt_Ava.getText());
                                    cs.setString(4, c1.getSelectedItem());
                                    cs.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Τα στοιχεία του δωματίου "+c1.getSelectedItem()+" ενημερώθηκαν επιτυχώς!");
                                    setVisible(false);
				}catch (Exception ee){
					JOptionPane.showMessageDialog(null, "Κάτι πήγε στραβά. Δοκιμάστε πάλι!");
                                        txt_Ava.setText(""); 
                                        txt_Status.setText("");
                                        txtPrice.setText("");
				}
				
			
			}
		});
		btnUpdate.setBounds(60, 355, 89, 23);
                btnUpdate.setBackground(Color.BLACK);
                btnUpdate.setForeground(Color.WHITE);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Πίσω");
		btnExit.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(180, 355, 89, 23);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		JLabel lblRoomPrice = new JLabel("Τιμή:");
		lblRoomPrice.setBounds(27, 133, 100, 14);
		contentPane.add(lblRoomPrice);
		
		getContentPane().setBackground(Color.WHITE);
	}

}