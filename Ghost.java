import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Ghost Class is called in the MyWorld Class. The class is spawned randomly
 * in the world and granted with random movement and action. The moving speed 
 * increases as the game time increase.
 * 
 * @author Lucas Deng
 * @version June 2022
 */
public class Ghost extends Actor
{
    int rightSideOfScreen;
    int bottomOfScreen;
    
    int speed = 3;
    
    private int timer = 0;

    
    GreenfootSound damageSound = new GreenfootSound("damagesound.mp3.wav");
    GreenfootImage[] ghostIdle = new GreenfootImage[6];
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    public void addedToWorld(World MyWorld)
    {
        rightSideOfScreen = MyWorld.getWidth() - 1;
        bottomOfScreen = MyWorld.getHeight() - 1;
    }
    
    /**
     * The Ghost method sets the idle image for the ghost with given size. 
     * 
     * @return nothing
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

    /**
     * The animateGhost method sets the image of the animation of the Ghost Class.
     * It sets the speed of the Ghost's animation using a timer with a pre-set speed
     * of 200 milliseconds.
     * 
     * @return nothing
     */
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
        
    
    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment. The act method
     * adjust the moving speed and touching conditions of the ghost.
     * 
     * @return nothing
     */
    public void act()
    {
        timer++;
        
        /*
         * The ghost accelerates as the predetermined int variable timer increase. 
         * When int speed equals 9, speed maintains at 9.
         */
        if(timer % 300 == 0)
        {
            speed++;
            if(speed >= 9)
            {
                speed = 9;
            }
        }
 
        move(speed);
        
        //Difficulty increases by randomly turning around.
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
        
        /*
         * When the class reaches the realm of the  world, it turns 180 degrees.
         * It checks whether boolean isTouching(Character.class) equals true; If
         * the condition is true, Chracter Class will be removed and spawn a new 
         * Character Class at the middle of the world and turns 180 degrees
         * preventing multiple damages.
         */
        if(isTouching(Character.class))
        {
            removeTouching(Character.class);
            MyWorld world = (MyWorld) getWorld();
            world.decreaseHealth();
            world.spawnCharacter();
            damageSound.play();
            turn(180);
        }
        
        //Object removed when score equals 30.
        MyWorld world = (MyWorld) getWorld();
        if(world.score == 30 || world.health == 0)
        {
            world.removeObject(this);
        }
    }
}
