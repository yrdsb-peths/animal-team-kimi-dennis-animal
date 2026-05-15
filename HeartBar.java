import greenfoot.*;
public class HeartBar extends Actor
{
    GreenfootImage[] HeartBarImages;
    public HeartBar()
    {
        HeartBarImages = new GreenfootImage[16];
        for(int i = 0; i < HeartBarImages.length; i++)
        {
            HeartBarImages[i] = new GreenfootImage(
                "HeartBar/HeartBar" + i + ".png"
            );
        }
        setImage(HeartBarImages[0]);
    }
    public void updateHeart(int heart)
    {
        // 100点血量 映射到 16张图（0-15）
        int frame = (int)((100 - heart) / 100.0 * 15);
        if(frame > 15) frame = 15;
        if(frame < 0)  frame = 0;
        setImage(HeartBarImages[frame]);
    }
}