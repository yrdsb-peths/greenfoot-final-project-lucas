import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Character class is the class that allows player interaction. The player
 * utilizes keys w, a, s, d to enable the game character to move around the world.
 * 
 * @author Lucas Deng
 * @version June 2022
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
     *It stores the code for animating the character in different direcrion.
     * 
     * @return nothing
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
    
    /**
     * This method utilizes the setImage method to animate Character. It uses
     * a timer to set the speed of animation. The 4 sets of animation images 
     * are set and animated according to the facing of the Character.
     * 
     * @Return animation time.
     */
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
    
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment. It stores the
     * facing condition based on the command given by the player via keys w,a,s,d,
     * and passes the string value back to the method animateCharacter() in order
     * to animte the character. The act method makes use of the animateCharacter()
     * method.
     * 
     * @return nothing
     */
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
        }
        
        collect();
        animateCharacter();
        
        MyWorld world = (MyWorld) getWorld();
        if(world.score == 30 || world.health == 0)
        {
            world.removeObject(this);
        }
        
    }
    
    /**
     * The collect() method detects the boolean isTouching, which check whether
     * the Character class is touching the Heart Class. If the boolean condition
     * is true, the Heart Class will be removes, the score increase by 1 while
     * playing the audio heartSound.
     * 
     * @return boolan isTouching of Heart Class.
     */
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
