import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The class sets up the end game conditions and all game components in the world. 
 * 
 * @author Lucas Deng
 * @version June 2022
 */
public class MyWorld extends World
{
    
    public int health = 3;
    Label healthLabel;
    
    public int score = 0;
    Label scoreLabel;

    /**
     * Constructor for objects of class MyWorld. Spawns Character and Ghost. 
     * healthLabel and scoreLabel added to World.
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
    
    
    /**
     * gameOverFailLabel method will be called when fail condition is
     * detected true.
     */
    public void gameOverFail()
    {
        Label gameOverFailLabel = new Label("You Are Killed By The Ghost :(", 50);
        addObject(gameOverFailLabel, 300, 200);
    }
    
    /**
     * gameOverWind method will be called when win condition is detected ture.
     */
    public void gameOverWin()
    {
        Label gameOverWinLabel = new Label("Win!! :)", 100);
        addObject(gameOverWinLabel, 300, 200);
    }
    
    
    /**
     * The increaseScore() method is called by the Character class if the
     * boolean condition isTouching(Heart.class) is true.
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        //Predetermined condtion of winning when int score equals 30. Makes use of the gameOverWin() method.
        if(score == 30)
        {
            gameOverWin();
        }
    }
    
    /**
     * The act() methods calls the spawnHeart() method to spawn hearts
     * at random coordination in the world.
     */
    public void act()
    {
        spawnHeart();
    }
    
    /**
     * The spawnCharacter() method spawns the character at the middle of the screen.
     */
    public void spawnCharacter()
    {
        Character character = new Character();
        addObject(character, 300, 200);
    }
    
    /**
     * The decreaseHealth() method is called in the Ghost Class if the boolean
     * isTouching(Chracter.class) detected true. Int health decreases by 1.
     */
    public void decreaseHealth()
    {
        health--;
        healthLabel.setValue(health);
        
        /*Predetermined condition of failing when int health equals 0.
         * Makes use of the gameOverFail() method and removes the object.
         */
        if(health == 0)
        {
            gameOverFail(); 
            removeObject(healthLabel);
        }
    }
    
    /**
     * The spawnHeart() method gets called by the act() method. Hearts will 
     * be spawned at random coordination.
     */
    private void spawnHeart()
    {
        int randNum = Greenfoot.getRandomNumber(40);
        if (randNum == 2){
            int randomX = Greenfoot.getRandomNumber (getWidth());
            int randomY = Greenfoot.getRandomNumber (getHeight());
            addObject (new Heart(), randomX, randomY);
        }
    }
    
    /**
     * The spawnGhost() method spawns the ghost at random location when code
     * runs.
     */
    public void spawnGhost()
    {
        int x = Greenfoot.getRandomNumber(200);
        int y = Greenfoot.getRandomNumber(100);
        Ghost ghost = new Ghost();
        addObject(ghost, x, y);
    }
}
