/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howtoupdateitem;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainViewController implements Initializable {

    @FXML
    private TableView<Car> tblCars;
    @FXML
    private TableColumn<Car, String> colName;
    @FXML
    private TableColumn<Car, Float> colPrice;
    @FXML
    private ListView<Car> lstCars;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colName.setCellValueFactory((cellFeatures) -> {
            return cellFeatures.getValue().nameProperty();
        }
        );

        colPrice.setCellValueFactory((cellFeatures) -> {
            return cellFeatures.getValue().priceProperty().asObject();
        });
        // Setting color on column in tableview, using updateitem
        // setCellFactory needed only for looks
        colPrice.setCellFactory((TableColumn<Car, Float> param) -> new TableCell<Car, Float>(){
            @Override
            protected void updateItem(Float carPrice, boolean empty) {
                super.updateItem(carPrice, empty); //To change body of generated methods, choose Tools | Templates.
                if (carPrice != null) {
                    Text t = new Text(carPrice + "");
                    Color color = Color.web("red");
                    if (carPrice < 500_000) {
                        color = Color.web("yellow");
                    }
                    else if (carPrice < 450_000) {
                        color = Color.web("green");
                    }
                    t.setStroke(color);
                    setGraphic(t);
                }
            }
        });
        
        // Setting color on listview, usign updateitem
        // setCellFactory needed both for value and looks
        lstCars.setCellFactory((ListView<Car> param)
                -> new ListCell<Car>() {
            @Override
            protected void updateItem(Car item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    Text t = new Text(item.getName() + " | " + item.getPrice());
                    Color color = Color.web("red");
                    if (item.getPrice() < 500_000) {
                        color = Color.web("yellow");
                    }
                    else if (item.getPrice() < 450_000) {
                        color = Color.web("green");
                    }

                    t.setStroke(color);
                    setGraphic(t);
                }
            }
        });

        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            Car c = new Car();
            c.setName("Audi " + (100 + i));
            c.setPrice(r.nextFloat() * 1_000_000 + 15_000);
            tblCars.getItems().add(c);
            lstCars.getItems().add(c);
        }
    }

}
