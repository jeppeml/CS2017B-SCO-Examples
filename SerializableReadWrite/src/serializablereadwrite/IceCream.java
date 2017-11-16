/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializablereadwrite;

import java.io.Serializable;

/**
 *
 * @author jeppjleemoritzled
 */
public class IceCream implements Serializable {
    
    private String consistency;
    private String brand;
    private String flavor;
    private int temp;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }


    public IceCream(String consistency, String brand, String flavor) {
        this.consistency = consistency;
        this.brand = brand;
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    
    public String getConsistency() {
        return consistency;
    }

    public void setConsistency(String consistency) {
        this.consistency = consistency;
    }

    @Override
    public String toString() {
        return "IceCream{" + "consistency=" + consistency + ", brand=" + brand + ", flavor=" + flavor + '}';
    }

}
