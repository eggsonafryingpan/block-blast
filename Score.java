import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img;
    public Score() {
        img = new GreenfootImage(600,400);
        Font font = new Font("Rockwell",60);
        img.setFont(font);
        img.setColor(new Color (255,255,255));
        img.drawString("" + MyWorld.shownScore, img.getWidth() / 2, img.getHeight() / 2);
        setImage(img);
    }
    public void backgroundShape() {
        
        //Arrays x = new Arrays(Arrays.asList(100, img.getHeight() / 2, 300, img.getWidth() / 2));
        //Arrays y = new Arrays(Arrays.asList(img.getWidth() /2, img.getWidth() / 2 + 100, img.getWidth() /2, img.getWidth() / 2 -100));
        //img.drawPolygon(x,y,4);
    }
    public void act()
    {
        img.clear();
        if (MyWorld.shownScore > 0) {
        setLocation(750 - (int)(Math.log10(MyWorld.shownScore)) * 20,getY());
        }
        img.drawString("" + MyWorld.shownScore, img.getWidth() / 2, img.getHeight() / 2);
        setImage(img);
        
    }
}
