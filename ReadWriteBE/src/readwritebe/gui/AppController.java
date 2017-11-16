/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwritebe.gui;

import java.io.*; // OLD java IO
import java.net.URL;
import java.nio.file.*; // NEW java IO
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import readwritebe.be.Prisoner;
import readwritebe.bll.BLLManager;

/**
 *
 * @author jeppjleemoritzled
 */
public class AppController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private ListView<Prisoner> lstPrisoners;
    
    private BLLManager bllManager = new BLLManager();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        ObservableList<Prisoner> prisoners;
        try {
            prisoners = bllManager.getAllPrisoners();
            lstPrisoners.setItems(prisoners);
        }
        catch (FileNotFoundException fnfe)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                "File not found: " + fnfe.getMessage()
                + String.format("%n")
                + "See error log for technical details."
            );
            alert.showAndWait();
        }
        catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                ex.getMessage()
                + String.format("%n")
                + "See error log for technical details."
            );
            alert.showAndWait();
            
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickDelete(ActionEvent event) {
        Prisoner selected = 
                lstPrisoners.getSelectionModel().getSelectedItem();
        
        lstPrisoners.getItems().remove(selected);
        
        try {
            bllManager.saveAllPrisoners(lstPrisoners.getItems());
        }
        catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                ex.getMessage()
                + String.format("%n")
                + "See error log for technical details."
            );
            alert.showAndWait();
            
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
