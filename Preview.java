import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
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
    GreenfootImage img;
    public static ArrayList<Integer> horizontal4 = new ArrayList<Integer>(Arrays.asList(0,1,2,3));
    public static ArrayList<Integer> block = new ArrayList<Integer>();
    //# check if a block can fit
    public static boolean checkFit(ArrayList block) {
        for (int i = 0; i< block.size(); i++) {
            if (!checkSqr(block.get(i))) {
                return false;
            }
        }
        return true;
    }
    public Preview(String block, int x, int y) {
        block = horizontal4;
        setImage(new GreenfootImage("" + block + ".png"));
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
            setLocation(Greenfoot.getMouseInfo().getX() - 120,Greenfoot.getMouseInfo().getY());
        } 
        else if (Greenfoot.mouseDragEnded(this)) {
            if (gridX < 8 - (img.getWidth() / 160)) {
                drop();
            }
            setLocation(startX,startY);
            img.scale((int)(imgWidth / 2), (int)(imgHeight / 2)); 
        }
    }
    //# check free square for check Fit
    public static boolean checkSqr(int n) {
        if (gridX + n < 64 && gridX >= 0) {
            return MyWorld.grid.get(gridX + n) == 0;
        }
        return false;
    }
    
    public static boolean checkFit1() { //delete later
        //if (Preview.block.equals("two")) {
            //if (checkSq(0,0) && checkSq(1,0)) {
                //return true;
            //}
        //}
        //if (Preview.block.equals("reverseT")) {
            //if (checkSq(1,0) && checkSq(0,1) && checkSq(1,1) &&checkSq(2,1)) {
                //return true;
            //}
        //}
        //if (Preview.block.equals("horizontal4")) {
            //if (checkSq(0,0) && checkSq(1,0) && checkSq(3,0) &&checkSq(3,0)) {
                //return true;
            //}
        //}
        return false;
    }
    //#adding blocks to grid
    public void setGrid(ArrayList block) {
        for (int i = 0; i<block.size(); i++) {
            MyWorld.grid.set(gridX + block.get(i),1);
        }
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
        if (block.equals("horizontal4")) {
            MyWorld.grid.set(gridX + gridY * 8,1);
            MyWorld.grid.set(gridX + 1  +(gridY) * 8,1);
            MyWorld.grid.set(gridX + 2 + (gridY) * 8,1);
            MyWorld.grid.set(gridX + 3 + (gridY) * 8,1);
        }

    }
    public void drop() {
        if (checkFit(block)) {
            setGrid();
        }
        //removeTouching(Shadow.class);
        //getWorld().removeObject(this);
    }
    public void act()
    {
        x = getX() - img.getWidth() / 2;
        y = getY() - img.getHeight() / 2;
        gridX = (int)(((getX() - 40) / 80) - 1);
        gridY = (int)(((getY() - 40) / 80));
        getWorld().showText("" + x + " " + y, 200, 100);
        getWorld().showText("" + gridX + " " + gridY, 100,100);
        drag();
    }
}
