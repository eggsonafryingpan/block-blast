import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class MyWorld extends World
{   
    // block data
    // ! Must be from smallest to largest !
    //Straight lines

    
    
        //Straight lines
    //static ArrayList<Integer> horizontal4 = new ArrayList<Integer>(Arrays.asList(0,1,2,3)); // numbers added to top left block to create block
    //static ArrayList<Integer> horizontal5 = new ArrayList<Integer>(Arrays.asList(0,1,2,3,5));
    //static ArrayList<Integer> vertical4 = new ArrayList<Integer>(Arrays.asList(0,8,16,24));
    //static ArrayList<Integer> vertical5 = new ArrayList<Integer>(Arrays.asList(0,8,16,24,32));
    //T
    //static ArrayList<Integer> tTop = new ArrayList<Integer>(Arrays.asList(0,1,2,9));
    //static ArrayList<Integer> tLeft = new ArrayList<Integer>(Arrays.asList(0,8,9,16));
    //static ArrayList<Integer> tBottom = new ArrayList<Integer>(Arrays.asList(1,8,9,10));
    //static ArrayList<Integer> tRight = new ArrayList<Integer>(Arrays.asList(1,8,9,17));
    //Big L
    //static ArrayList<Integer> bigLBottomLeft = new ArrayList<Integer>(Arrays.asList(0,8,16,17,18));
    //static ArrayList<Integer> bigLBottomRight = new ArrayList<Integer>(Arrays.asList(2,10,16,17,18));
    //static ArrayList<Integer> bigLTopLeft = new ArrayList<Integer>(Arrays.asList(0,1,2,8,16));
    //static ArrayList<Integer> bigLTopRight = new ArrayList<Integer>(Arrays.asList(0,1,2,10,18));
    //L
    //# !!! move the code after the "=" into the ".add" in generateBlockData()
    //# I already did the commented ones
    static ArrayList<Integer> LHorizontalBottomLeft = new ArrayList<Integer>(Arrays.asList(0,8,9,10));
    static ArrayList<Integer> LHorizontalBottomRight = new ArrayList<Integer>(Arrays.asList(2,8,9,10));
    static ArrayList<Integer> LHorizontalTopLeft = new ArrayList<Integer>(Arrays.asList(0,1,2,8));
    static ArrayList<Integer> LHorizontalTopRight = new ArrayList<Integer>(Arrays.asList(0,1,2,10));
    static ArrayList<Integer> LVerticalBottomLeft = new ArrayList<Integer>(Arrays.asList(0,8,16,17));
    static ArrayList<Integer> LVerticalBottomRight = new ArrayList<Integer>(Arrays.asList(1,9,16,17));
    static ArrayList<Integer> LVerticalTopLeft = new ArrayList<Integer>(Arrays.asList(0,1,8,16));
    static ArrayList<Integer> LVerticalTopRight = new ArrayList<Integer>(Arrays.asList(0,1,9,17));
    
    //Z
    static ArrayList<Integer> zHorizontalLeft = new ArrayList<Integer>(Arrays.asList(0,1,9,10));
    static ArrayList<Integer> zHorizontalRight = new ArrayList<Integer>(Arrays.asList(1,2,8,9));
    static ArrayList<Integer> zVerticalLeft = new ArrayList<Integer>(Arrays.asList(0,8,9,17));
    static ArrayList<Integer> zVerticalRight = new ArrayList<Integer>(Arrays.asList(1,8,9,16));
    
    //squares
    static ArrayList<Integer> square = new ArrayList<Integer>(Arrays.asList(0,1,8,9));
    static ArrayList<Integer> bigSquare = new ArrayList<Integer>(Arrays.asList(0,1,2,8,9,10,16,17,18));
    
    //rectangles
    static ArrayList<Integer> rectHorizontal = new ArrayList<Integer>(Arrays.asList(0,1,2,8,9,10));
    static ArrayList<Integer> rectVertical = new ArrayList<Integer>(Arrays.asList(0,1,8,9,16,17));
    
    //small l
    static ArrayList<Integer> smallLTopLeft = new ArrayList<Integer>(Arrays.asList(0,1,8));
    static ArrayList<Integer> smallLTopRight = new ArrayList<Integer>(Arrays.asList(0,1,9));
    static ArrayList<Integer> smallLBottomLeft = new ArrayList<Integer>(Arrays.asList(0,8,9));
    static ArrayList<Integer> smallLBottomRight = new ArrayList<Integer>(Arrays.asList(1,8,9));
    
    //two
    static ArrayList<Integer> twoHorizontal = new ArrayList<Integer>(Arrays.asList(0,1));
    static ArrayList<Integer> twoVertical = new ArrayList<Integer>(Arrays.asList(0,8));
    static ArrayList<ArrayList> blockData = new ArrayList<ArrayList>();
    
    //# How it works:
    //# Example: tTop is (0,1,2,9)
    //#  0  1  2  (3) ... up to (7)
    //# (8) 9 (10) ... up to (15)
    //#the tTop looks like this basically
    //#the numbers without perenthesis is the block itself
    //#the array goes up to 7
    //#so you go to the next row by adding 8
    //#the numbers are the amount of steps from 0
    
    //instance vars
    public static int score;
    // shownScore is different from score since it slowly counts up
    public int shownScore;
    public int time;
    public Preview b1;
    public Preview b2;
    public Preview b3;
    public static int blocksLeft;
    public static ArrayList<Integer> grid; //64 number array representing grid
    public static ArrayList<Color> gridColor; // color for each square in grid
    public static Color red = new Color(189,66,62); // colors in RGB
    public static Color orange = new Color(222, 125, 62);
    public static Color yellow = new Color(228, 188, 84);
    public static Color green = new Color(99, 177, 89);
    public static Color lBlue = new Color(101, 180, 226);
    public static Color dBlue = new Color(76, 99, 217);
    public static Color purple = new Color(133, 95, 201);
    
    //# !!!!!!!! Do blockData.get([some integer here]) to get the block now
    public void generateBlockData() {
        //#Straight Lines
        //horizontal3
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 2))));
        //horizontal4
        blockData.add(new ArrayList<Integer>(Arrays.asList(0,1,2,3)));
        //horizontal5
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0,1,2,3,4))));
        //vertical3
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 8, 16))));
        //vertical4
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0,8,16,24))));
        //vertical5
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0,8,16,24,32))));
        //#T blocks
        //tTop
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0,1,2,9))));
        //tLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0,8,9,16))));
        //tBottom
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(1,8,9,10))));
        //tRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(1,8,9,17))));
        //# Big L blocks
        //bigLBottomLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0,8,16,17,18))));
        //bigLBottomRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(2,10,16,17,18))));
        //bigLTopLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0,1,2,8,16))));
        //bigLTopRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0,1,2,10,18))));
        //# L blocks
        //LHorizontalBottomLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 8, 9, 10))));
        //LHorizontalTopLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 8))));
        //LHorizontalBottomRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(2, 8, 9, 10))));
        //LHorizontalTopRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 10))));
        //LVerticalBottomLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 8, 16, 17))));
        //LVerticalTopLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 8, 16))));
        //LVerticalBottomRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(1, 9, 16, 17))));
        //LVerticalTopRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 9, 17))));
        //# Diagonal 3 blocks
        //DiagonalLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 9, 18))));
        //DiagonalRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(2, 9, 16))));
        //# Square and Rectangle blocks
        //FourSquare
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 8, 9))));
        //NineSquare
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 8, 9, 10, 16, 17, 18))));
        //SixSquare
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1,2, 8, 9, 10))));
        //# Z blocks
        //ZVerticalLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 8, 9, 17))));
        //ZVerticalRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(1, 8, 9, 16))));
        //ZHorizontalLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 9, 10))));
        //ZHorizontalRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(1, 2, 8, 9))));
        //# Continue adding everything
        blockData.add(new ArrayList<Integer>());
        blockData.add(new ArrayList<Integer>());
        blockData.add(new ArrayList<Integer>());
        blockData.add(new ArrayList<Integer>());
        blockData.add(new ArrayList<Integer>());
        blockData.add(new ArrayList<Integer>());
        blockData.add(new ArrayList<Integer>());
        
    }
    public MyWorld() {  
        super(80 * 11,80 * 8, 1);
        generateBlockData();
        blocksLeft = 3;
        time = 0;
        score = 0;
        shownScore = 0;
        GreenfootImage img = new GreenfootImage("Plain Blocks/Backgroundfull/Background.png");
        setBackground(img);
        grid = new ArrayList<Integer>();
        gridColor = new ArrayList<Color>();
        setPaintOrder(Preview.class,Block.class,Shadow.class); //Class order
        //creating grid
        for (int i = 0; i < 64; i++) {
            grid.add(0);
        }
        for (int i = 0; i < 64; i++) {
            gridColor.add(new Color(0,0,0));
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
        //#addB#(blockData.get([insert integer here]), color(Color(RGB)), x, y)
        addB1(blockData.get(2),red,750,(int)(getHeight() * 0.4));
        addB2(blockData.get(1),red,750,(int)(getHeight() * 0.625));
        addB3(blockData.get(3),red,750,(int)(getHeight() * 0.85));
        setPaintOrder(Preview.class,Block.class,Shadow.class); //Class order
    }
    
    //#create Preview
    public void addB1(ArrayList block, Color color,int x, int y) {
        b1 = new Preview(block, color,x,y);
        addObject(b1,x,y);
        addObject(new Shadow(b1,color),x,y);
    }
    public void addB2(ArrayList block, Color color,int x, int y) {
        b2 = new Preview(block, color,x,y);
        addObject(b2,x,y);
        addObject(new Shadow(b2,color),x,y);
    }
       public void addB3(ArrayList block, Color color,int x, int y) {
        b3 = new Preview(block, color,x,y);
        addObject(b3,x,y);
        addObject(new Shadow(b3,color),x,y);
    }

    public void act() {
        showScore(750,100); // display score
        clearHorizontal(); // check if column is full
        clearVertical();
        removeObjects(getObjects(Block.class)); // clear the screen each act
        load(); // reload the screen each act
        showText("b1: " +checkGridFitAll(b1),100,100);
        showText("" + blockData, 200,200);
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
                    addObject(new Block(gridColor.get(i * 8 + k)),k * 80 + 40,i * 80 + 40);
                }
            }
        }
    }
    
    //#used for checkGridFitAll()
    public boolean checkGridFit(Preview block, int x, int y) {
        if (x > 8 - block.imgWidth / 80) {
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
    //#for checking for game over
    public boolean checkGridFitAll(Preview block) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (checkGridFit(block,x,y)) {
                    return true;
                }
            }
        }
        return false;
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
                clearVertical(); //#doing clear vertical because vertical and horizontal rows can be full at once
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
