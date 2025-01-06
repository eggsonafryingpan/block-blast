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
        list.set(x + y *8, 1);
    }
    public void load() {
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++){
                if (list.get(i * 8 + k) == 1) {
                    addObject(new Block(),k,i);
                }
            }
        }
        
    }
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(112,154, 5); 
        //70 pixels for board
        
        for (int i = 0; i < 64; i++) {
            list.add(0);
        }
        //addObject(new Block(),list.get(0),list.get(1))
                
        addBlock(1,1);
        load();
    }
    public void square(int x,int y) {
        addBlock(x+0,y+0);
        addBlock(x+0,y+1);
        addBlock(x+1,y+0);
        addBlock(x+1,y+1);
    }
    public void act() {

    }
        
}
