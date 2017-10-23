/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphismexample;

import java.util.ArrayList;
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
        // ISP Example
        // CableModem type (abstract) variable is holding SBG6580 is concrete
        CableModem cmSBG6580 = new SBG6580();
        
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
