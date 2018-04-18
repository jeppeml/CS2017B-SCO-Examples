/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howtoupdateitem;

import javafx.beans.property.*;

/**
 *
 * @author jeppjleemoritzled
 */
public class Car {

    private final StringProperty name = new SimpleStringProperty();
    private final FloatProperty price = new SimpleFloatProperty();

    public float getPrice() {
        return price.get();
    }

    public void setPrice(float value) {
        price.set(value);
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }
    
}
