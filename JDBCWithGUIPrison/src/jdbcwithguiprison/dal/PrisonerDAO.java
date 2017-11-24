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

        List<Prisoner> allPrisoners = new ArrayList();

        try (Connection con = cm.getConnection()) {
            // No good when having userinput, because SQL injection
//            Statement stmt = con.createStatement();

            String query
                    = "SELECT * FROM Prisoners "
                    + "WHERE nationality LIKE ? "
                    + "ORDER BY id DESC";

            // Protect against SQL injection
            PreparedStatement pstmt
                    = con.prepareStatement(query);
            pstmt.setString(1, "%" + nationality + "%");

            ResultSet rs = pstmt.executeQuery();
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
            Logger.getLogger(PrisonerDAO.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return allPrisoners;

    }

    public List<Prisoner> getAllPrisoners() {
        List<Prisoner> allPrisoners
                = new ArrayList();

        try (Connection con = cm.getConnection()) {
            PreparedStatement stmt
                    = con.prepareStatement("SELECT * FROM Prisoners");
            ResultSet rs = stmt.executeQuery();
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
            Logger.getLogger(PrisonerDAO.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return allPrisoners;
    }

    public void remove(Prisoner selectedPrisoner) {
        try (Connection con = cm.getConnection()) {
            String sql
                    = "DELETE FROM Prisoners WHERE id=?";
            PreparedStatement pstmt
                    = con.prepareStatement(sql);
            pstmt.setInt(1, selectedPrisoner.getId());
            pstmt.execute();
        }
        catch (SQLException ex) {
            Logger.getLogger(PrisonerDAO.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    public void add(Prisoner prisoner) {
        try (Connection con = cm.getConnection()) {
            String sql
                    = "INSERT INTO Prisoners"
                    + "(name, ssn, nationality, race, sentencelength) "
                    + "VALUES(?,?,?,?,?)";
            PreparedStatement pstmt
                    = con.prepareStatement(
                            sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, prisoner.getName());
            pstmt.setString(2, prisoner.getSsn());
            pstmt.setString(3, prisoner.getNationality());
            pstmt.setString(4, prisoner.getRace());
            pstmt.setInt(5, prisoner.getSentenceLength());

            int affected = pstmt.executeUpdate();
            if (affected<1)
                throw new SQLException("Prisoner could not be added");

            // Get database generated id
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                prisoner.setId(rs.getInt(1));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(PrisonerDAO.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    public void update(Prisoner prisoner) {
        try (Connection con = cm.getConnection()) {
            String sql
                    = "UPDATE Prisoners SET "
                    + "name=?, ssn=?, nationality=?, race=?, sentencelength=? "
                    + "WHERE id=?";
            PreparedStatement pstmt
                    = con.prepareStatement(sql);
            pstmt.setString(1, prisoner.getName());
            pstmt.setString(2, prisoner.getSsn());
            pstmt.setString(3, prisoner.getNationality());
            pstmt.setString(4, prisoner.getRace());
            pstmt.setInt(5, prisoner.getSentenceLength());
            pstmt.setInt(6, prisoner.getId());

            int affected = pstmt.executeUpdate();
            if (affected<1)
                throw new SQLException("Prisoner could not be updated");

        }
        catch (SQLException ex) {
            Logger.getLogger(PrisonerDAO.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
}
