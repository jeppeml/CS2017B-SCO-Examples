import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Animal
{
    private int eggsLayed = 0;
    
    public void die()
    {
        getWorld().removeObject(this);
    }
    
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move(2);
        
        int randomNumber = Greenfoot.getRandomNumber(15);
        
        if(randomNumber<1)
        {
            int randomTurn = Greenfoot.getRandomNumber(360);
            turn(randomTurn);
        }
        
        if(super.getTimePassed()%500==0)
        {
            Egg newEgg = new Egg();
            getWorld().addObject(newEgg, getX(), getY());
            eggsLayed = eggsLayed +1;
            if(eggsLayed == 3)
            {
                die();
            }
        }
        
        // Add your action code here.
    }    
}
