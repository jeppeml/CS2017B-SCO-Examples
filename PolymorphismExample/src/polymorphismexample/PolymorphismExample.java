/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphismexample;

import java.util.ArrayList;
import methodoverload.Employee;
import methodoverload.Warehouse;
import polymorphismexample.ISPExample.CableModem;
import polymorphismexample.ISPExample.MB7220;
import polymorphismexample.ISPExample.SB6190;
import polymorphismexample.ISPExample.SBG6580;
import polymorphismexample.textbookexample.Dog;
import polymorphismexample.textbookexample.Cat;

/**
 *
 * @author jeppjleemoritzled
 */
public class PolymorphismExample
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Another method overloading example (constructor)
        Employee jim = new Employee("Jim","393984737");
        jim.setAddress("Somewhere, something");
        jim.setbDate("24-12-00");
        
        Employee jane = new Employee(
                "Jane", "Sometinh", "45939534", "Sit around", "12-12-12");
        
        
        // Method overloading example
        Warehouse warehouse = new Warehouse();
        
        // Fetch all items
        ArrayList<String> items = warehouse.getItems();
        ArrayList<String> someItems = warehouse.getItems(4);
        ArrayList<String> startsItems = warehouse.getItems("M");
        
        for (String item : items)
        {
            System.out.println(item);
        }
        
        for (String item : someItems)
        {
            System.out.println(item);
        }
        
        for (String item : startsItems)
        {
            System.out.println(item);
        }
        
        // ISP Example
        // CableModem type (abstract) variable is holding SBG6580 is concrete
        /*CableModem cmSBG6580 = new SBG6580();
        
        CableModem cmMB7220 = new MB7220();
        
        CableModem cmSB6190 = new SB6190();
        
        ArrayList<CableModem> modems = new ArrayList();
        for (int i = 0; i < 12000; i++)
        {
            modems.add(new MB7220());
            modems.add(new SB6190());
            modems.add(new SBG6580());
        }
        
        for (CableModem modem : modems)
        {
            modem.update("ftp://myfiles.com/firmware2.bin");
        }
        
        System.out.println("Mac: "+ cmSBG6580.getSNMPVersion());
        */
        
        
        // TEXTBOOK EXAMPLE
        /* 
        Dog jack = new Dog();
        Cat samantha = new Cat();
        
        System.out.println("Trying to make them walk");
        System.out.println("Walking the dog:");
        jack.walk();
        jack.makeSound();
        System.out.println("Walking the cat:");
        samantha.walk();
        samantha.makeSound();
        */
    }
    
}
