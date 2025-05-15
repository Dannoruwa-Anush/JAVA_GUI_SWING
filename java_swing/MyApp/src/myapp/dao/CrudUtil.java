/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import myapp.dbConfig.DbConnection;

/**
 *
 * @author HP
 */
public class CrudUtil {
    private static PreparedStatement getPreparedStatement(String sql, Object... args) throws SQLException, ClassNotFoundException{
        Connection connection = DbConnection.getInstance().getConnection();
        
        if (connection == null) {
            System.out.println("Database connection is null.");
            throw new SQLException("Failed to obtain database connection.");
        } else if (connection.isClosed()) {
            System.out.println("Database connection is closed.");
            throw new SQLException("Database connection is closed.");
        } else {
            System.out.println("Database connection is active.");
        }
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if(args != null){
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1, args[i]);
            }
        }
        return preparedStatement;
    }
    
    public static boolean executeUpdate(String sql, Object... args) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }

            return preparedStatement.executeUpdate() > 0;
        }
    }
    
    public static ResultSet executeQuery(String sql, Object... args) throws SQLException, ClassNotFoundException{
        return getPreparedStatement(sql, args).executeQuery();
    }
}
