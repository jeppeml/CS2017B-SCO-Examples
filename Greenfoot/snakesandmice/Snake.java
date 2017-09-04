import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Animal
{
    
    public Snake(boolean isItPoisonous) // Constructor with parameter
    {
        isPoisonous = isItPoisonous;
    }
    
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move(2);
        if(Greenfoot.getRandomNumber(15)<1)
        {
            this.turn(Greenfoot.getRandomNumber(360));
        }
        
        if(Greenfoot.getRandomNumber(1000)<1)
        {
            layEgg();
        }
        
        checkAndEatFood();
        
    }  
    
    public void checkAndEatFood()
    {
       Actor mouse = getOneObjectAtOffset(0, 0, Mouse.class);
       if(mouse != null) {
           // eat the mouse
           getWorld().removeObject(mouse);
       }
    }
    
    public void layEgg()
    {
        
        getWorld().addObject(new SnakeEgg(), this.getX(), this.getY());
    }
}
