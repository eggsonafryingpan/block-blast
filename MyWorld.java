import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;
public class MyWorld extends World
{
    public static ArrayList<Integer> grid; //64 number array representing grid
    public MyWorld() {    
        super(80 * 11,80 * 8, 1); 
        //80 pixels for board
        grid = new ArrayList<Integer>();
        setPaintOrder(Preview.class,Block.class,Shadow.class); //Class order
        for (int i = 0; i < 64; i++) {
            grid.add(0); 
        }
        addHorizontal4();
    }
    
    //#add block methods
    public void addTwo() {
        addObject(new Preview("two",800,300),800,300);
        addObject(new Shadow("two"),800,300);
    }
    public void addHorizontal4() {
        addObject(new Preview("horizontal4",800,300),800,300);
        addObject(new Shadow("horizontal4"),800,300);
    }
    public void addReverseT() {
        addObject(new Preview("reverseT",800,300),800,300);
        addObject(new Shadow("reverseT"),800,100);
    }
    
    public void addBlock(int x, int y) {
        grid.set(x + y * 8, 1);
    }
    
    //#make blocks on the board
    public void load() {
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++){
                if (grid.get(i * 8 + k) == 1) {
                    addObject(new Block(),k * 80 + 40,i * 80 + 40);
                }
            }
        }
    }
    
    public void clearHorizontalRow(int y) {
        for (int x = 0; x<8; x++) {
            grid.set(x + y * 8, 0); 
        }
    }
    
    public void clearHorizontal() {
        //horizontal clear check
        int n = 0;
        for (int y = 0; y<8; y++) {
            for (int x = 0; x<8; x++) {
                if (grid.get(y * 8 + x) == 1) {
                    n++;
                }
            }
            if (n == 8) {
                clearHorizontalRow(y);
                }
            n = 0;
        }
    }
    
        public void clearVerticalRow(int x) {
        for (int y = 0; y<8; y++) {
            grid.set(x + y * 8, 0); 
        }
    }
    
    public void clearVertical() {
        //vertical clear check
        int a = 0;
        for (int x = 0; x<8; x++) {
            for (int y = 0; y<8; y++) {
                if (grid.get(y * 8 + x) == 1) {
                    a++;
                }
            }
            if (a == 8) {
                clearVerticalRow(x);
            }
            a = 0;
        }
    }
    public void act() {
        clearHorizontal(); //check if column is full
        clearVertical(); //check if column is full
        removeObjects(getObjects(Block.class)); //clear the screen each act
        load(); // reload the screen each act
    }
        
}
