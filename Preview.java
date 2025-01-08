import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Shadow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Preview extends Actor
{
    static int gridX;
    static int gridY;
    static int x;
    static int y;
    int imgWidth;
    int imgHeight;
    public static String block;
    GreenfootImage img;
    public Preview(String block) {
        if (block.equals("two")) {
            setImage(new GreenfootImage("two.png"));
        }
        this.block = block;
        img = getImage();
        imgWidth = img.getWidth();
        imgHeight = img.getHeight();
    }
    public void drag() {
        if (Greenfoot.mouseDragged(this)){
            img.scale(imgWidth, imgHeight); 
             setLocation(Greenfoot.getMouseInfo().getX() - imgWidth,Greenfoot.getMouseInfo().getY() - imgHeight);
        } 
        else if (Greenfoot.mouseDragEnded(this)) {
            if (gridX < 8 - (img.getWidth() / 160)) {
                drop();

            }
            setLocation(800,400);
            img.scale((int)(imgWidth / 2), (int)(imgHeight / 2)); 
        }
    }
    public static boolean checkFit() {
        if (Preview.block.equals("two")) {
            if (MyWorld.grid.get(gridX + gridY * 8) == 0) {
                if (MyWorld.grid.get(gridX + 1 +gridY * 8) == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public void setGrid() {
        if (block.equals("two")) {
            MyWorld.grid.set(gridX + gridY * 8,1);
            MyWorld.grid.set(gridX + 1 + gridY * 8,1);
        }
    }
    public void drop() {
        if (checkFit()) {
            setGrid();
        }
        //removeTouching(Shadow.class);
        //getWorld().removeObject(this);
    }

    public void act()
    {
        x = getX() - img.getWidth() / 2;
        y = getY() - img.getHeight() / 2;
        gridX = (int)((getX() - 40) / 80);
        gridY = (int)((getY() - 40) / 80);
        getWorld().showText("" + x + " " + y, 200, 100);
        getWorld().showText("" + gridX + " " + gridY, 100,100);
        drag();
    }
}
