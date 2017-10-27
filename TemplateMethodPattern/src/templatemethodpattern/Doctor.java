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
class Doctor extends Person
{
    public Doctor(int tiredness, int health, String name)
    {
        super(tiredness, health, name);
    }
    @Override
    public void findWillPower()
    {
        System.out.println(getName() + ": Doing loads of coke, feeling GREEEAT!");
        setHealth(getHealth()-10);
    }

    @Override
    public void goHomeFromWork()
    {
        System.out.println(getName() + ": drives home in mercedes, like a pro, only hit 2 old ladies on the way home");
    }

    @Override
    public void goToWork()
    {
        System.out.println(getName() + ": drives to work in mercedes, like a pro, although hit neighbors dog on his way");
    }
    
    
}
