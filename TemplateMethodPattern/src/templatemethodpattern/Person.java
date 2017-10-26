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
abstract class Person
{
    private int tiredness;
    private int health;
    private String name;

    public Person(int tiredness, int health, String name)
    {
        this.tiredness = tiredness;
        this.health = health;
        this.name = name;
    }
    
    public void getOutOfBed()
    {
        System.out.println(name + ": Getting out of bed");
    }
    
    public void eatBreakfast()
    {
        System.out.println(name + ": Eating breakfast");
    }
    
    public void getDressed()
    {
        System.out.println(name + ": Getting dressed");
    }
    
    public void findWillPower()
    {
        System.out.println(name + ": Finding willpower by staring hopelessly into mirror, contemplating on self image, etc.");
    }
    
    public void goToWork()
    {
        System.out.println(name + ": Cannot go to work, unemployed bum, should have done better in school");
    }
    
    public void goHomeFromWork()
    {
        System.out.println(name + ": Still at home, haven't got a job");
    }
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }


    /**
     * Get the value of health
     *
     * @return the value of health
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Set the value of health
     *
     * @param health new value of health
     */
    public void setHealth(int health)
    {
        this.health = health;
    }


    /**
     * Get the value of tiredness
     *
     * @return the value of tiredness
     */
    public int getTiredness()
    {
        return tiredness;
    }

    /**
     * Set the value of tiredness
     *
     * @param tiredness new value of tiredness
     */
    public void setTiredness(int tiredness)
    {
        this.tiredness = tiredness;
    }

}
