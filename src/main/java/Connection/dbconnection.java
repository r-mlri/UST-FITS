package Connection;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */


public class dbconnection {
    //private static Connection con;
    
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ustfits","root","MyNewPass");
          }catch (ClassNotFoundException e){
                e.printStackTrace(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}