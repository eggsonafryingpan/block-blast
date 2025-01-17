import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img;
    int width;
    int height;
    public GameOver(int width, int height) {
        img = new GreenfootImage(width,height);
        this.width = width;
        this.height = height;
    }
    public void draw() {
        int border = ((width + height) / 2) / 35;
        img.clear();
        img.setColor(new Color(255,255,255));
        img.fillRect(0,0,width, border);
        img.fillRect(width - border,border,border, height - border);
        img.fillRect(border,height - border,width - border * 2, border);
        img.fillRect(0,border,border, height - border);
        setImage(img);
    }
    public void act()
    {
        // Add your action code here.
    }
}
