/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentmultiwindows;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jeppjleemoritzled
 */
public class QuestionWindowController implements Initializable
{
    private int score = 0;
    @FXML
    private GridPane gpQuestions;
    
    @FXML
    private Label lblScore;
    
    MainWindowController parentWindow;
    String personName="";
    @FXML
    private Label lblName;
    @FXML
    private ToggleGroup tg1;
    @FXML
    private ToggleGroup tg2;
    @FXML
    private ToggleGroup tg3;
    @FXML
    private ToggleGroup tg5;
    @FXML
    private ToggleGroup tg4;
    @FXML
    private ToggleGroup tg6;
    @FXML
    private ToggleGroup tg7;
    @FXML
    private ToggleGroup tg8;
    @FXML
    private ToggleGroup tg9;
    
    public void setNameAndParent(MainWindowController mwc, String personName)
    {
        parentWindow=mwc;
        this.personName=personName;
        lblName.setText("Participant: "+personName);
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
        // TODO
    }    

    @FXML
    private void clickCalculateScore(ActionEvent event)
    {
        score=0;
        gpQuestions.getChildren().forEach(n->{
            if(n.getClass()==HBox.class)
            {
                ((HBox)n).getChildren().forEach(k->{
                    if(k.getClass()==RadioButton.class)
                    {
                        RadioButton rb = (RadioButton)k;
                        if(rb.selectedProperty().get()==true)
                        {
                            
                            String rbText = rb.textProperty().get().toLowerCase();
                            switch (rbText)
                            {
                                case "agree":
                                    score++;
                                    break;
                                case "disagree":
                                    score--;
                                    break;
                            }
                            
                        }
                    }
                });
            }
        });
        lblScore.textProperty().setValue(""+score);
    }

    @FXML
    private void clickSaveScore(ActionEvent event)
    {
        parentWindow.addParticipantAndScore(personName, score);
        ((Stage)lblScore.getScene().getWindow()).close();
    }
    
}
