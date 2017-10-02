/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answersinclass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainWindowController implements Initializable
{
    
    @FXML
    private Label fnig;
    @FXML
    private Button button;
    @FXML
    private TextField edtName;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException
    {
        Stage myNewStage = new Stage(); // new window
        myNewStage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(
            getClass().getResource("OtherWindow.fxml"));
        
        Parent root = fxLoader.load();
        
        OtherWindowController owc = fxLoader.getController();
        owc.myMethod(edtName.getText());
        
        Scene scene = new Scene(root);
        
        myNewStage.setScene(scene);
        myNewStage.showAndWait();
        
        fnig.setText("Button clicked");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
