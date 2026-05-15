import greenfoot.*;
public class Apple extends Actor
{
    int speed = 1;

    public void act()
    {
        setLocation(getX(), getY() + speed);

        if(getY() >= getWorld().getHeight() - 1)
        {
            if(getWorld() instanceof MyWorld)
            {
                MyWorld world = (MyWorld) getWorld();
                world.useHeart(13);
                world.createApple();
                world.removeObject(this);
                return;
            }
        }
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}