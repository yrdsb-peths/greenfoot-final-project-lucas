import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    
    private int targetX, targetY;
    private boolean targetAcquired;
    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    public void act()
    {
        trackTarget();
        
        MyWorld world = (MyWorld)getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
            world.spawnGhost();
        }
        else if(getX() >= world .getWidth())
        {
            world.removeObject(this);
            world.spawnGhost();
        }
        
        removeTouching(Character.class);// Add your action code here.
    }
    
    public void trackTarget()
    {
        int x = getX() + speed;
        int y = getY() + speed;
        
        Character c = getWorld().getObjects(Character.class).get(0);

        targetX = c.getX();
        targetY = c.getY();
        
        if(targetX < x && targetY < y)
        {
            setLocation(x - targetX,y - targetY);
        }
        else if(targetX > x && targetY < y)
        {
            setLocation(x + targetX,y - targetY);
        }
        else if(targetX < x && targetY > y)
        {
            setLocation(x - targetX,y + targetY);
        }
        else if(targetX > x && targetY > y)
        {
            setLocation(x + targetX,y + targetY);
        }
    }
}
