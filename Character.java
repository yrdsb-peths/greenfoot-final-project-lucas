import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    
    
    GreenfootSound heartSound = new GreenfootSound("heartsound.mp3.wav");
    GreenfootImage[] idleRight = new GreenfootImage[4];
    GreenfootImage[] idleLeft = new GreenfootImage[4];
    GreenfootImage[] idleFront = new GreenfootImage[4];
    GreenfootImage[] idleBack = new GreenfootImage[4];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Character()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/character_idle/idle" + i + ".png.png");
            idleRight[i].scale(80, 80);
    
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/character_idle/idle" + i + ".png.png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(80, 80);
        }
        
        for(int i = 0; i < idleFront.length; i++)
        {
            idleFront[i] = new GreenfootImage("images/character_idle_front/idleFront" + i + ".png");
            idleFront[i].scale(80, 80);
        }
        
        for(int i = 0; i < idleBack.length; i++)
        {
            idleBack[i] = new GreenfootImage("images/character_idle_back/idleBack" + i + ".png");
            idleBack[i].scale(80, 80);
        }
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animateCharacter()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
        if(facing.equals("front"))
        {
            setImage(idleFront[imageIndex]);
            imageIndex = (imageIndex + 1) % idleFront.length;
        }
        
        if(facing.equals("back"))
        {
            setImage(idleBack[imageIndex]);
            imageIndex = (imageIndex + 1) % idleBack.length;
        }
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            move(-5);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(5);
            facing = "right";
        }
        else if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY()-5);
            facing = "back";
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()+5);
            facing = "front";
        }// Add your action code here.
        
        collect();
        animateCharacter();
        
        MyWorld world = (MyWorld) getWorld();
        if(world.score == 80 || world.health == 0)
        {
            world.removeObject(this);
        }
        
    }
    
    public void collect()
    {
        if(isTouching(Heart.class))
        {
            removeTouching(Heart.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            heartSound.play();
        }
    }
}
