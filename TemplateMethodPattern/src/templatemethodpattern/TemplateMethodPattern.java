/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatemethodpattern;

/**
 *
 * @author jeppjleemoritzled
 */
public class TemplateMethodPattern
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Person jim = new Janitor(30, 56, "Jim Jungle");
        Person dennis = new Doctor(89, 43, "Dennis Dangle");
        Person peter = new Programmer(0, 99, "Peter Ptegger");
        
        doDay(jim);
        doDay(dennis);
        doDay(peter);
        
        
    }
    
    public static void doDay(Person person)
    {
        person.getOutOfBed();
        person.eatBreakfast();
        person.getDressed();
        person.findWillPower();
        person.goToWork();
        person.goHomeFromWork();
    }
    
}
