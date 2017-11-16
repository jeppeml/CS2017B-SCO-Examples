/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwritebe.dal;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import readwritebe.be.Prisoner;

/**
 *
 * @author jeppjleemoritzled
 */
public class DALManager {

    public ObservableList<Prisoner> getAllPrisoners() throws IOException {

        List<String> allLinesAsStrings = new ArrayList();
        ObservableList<Prisoner> prisoners = 
                FXCollections.observableArrayList();
        
        Path path = Paths.get("Prisoners.csv");
        allLinesAsStrings = Files.readAllLines(path);
        
        allLinesAsStrings.remove(0); // Removes header
        for (String line : allLinesAsStrings) {
                String[] fields = line.split(",");
                Prisoner tempPrisoner = new Prisoner(
                        fields[0], 
                        fields[1], 
                        fields[2], 
                        fields[3], 
                        Integer.parseInt(fields[4]));
                
                prisoners.add(tempPrisoner);
        }
        return prisoners;
        
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
    
}
