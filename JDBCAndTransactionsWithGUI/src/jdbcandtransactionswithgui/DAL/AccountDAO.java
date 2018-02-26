/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcandtransactionswithgui.DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jdbcandtransactionswithgui.BE.Account;

/**
 *
 * @author jeppjleemoritzled
 */
public class AccountDAO {

    private static SQLServerDataSource ds
            = new SQLServerDataSource();

    public AccountDAO() {
        ds.setDatabaseName("CS2017B_39_FraadBank");
        ds.setUser("CS2017A_39_java");
        ds.setPassword("javajava");
        ds.setPortNumber(1433);
        ds.setServerName("10.176.111.31");
    }

    public ObservableList<Account> getAllAccounts() throws SQLServerException, SQLException {

        ObservableList<Account> accounts
                = FXCollections.observableArrayList();

        String sql = "SELECT * FROM Accounts";
        Connection con = ds.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Account acc = new Account(
                    rs.getInt("AccountNo"),
                    rs.getString("Name"),
                    rs.getFloat("Balance"));
            accounts.add(acc);
        }

        try {
            Thread.sleep(0);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return accounts;
    }

    private float getBalance(int accountNo, Connection con)
            throws SQLException {
        String sqlQuery = "SELECT Balance FROM Accounts "
                + "WHERE AccountNo=?";
        PreparedStatement pstmt = con.prepareStatement(sqlQuery);
        pstmt.setInt(1, accountNo);
        ResultSet rs = pstmt.executeQuery();
        rs.next(); // Select first row
        return rs.getFloat("Balance");
    }

    
    private void setBalance(int accountNo,
        float newBalance, Connection con) throws SQLException {
        String sql = "UPDATE Accounts SET balance=? "
                + "WHERE accountno=?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setFloat(1, newBalance);
        pstmt.setInt(2, accountNo);
        pstmt.execute();
    }

    public void addToBalance(Account selectedAccount, float amount) throws SQLException {

        try (Connection con = ds.getConnection()) {
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            float currentBalance = getBalance(
                    selectedAccount.getAccountNo(), 
                    con);
            
            setBalance(
                    selectedAccount.getAccountNo(), 
                    currentBalance + amount, 
                    con);
            
            try {
                con.commit();
            }
            catch (SQLException ex) {
                con.rollback();
                System.out.println("Rolling, rolling, rolling.");
            }
        }
    }

}
