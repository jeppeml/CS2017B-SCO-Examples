import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakeEgg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeEgg extends Animal
{
    private int hatchAge; // Field variable, visible to all class methods
    
    public SnakeEgg() // constructor
    {
        this.setRotation(Greenfoot.getRandomNumber(360));
        hatchAge = Greenfoot.getRandomNumber(10000)+1000; // Age before hatching
        this.getImage().scale(20, 20);
        
    }
    
    /**
     * Act - do whatever the SnakeEgg wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        
        if(checkIfHatch() == true)
        {
            hatch();
        }
        // Add your action code here.
    }   
    
    public void hatch() // Hatches egg by destroying egg and spawning snake
    {
        Snake newBornSnake = new Snake(false); // Local variable, only available to the hatch method
        newBornSnake.setRotation(this.getRotation());
        getWorld().addObject(newBornSnake, this.getX(), this.getY());
        getWorld().removeObject(this);
        
    }
    
    public boolean checkIfHatch() // Checks if it is time to hatch
    {
        
        if(this.getAge()>hatchAge)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
