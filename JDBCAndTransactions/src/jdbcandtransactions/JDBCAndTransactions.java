/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcandtransactions;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.Random;
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

    private static void transferMoney(int from, int to,
            float amount) {
        try (Connection con = ds.getConnection()) {
            con.setAutoCommit(false); // enables transactions
            con.setTransactionIsolation(
                    Connection.TRANSACTION_REPEATABLE_READ);
            Random r = new Random();
            float fromBalance = getBalance(3, con);
            try {
                Thread.sleep(r.nextInt(300));
            }
            catch (InterruptedException ex) {
                Logger.getLogger(JDBCAndTransactions.class.getName()).log(Level.SEVERE, null, ex);
            }
            float toBalance = getBalance(12, con);

            setBalance(from, fromBalance - amount, con);
            setBalance(to, toBalance + amount, con);
            try
            {
                con.commit();
            }
            catch (SQLServerException sse)
            {
                System.out.println("Mo' threads mo problems... Rolling back...");
                con.rollback();
            }
            
            System.out.println("All good!");
        }
        catch (SQLException ex) {
            Logger.getLogger(JDBCAndTransactions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        setupDB();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    transferMoney(12, 3, 30000);
                    transferMoney(3, 12, 30000);
                }

            });
            t.start();
        }
        while (true) {
            Thread.sleep(500);
            System.out.println("Running...");
        }

    }

}
