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
    int startX; // position on the tray
    int startY; // position on the tray
    static int x;
    static int y;
    int imgWidth;
    int imgHeight;
    public static String block; //kind of block
    GreenfootImage img;
    public Preview(String block, int x, int y) {
        setImage(new GreenfootImage("" + block + ".png"));
        this.block = block;
        img = getImage();
        imgWidth = img.getWidth();
        imgHeight = img.getHeight();
        this.startX = x;
        this.startY = y;
        img.scale((int)(imgWidth / 2), (int)(imgHeight / 2)); 
        
    }
    public void drag() {
        if (Greenfoot.mouseDragged(this)){
            img.scale(imgWidth, imgHeight); 
            setLocation(Greenfoot.getMouseInfo().getX() - 60,Greenfoot.getMouseInfo().getY() - 60);
        } 
        else if (Greenfoot.mouseDragEnded(this)) {
            if (gridX < 8 - (img.getWidth() / 160)) {
                drop();
            }
            setLocation(startX,startY);
            img.scale((int)(imgWidth / 2), (int)(imgHeight / 2)); 
        }
    }
    //check free square for check Fit
    public static boolean checkSq(int x, int y) {
        if (gridX + x + (gridY + y) * 8 < 64) {
            return MyWorld.grid.get(gridX + x + (gridY + y) * 8) == 0;
        }
        return false;
    }
    public static boolean checkFit() {
        if (Preview.block.equals("two")) {
            if (checkSq(0,0)) {
                if (checkSq(1,0)) {
                    return true;
                }
            }
        }
        if (Preview.block.equals("reverseT")) {
            if (checkSq(1,0)) {
                if (checkSq(0,1)) {
                    if (checkSq(1,1)) {
                        if (checkSq(2,1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public void setGrid() {
        if (block.equals("two")) {
            MyWorld.grid.set(gridX + gridY * 8,1);
            MyWorld.grid.set(gridX + 1 + (gridY + 0) * 8,1);
        }
        if (block.equals("reverseT")) {
            MyWorld.grid.set(gridX + 1 + gridY * 8,1);
            MyWorld.grid.set(gridX + (gridY + 1) * 8,1);
            MyWorld.grid.set(gridX + 1 + (gridY + 1) * 8,1);
            MyWorld.grid.set(gridX + 2 + (gridY + 1) * 8,1);
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
