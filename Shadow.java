import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.List;
public class Shadow extends Actor
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img; 
    public Shadow(String block) {
        //changing the image
        img = new GreenfootImage(block + ".png");
        
    }
    public void hide() {
        setImage(new GreenfootImage("Misc/clear.png"));
    }

    public void act()
    {   
        //setting shadow under Preview block
        if (Preview.gridX <= 8 - (img.getWidth() / 80) && Preview.checkFit(Preview.block)) {
            setImage(img);
            setLocation((Preview.gridX * 80) + img.getWidth() / 2,(Preview.gridY * 80) + img.getHeight() / 2 + 1);
        } else {
            hide();
        }
    }
 
}
