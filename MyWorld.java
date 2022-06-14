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
    
    public int score = 0;
    Label scoreLabel;

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
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 500, 50);
        
        spawnGhost();
    }
    
    public void gameOverFail()
    {
        Label gameOverFailLabel = new Label("You Are Killed By The Ghost :(", 50);
        addObject(gameOverFailLabel, 300, 200);
    }
    
    public void gameOverWin()
    {
        Label gameOverWinLabel = new Label("Win!! :)", 100);
        addObject(gameOverWinLabel, 300, 200);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score == 30)
        {
            gameOverWin();
        }
    }
    
    public void act()
    {
        spawnHeart();
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
        
        if(health == 0)
        {
            gameOverFail(); 
            removeObject(healthLabel);
        }
    }
    
    private void spawnHeart()
    {
        int randNum = Greenfoot.getRandomNumber(40);
        if (randNum == 2){
            int randomX = Greenfoot.getRandomNumber (getWidth());
            int randomY = Greenfoot.getRandomNumber (getHeight());
            addObject (new Heart(), randomX, randomY);
        }
    }
    
    public void spawnGhost()
    {
        int x = Greenfoot.getRandomNumber(200);
        int y = Greenfoot.getRandomNumber(100);
        Ghost ghost = new Ghost();
        addObject(ghost, x, y);
    }
}
