/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

/**
 *
 * @author sotch
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ChangeTracking {
    public static void logChange(String changeType, String user, String tableName, String primaryKeyColumn, String Value) {
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.21:1521:dblabs", "iee2019187", "mydata")) {
            try (CallableStatement callableStatement = connection.prepareCall("{call log_change(?, ?, ?, ?, ?, ?)}")) {
                callableStatement.setString(1, changeType);
                callableStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                callableStatement.setString(3, user);
                callableStatement.setString(4, tableName);
                callableStatement.setString(5, primaryKeyColumn);
                callableStatement.setString(6, Value);
                callableStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
