import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The TitleScreen class sets the title page of the game including instructions
 * and the game's name.
 * 
 * @author Lucas Deng 
 * @version June 2022
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Haunted House", 60);

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, 50);
        prepare();
    }
    
    /**
     * The act method allows the player to start the game by pressing the
     * space key. MyWorld Class get set by this method.
     *  
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("Use <a> <d> <w> <s> to Move", 40);
        addObject(label,getWidth()/2,350);
        Label label2 = new Label("Press <space> to Start", 30);
        addObject(label2,getWidth()/2,297);
        Label label3 = new Label("Collect hearts while avoiding randomly moving ghost.", 30);
        addObject(label3,getWidth()/2,110);

        Label label4 = new Label("The ghost movement speed will accelerate", 30);
        addObject(label4,getWidth()/2,140);
        Label label5 = new Label("as the game time increases.", 30);
        addObject(label5,getWidth()/2,170);
        Label label6 = new Label(" Hearts will vanish after a specific period of time;", 30);
        addObject(label6,getWidth()/2,200);
        Label label7 = new Label("gather 30 hearts to win.", 30);
        addObject(label7,getWidth()/2,230);
    }
}
