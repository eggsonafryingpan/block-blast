import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Block() {
        setImage(new GreenfootImage("One Block/Block.png"));
    }
    public void checkGrid() {
        if (MyWorld.grid.get((int)(getX() / 80) + (int)(getY() / 80) * 8) == 0) {
            getWorld().removeObject(this);
        }
    }
    public void act()
    {
    }
}
