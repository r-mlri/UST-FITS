/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */
public class studententrylog{
    public int registerStudent(studentLog student) throws ClassNotFoundException {
        String INSERT = "INSERT INTO USTFITS.STUDENTENTRYLOG" +
            "  (SN) VALUES " +
            " (?)";

        int result = 0;

        Class.forName("org.apache.derby.jdbc.ClientDriver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/ustfits/studententrylog", "root", "MyNewPass");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, student.getSN());
            

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
}