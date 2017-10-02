/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answersinclass;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
}
