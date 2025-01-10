import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class MyWorld extends World
{   
    //# block data
    static ArrayList<Integer> horizontal4 = new ArrayList<Integer>(Arrays.asList(0,1,2,3));
    static ArrayList<Integer> tUp = new ArrayList<Integer>(Arrays.asList(0,1,2,9));
    
    public static ArrayList<Integer> grid; //64 number array representing grid
    public MyWorld() {    
        super(80 * 11,80 * 8, 1); 
        //80 pixels for board
        grid = new ArrayList<Integer>();
        setPaintOrder(Preview.class,Block.class,Shadow.class); //Class order
        for (int i = 0; i < 64; i++) {
            grid.add(0); 
        }
        addHorizontal4("DBlue blocks");
    }
    
    //# setting grid   not using currently
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
    
    //#used for clearHorizontal
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
    
    //#used for clearVertical
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
    //#add block methods
    
    public void addHorizontal4(String color) {
        addObject(new Preview(horizontal4, color + "/horizontal4",800,300),800,300);
        addObject(new Shadow("" + color + "/horizontal4"),800,300);
    }
    public void addTUp(String color) {
         addObject(new Preview(tUp, color + "/tUp",800,300),800,300);
        addObject(new Shadow("" + color + "/tUp"),800,300);
    }


        
}
