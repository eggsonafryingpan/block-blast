import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class MyWorld extends World
{   
    //# block data
    static ArrayList<Integer> horizontal4 = new ArrayList<Integer>(Arrays.asList(0,1,2,3)); // numbers added to top left block to create block
    static ArrayList<Integer> horizontal5 = new ArrayList<Integer>(Arrays.asList(0,1,2,3,5));
    static ArrayList<Integer> vertical4 = new ArrayList<Integer>(Arrays.asList(0,8,16,32));
    static ArrayList<Integer> vertical5 = new ArrayList<Integer>(Arrays.asList(0,8,16,32,40));
    static ArrayList<Integer> tUp = new ArrayList<Integer>(Arrays.asList(0,1,2,9)); // change in y is adding 8
    //  0  1  2  (3) ... up to (7)
    // (8) 9 (10) ... up to (15)
    //the tUp looks like this basically
    //XXX   like this where the X is a square and O is emtpy
    //OXO
    //the numbers without perenthesis is the block itself
    //the array goes up to 7
    //so you go to the next row with adding 8
    //#current bug: cannot add two blocks at once - will fix
    public static ArrayList<Integer> grid; //64 number array representing grid
    public MyWorld() {    
        super(80 * 11,80 * 8, 1); 
        //80 pixels for board
        grid = new ArrayList<Integer>();
        setPaintOrder(Preview.class,Block.class,Shadow.class); //Class order
        for (int i = 0; i < 64; i++) {
            grid.add(0); 
        }
        addTUp("DBlue blocks",800,300);

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
    public void addHorizontal4(String color,int x, int y) {
        addObject(new Preview(horizontal4, color + "/horizontal4",x,y),x,y);
        addObject(new Shadow("" + color + "/horizontal4"),x,y);
    }
    public void addTUp(String color, int x, int y) {
         addObject(new Preview(tUp, color + "/tUp",x,y),x,y);
        addObject(new Shadow("" + color + "/tUp"),x,y);
    }


        
}
