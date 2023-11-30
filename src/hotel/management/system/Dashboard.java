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
        
        JLabel AirlineManagementSystem = new JLabel("Πληροφοριακό σύστημα μηχανογράφησης ξενοδοχείου");
	AirlineManagementSystem.setForeground(Color.WHITE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 30));
	AirlineManagementSystem.setBounds(600, 60, 1000, 85);
	NewLabel.add(AirlineManagementSystem);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu AirlineSystem = new JMenu("Διαχείριση ξενοδοχείου ");
        AirlineSystem.setForeground(Color.BLUE);
	menuBar.add(AirlineSystem);
		
        JMenuItem FlightDetails = new JMenuItem("RECEPTION");
	AirlineSystem.add(FlightDetails);
		
	JMenu AirlineSystemHello = new JMenu("Διαχειριστής");
        AirlineSystemHello.setForeground(Color.RED);
	menuBar.add(AirlineSystemHello);
        
        JMenuItem FlightDetailshello1 = new JMenuItem("ΕΙΣΑΓΩΓΗ ΥΠΑΛΛΉΛΟΥ");
	AirlineSystemHello.add(FlightDetailshello1);
        
        FlightDetailshello1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddEmployee().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

        JMenuItem FlightDetailshello2 = new JMenuItem("ΕΙΣΑΓΩΓΗ ΔΩΜΑΤΙΩΝ");
	AirlineSystemHello.add(FlightDetailshello2);
        
        FlightDetailshello2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddRoom().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

	FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
	});
        
        
        JMenuItem FlightDetailshello3 = new JMenuItem("ΕΙΣΑΓΩΓΗ ΟΔΗΓΩΝ");
	AirlineSystemHello.add(FlightDetailshello3);
        
	FlightDetailshello3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddDrivers().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        JMenuItem FlightDetailshello4 = new JMenuItem("ΔΙΑΓΡΑΦΗ ΥΠΑΛΛΗΛΩΝ");
	AirlineSystemHello.add(FlightDetailshello4);
        
	FlightDetailshello4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DelEmployee().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
		
        setSize(1950,1090);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
