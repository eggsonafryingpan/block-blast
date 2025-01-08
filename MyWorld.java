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
    public static ArrayList<Integer> grid; 
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
    public void clearCheck() {
        //horizontal
        int n = 0;
        for (int y = 0; y<8; y++) {
            for (int x = 0; x<8; x++) {
                if (grid.get(y * 8 + x) == 1) {
                    
                }
            }
        }
    }
    public MyWorld()
    {    
        super(80 * 11,80 * 8, 1); 
        //80 pixels for board
        grid = new ArrayList<Integer>();
        setPaintOrder(Preview.class,Block.class,Shadow.class); //Class order
        for (int i = 0; i < 64; i++) {
            grid.add(0); 
        }
        addObject(new Preview("two"),500,300);
        addObject(new Shadow("two"),0,0);
    }
    public void act() {

        removeObjects(getObjects(Block.class));
        load();
    }
        
}
