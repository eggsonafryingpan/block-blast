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
    public ArrayList<Integer> list = new ArrayList<Integer>();
    public void addBlock(int x, int y) {
        list.set(x + y * 8, 1);

    }
    public void load() {
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++){
                if (list.get(i * 8 + k) == 1) {
                    addObject(new Block(),k * 40,i * 40);
                }
            }
        }
        
    }
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(80 * 11,80 * 8, 1); 
        //70 pixels for board
        setPaintOrder(Preview.class,Block.class); //Class order
        
        for (int i = 0; i < 64; i++) {
            list.add(0); 
        }
        addObject(new Preview("two"),500,300);
        //addObject(new Block(),list.get(0),list.get(1))
                


    }
    public void square(int x,int y) {
        addBlock(x+0,y+0);
        addBlock(x+0,y+1);
        addBlock(x+1,y+0);
        addBlock(x+1,y+1);
    }
    public void act() {
        removeObjects(getObjects(Block.class));
        
        addBlock(1,1);
        
        load();
    }
        
}
