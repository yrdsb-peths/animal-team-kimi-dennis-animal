import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TitleScreen
 * 
 * @Kimi
 * @May 6
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2,200);
        prepare();
    }

    public void act() 
    {    
        if(Greenfoot.isKeyDown("space")) 

        { 
            MyWorld gameWorld = new MyWorld(); 
            Greenfoot.setWorld(gameWorld) ;
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,502,105);
        Label label = new Label("Use \u2190 and \u2192 to Move", 40);
        addObject(label,284,278);
        label.setLocation(294,206);
        Label label2 = new Label("Press <space> to start", 40);
        addObject(label2,276,279);
        label2.setLocation(312,282);
        label.setLocation(301,224);
        label2.setLocation(264,307);
        elephant.setLocation(513,190);
        label.setLocation(245,264);
    }
}