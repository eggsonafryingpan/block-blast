import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    GreenfootImage img;
    public Block(Color base) {
        img = new GreenfootImage(80,80);
        img.setColor(new Color(base.getRed() + 25,base.getGreen() + 25,base.getBlue() + 25));
        img.fillRect(0,0, 80, 80); // lighter side
        img.setColor(new Color((int)(base.getRed() * 0.75),(int)(base.getGreen() * 0.75),(int)(base.getBlue() * 0.75)));
        img.fillRect(8, 8, 72, 72); // darker side
        img.setColor(base);
        img.fillRect(8, 8, 64,64); //middle square
        setImage(img);
    }
    //#not using currently
    public void checkGrid() {
        if (MyWorld.grid.get((int)(getX() / 80) + (int)(getY() / 80) * 8) == 0) {
            getWorld().removeObject(this);
        }
    }
    public void act()
    {
    }
}   
