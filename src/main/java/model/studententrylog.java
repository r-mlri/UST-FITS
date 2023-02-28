package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class studententrylog {
    private final String url = "jdbc:mysql://localhost:3306/ustfits";   //Database
    private final String user = "root";                                  //Database name
    private final String password = "MyNewPass";                              //Database Password

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    private static final String INSERT_STUDENTENTRY_SQL = "INSERT INTO studententrylog" + "  (SN, NAME, ENTRYTYPE, TIMESTAMP) VALUES " +
        " (?, ?, ?, ?);";

    private static final String SELECT_STUDENTENTRY_BY_SN = "select SN,NAME,ENTRYTYPE,TIMESTAMP from studententrylog where SN =?";
    private static final String DELETE_STUDENTENTRY_SQL = "delete from studententrylog where SN = ?;";
    private static final String UPDATE_STUDENTENTRY_SQL = "update studententrylog set NAME = ?,ENTRYTYPE= ?, TIMESTAMP =? where SN = ?;";

    
    public studententrylog(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    public studententrylog() {
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public List<Student> getAllEntry() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM studententrylog";             //The database name for Student
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
                String SN = resultSet.getString("SN");
                String NAME = resultSet.getString("NAME");
                String ENTRYTYPE = resultSet.getString("ENTRYTYPE");
                String TIMESTAMP = resultSet.getString("TIMESTAMP");
                Student entry = new Student(SN, NAME, ENTRYTYPE, TIMESTAMP);
                students.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public void insertEntry(Student entry) throws SQLException {
        System.out.println(INSERT_STUDENTENTRY_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTENTRY_SQL)) {
            preparedStatement.setString(1, entry.getSN());
            preparedStatement.setString(2, entry.getNAME());
            preparedStatement.setString(3, entry.getENTRYTYPE());
            preparedStatement.setString(4, entry.getTIMESTAMP());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public Student selectEntry(int id) {
        Student entry = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTENTRY_BY_SN);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String SN = rs.getString("SN");
                String NAME = rs.getString("NAME");
                String ENTRYTYPE = rs.getString("ENTRYTYPE");
                String TIMESTAMP = rs.getString("TIMESTAMP");
                entry = new Student(SN, NAME, ENTRYTYPE, TIMESTAMP);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return entry;
    }

    public boolean deleteEntry(String SN) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTENTRY_SQL);) {
            statement.setString(1, SN);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public boolean updateEntry(Student student) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTENTRY_SQL);) {
            statement.setString(1, student.getSN());
            statement.setString(2, student.getNAME());
            statement.setString(3, student.getENTRYTYPE());
            statement.setString(4, student.getTIMESTAMP());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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

    public boolean insertData(int ID, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}