/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Jefferson Qiu
 */
public class studentselectlog {
    public ResultSet retrieveData(Connection conn)
    {
        try {
            String query = "SELECT * FROM studentetrylog ";
            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
            
            ResultSet records = ps.executeQuery();
            
            if(records.next()){
                records.beforeFirst();
                return records;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(studentselectlog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
