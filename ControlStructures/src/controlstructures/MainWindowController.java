/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlstructures;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TextField edtInput;
    @FXML
    private Button button;
    @FXML
    private Label lblTextAdventure;
    @FXML
    private Label lblAgeOutput;
    @FXML
    private TextField edtTextAdventure;
    
    @FXML
    private ListView<String> lstCommands;
    @FXML
    private Button btnAnnoy;
    
    private void evaluateAgeInput()
    {
        String input = edtInput.getText();
        
        int age = Integer.parseInt(input);
        
        boolean isOld = age>17;
        
        if(age>200 || age<0)
        {
            lblAgeOutput.setText("INVALID INPUT, CANNOT COMPUTE");
        }
        else if(!isOld) // will always occur
        {
            lblAgeOutput.setText("You can go to a juvenile facility");
        }
        else
        {
            lblAgeOutput.setText("You can go to jail");
        }
        
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        evaluateAgeInput();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        lstCommands.setItems(getCommandList());
        // TODO
    }    
    
    private ObservableList<String> getCommandList()
    {
        ObservableList<String> list = FXCollections.observableArrayList();
        
        list.add("Try to kill everyone");
        list.add("Try to kill someone");
        list.add("Try to kill orcs");
        
        return list;
    }
    
    private ObservableList<String> getSpellList()
    {
        ObservableList<String> list = FXCollections.observableArrayList();
        
        list.add("1: Spell of immence lightning");
        list.add("2: Fireball of doom");
        list.add("3: Reanimate from blood");
        list.add("4: Summon demon of lesser evil");
        list.add("5: Bahamut");
        
        return list;
    }
    
    private void executeSpell()
    {
        int userInput = Integer.parseInt(edtTextAdventure.getText());
        String youAreDead = "You are dead, WRONG decision!";
        String youLived = "You lived to see another horrible day in the catacombs";
        
        switch (userInput)
        {
            case 1:
                lblTextAdventure.setText(youLived);
                break;
            case 2:
                lblTextAdventure.setText(youAreDead);
                break;
            case 3:
                lblTextAdventure.setText(youAreDead);
                break;
            case 4:
                lblTextAdventure.setText(youLived);
                break;
            case 5:
                lblTextAdventure.setText(youLived);
                break;
            default:
                lblTextAdventure.setText("You suck, please write something sane!");
                break;
        }
    }
    
    @FXML
    private void clickDoIt(ActionEvent event)
    {
        String showSpells = "show spells";
        String showCommands = "show commands";
        String inputCommand = edtTextAdventure.getText().toLowerCase();
        
        if(inputCommand.equals(showSpells))
        {
            lstCommands.setItems(getSpellList());
        }
        else if (inputCommand.equals(showCommands))
        {
            lstCommands.setItems(getCommandList());
        }
        else
        {
            executeSpell();
        }
        
    }

    @FXML
    private void clickAnnoy(ActionEvent event) throws IOException
    {
        for (int i = 0; i < 100; i++)
        {
            Stage primStage = (Stage)lblAgeOutput.getScene().getWindow();
            FXMLLoader fxLoader = new FXMLLoader(
                    getClass().getResource("AnnoyWindow.fxml"));
            Parent root = fxLoader.load();
            root.layoutXProperty().setValue(Math.random()*600);
            root.layoutYProperty().setValue(Math.random()*600);
            Stage stage = new Stage(); // new window
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initOwner(primStage);
            stage.initModality(Modality.WINDOW_MODAL);

            stage.show();
        }
        
    }

    
    
}
