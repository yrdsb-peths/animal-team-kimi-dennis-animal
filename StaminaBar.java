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
        int frame = (100 - stamina) / 12;

        if(frame > 7)
        {
            frame = 7;
        }

        if(frame < 0)
        {
            frame = 0;
        }

        setImage(staminaImages[frame]);
    }
}