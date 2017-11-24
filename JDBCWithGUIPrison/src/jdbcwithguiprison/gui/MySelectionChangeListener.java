/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcwithguiprison.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author jeppjleemoritzled
 */
public class MySelectionChangeListener implements ChangeListener{
    MainWindowController controller = new MainWindowController();

    public MySelectionChangeListener( MainWindowController controller) {
        this.controller = controller;
    }
    
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        controller.fillTextFields();
    }
    
}
