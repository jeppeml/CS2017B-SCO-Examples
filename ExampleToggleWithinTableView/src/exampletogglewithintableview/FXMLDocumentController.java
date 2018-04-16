/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampletogglewithintableview;

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
    
    private Label label;
    @FXML
    private TableColumn<?, ?> colA;
    @FXML
    private TableColumn<?, ?> colB;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnHandler(ActionEvent event) {
        Button pressedBtn = ((Button)event.getSource());
        if(pressedBtn.getId().equals("btn1"))
        {
            System.out.println("btn1 pressed");
        }
        else if(pressedBtn.getId().equals("btn2")){
            System.out.println("btn2 pressed");
        }
    }
    
}
