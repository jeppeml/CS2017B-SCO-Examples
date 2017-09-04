import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        
        // Create a new world with 600x400 cells with a cell size of 2x2 pixels.
        super(600, 400, 2); 
        /*GreenfootImage bg = getBackground();
        bg.scale(20,20);
        
        setBackground(bg);*/
        //getBackground().scale(200,20);
        for(int i=0;i<20;i++)
        {
            Mouse m = new Mouse();
            m.setApproxDeathAge(2000);
            
            addObject(m,20,20);
        }
        
        for(int i=0;i<3;i++)
            addObject(new Snake(true),400,300);
        
            
           // GreenfootImage backgroundImage = new GreenfootImage(600,400);
       
    }
}
