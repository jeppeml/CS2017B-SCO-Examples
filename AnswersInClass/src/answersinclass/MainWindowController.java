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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainWindowController implements Initializable
{
    
    public static void staticMethod()
    {
    }
    
    @FXML
    private Label fnig;
    @FXML
    private Button button;
    @FXML
    private TextField edtName;
    @FXML
    private ListView<String> lstNames;
    
    public void addScore(String name, int score)
    {
        lstNames.getItems().add(
                name +  
                " : " +
                score);
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException
    {
        Stage myNewStage = new Stage(); // new window
        myNewStage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(
            getClass().getResource("OtherWindow.fxml"));
        
        Parent root = fxLoader.load();
        
        OtherWindowController owc = fxLoader.getController();
        owc.setParentWindowController(this);
        
        Scene scene = new Scene(root);
        
        myNewStage.setScene(scene);
        myNewStage.showAndWait();
        
        fnig.setText("Button clicked");
    }
    
    public String getName()
    {
        return edtName.getText();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
