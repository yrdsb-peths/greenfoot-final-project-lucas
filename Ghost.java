import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    int rightSideOfScreen;
    int bottomOfScreen;
    
    GreenfootSound damageSound = new GreenfootSound("damagesound.mp3.wav");
    GreenfootImage[] ghostIdle = new GreenfootImage[6];
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    public void addedToWorld(World MyWorld)
    {
        rightSideOfScreen = MyWorld.getWidth() - 1;
        bottomOfScreen = MyWorld.getHeight() - 1;
    }
    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Ghost()
    {
        for(int i = 0; i < ghostIdle.length; i++)
        {
            ghostIdle[i] = new GreenfootImage("images/ghost_idle/ghost_idle" + i + ".png");
            ghostIdle[i].scale(80, 80);
    
        }
        
        animationTimer.mark();
        
        setImage(ghostIdle[0]);
    }
    
    int imageIndex = 0;
    public void animateGhost()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        
        setImage(ghostIdle[imageIndex]);
        imageIndex = (imageIndex + 1) % ghostIdle.length;
    }
        
    
    public void act()
    {
        move(5);
        if(Greenfoot.getRandomNumber(20) == 1)
        {
            setRotation(Greenfoot.getRandomNumber(360));
        }
        
        int x = getX();
        int y = getY();
        
        if(x <= 0 || y <= 0 || x >= rightSideOfScreen || y >= bottomOfScreen)
        {
            turn(180);
        }
        
        if(isTouching(Character.class))
        {
            removeTouching(Character.class);
            MyWorld world = (MyWorld) getWorld();
            world.decreaseHealth();
            world.spawnCharacter();
            damageSound.play();
        }
        
        MyWorld world = (MyWorld) getWorld();
        if(world.score == 30 || world.health == 0)
        {
            world.removeObject(this);
        }
        // Add your action code here.
    }

}
