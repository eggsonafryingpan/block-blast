import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    private int color;
    GreenfootImage img;
    public Block() {
        color = Greenfoot.getRandomNumber(7)+1;
        if (color == 1){
            Color base = MyWorld.red;
        } else if (color == 2){
            Color base = MyWorld.orange;
        } else if (color == 3){
            Color base = MyWorld.yellow;
        } else if (color == 4){
            Color base = MyWorld.green;
        } else if (color == 5){
            Color base = MyWorld.lBlue;
        } else if (color == 6){
            Color base = MyWorld.dBlue;
        } else{
            Color base = MyWorld.purple;
        }
        img = new GreenfootImage(80,80);
        img.setColor(new Color(base.getRed() + 40,base.getGreen() + 40,base.getBlue() + 40));
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
