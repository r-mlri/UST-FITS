/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerDAO {
    private final String url = "jdbc:mysql://localhost:3306/ustfits";   //Database
    private final String user = "root";                                  //Database name
    private final String password = "MyNewPass";                              //Database Password

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public TrainerDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        String query = "SELECT * FROM ustfits/trainers";             //The database name is Trainer
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialty = resultSet.getString("specialty");
                String sports = resultSet.getString("sports");
                Trainer trainer = new Trainer(id, name, specialty, sports);
                trainers.add(trainer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainers;
    }

    public Trainer getTrainerById(int id) {
        String query = "SELECT * FROM app.Trainer WHERE id = ?";            //The database name is Trainer
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String specialty = resultSet.getString("specialty");
                    String sports = resultSet.getString("sports");
                    Trainer trainer = new Trainer(id, name, specialty, sports);
                    return trainer;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addTrainer(Trainer trainer) {
        String query = "INSERT INTO app.Trainer (name, specialty, sports) VALUES (?, ?, ?)";        //The database name is Trainer
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, trainer.getName());
            statement.setString(2, trainer.getSpecialty());
            statement.setString(3, trainer.getSports());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTrainer(Trainer trainer) {
        String query = "UPDATE app.Trainer SET name = ?, specialty = ?, sports = ? WHERE id = ?";   //The database name is Trainer
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, trainer.getName());
            statement.setString(2, trainer.getSpecialty());
            statement.setString(3, trainer.getSports());
            statement.setInt(4, trainer.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTrainer(int id) {
        String query = "DELETE FROM app.Trainer WHERE id = ?";                      //The database name is Trainer
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

public boolean saveTrainer(Trainer trainer) {
    if (trainer.getId() == 0) {
        // trainer is new, create new record in database
        return addTrainer(trainer);
    } else {
        // trainer already exists, update existing record in database
        return updateTrainer(trainer);
    }
}

public Trainer getTrainer(int id) {
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM trainers WHERE id = ?")) {           //The database name is Trainer
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Trainer trainer = new Trainer();
                trainer.setId(rs.getInt("id"));
                trainer.setName(rs.getString("name"));
                trainer.setSpecialty(rs.getString("specialty"));
                trainer.setSports(rs.getString("sports"));
                return trainer;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}