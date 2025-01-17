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
    public ArrayList<Integer> block;
    Color base;
    String b;
    public Preview(ArrayList block, Color base, int x, int y, String b) {
        this.block = block;
        this.base = base; 
        this.b = b;
        imgWidth = (calculateWidth() + 1) * 80;
        imgHeight = (((int)((int)(block.get(block.size() - 1)) / 8)) + 1) * 80;
        img = new GreenfootImage(imgWidth, imgHeight);
        draw();
        this.startX = x;
        this.startY = y;
        img.scale((int)(imgWidth / 2.5), (int)(imgHeight / 2.5)); 
    }
    
    
    
    //# calculating width for draw()
    public int calculateWidth() {
        // 2,9,16
        int biggest = block.get(0);
        for (int i = 0; i<block.size() - 1; i++) {
            biggest = Math.max(biggest,block.get(i + 1) % 8);
        }
        return biggest;
    }
    //#drawing shape
    public void draw() {
         for (int i = 0; i < block.size();i ++) {
            int x = block.get(i) % 8 * 80;
            int y = (int)(block.get(i) / 8) * 80;
            img.setColor(new Color(base.getRed() + 25,base.getGreen() + 25,base.getBlue() + 25));
            img.fillRect(x,y, 80, 80); // lighter side
            img.setColor(new Color((int)(base.getRed() * 0.75),(int)(base.getGreen() * 0.75),(int)(base.getBlue() * 0.75)));
            img.fillRect(x + 8, y + 8, 72, 72); // darker side
            img.setColor(base);
            img.fillRect(x + 8, y + 8, 64,64); //middle square
            setImage(img);
        }
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
        if (gridX + gridY * 8 + n < 64 && gridX >= 0 && gridY >= 0) {
            return MyWorld.grid.get(gridX + gridY * 8 + n) == 0;
        }
        return false;
    }
    //# check if a block can fit
    public boolean checkFit(ArrayList block) {
        if (gridX > 8 - imgWidth / 80) {
            return false;
        }
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
        }
    }
    public void setGridColor(ArrayList block) {
        for (int i = 0; i<block.size(); i++) {
            MyWorld.gridColor.set(gridX + gridY * 8 + (int)(block.get(i)),base);
        }
    }
    
    
    //#putting blocks onto the grid
    public void drop() {
        if (checkFit(block)) {
            MyWorld.score += 20;
            setGrid(block);
            setGridColor(block);
            removeTouching(Shadow.class); //removes the block 
            MyWorld.blocksOnSide--;
            if (b.equals("b1")) {
                MyWorld.b1 = null;
            } else if (b.equals("b2")) {
                MyWorld.b2 = null;
            } else if (b.equals("b3")) {
                MyWorld.b3 = null;
            }
            getWorld().removeObject(this);
            
        }
    }
    
    
    public void act()
    {
        x = getX() - img.getWidth() / 2;
        y = getY() - img.getHeight() / 2;
        gridX = (int)(((x) / 80));
        gridY = (int)(((y) / 80));
        drag();
    }
}
