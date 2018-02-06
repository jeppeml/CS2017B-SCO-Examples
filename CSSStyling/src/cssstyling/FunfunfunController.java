/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssstyling;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author jeppjleemoritzled
 */
public class FunfunfunController implements Initializable {

    @FXML
    private TableView<String> tblSomething;
    @FXML
    private TextField test;
    @FXML
    private TableColumn<String, String> colC1;
    @FXML
    private TableColumn<String, String> colC2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        test.textProperty().addListener((e)->{
            System.out.println("RHello");
        });
        
        colC1.setCellFactory(new Callback<TableColumn<String, String>, TableCell<String, String>>() {
            @Override
            public TableCell<String, String> call(TableColumn<String, String> param) {
                return new TableCell<String, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        if(item!=null)
                            super.updateItem(item.toUpperCase(), empty); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                };
            }
        });
        
        tblSomething.getItems().add("Tester");
        
        
    }    
    
}
