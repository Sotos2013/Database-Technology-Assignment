/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

/**
 *
 * @author sotch
 */
import java.sql.*;  

public class Connect {
    Connection c;
    Statement s;
    Connect(){  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            c =DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs", "iee2019187", "mydata");
            
            s = c.createStatement();  
           
        }
        catch(Exception e){ 
            System.out.println(e);
        }  
    } 
}
