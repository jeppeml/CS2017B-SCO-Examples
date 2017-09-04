import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Animal
{
    private int mouseSize;
    private GreenfootImage mouseImg;
    
    public Mouse()
    {
        mouseSize=10;
        this.getImage().scale(mouseSize, mouseSize);
    }
    
    public void growMouse()
    {
        if(mouseSize<50)
        {
            mouseSize+=4;
            this.setImage(new GreenfootImage("images/mouse.png"));
            this.getImage().scale(mouseSize, mouseSize);
        }
    }
        
    /**
     * Act - do whatever the Mouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();

        move(4);
        if(Greenfoot.getRandomNumber(10)<1)
        {
            this.turn(Greenfoot.getRandomNumber(360));
        }
        
        if(this.getAge()%200==0)
        {
            growMouse();
        }
        
        if(mouseSize>25)
        {
            giveBirth();
        }
        
        checkAndEatFood();
        
        dieIfTooOld();
    }    
    
    public void dieIfTooOld()
    {
        if(this.getAge()>2000)
        {
            getWorld().removeObject(this);
        }
    }
    
    public void giveBirth()
    {
        if(this.getAge()%500==0)
        {
            for(int i=0;i<Greenfoot.getRandomNumber(10);i++)
            {
                getWorld().addObject(new Mouse(), this.getX(), this.getY());
            }
        }
    }
    
    public void checkAndEatFood()
    {
       Actor snakeEgg = getOneObjectAtOffset(0, 0, SnakeEgg.class);
       if(snakeEgg != null) {
           // eat the mouse
           getWorld().removeObject(snakeEgg);
       }
       
       
    }
}
