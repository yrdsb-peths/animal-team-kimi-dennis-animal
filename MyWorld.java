import greenfoot.*;

public class MyWorld extends World 
{
    public int score = 0;
    public int stamina = 100;
    Label scoreLabel;
    int level = 1;
    public MyWorld() 
    {
        super(600, 400, 1, false);

        Monkey monkey = new Monkey();
        addObject(monkey, 200, 200);

        scoreLabel = new Label("0", 100);
        addObject(scoreLabel, 50, 50);
        
        StaminaBar staminaBar;
        staminaBar = new StaminaBar();
        addObject(staminaBar, 500, 100);
        staminaBar.updateStamina(stamina);
        
        createApple();
        createBomb();
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
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    public void createBomb()
    {
        Boom bomb = new Boom();
        bomb.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(bomb, x, y);
    }
}