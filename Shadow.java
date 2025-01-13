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
    Color base;
    public Shadow(Preview block, Color base) {
        //changing the image
        img = new GreenfootImage(block.imgWidth,block.imgHeight);
        this.block = block;
        this.base = new Color((int)(base.getRed() * 0.7),(int)(base.getGreen() * 0.7),(int)(base.getBlue() * 0.7));
        draw();
    }
    //#drawing the shadow
    private void draw() {
         for (int i = 0; i < block.block.size(); i ++) {
            int x = block.block.get(i) % 8 * 80;
            int y = (int)(block.block.get(i) / 8) * 80;
            img.setColor(new Color(base.getRed() + 25,base.getGreen() + 25,base.getBlue() + 25));
            img.fillRect(x,y, 80, 80); // lighter side
            img.setColor(new Color((int)(base.getRed() * 0.75),(int)(base.getGreen() * 0.75),(int)(base.getBlue() * 0.75)));
            img.fillRect(x + 8, y + 8, 72, 72); // darker side
            img.setColor(base);
            img.fillRect(x + 8, y + 8, 64,64); //middle square
        }
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
        } else { //# will not show if it is not on the grid or it doesn't fit
            hide();
        }
    }
 
}
