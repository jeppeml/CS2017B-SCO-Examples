/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcwithguiprison.gui;

import com.sun.javafx.property.adapter.PropertyDescriptor;
import java.io.IOException;
import jdbcwithguiprison.BE.Prisoner;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jdbcwithguiprison.bll.BLLManager;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainWindowController implements Initializable {

    @FXML
    private ListView<Prisoner> lstPrisoners;

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
       
        
        // One way of doing it
        lstPrisoners.getSelectionModel()
                .selectedItemProperty().addListener(
                    new ChangeListener() {
                        @Override
                        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                            fillTextFields();
                        }
                }
                );
        
        // Another way of doing it
//         MySelectionChangeListener listener =
//                new MySelectionChangeListener(this);
//         lstPrisoners.getSelectionModel()
//                .selectedItemProperty().addListener(listener);
//         
         // Third way of doing it
        lstPrisoners.getSelectionModel()
            .selectedItemProperty()
                .addListener(
                    (obs,oldVal,newVal)->{fillTextFields();}
                );

        lstPrisoners.setItems(model.getPrisonersList());
        try {
            Stage newStage = new Stage();
            FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("WardenView.fxml"));

            Parent root = fxLoader.load();
            WardenViewController controller
                    = fxLoader.getController();

            controller.setModel(model);

            Scene scene = new Scene(root);
            newStage.setScene(scene);
            newStage.show();
        }
        catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickLoadDB(ActionEvent event) {
        model.loadAll();
    }

    @FXML
    private void clickDelete(ActionEvent event) {
        Prisoner selectedPrisoner
                = lstPrisoners.getSelectionModel().getSelectedItem();

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

        model.add(prisoner);
    }

    public void fillTextFields() {
        Prisoner selectedPrisoner
                = lstPrisoners.getSelectionModel().getSelectedItem();

        txtName.setText(selectedPrisoner.getName());
        txtSSN.setText(selectedPrisoner.getSsn());
        txtRace.setText(selectedPrisoner.getRace());
        txtNationality.setText(selectedPrisoner.getNationality());
        txtSentenceLength.setText(
                selectedPrisoner.getSentenceLength() + "");
    }

    @FXML
    private void clickUpdate(ActionEvent event) {

    }

}
