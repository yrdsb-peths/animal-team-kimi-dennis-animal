import greenfoot.*;
public class Boom extends Actor
{
    int speed = 1;
    GreenfootSound boomSound = new GreenfootSound("bomb.mp3"); 

    public void act()
    {
        setLocation(getX(), getY() + speed);

        if(isTouching(Monkey.class))
        {
            if(getWorld() instanceof MyWorld)
            {
                MyWorld world = (MyWorld) getWorld();
                boomSound.play();         
                world.useHeart(13);
                world.createBomb();
                world.removeObject(this);
                return;
            }
        }

        if(getY() >= getWorld().getHeight() - 1)
        {
            if(getWorld() instanceof MyWorld)
            {
                MyWorld world = (MyWorld) getWorld();
                world.createBomb();
                world.removeObject(this);
                return;
            }
        }
    }
    
    public Boom()
    {
        GreenfootImage image = getImage();
        image.scale(50, 50);
    }
    
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}