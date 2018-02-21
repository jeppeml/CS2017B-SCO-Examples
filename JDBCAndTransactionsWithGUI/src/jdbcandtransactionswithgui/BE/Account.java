/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcandtransactionswithgui.BE;

import javafx.beans.property.*;

/**
 *
 * @author jeppjleemoritzled
 */
public class Account {

    private final StringProperty name = new SimpleStringProperty();
    private final FloatProperty balance = new SimpleFloatProperty();
    private final IntegerProperty accountNo = new SimpleIntegerProperty();

    public Account() {
    }

    @Override
    public String toString() {
        return accountNo.getValue() + ": " + 
               name.getValue() + "  " + 
               balance.getValue();
    }

    public Account(int accountNo, String name, float balance) {
        this.accountNo.set(accountNo);
        this.name.set(name);
        this.balance.set(balance);
    }
    
    
    public int getAccountNo() {
        return accountNo.get();
    }

    public void setAccountNo(int value) {
        accountNo.set(value);
    }

    public IntegerProperty accountNoProperty() {
        return accountNo;
    }

    public float getBalance() {
        return balance.get();
    }

    public void setBalance(float value) {
        balance.set(value);
    }

    public FloatProperty balanceProperty() {
        return balance;
    }
    
    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }
    
    
}
