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
import javafx.scene.control.TextField;
import jdbcwithguiprison.bll.BLLManager;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainWindowController implements Initializable {

    @FXML
    private ListView<Prisoner> lstPrisoners;
    
    private final BLLManager bllManager = 
            new BLLManager();
    @FXML
    private TextField txtFilter;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtSSN;
    @FXML
    private TextField txtNationality;
    @FXML
    private TextField txtRace;
    @FXML
    private TextField txtSentenceLength;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickLoadDB(ActionEvent event) {
        List<Prisoner> allPrisoners =
                bllManager.getAllPrisonersByNationality(
                    txtFilter.getText());
        
        lstPrisoners.getItems().clear();
        lstPrisoners.getItems().addAll(allPrisoners);
    }

    @FXML
    private void clickDelete(ActionEvent event) {
        Prisoner selectedPrisoner =
                lstPrisoners.getSelectionModel().getSelectedItem();
        
        bllManager.remove(selectedPrisoner);
        lstPrisoners.getItems().remove(selectedPrisoner);
        
    }

    @FXML
    private void clickAddPrisoner(ActionEvent event) {
        Prisoner prisoner = new Prisoner();
        prisoner.setName(txtName.getText());
        prisoner.setSsn(txtSSN.getText());
        prisoner.setRace(txtRace.getText());
        prisoner.setNationality(txtNationality.getText());
        int sentLength = Integer.parseInt(
                txtSentenceLength.getText());
        prisoner.setSentenceLength(sentLength);
        //lstPrisoners.getItems().add(prisoner);
        
        bllManager.add(prisoner);
        clickLoadDB(event);
    }
    
}
