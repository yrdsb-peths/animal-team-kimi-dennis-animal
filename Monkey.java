import greenfoot.*;
public class Monkey extends Actor
{
    GreenfootSound monkeySound = new GreenfootSound("u_zpj3vbdres-monkey-128368.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];  
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer staminaTimer = new SimpleTimer();
    SimpleTimer exhaustedTimer = new SimpleTimer();  // 耗尽后的冷却计时器
    boolean isExhausted = false;                     // 是否处于耗尽状态

    public Monkey()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/monkey_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/monkey_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(90, 75);
        }
        animationTimer.mark();
        staminaTimer.mark();
        exhaustedTimer.mark();
        setImage(idleRight[0]);
    }

    int imageIndex = 0;
    public void animateMonkey()
    {   
        if(animationTimer.millisElapsed() < 100) return;
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
        if(!(getWorld() instanceof MyWorld)) 
        {
            animateMonkey();
            return;
        }

        MyWorld world = (MyWorld) getWorld();

        if(world.isGameOver()) return;

        boolean canSprint = !isExhausted && world.stamina > 0;

        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            facing = "left";
            if(Greenfoot.isKeyDown("shift") && canSprint)
            {
                move(-7);
            }
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "right";
            if(Greenfoot.isKeyDown("shift") && canSprint)
            {
                move(7);
            }
        }

        clampToWorld();   // 空气墙
        eat();
        animateMonkey();
        handleStamina();
    }

    // 限制猴子不超出世界边界
    public void clampToWorld()
    {
        int halfW = getImage().getWidth() / 2;
        int halfH = getImage().getHeight() / 2;
        int worldW = getWorld().getWidth();
        int worldH = getWorld().getHeight();

        int x = getX();
        int y = getY();

        if(x < halfW)            x = halfW;
        if(x > worldW - halfW)   x = worldW - halfW;
        if(y < halfH)            y = halfH;
        if(y > worldH - halfH)   y = worldH - halfH;

        setLocation(x, y);
    }

    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            if(getWorld() instanceof MyWorld)
            {
                MyWorld world = (MyWorld) getWorld();
                world.createApple();
                world.increaseScore();
                monkeySound.play();
            }
        }
    }

    public void handleStamina()
    {
        if(!(getWorld() instanceof MyWorld)) return;
        MyWorld world = (MyWorld) getWorld();

        // 耗尽状态：等待3秒冷却
        if(isExhausted)
        {
            if(exhaustedTimer.millisElapsed() >= 3000)
            {
                isExhausted = false;   // 3秒后解除耗尽
            }
            return;                    // 冷却期间不恢复也不消耗
        }

        if(staminaTimer.millisElapsed() >= 63)
        {
            staminaTimer.mark();
            if(Greenfoot.isKeyDown("shift"))
            {
                if(world.stamina > 0)
                {
                    world.useStamina(1);

                    // 刚好耗尽，进入冷却
                    if(world.stamina == 0)
                    {
                        isExhausted = true;
                        exhaustedTimer.mark();   // 开始计时3秒
                    }
                }
            }
            else
            {
                world.recoverStamina(1);
            }
        }
    }
}