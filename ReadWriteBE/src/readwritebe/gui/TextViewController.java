/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwritebe.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import readwritebe.be.Prisoner;
import readwritebe.bll.BLLManager;

/**
 * FXML Controller class
 *
 * @author jeppjleemoritzled
 */
public class TextViewController implements Initializable {

    @FXML
    private TextArea txtOutput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickLoad(ActionEvent event) {
        BLLManager manager = new BLLManager();
        try {
            ObservableList<Prisoner> prisoners =
                    manager.getAllPrisoners();
            for (Prisoner prisoner : prisoners) {
                txtOutput.appendText(
                        prisoner.toString() + "\n");
            }
        }
        catch (IOException ex) {
            Logger.getLogger(TextViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
