import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            move(-5);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(5);
        }
        else if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY()-5);
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()+5);
        }// Add your action code here.
        
        collect();
    }
    
    public void collect()
    {
        if(isTouching(Heart.class))
        {
            removeTouching(Heart.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
        }
    }
}
