/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbindings;

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
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField txtOne;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button.textProperty().bind(txtOne.textProperty());
        txtOne.setText("Nice button");
        txtOne.textProperty().bindBidirectional(txt2.textProperty());
        txt2.textProperty().bindBidirectional(txt3.textProperty());
        // TODO
    }
    
}
