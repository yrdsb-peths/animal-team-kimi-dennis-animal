import greenfoot.*;
public class StaminaBar extends Actor
{
    GreenfootImage[] staminaImages;
    public StaminaBar()
    {
        staminaImages = new GreenfootImage[16];
        for(int i = 0; i < staminaImages.length; i++)
        {
            staminaImages[i] = new GreenfootImage(
                "StaminaBar/StaminaBar" + i + ".png"
            );
        }
        setImage(staminaImages[0]);
    }
    public void updateStamina(int stamina)
    {
        // 100点耐力 映射到 16张图（0-15）
        int frame = (int)((100 - stamina) / 100.0 * 15);
        if(frame > 15) frame = 15;
        if(frame < 0)  frame = 0;
        setImage(staminaImages[frame]);
    }
}