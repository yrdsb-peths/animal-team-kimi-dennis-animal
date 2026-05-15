import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Monkey extends Actor
{
    GreenfootSound monkeySound = new GreenfootSound("u_zpj3vbdres-monkey-128368.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];  
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Monkey()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i]= new GreenfootImage("images/monkey_idle/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i]= new GreenfootImage("images/monkey_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(90,75);
        }
        animationTimer.mark();
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animateMonkey()
    {   
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-10);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(10);
            facing = "right";
        }
        eat();
        
        animateMonkey();
    }

    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            monkeySound.play();
        }
    }
}
