package hotel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpdateRoom extends JFrame {
    private JPanel contentPane;
    private JTextField txt_Ava, txt_Status;
    private JFormattedTextField txtPrice;
    private Choice c1;
    private Properties prop = new Properties();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UpdateRoom frame = new UpdateRoom();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UpdateRoom() throws SQLException {
        loadProperties();
        
        setBounds(530, 200, 450, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null); 
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblTitle = new JLabel("Ενημέρωση Δωματίου");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(85, 11, 250, 34);
        contentPane.add(lblTitle);

        JLabel lblRoomNum = new JLabel("Αριθμός Δωματίου:");
        lblRoomNum.setBounds(27, 87, 120, 14);
        contentPane.add(lblRoomNum);

        c1 = new Choice();
        populateRoomChoice();
        c1.setBounds(160, 84, 140, 20);
        contentPane.add(c1);

        JLabel lblPrice = new JLabel("Τιμή (€):");
        lblPrice.setBounds(27, 133, 100, 14);
        contentPane.add(lblPrice);

        // Διαμόρφωση πεδίου τιμής (μόνο αριθμοί)
        NumberFormat format = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setAllowsInvalid(false);
        txtPrice = new JFormattedTextField(formatter);
        txtPrice.setBounds(160, 130, 140, 20);
        contentPane.add(txtPrice);

        JLabel lblAvailability = new JLabel("Διαθεσιμότητα:");
        lblAvailability.setBounds(27, 187, 100, 14);
        contentPane.add(lblAvailability);

        txt_Ava = new JTextField();
        txt_Ava.setBounds(160, 184, 140, 20);
        contentPane.add(txt_Ava);

        JLabel lblCleanStatus = new JLabel("Κατάσταση:");
        lblCleanStatus.setBounds(27, 240, 100, 14);
        contentPane.add(lblCleanStatus);

        txt_Status = new JTextField();
        txt_Status.setBounds(160, 237, 140, 20);
        contentPane.add(txt_Status);

        // --- BUTTON: ΕΛΕΓΧΟΣ ---
        JButton btnCheck = new JButton("Έλεγχος");
        btnCheck.setBounds(120, 315, 100, 30);
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
        contentPane.add(btnCheck);

        btnCheck.addActionListener(e -> {
            try (Connection con = getConnection()) {
                CallableStatement cs = con.prepareCall("{ call SEARCH_ROOM_NUM(?,?)}");
                cs.setInt(1, Integer.parseInt(c1.getSelectedItem()));
                cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
                cs.executeQuery();
                ResultSet rs = (ResultSet) cs.getObject(2);
                if (rs.next()) {
                    txt_Ava.setText(rs.getString(2)); 
                    txt_Status.setText(rs.getString(3));
                    txtPrice.setText(rs.getString(4));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Σφάλμα κατά την ανάκτηση στοιχείων.");
            }
        });

        // --- BUTTON: ΕΝΗΜΕΡΩΣΗ ---
        JButton btnUpdate = new JButton("Ενημέρωση");
        btnUpdate.setBounds(60, 360, 120, 30);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        contentPane.add(btnUpdate);

        btnUpdate.addActionListener(e -> {
            try (Connection con = getConnection()) {
                CallableStatement cs = con.prepareCall("{ call UPDATE_ROOM(?,?,?,?)}");
                cs.setString(1, txtPrice.getText().replace(".", "")); // Καθαρισμός formatting
                cs.setString(2, txt_Status.getText());
                cs.setString(3, txt_Ava.getText());
                cs.setString(4, c1.getSelectedItem());
                cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Επιτυχής ενημέρωση δωματίου " + c1.getSelectedItem());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Σφάλμα κατά την ενημέρωση.");
            }
        });

        // --- BUTTON: ΠΙΣΩ ---
        JButton btnBack = new JButton("Πίσω");
        btnBack.setBounds(220, 360, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        contentPane.add(btnBack);
        
        btnBack.addActionListener(e -> {
            new Reception().setVisible(true);
            dispose();
        });
    }

    private void populateRoomChoice() {
        try (Connection con = getConnection()) {
            CallableStatement cs = con.prepareCall("{ call GET_AV_ROOM(?)}");
            cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet) cs.getObject(1);
            while(rs.next()) {
                c1.add(rs.getString(1));
            }
        } catch(Exception e) {
            System.err.println("Error populating choices.");
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.user"), prop.getProperty("db.pass"));
    }

    private void loadProperties() {
        // Διαβάζει το αρχείο από το εσωτερικό του JAR/EXE
        try (InputStream is = UpdateRoom.class.getResourceAsStream("/hotel/management/system/config.properties")) {
            if (is != null) {
                prop.load(is);
            } else {
                System.err.println("Το αρχείο config.properties δεν βρέθηκε μέσα στο EXE!");
            }
        } catch (IOException e) {
            System.err.println("Σφάλμα κατά τη φόρτωση των ρυθμίσεων: " + e.getMessage());
        }
    }
}