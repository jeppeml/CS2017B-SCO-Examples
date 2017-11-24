/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcwithguiprison.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jdbcwithguiprison.BE.Prisoner;

/**
 * FXML Controller class
 *
 * @author jeppjleemoritzled
 */
public class WardenViewController implements Initializable {

    @FXML
    private TableView<Prisoner> tablePrisoners;
    PrisonerModel model;
    
    @FXML
    private TableColumn<Prisoner, String> columnId;
    @FXML
    private TableColumn<Prisoner, String> columnName;
    @FXML
    private TableColumn<Prisoner, String> columnSSN;
    @FXML
    private TableColumn<Prisoner, String> columnNationality;
    @FXML
    private TableColumn<Prisoner, String> columnRace;
    @FXML
    private TableColumn<Prisoner, Integer> columnSentenceLength;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnId.setCellValueFactory(
            new PropertyValueFactory("id"));
        columnName.setCellValueFactory(
            new PropertyValueFactory("name"));
        columnNationality.setCellValueFactory(
            new PropertyValueFactory("nationality"));
        columnRace.setCellValueFactory(
            new PropertyValueFactory("race"));
        columnSSN.setCellValueFactory(
            new PropertyValueFactory("ssn"));
        columnSentenceLength.setCellValueFactory(
            new PropertyValueFactory("sentenceLength"));
    }    

    @FXML
    private void clickLoad(ActionEvent event) {
        model.loadAll();
    }

    public void setModel(PrisonerModel model) {
        this.model = model;
        tablePrisoners.setItems(model.getPrisonersList());
    }
    
}
