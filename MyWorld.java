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
    static ArrayList<Integer> tTop = new ArrayList<Integer>(Arrays.asList(0,1,2,9));
    static ArrayList<Integer> tLeft = new ArrayList<Integer>(Arrays.asList(0,8,9,16));
    static ArrayList<Integer> tBottom = new ArrayList<Integer>(Arrays.asList(1,8,9,10));
    static ArrayList<Integer> tRight = new ArrayList<Integer>(Arrays.asList(1,8,9,17));
    static ArrayList<Integer> bigLBottomLeft = new ArrayList<Integer>(Arrays.asList(0,8,16,17,18));
    static ArrayList<Integer> bigLBottomRight = new ArrayList<Integer>(Arrays.asList(16,17,18,10,2));
    static ArrayList<Integer> bigLTopLeft = new ArrayList<Integer>(Arrays.asList(0,1,2,8,16));
    static ArrayList<Integer> bigLTopRight = new ArrayList<Integer>(Arrays.asList(0,1,2,10,18));
    static ArrayList<Integer> LHorizontalBottomLeft = new ArrayList<Integer>(Arrays.asList(0,8,9,10));
    static ArrayList<Integer> LHorizontalBottomRight = new ArrayList<Integer>(Arrays.asList(2,8,9,10));
    static ArrayList<Integer> LHorizontalTopLeft = new ArrayList<Integer>(Arrays.asList(0,1,2,8));
    static ArrayList<Integer> LHorizontalTopRight = new ArrayList<Integer>(Arrays.asList(0,1,2,10));
    static ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(0,1));
    //#  0  1  2  (3) ... up to (7)
    //# (8) 9 (10) ... up to (15)
    //#the tUp looks like this basically
    //#the numbers without perenthesis is the block itself
    //#the array goes up to 7
    //#so you go to the next row with adding 8
    
    //instance vars
    public static int score;
    //# shownScore is different from score since it slowly counts up
    public int shownScore;
    public int time;
    public Preview b1;
    public Preview b2;
    public Preview b3;
    public static int blocksLeft;
    public static ArrayList<Integer> grid; //64 number array representing grid

    public MyWorld() {  
        super(80 * 11,80 * 8, 1);
        blocksLeft = 3;
        time = 0;
        score = 0;
        shownScore = 0;
        grid = new ArrayList<Integer>();
        setPaintOrder(Preview.class,Block.class,Shadow.class); //Class order
        //creating grid
        for (int i = 0; i < 64; i++) {
            if (Greenfoot.getRandomNumber(10) % 2 == 0) {
                grid.add(0);
            } else {
            grid.add(0);
            }
        }
        
        
        //#b1,b2,b3 is the blocks on the right
        //# For example if this is the right side:
        //#
        //#    score
        //#
        //#     b1  (1st block)
        //#     b2  (2nd block)
        //#     b3  (3rd block)
        //#
        //#addB#(blockNumber(Preview), data(ArrayList),folder,block name, x, y)
        addB1(two,"misc","two",750,(int)(getHeight() * 0.4));
        //addB2(bigLBottomLeft,"[color]","bigLBottomLeft",750,(int)(getHeight() * 0.625));
        //addB3(LHorizontalBottomLeft,"[color]","LHorizontalBottomLeft",750,(int)(getHeight() * 0.85));
    }
    
    //#create Preview
    public void addB1(ArrayList block, String color,String blockName,int x, int y) {
        b1 = new Preview(block, color + "/" + blockName + ".png",x,y);
        addObject(b1,x,y);
        addObject(new Shadow("" + color + "/" + blockName + ".png", b1),x,y);
    }
    public void addB2(ArrayList block, String color,String blockName,int x, int y) {
        b2 = new Preview(block, color + "/" + blockName + ".png",x,y);
        addObject(b2,x,y);
        addObject(new Shadow("" + color + "/" + blockName + ".png", b2),x,y);
    }
    public void addB3(ArrayList block, String color,String blockName,int x, int y) {
        b3 = new Preview(block, color + "/" + blockName + ".png",x,y);
        addObject(b3,x,y);
        addObject(new Shadow("" + color + "/" + blockName + ".png", b3),x,y);
    }
    
    public void act() {
        showScore(750,100); // display score
        clearHorizontal(); // check if column is full
        clearVertical();
        removeObjects(getObjects(Block.class)); // clear the screen each act
        load(); // reload the screen each act
        showText("b1: " +checkGridFitAll(b1),100,100);
        //showText("b2: " +checkGridFitAll(b2),100,200);
        //showText("b3: " +checkGridFitAll(b3),100,300);
        time++; 
    }

    
    
    public void showScore(int x, int y) {
        int diff = score - shownScore;
        if (diff <= 5 && diff > 0) {
            if (time % 15 == 0) {
                shownScore += 1;
            }
        } else if (diff <= 20 && diff > 0) {
            if (time % 7 == 0) {
                shownScore += 1;
            }
        } else if (diff <= 40 && diff > 0) {
            if (time % 2 == 0) {
                shownScore += 1;
            }
        } else if (diff <= 80 && diff > 0) {
                shownScore += 1;
        }else if (diff > 80) {
            shownScore = score - 10;
        }
        showText("" + shownScore, x, y);
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
    
    
    public boolean checkGridFit(Preview block, int x, int y) {
        if (x> 8 - block.imgWidth / 80) {
            return false;
        }
        for (int i = 0; i < block.block.size(); i++) {
            if (x + y * 8 + (int)(block.block.get(i)) < 64) { 
                if (grid.get(x + y * 8 + (int)(block.block.get(i))) == 1) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    //#check if block can fit anywhere on the grid
    public boolean checkGridFitAll(Preview block) {
        //if (block != null) {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (checkGridFit(block,x,y)) {
                        return true;
                    }
                }
            }
            return false;
        //}
        //return false;
    }
    
    //# clear squares if a row is full
    public void clearHorizontal() { 
        int n = 0;
        for (int y = 0; y<8; y++) {
            for (int x = 0; x<8; x++) {
                if (grid.get(y * 8 + x) == 1) {
                    n++;
                }
            }
            if (n == 8) {
                clearVertical();
                clearHorizontalRow(y);
                score += 100;
            }
            n = 0;
        }
    }
    //#used for clearHorizontal
    public void clearHorizontalRow(int y) {
        for (int x = 0; x<8; x++) {
            grid.set(x + y * 8, 0); 
        }
    }
    //#used for clearVertical
    public void clearVerticalRow(int x) {
        for (int y = 0; y<8; y++) {
            grid.set(x + y * 8, 0); 
        }
    }
    public void clearVertical() {
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
    



        
}
