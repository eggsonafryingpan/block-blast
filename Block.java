import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Block() {
        //GreenfootImage image = getImage();
        //image.scale((int)(image.getWidth() * 0.8), (int)(image.getHeight() * 0.8)); 
    }
    public void act()
    {
        if (Preview.gridX < 8) {
            setLocation(Preview.gridX * 80 + 40,Preview.gridY * 80 + 40);
        }
    }
 
}
