import greenfoot.*;
public class MyWorld extends World 
{
    public int score = 0;
    public int stamina = 100;
    public int heart = 100;
    Label scoreLabel;
    StaminaBar staminaBar;
    HeartBar heartBar;
    int level = 1;

    public MyWorld() 
    {
        super(600, 400, 1, false);
        Monkey monkey = new Monkey();
        addObject(monkey, 200, 200);
        scoreLabel = new Label("0", 100);
        addObject(scoreLabel, 50, 50);
        
        staminaBar = new StaminaBar();
        addObject(staminaBar, 500, 100);
        staminaBar.updateStamina(stamina);
        
        heartBar = new HeartBar();
        addObject(heartBar, 500, 50);
        heartBar.updateHeart(heart);
        
        createApple();
        createBomb();
    }

    public boolean isGameOver()
    {
        return heart <= 0;
    }

    public void gameOver()
    {
        Label gameOverLabel = new Label("😂Game Over😂", 75);
        addObject(gameOverLabel, 300, 200);
    }

    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        if(score % 5 == 0)
        {
            level++;
        }
    }

    public void createApple()
    {
        if(isGameOver()) return;   // 游戏结束后不再生成
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        addObject(apple, x, 0);
    }
    
    public void createBomb()
    {
        if(isGameOver()) return;   // 游戏结束后不再生成
        Boom bomb = new Boom();
        bomb.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        addObject(bomb, x, 0);
    }
    
    public void useStamina(int amount)
    {
        stamina -= amount;
        if(stamina < 0) stamina = 0;
        staminaBar.updateStamina(stamina);
    }

    public void recoverStamina(int amount)
    {
        stamina += amount;
        if(stamina > 100) stamina = 100;
        staminaBar.updateStamina(stamina);
    }

    public void useHeart(int amount)
    {
        heart -= amount;
        if(heart < 0) heart = 0;
        heartBar.updateHeart(heart);
        if(heart <= 0)
        {
            gameOver();
        }
    }
}