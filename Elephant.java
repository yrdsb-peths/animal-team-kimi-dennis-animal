import greenfoot.*;

public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");

    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];

    String facing = "right";

    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer staminaTimer = new SimpleTimer();

    int imageIndex = 0;

    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }

        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }

        animationTimer.mark();
        staminaTimer.mark();

        setImage(idleRight[0]);
    }

    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }

        animationTimer.mark();

        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
        }
        else
        {
            setImage(idleLeft[imageIndex]);
        }

        imageIndex = (imageIndex + 1) % idleRight.length;
    }

        public void act()
    {
        if(!(getWorld() instanceof MyWorld))
        {
            animateElephant();
            return;
        }
    
        MyWorld world = (MyWorld)getWorld();
    
        int speed = 3;
    
        if(Greenfoot.isKeyDown("shift") && world.stamina > 0)
        {
            speed = 10;
    
            if(staminaTimer.millisElapsed() > 200)
            {
                world.stamina--;
                world.staminaLabel.setValue(world.stamina);
    
                staminaTimer.mark();
            }
        }
    
        if(Greenfoot.isKeyDown("left"))
        {
            move(-speed);
            facing = "left";
        }
    
        if(Greenfoot.isKeyDown("right"))
        {
            move(speed);
            facing = "right";
        }
    
        eat();
        animateElephant();
    }

    

    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);

            MyWorld world = (MyWorld)getWorld();

            world.creatApple();
            world.increaseScore();

            elephantSound.play();
        }
    }
}