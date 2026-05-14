import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{
    Label titleLabel = new Label("🐒Hungry Monkey🐒", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel, 300, 120);
        prepare();
    }

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
        Monkey monkey = new Monkey();
        addObject(monkey,284,189);
        monkey.setLocation(289,51);
        Label label = new Label("Press <space> to Start", 35);
        addObject(label,278,294);
        label.setLocation(307,318);
        label.setLocation(313,364);
        label.setLocation(333,356);
        Label label2 = new Label("Press ← → to Move", 35);
        addObject(label2,313,308);
        label2.setLocation(372,297);
        label2.setLocation(310,199);
        label.setLocation(294,348);
        label.setLocation(319,340);
        label.setLocation(325,356);
    }
}
