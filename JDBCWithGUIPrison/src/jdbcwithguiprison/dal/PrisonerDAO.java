/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcwithguiprison.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbcwithguiprison.BE.Prisoner;

/**
 *
 * @author jeppjleemoritzled
 */
public class PrisonerDAO {

    private ConnectionManager cm = new ConnectionManager();

     public List<Prisoner> getAllPrisonersByNationality(
             String nationality) {
        
        List<Prisoner> allPrisoners
                = new ArrayList();

        try (Connection con = cm.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM Prisoners " +
                            "WHERE nationality LIKE '%"+
                            nationality + "%' " + 
                            " OR "+
                            "[name] LIKE '%" + nationality + "%'");
            while (rs.next()) {
                Prisoner p = new Prisoner();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setNationality(rs.getString("nationality"));
                p.setRace(rs.getString("race"));
                p.setSentenceLength(rs.getInt("sentencelength"));
                p.setSsn(rs.getString("ssn"));
                
                allPrisoners.add(p);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(PrisonerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allPrisoners; 
         
     }
    
    public List<Prisoner> getAllPrisoners() {
        List<Prisoner> allPrisoners
                = new ArrayList();

        try (Connection con = cm.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM Prisoners");
            while (rs.next()) {
                Prisoner p = new Prisoner();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setNationality(rs.getString("nationality"));
                p.setRace(rs.getString("race"));
                p.setSentenceLength(rs.getInt("sentencelength"));
                p.setSsn(rs.getString("ssn"));
                
                allPrisoners.add(p);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(PrisonerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allPrisoners;
    }
}
