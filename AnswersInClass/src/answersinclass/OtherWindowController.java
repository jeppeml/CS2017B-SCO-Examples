/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answersinclass;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author jeppjleemoritzled
 */
public class OtherWindowController implements Initializable
{

    @FXML
    private Label lblName;

    private MainWindowController parent;
    @FXML
    private ToggleGroup group2;
    
    @FXML
    private ToggleGroup group1;
    
    @FXML
    private Label lblScore;
    @FXML
    private Button btnCalculate;
    
    private int score=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
        // TODO
    }    
    
    public void setParentWindowController(MainWindowController parent)
    {
        this.parent = parent;
        lblName.setText(parent.getName());
    }

    @FXML
    private void clickSaveScore(ActionEvent event)
    {
        parent.addScore("Jeppe", 12);
    }
    

    @FXML
    private void calculateScore(ActionEvent event)
    {
        score=0;
        RadioButton rb1 = (RadioButton)group1.getSelectedToggle();
        RadioButton rb2 = (RadioButton)group2.getSelectedToggle();
        
        if(rb1.getText().equals("Score plus"))
        {
            score++;
        }
        else if (rb1.getText().equals("Score minus"))
        {
            score--;
        }
        
        if(rb2.getText().equals("Score plus"))
        {
            score++;
        }
        else if (rb2.getText().equals("Score minus"))
        {
            score--;
        }
        
        lblScore.setText(score+"");
    }
}
