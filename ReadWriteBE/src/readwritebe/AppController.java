/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwritebe;

import java.net.URL;
import java.nio.file.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 *
 * @author jeppjleemoritzled
 */
public class AppController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private ListView<Prisoner> lstPrisoners;
    
  
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
        Prisoner peter = new Prisoner("343-455-843", "Peter Stegger", 
                "Arab", "Saudi Arabia", 400);
        Path path = Paths.get("Prisoners.csv");
        if(Files.isReadable(path))
            System.out.println("File is readable");
        
        lstPrisoners.getItems().add(peter);
        
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
