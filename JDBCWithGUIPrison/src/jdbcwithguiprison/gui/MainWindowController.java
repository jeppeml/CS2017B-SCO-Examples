/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcwithguiprison.gui;

import jdbcwithguiprison.BE.Prisoner;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import jdbcwithguiprison.bll.BLLManager;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainWindowController implements Initializable {

    @FXML
    private ListView<Prisoner> lstPrisoners;
    
    private BLLManager bllManager = 
            new BLLManager();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickLoadDB(ActionEvent event) {
        
        List<Prisoner> allPrisoners =
                bllManager.getAllPrisoners();
        
        lstPrisoners.getItems().addAll(allPrisoners);
    }
    
}
