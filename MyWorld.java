import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static ArrayList<Integer> grid = new ArrayList<Integer>();
    public void addBlock(int x, int y) {
        grid.set(x + y * 8, 1);

    }
    public void load() {
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++){
                if (grid.get(i * 8 + k) == 1) {
                    addObject(new Block(),k * 80 + 40,i * 80 + 40);
                }
            }
        }
        
    }
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(80 * 11,80 * 8, 1); 
        //70 pixels for board
        setPaintOrder(Preview.class,Block.class,Shadow.class); //Class order
        
        for (int i = 0; i < 64; i++) {
            grid.add(0); 
        }
        addObject(new Preview("two"),500,300);
        addObject(new Shadow("two"),0,0);
        //addObject(new Block(),grid.get(0),grid.get(1))
                


    }
    public void square(int x,int y) {
        addBlock(x+0,y+0);
        addBlock(x+0,y+1);
        addBlock(x+1,y+0);
        addBlock(x+1,y+1);
    }
    public void act() {
        removeObjects(getObjects(Block.class));
        load();
    }
        
}
