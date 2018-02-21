/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcandtransactionswithgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Account c1 = new Account(0, "Jeppe", -256f);
        Account c2 = new Account(324, "Peter", -512f);
        Account c3 = new Account(422, "Hans", 1024f);
        Account c4 = new Account(666, "Adolf", 65536f);
        lstAccounts.getItems().add(c1);
        lstAccounts.getItems().add(c2);
        lstAccounts.getItems().add(c3);
        lstAccounts.getItems().add(c4);
    }    

    @FXML
    private void clickWithdraw(ActionEvent event) {
        float amount = Float.parseFloat(txtAmount.getText());
        updateBalance(amount*-1);
    }

    @FXML
    private void clickDeposit(ActionEvent event) {
        float amount = Float.parseFloat(txtAmount.getText());
        updateBalance(amount);
    }
    
    private void updateBalance(float amount)
    {
        Account selectedAccount = lstAccounts.getSelectionModel()
                .getSelectedItem();
        
        selectedAccount.setBalance(
                selectedAccount.getBalance() + amount);
    }
    
}
