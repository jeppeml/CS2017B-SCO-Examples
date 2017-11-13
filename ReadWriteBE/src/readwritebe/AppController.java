/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwritebe;

import java.io.*; // OLD java IO
import java.net.URL;
import java.nio.file.*; // NEW java IO
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        // New
        List<String> allLinesAsStrings = new ArrayList();
        
        Path path = Paths.get("Prisoners.csv");
        try {
            allLinesAsStrings = Files.readAllLines(path);
        }
        catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        allLinesAsStrings.remove(0); // Removes header
        for (String line : allLinesAsStrings) {
                String[] fields = line.split(",");
                Prisoner tempPrisoner = new Prisoner(
                        fields[0], 
                        fields[1], 
                        fields[2], 
                        fields[3], 
                        Integer.parseInt(fields[4]));
                
                lstPrisoners.getItems().add(tempPrisoner);
        }
        
        /*
        // OLD
        // Ensures close of the reader
        // Reads into meory line by line as a Prisoner
        try (BufferedReader br = new BufferedReader(
                new FileReader("Prisoners.csv")))
        {
            Scanner scanner = new Scanner(br);
            scanner.nextLine(); // First line skip
            while(scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                Prisoner tempPrisoner = new Prisoner(
                        fields[0], 
                        fields[1], 
                        fields[2], 
                        fields[3], 
                        Integer.parseInt(fields[4]));
                
                lstPrisoners.getItems().add(tempPrisoner);
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
