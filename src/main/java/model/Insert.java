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

import model.Trainer;

public class Insert {

    public int insertTrainers(Trainer trainer) throws ClassNotFoundException {  //This method is for the database change the SQL script
        String INSERT_USERS_SQL = "INSERT INTO APP.TRAINER" +
            "  (name, specialty, sports) VALUES " +
            " (?, ?, ?)";

        int result = 0;

        Class.forName("org.apache.derby.jdbc.ClientDriver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:derby://localhost:1527/Trainer", "app", "app");    //Change the script

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, trainer.getName());
            preparedStatement.setString(2, trainer.getSpecialty());
            preparedStatement.setString(3, trainer.getSports());
            

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