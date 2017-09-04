import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Animal extends Actor // Animal super class, only for common attrbutes and behavior
{
    private int age;
    private int hp;
    public boolean isPoisonous;
    private int deathAge;
    
    public static String getNameOfClass()
    {
        return "Animal";
    }
    
    public Animal() // Constructor
    {
        age=0;
        hp=100;
        isPoisonous=false;
        setApproxDeathAge(4000);
        
    }
    
    public void setApproxDeathAge(int approxDeathAge) // Method
    {
        deathAge = Greenfoot.getRandomNumber(1500)+approxDeathAge;
        
    }
    
    public int getAge()
    {
        return age;
    }
    
    public int getHP() // Method without parameter, but with return type
    {
        return hp;
    }
    
    public void loseHP(int howMuchHPToLose) // Method with parameter
    {
        hp = hp - howMuchHPToLose;
    }
    
    public boolean getIsPoisonous()
    {
        return isPoisonous;
    }
    
    public void dieIfTooOld()
    {
        if(this.getAge()>deathAge)
        {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Act - do whatever the Animal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        age++;
        
        //dieIfTooOld();
    }    
}
