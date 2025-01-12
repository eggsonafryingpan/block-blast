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
    static ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(0,1));
    static ArrayList<Integer> tUp = new ArrayList<Integer>(Arrays.asList(0,1,2,9)); // change in y is adding 8
    //  0  1  2  (3) ... up to (7)
    // (8) 9 (10) ... up to (15)
    //the tUp looks like this basically
    //XXX   like this where the X is a square and O is emtpy
    //OXO
    //the numbers without perenthesis is the block itself
    //the array goes up to 7
    //so you go to the next row with adding 8
    public static int score;
    //# shownScore is different from score since it slowly counts up
    public int shownScore;
    public int time;
    public static ArrayList<Integer> grid; //64 number array representing grid
    public static Preview b1;
    public static Preview b2;
    public static Preview b3;
    public static int blocksLeft;
    public MyWorld() {  
        super(80 * 11,80 * 8, 1);
        blocksLeft = 3;
        time = 0;
        score = 0;
        shownScore = 0;
        //80 pixels for board
        grid = new ArrayList<Integer>();
        setPaintOrder(Preview.class,Block.class,Shadow.class); //Class order
        for (int i = 0; i < 64; i++) {
            grid.add(0); 
        }
        //#(block number(Preview), data(ArrayList),folder,block name, x, y)
        //# block number decides which block it is out of the 3 always present
        addblock(b1,two,"misc","two",800,300);
        addblock(b2,two,"misc","two",800,400);
        addblock(b3,two,"misc","two",800,500);

    }

    public void showScore() {
        int diff = score - shownScore;
        if (diff <= 5 && diff > 0) {
            if (time % 15 == 0) {
                shownScore += 1;
            }
        } else if (diff > 10 && diff > 0) {
            if (time % 7 == 0) {
                shownScore += 1;
            }
        } else if (diff <= 40 && diff > 0) {
            if (time % 5 == 0) {
                shownScore += 1;
            }
        } else if (diff <= 80 && diff > 0) {
            if (time % 2 == 0) {
                shownScore += 1;
            }
        }else if (diff > 80) {
            shownScore = score - 10;
        }
        showText("" + shownScore, 700, 100);
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
                score += 100;
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
                score += 100;
            }
            a = 0;
        }
    }
    public void act() {

        showScore();
        clearHorizontal(); //check if column is full
        clearVertical(); //check if column is full
        removeObjects(getObjects(Block.class)); //clear the screen each act
        load(); // reload the screen each act
        time++; 
    }
    
    //#add block methods
    public void addblock(Preview b, ArrayList block, String color,String blockName,int x, int y) {
        b = new Preview(block, color + "/" + blockName + ".png",x,y);
        addObject(b,x,y);
        addObject(new Shadow("" + color + "/" + blockName + ".png", b),x,y);
    }


        
}
