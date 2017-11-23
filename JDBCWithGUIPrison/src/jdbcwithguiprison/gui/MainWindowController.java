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
    
    PrisonerModel model = new PrisonerModel();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstPrisoners.setItems(model.getPrisonersList());
    }    

    @FXML
    private void clickLoadDB(ActionEvent event) {
        model.loadAll();
    }

    @FXML
    private void clickDelete(ActionEvent event) {
        Prisoner selectedPrisoner =
                lstPrisoners.getSelectionModel().getSelectedItem();
        
        model.remove(selectedPrisoner);
    }

    @FXML
    private void clickAddPrisoner(ActionEvent event) {
        Prisoner prisoner = new Prisoner();
        prisoner.setId(-1);
        prisoner.setName(txtName.getText());
        prisoner.setSsn(txtSSN.getText());
        prisoner.setRace(txtRace.getText());
        prisoner.setNationality(txtNationality.getText());
        int sentLength = Integer.parseInt(
                txtSentenceLength.getText());
        prisoner.setSentenceLength(sentLength);
        //lstPrisoners.getItems().add(prisoner);
        
        model.add(prisoner);
    }
    
}
