import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TurnElephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrunkElephant extends StraightElephant
{
    /**
     * Act - do whatever the TurnElephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        turn(45);
        // Add your action code here.
    }    
}
