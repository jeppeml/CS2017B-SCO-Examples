/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittestingexample;

/**
 *
 * @author jeppjleemoritzled
 */
public class Car {
    
    private String color;
    
    private double milage;
    private double basePrice;
    
    public double getPrice()
    {
        switch (color.toLowerCase()) {
            case "yellow":
                basePrice = 10_000f;
                break;
            case "red":
                basePrice = 15_000f;
                break;
            case "blue":
                basePrice = 12_500f;
                break;
            default:
                break;
        }
        double div = milage/44_000f;
        return basePrice/div;
    }

    /**
     * Get the value of milage
     *
     * @return the value of milage
     */
    public double getMilage() {
        return milage;
    }

    /**
     * Set the value of milage
     *
     * @param milage new value of milage
     */
    public void setMilage(double milage) {
        this.milage = milage;
    }


    /**
     * Get the value of color
     *
     * @return the value of color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the value of color
     *
     * @param color new value of color
     */
    public void setColor(String color) {
        this.color = color;
    }

}
