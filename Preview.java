import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Preview extends Actor
{
    int gridX;
    int gridY;
    int startX; // position on the tray
    int startY; // position on the tray
    int x;
    int y;
    int imgWidth;
    int imgHeight;
    GreenfootImage img;
    public static ArrayList<Integer> block = new ArrayList<Integer>(Arrays.asList(0,1,2,3));
    public Preview(ArrayList block,String blockName, int x, int y) {
        this.block = block;
        setImage(new GreenfootImage("" + blockName));
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
    public boolean checkSqr(int n) {
        if (gridX + gridY * 8 + n < 64 && gridX >= 0) {
            return MyWorld.grid.get(gridX + gridY * 8 + n) == 0;
        }
        return false;
    }
    //# check if a block can fit
    public boolean checkFit(ArrayList block) {
        for (int i = 0; i< block.size(); i++) {
            if (!checkSqr((int)(block.get(i)))) {
                return false;
            }
        }
        return true;
    }
    //#adding blocks to grid
    public void setGrid(ArrayList block) {
        for (int i = 0; i<block.size(); i++) {
            MyWorld.grid.set(gridX + gridY * 8 + (int)(block.get(i)),1);
            //getWorld().showText(""+gridX + (int)(block.get(i)),400,100);
        }
    }
    //#putting blocks onto the grid
    public void drop() {
        if (checkFit(block)) {
            MyWorld.score += 20;
            setGrid(block);
        }
        //removeTouching(Shadow.class); //removes the block 
        //getWorld().removeObject(this);// commented so the block doesnt disapear when it is placed for testing
    }
    public void act()
    {
        x = getX() - img.getWidth() / 2;
        y = getY() - img.getHeight() / 2;
        gridX = (int)(((getX() - 40) / 80));
        gridY = (int)(((getY() - 40) / 80));
        drag();
    }
}
