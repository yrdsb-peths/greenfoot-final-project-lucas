import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    public int health = 3;
    Label healthLabel;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        spawnCharacter();
        
        healthLabel = new Label(3, 80);
        addObject(healthLabel, 50, 50);
        
        spawnGhost();
        spawnGhost();
    }
    
    public void spawnCharacter()
    {
        Character character = new Character();
        addObject(character, 300, 200);
    }
    
    public void decreaseHealth()
    {
        health--;
        healthLabel.setValue(health);
    }
    
    public void spawnGhost()
    {
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(300);
        Ghost ghost = new Ghost();
        addObject(ghost, x, y);
    }
}
