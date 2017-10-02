import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Egg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Egg extends Animal
{
    public Egg() // Constructor
    {
        super();
        GreenfootImage eggImage = getImage();
        eggImage.scale(20,20);
    }
    
    private void hatch()
    {
        int randomNumber = Greenfoot.getRandomNumber(2);
            if(randomNumber==1)
            {
                // This will spawn a snake on same position as egg
                getWorld().addObject(new Snake(),getX(),getY());
                // Removes itself from the world
                getWorld().removeObject(this);
            }
    }
    
    /**
     * Act - do whatever the Egg wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Snake.funNumber = 7;
        super.act();
        if(super.getTimePassed()==250)
        {
           hatch();
        }
        
        World w = getWorld();
        int amountOfWorms = w.getObjects(Snake.class).size();
        if(amountOfWorms > 0)
        {
            // SCream
        }
        // Add your action code here.
    }    
}
