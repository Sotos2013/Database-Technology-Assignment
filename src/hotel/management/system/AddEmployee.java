package hotel.management.system;


import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame{ //Third Frame

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6, textField_7, textField_8;
        JComboBox c1;
        ButtonGroup G1;

        public AddEmployee(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("Προσθήκη νέου υπαλλήλου");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
            
            JLabel id = new JLabel("ID:");
            id.setFont(new Font("Arial", Font.PLAIN, 17));
            id.setBounds(60, 30, 150, 27);
            add(id);
            
            textField_7 = new JTextField();
            textField_7.setBounds(200, 30, 150, 27);
            add(textField_7);
			
            JLabel Name = new JLabel("Όνομα:");
            Name.setFont(new Font("Arial", Font.PLAIN, 17));
            Name.setBounds(60, 70, 150, 27);
            add(Name);
            
            textField = new JTextField();
            textField.setBounds(200, 70, 150, 27);
            add(textField);
            
            JLabel surName = new JLabel("Επώνυμο:");
            surName.setFont(new Font("Arial", Font.PLAIN, 17));
            surName.setBounds(60, 110, 150, 27);
            add(surName);
            
            textField_8 = new JTextField();
            textField_8.setBounds(200, 110, 150, 27);
            add(textField_8);
			
            JButton Next = new JButton("Καταχώρηση");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
			
            JLabel Pnrno = new JLabel("Ηλικία:");
            Pnrno.setFont(new Font("Arial", Font.PLAIN, 17));
            Pnrno.setBounds(60, 150, 150, 27);
            add(Pnrno);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 150, 150, 27);
            add(textField_1);
            
            JLabel Gender = new JLabel("Φύλο:");
            Gender.setFont(new Font("Arial", Font.PLAIN, 17));
            Gender.setBounds(60, 190, 150, 27);
            add(Gender);
	
            G1 = new ButtonGroup();
            
            JRadioButton Male = new JRadioButton("Άνδρας");
            Male.setBackground(Color.WHITE);
            Male.setBounds(200, 190, 70, 27);
            add(Male);
	
            JRadioButton Female = new JRadioButton("Γυναίκα");
            Female.setBackground(Color.WHITE);
            Female.setBounds(280, 190, 70, 27);
            add(Female);
            
            this.add(Male); 
	    this.add(Female); 
                
            G1.add(Male); 
            G1.add(Female);
            
            JLabel Address = new JLabel("Τύπος Εργασίας");
            Address.setFont(new Font("Arial", Font.PLAIN, 17));
            Address.setBounds(60, 230, 150, 27);
            add(Address);
			
            String course[] = {"Υπάλληλος Reception","Πορτιέρης","Καμαριέρης","Σέφ","Υπηρεσία Δωματίου","Προσωπικό Κουζίνας"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,230,150,30);
            add(c1);
            		
            JLabel Nationality = new JLabel("Μισθός:");
            Nationality.setFont(new Font("Arial", Font.PLAIN, 17));
            Nationality.setBounds(60, 270, 150, 27);
            add(Nationality);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 270, 150, 27);
            add(textField_3);
	
            JLabel Phone = new JLabel("Τηλέφωνο:");
            Phone.setFont(new Font("Arial", Font.PLAIN, 17));
            Phone.setBounds(60, 310, 150, 27);
            add(Phone);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 310, 150, 27);
            add(textField_4);
	
            
            JLabel email = new JLabel("E-mail:");
            email.setFont(new Font("Arial", Font.PLAIN, 17));
            email.setBounds(60, 350, 150, 27);
            add(email);
			
            textField_6 = new JTextField();
            textField_6.setBounds(200, 350, 150, 27);
            add(textField_6);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(450, 24, 442, 35);
            add(AddPassengers);
			
     
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(410,80,480,410);
            add(image);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    int id;
                    try{
                        id = Integer.parseInt(textField_7.getText());
                    } catch (Exception z){
                        JOptionPane.showMessageDialog(null, "Το πεδίο 'ID' δεν μπορεί να μείνει κενό!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                        textField_7.setText("");
                        return;
                    }
                    String name = textField.getText();
                    int age;
                    try{
                        age = Integer.parseInt(textField_1.getText());
                    } catch (Exception z){
                        JOptionPane.showMessageDialog(null, "Το πεδίο 'Ηλικία' δεν μπορεί να μείνει κενό!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                        textField_1.setText("");
                        return;
                    }
                    String surname = textField_8.getText();
                    int salary,phone;
                    try{
                        salary = Integer.parseInt(textField_3.getText());
                    } catch (Exception z){
                        JOptionPane.showMessageDialog(null, "Το πεδίο 'Μισθός' δέχεται μόνο αριθμούς!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                        textField_3.setText("");
                        return;
                    }
                    try{
                        phone = Integer.parseInt(textField_4.getText());
                    } catch (Exception z){
                        JOptionPane.showMessageDialog(null, "Το πεδίο 'Τηλέφωνο' δέχεται μόνο αριθμούς!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                        textField_4.setText("");
                        return;
                    }
                    String email = textField_6.getText();
                   
                    String gender = null;
                    
                    if(Male.isSelected())
                        gender = "Άνδρας";
                    else if(Female.isSelected())
                        gender = "Γυναίκα";
                        
                    String job = (String)c1.getSelectedItem();
                    if(name.equals("")){
                        JOptionPane.showMessageDialog(null, "Το πεδίο 'Όνομα' δεν μπορεί να μείνει κενό!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else if(surname.equals("")){
                        JOptionPane.showMessageDialog(null, "Το πεδίο 'Επώνυμο' δεν μπορεί να μείνει κενό!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else if(email.equals("")){
                        JOptionPane.showMessageDialog(null, "Το πεδίο 'E-Mail' δεν μπορεί να μείνει κενό!",
                            "Πρόβλημα με στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Connection con;
                        CallableStatement cs;
                        try {
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
                            cs = con.prepareCall("{ call Add_Employee(?,?,?,?,?,?,?,?,?)}");
                            cs.setInt("id", id);
                            cs.setString("name", name);
                            cs.setString("surname", surname);
                            cs.setInt("age", age);
                            cs.setString("sex", gender);
                            cs.setString("job", job);
                            cs.setInt("salary", salary);
                            cs.setInt("phone", phone);
                            cs.setString("email", email);
                            cs.executeUpdate();
                            JOptionPane.showMessageDialog(null,"Employee Added");
                            setVisible(true);

                        } catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "Υπάρχει ήδη καταχωρημένος υπάλληλος με το ID που εισάγατε!","Πρόβλημα με τα στοιχεία εισαγωγής!", JOptionPane.ERROR_MESSAGE);
                            textField_7.setText("");
                        
                        }
                    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(530,200);
			
	}
        
    public static void main(String[] args){
        new AddEmployee();
    }   
}