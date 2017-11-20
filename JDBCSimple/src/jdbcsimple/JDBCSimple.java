/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcsimple;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeppjleemoritzled
 */
public class JDBCSimple {

    private static ConnectionManager cm = 
            new ConnectionManager();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        printAllPrisoners();
        printAllCanadianPrisoners();
        
        
        System.out.println("Finished...");
        
        // TODO code application logic here
    }
    private static void printAllCanadianPrisoners()
    {
        System.out.println("Trying to connect");
        try (Connection con = cm.getConnection();){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM Prisoners WHERE nationality='Canada'");
            while(rs.next())
            {
                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name")  + "\t" +
                        rs.getString("nationality"));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(JDBCSimple.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void printAllPrisoners()
    {
        System.out.println("Trying to connect");
        try (Connection con = cm.getConnection();){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM Prisoners");
            while(rs.next())
            {
                System.out.println(
                        rs.getString("name") + "\t" +
                        rs.getInt("id"));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(JDBCSimple.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
