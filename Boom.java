import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Boom extends Actor
{
    int speed = 1;

    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Monkey.class))
        {
            world.gameOver();
            Greenfoot.stop();
        }
        else if(getY() >= world.getHeight())
        {
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed=spd;
    }
    
    public Boom()
    {
        GreenfootImage image = getImage();
        image.scale(60, 60);
    }
}
