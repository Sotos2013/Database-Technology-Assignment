/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame{

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    
    public Dashboard() {
        super("Πληροφοριακό σύστημα μηχανογράφησης ξενοδοχείου");
	
        setForeground(Color.BLUE);
        setLayout(null); 
        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1950, 1000); 
        add(NewLabel);
        
        JLabel Label = new JLabel("Πληροφοριακό σύστημα μηχανογράφησης ξενοδοχείου");
	Label.setForeground(Color.WHITE);
        Label.setFont(new Font("Tahoma", Font.PLAIN, 30));
	Label.setBounds(600, 60, 1000, 85);
	NewLabel.add(Label);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu AdminBar = new JMenu("Διαχείριση ξενοδοχείου ");
        AdminBar.setForeground(Color.BLUE);
	menuBar.add(AdminBar);
		
        JMenuItem Reception = new JMenuItem("RECEPTION");
	AdminBar.add(Reception);
		
	JMenu AdminMenu = new JMenu("Διαχειριστής");
        AdminMenu.setForeground(Color.RED);
	menuBar.add(AdminMenu);
        
        JMenuItem EmployeeInsertion = new JMenuItem("ΕΙΣΑΓΩΓΗ ΥΠΑΛΛΉΛΟΥ");
	AdminMenu.add(EmployeeInsertion);
        
        EmployeeInsertion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddEmployee().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

        JMenuItem RoomInsertion = new JMenuItem("ΕΙΣΑΓΩΓΗ ΔΩΜΑΤΙΩΝ");
	AdminMenu.add(RoomInsertion);
        
        RoomInsertion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddRoom().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

	Reception.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
	});
        
        
        JMenuItem DriverInsertion = new JMenuItem("ΕΙΣΑΓΩΓΗ ΟΔΗΓΩΝ");
	AdminMenu.add(DriverInsertion);
        
	DriverInsertion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddDrivers().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        JMenuItem EmployeeDelete = new JMenuItem("ΔΙΑΓΡΑΦΗ ΥΠΑΛΛΗΛΩΝ");
	AdminMenu.add(EmployeeDelete);
        
	EmployeeDelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DelEmployee().setVisible(true);
                }catch(Exception e ){}
            }
	});
        JMenuItem DriverDelete = new JMenuItem("ΔΙΑΓΡΑΦΗ ΟΔΗΓΩΝ");
	AdminMenu.add(DriverDelete);
        
	DriverDelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DelDrivers().setVisible(true);
                }catch(Exception e ){}
            }
	});
        JMenuItem RoomDelete = new JMenuItem("ΔΙΑΓΡΑΦΗ ΔΩΜΑΤΙΩΝ");
	AdminMenu.add(RoomDelete);
        
	RoomDelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DelRoom().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
		
        setSize(1950,1090);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
