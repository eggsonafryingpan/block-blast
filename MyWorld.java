import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class MyWorld extends World
{   
    //instance vars
    public static int score;
    // shownScore is different from score since it slowly counts up
    public int shownScore;
    public int time;
    public Preview b1;
    public Preview b2;
    public Preview b3;
    public static int blocksOnSide;
    public static ArrayList<Integer> grid; //64 number array representing grid
    public static ArrayList<Color> gridColor; // color for each square in grid
    static ArrayList<ArrayList> blockData = new ArrayList<ArrayList>();
    // colors in RGB
    public static Color red = new Color(189,66,62); 
    public static Color orange = new Color(222, 125, 62);
    public static Color yellow = new Color(224, 188, 84);
    public static Color green = new Color(99, 177, 89);
    public static Color lBlue = new Color(101, 180, 220);
    public static Color dBlue = new Color(76, 99, 217);
    public static Color purple = new Color(133, 95, 201);
    public static Color pink = new Color(245, 125, 187);
    

    public MyWorld() {  
        super(80 * 11,80 * 8, 1);
        generateBlockData();
        blocksOnSide = 3;
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
        
        checkAndCreateBlocks();
    }
    
    
    


    public void act() {
        if (checkGameOver()) {
            showText("GAME OVER\n Score: " + score, getWidth() / 2, getHeight() / 2); 
            //#change thing
        }
        showScore(750,100); // display score
        clearHorizontal(); // check if column is full
        clearVertical();
        removeObjects(getObjects(Block.class)); // clear the screen each act
        load(); // reload the screen each act
        //showText("b1: " +checkGridFitAll(b1),100,100);
        //showText("" + blockData, 200,200);
        //showText("b2: " +checkGridFitAll(b2),100,200);
        //showText("b3: " +checkGridFitAll(b3),100,300);
        time++; 
    }
    private void checkAndCreateBlocks(){
        if (blocksOnSide == 0){
            addB1(blockData.get(randomBlock()), randomColor(), 750,(int)(getHeight() * 0.4));
            addB2(blockData.get(randomBlock()), randomColor(), 750,(int)(getHeight() * 0.625));
            addB3(blockData.get(randomBlock()), randomColor(), 750,(int)(getHeight() * 0.85));
        }
    }
    
        //#create Preview
    public void addB1(ArrayList block, Color color,int x, int y) {
        b1 = new Preview(block, color,x,y);
        addObject(b1,x,y);
        addObject(new Shadow(b1,color),x,y);
        blocksOnSide++;
    }
    public void addB2(ArrayList block, Color color,int x, int y) {
        b2 = new Preview(block, color,x,y);
        addObject(b2,x,y);
        addObject(new Shadow(b2,color),x,y);
        blocksOnSide++;
    }
       public void addB3(ArrayList block, Color color,int x, int y) {
        b3 = new Preview(block, color,x,y);
        addObject(b3,x,y);
        addObject(new Shadow(b3,color),x,y);
        blocksOnSide++;
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
    
    
    
    public boolean checkGameOver() {
        if (checkGridFitAll(b1)) {
            return false;
        } else if (checkGridFitAll(b2)) {
            return false;
        } else if (checkGridFitAll(b3)) {
            return false;
        } else {
            return true;
        }
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
        if (block != null) {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (checkGridFit(block,x,y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    
    //#used for clearHorizontal
    public void clearHorizontalRow(int y) {
        for (int x = 0; x<8; x++) {
            grid.set(x + y * 8, 0); 
        }
        //#glowing row when cleared:
        addObject(new Glow(640,80),320,y * 80 + 40);
        //#full screen glow:
       addObject(new Glow(getWidth(), getHeight()), getWidth() / 2, getHeight() / 2);
        
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
    //#used for clearVertical
    public void clearVerticalRow(int x) {
        for (int y = 0; y<8; y++) {
            grid.set(x + y * 8, 0); 
        }
        //#glowing row when cleared:
        addObject(new Glow(80,640),x * 80 + 40,getHeight() / 2);
        //#full screen glow:
        addObject(new Glow(getWidth(), getHeight()), getWidth() / 2, getHeight() / 2);
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
    
    
    
 
    public void generateBlockData() {
        
        //#Straight Lines
        //horizontal2
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1))));
        //horizontal3
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 2))));
        //horizontal4
        blockData.add(new ArrayList<Integer>(Arrays.asList(0,1,2,3)));
        //horizontal5
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0,1,2,3,4))));
        //vertical2
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 8))));
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
        //SixSquare Horizontal
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1,2, 8, 9, 10))));
        //SixSquare Vertical
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1,8, 9, 16, 17))));
        //# Z blocks
        //ZVerticalLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 8, 9, 17))));
        //ZVerticalRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(1, 8, 9, 16))));
        //ZHorizontalLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 9, 10))));
        //ZHorizontalRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(1, 2, 8, 9))));
        //# Small Corner blocks
        //SmallCornerTopLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 8))));
        //SmallCornerBottomLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 8, 9))));
        //SmallCornerTopRight
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(0, 1, 9))));
        //SmallCornerBottomLeft
        blockData.add(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(1, 8, 9))));
    
        blockData.add(new ArrayList<Integer>());
        blockData.add(new ArrayList<Integer>());
        blockData.add(new ArrayList<Integer>());
        blockData.add(new ArrayList<Integer>());
        blockData.add(new ArrayList<Integer>());
        
        //# How it works:
        //# Example: tTop is (0,1,2,9)
        //#  0  1  2  (3) ... up to (7)
        //# (8) 9 (10) ... up to (15)
        //#the tTop looks like this basically
        //#the numbers without perenthesis is the block itself
        //#the array goes up to 7
        //#so you go to the next row by adding 8
        //#the numbers are the amount of steps from 0
    
    }
    public Color randomColor() {
        int color;
        color = Greenfoot.getRandomNumber(7)+1;
        if (color == 1){
            return red;
        } else if (color == 2){
            return orange;
        } else if (color == 3){
            return yellow;
        } else if (color == 4){
            return green;
        } else if (color == 5){
            return lBlue;
        } else if (color == 6){
            return dBlue;
        } else{
            return purple;
        }
    }  
    
    public int randomBlock(){
        int block;
        block = Greenfoot.getRandomNumber(38);
        if (block == 0){
            return 0;
        } else if (block == 1){
            return 1;
        } else if (block == 2){
            return 2;
        } else if (block == 3){
            return 3;
        } else if (block == 4){
            return 4;
        } else if (block == 5){
            return 5;
        } else if (block == 6){
            return 6;
        } else if (block == 7){
            return 7;
        } else if (block == 8){
            return 8;
        } else if (block == 9){
            return 9;
        } else if (block == 10){
            return 10;
        } else if (block == 11){
            return 11;
        } else if (block == 12){
            return 12;
        } else if (block == 13){
            return 13;
        } else if (block == 14){
            return 14;
        } else if (block == 15){
            return 15;
        } else if (block == 16){
            return 16;
        } else if (block == 17){
            return 17;
        } else if (block == 18){
            return 18;
        } else if (block == 19){
            return 19;
        } else if (block == 20){
            return 20;
        } else if (block == 21){
            return 21;
        } else if (block == 22){
            return 22;
        } else if (block == 23){
            return 23;
        } else if (block == 24){
            return 24;
        } else if (block == 25){
            return 25;
        } else if (block == 26){
            return 26;
        } else if (block == 27){
            return 27;
        } else if (block == 28){
            return 28;
        } else if (block == 29){
            return 29;
        } else if (block == 30){
            return 30;
        } else if (block == 31){
            return 31;
        } else if (block == 32){
            return 32;
        } else if (block == 33){
            return 33;
        } else if (block == 34){
            return 34;
        } else if (block == 35){
            return 35;
        } else if (block == 36){
            return 36;
        } else{
            return 37;
        }
    }
}
