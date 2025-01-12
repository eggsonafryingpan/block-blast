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
    Preview block;
    public Shadow(String image,Preview block) {
        //changing the image
        img = new GreenfootImage(image);
        this.block = block;
    }
    public void hide() {
        setImage(new GreenfootImage("Misc/clear.png"));
    }

    public void act()
    {   
        //setting shadow under Preview block
        if (block.gridX <= 8 - (img.getWidth() / 80) && block.checkFit(block.block)) {
            setImage(img);
            setLocation((block.gridX * 80) + img.getWidth() / 2,(block.gridY * 80) + img.getHeight() / 2);
        } else {
            hide();
        }
    }
 
}
