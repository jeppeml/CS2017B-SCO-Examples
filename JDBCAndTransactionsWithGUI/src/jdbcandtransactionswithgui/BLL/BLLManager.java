/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcandtransactionswithgui.BLL;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import jdbcandtransactionswithgui.BE.Account;
import jdbcandtransactionswithgui.DAL.AccountDAO;

/**
 *
 * @author jeppjleemoritzled
 */
public class BLLManager {
    private AccountDAO accDAO = new AccountDAO();
    
    public ObservableList<Account> getAllAccounts() throws SQLException {
       return accDAO.getAllAccounts();
    }

    public void addToBalance(Account selectedAccount, float amount) throws SQLException {
        accDAO.addToBalance(selectedAccount, amount);
        
    }
    
}
