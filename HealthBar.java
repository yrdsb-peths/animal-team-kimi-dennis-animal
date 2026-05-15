import greenfoot.*;

public class HealthBar extends Actor
{
    public void updateHealth(int health)
    {
        GreenfootImage image = new GreenfootImage("healthbar.png");

        image.scale(health * 40, 20);

        setImage(image);
    }
}