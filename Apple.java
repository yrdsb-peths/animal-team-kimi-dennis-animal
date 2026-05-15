import greenfoot.*;

public class Apple extends Actor
{

    private static GreenfootImage appleImage;
    int speed = 1;
    public Apple()
    {
        appleImage = new GreenfootImage("apple1");
        setImage(appleImage);
    }
    

    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed=spd;
    }
}