import greenfoot.*;
public class Boom extends Actor
{
    int speed = 1;

    public void act()
    {
        setLocation(getX(), getY() + speed);

        if(isTouching(Monkey.class))
        {
            if(getWorld() instanceof MyWorld)
            {
                MyWorld world = (MyWorld) getWorld();
                world.useHeart(13);
                world.createBomb();
                world.removeObject(this);
                return;  // 立刻停止，不再往下执行
            }
        }

        if(getY() >= getWorld().getHeight() - 1)
        {
            if(getWorld() instanceof MyWorld)
            {
                MyWorld world = (MyWorld) getWorld();
                world.createBomb();
                world.removeObject(this);
                return;  // 立刻停止
            }
        }
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    
    public Boom()
    {
        GreenfootImage image = getImage();
        image.scale(50, 50);
    }
}
