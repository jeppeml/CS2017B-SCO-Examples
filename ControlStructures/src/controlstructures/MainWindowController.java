/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlstructures;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainWindowController implements Initializable
{
    
    @FXML
    private Label label;
    
    @FXML
    private TextField edtInput;
    
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        
        String input = edtInput.getText();
        int age = -1;
        
        boolean isOld = age>17;
        
        if(!isOld) // will always occur
        {
            label.setText("You can go to a juvinile facility");
        }
        else
        {
            label.setText("You can go to jail");
        }
        
        //
        
        
        System.out.println("You clicked me!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    
    
}
