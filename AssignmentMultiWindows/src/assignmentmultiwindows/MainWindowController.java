/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentmultiwindows;

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
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField edtName;
    @FXML
    private ListView<String> lstPart;
    
    
    
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    public void addParticipantAndScore(String participantName, int score)
    {
        lstPart.getItems().add(participantName+" : "+score);
    }
    
    @FXML
    private void clickFillQuestion(ActionEvent event) throws IOException
    {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("QuestionWindow.fxml"));
        
        Parent root = fxLoader.load();
        ((QuestionWindowController)fxLoader.getController()).setNameAndParent(this, edtName.getText());
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }
    
}
