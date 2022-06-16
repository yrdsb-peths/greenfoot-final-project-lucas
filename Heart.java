import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Heart class gets called in MyWorld Class and spawns hearts in the world
 * at random location for the player to collect.
 * 
 * @author Lucas Deng 
 * @version June 2022
 */
public class Heart extends Actor
{
    /**
     *The Heart method sets the time remain of the heart spawned in the world.
     */
    private int timeRemain;
    public Heart()
    {
        timeRemain = 100;
    }
    
    /**
     * The act() method counts down the predetermined remain time once the heart
     * is spawned. When int timeRemain is less than 60, the transparency of the image of the heart
     * gradually increases. When int timeRemain equals 0, object will be removed
     * from the world.
     */
    public void act()
    {
        timeRemain--;
        if (timeRemain == 0){
            getWorld().removeObject(this);
        }
        else if (timeRemain < 60){
            getImage().setTransparency (60 + (timeRemain * 2));
        }
    }
}
