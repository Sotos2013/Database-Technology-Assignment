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
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotel",
                "root", "");
            
            s =c.createStatement();  
           
        }
        catch(Exception e){ 
            System.out.println(e);
        }  
    } 
}
