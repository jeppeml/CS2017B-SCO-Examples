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
public class UnitTestingExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car c = new Car("");
        c.setColor("yellow");
        c.setMilage(65_000);
        System.out.println("Price: " + c.getPrice());
               
    }
    
}
