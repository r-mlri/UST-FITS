/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.studentLog;
/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */
public class studententrylog{   
    public boolean insertData (int SN, Connection conn)        
    {
         try
         {
             String query = "INSERT into studententrylog SET SN = ?";

            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  
            ps.setInt(1, SN);
            
            ps.executeUpdate();
        } catch (SQLException ex) 
        {
            Logger.getLogger(studentselectlog.class.getName()).log(Level.SEVERE, null, ex);
        }return true;
    }
}

    
    /*
    public int registerStudent(studentLog student) throws ClassNotFoundException {
        String INSERT = "INSERT INTO studententrylog" +
            "  (SN, NAME, ENTRYTYPE, TIMESTAMP) VALUES " +
            " (?, ?, IN, ?)";

        int result = 0;
        
        
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/ustfits", "root", "MyNewPass");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, student.getSN());
            preparedStatement.setString(2, student.getEQUIPMENTS());
            

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }
     private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
     }
}*/
