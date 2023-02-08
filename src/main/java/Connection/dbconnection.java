package Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */


public class dbconnection {
    private static Connection con;
    
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ustfits","root","MyNewPass");
          }catch (ClassNotFoundException | SQLException e){
        }
        return con;
    }
}