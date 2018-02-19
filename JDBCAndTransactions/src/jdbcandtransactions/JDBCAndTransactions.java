/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcandtransactions;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeppjleemoritzled
 */
public class JDBCAndTransactions {

    private static SQLServerDataSource ds
            = new SQLServerDataSource();

    private static void setupDB() {
        ds.setDatabaseName("CS2017B_39_FraadBank");
        ds.setUser("CS2017A_39_java");
        ds.setPassword("javajava");
        ds.setPortNumber(1433);
        ds.setServerName("10.176.111.31");
    }

    private static float getBalance(int accountNo, Connection con)
            throws SQLException {
        String sqlQuery = "SELECT Balance FROM Accounts "
                + "WHERE AccountNo=?";
        PreparedStatement pstmt = con.prepareStatement(sqlQuery);
        pstmt.setInt(1, accountNo);
        ResultSet rs = pstmt.executeQuery();
        rs.next(); // Select first row
        return rs.getFloat("Balance");
    }

    private static void setBalance(int accountNo,
            float newBalance, Connection con) throws SQLException {
        String sql = "UPDATE Accounts SET balance=? "
                + "WHERE accountno=?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setFloat(1, newBalance);
        pstmt.setInt(2, accountNo);
        pstmt.execute();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        setupDB();
        try (Connection con = ds.getConnection()) {
            con.setAutoCommit(false); // enables transactions

            float soniaBalance = getBalance(3, con);
            float ronicaBalance = getBalance(12, con);

            setBalance(3, soniaBalance - 10000, con);
            setBalance(12, ronicaBalance + 10000, con);

            con.commit();
            System.out.println("All good!");
        }
        catch (SQLException ex) {
            Logger.getLogger(JDBCAndTransactions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
