import greenfoot.*;

public class MyWorld extends World {
    
    public int score = 0;
    public int stamina = 10;
    Label scoreLabel;
    Label staminaLabel;
    int level = 1;
    
    public MyWorld() {
        super(600, 400, 1, false);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel,50 ,50);
        
        staminaLabel = new Label(10, 80);
        addObject(staminaLabel,450 ,50);
        
        creatApple();
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 ==0)
        {
            level += 1;
        }
    }
    
    SimpleTimer staminaTimer = new SimpleTimer();
    public void increaseStamina()
    {
        if(staminaTimer.millisElapsed() < 1000)
        {
            return;
        }
    
        stamina++;
    
        staminaLabel.setValue(stamina);
    
        staminaTimer.mark();
    }
    
    public void creatApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    public void act()
    {
        increaseStamina();
    }
}
