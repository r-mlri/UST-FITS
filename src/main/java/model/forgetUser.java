
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */


public class forgetUser {
   public boolean check(String username, String resetpin) throws ClassNotFoundException, SQLException
   {
       String url = "jdbc:mysql://localhost:3306/ustfits/accounts";
       String conusername = "root";
       String conpassword = "MyNewPass";
       
       String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME=? AND RESETPIN=?";
       
       try {
       Class.forName("org.apache.derby.jdbc.ClientDriver");
       Connection con = DriverManager.getConnection(url, conusername, conpassword);
       PreparedStatement st = con.prepareStatement(sql);
       st.setString(1, username);
       st.setString(2, resetpin);
               
       ResultSet rs = st.executeQuery();
       
       if(rs.next())
       {
           return true;
       }
       
       }
       catch(Exception e) {
           e.printStackTrace();
       }
 
       return false;
       
   }
   
}
