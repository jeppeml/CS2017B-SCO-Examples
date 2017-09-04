import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Animal extends Actor
{
    int timePassed = 0;
    
    public int getTimePassed()
    {
        return timePassed;
    }
    
    /**
     * Act - do whatever the Animal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timePassed = timePassed + 1;
        // Add your action code here.
    }    
}
