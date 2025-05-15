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
    
    private static PreparedStatement getPreparedStatement(String sql, Object... args) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();

        if (connection == null || connection.isClosed()) {
            throw new SQLException("Unable to establish a valid database connection.");
        }

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
        }

        return preparedStatement;
    }
    
    //Executing SQL statements that change data, like INSERT, UPDATE, DELETE.
    public static boolean executeUpdate(String sql, Object... args) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStatement = getPreparedStatement(sql, args)) {
            return preparedStatement.executeUpdate() > 0;
        }
    }
    
    //Executing SQL queries that return data, like SELECT
     public static ResultSet executeQuery(String sql, Object... args) throws SQLException, ClassNotFoundException {
        return getPreparedStatement(sql, args).executeQuery();
    }
}
