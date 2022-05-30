import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timeRemain;
    public Heart()
    {
        timeRemain = 100;
    }
    
    public void act()
    {
        timeRemain--;
        if (timeRemain == 0){
            getWorld().removeObject(this);
        }
        else if (timeRemain < 60){
            getImage().setTransparency (60 + (timeRemain * 2));
        }// Add your action code here.
    }
}
