/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcandtransactionswithgui.GUI;

import jdbcandtransactionswithgui.BE.Account;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import jdbcandtransactionswithgui.BLL.BLLManager;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainWindowController implements Initializable {

    private Label label;
    @FXML
    private TextField txtAmount;
    @FXML
    private TextField txtAccountNo;
    @FXML
    private ListView<Account> lstAccounts;

    private final BLLManager bll = new BLLManager();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Thread t = new Thread(() -> {
            try {
                ObservableList<Account> accList;
                accList = bll.getAllAccounts();
                
                Platform.runLater(() -> {
                    lstAccounts.setItems(accList);
                });
            }
            catch (SQLException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        );

        t.start();
        

    }

    @FXML

    private void clickWithdraw(ActionEvent event) throws SQLException {
        float amount = Float.parseFloat(txtAmount.getText());
        updateBalance(amount * -1);
        lstAccounts.refresh();
    }

    @FXML
    private void clickDeposit(ActionEvent event) throws SQLException {
        float amount = Float.parseFloat(txtAmount.getText());
        updateBalance(amount);
        lstAccounts.refresh();

    }

    private void updateBalance(float amount) throws SQLException {
        Account selectedAccount = lstAccounts.getSelectionModel()
                .getSelectedItem();
        
        bll.addToBalance(selectedAccount, amount);
        
        selectedAccount.setBalance(
                selectedAccount.getBalance() + amount);
        
        
    }

}
