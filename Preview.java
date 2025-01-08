import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shadow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Preview extends Actor
{
    static int gridX;
    static int gridY;
    static int x;
    static int y;
    public GreenfootImage image;
    public Preview(String block) {
        if (block.equals("two")) {
            setImage(new GreenfootImage("two.png"));
        }
        image = getImage();
    }
    public void drag() {
        if (Greenfoot.mouseDragged(this)){

             setLocation(Greenfoot.getMouseInfo().getX() - 80,Greenfoot.getMouseInfo().getY() - 80);
        } else if (Greenfoot.mouseDragEnded(this)) {
            setLocation(800,400);
        }
    }

    public void act()
    {
        x = getX() - image.getWidth() / 2;
        y = getY() - image.getHeight() / 2;
        gridX = (int)((getX()) / 80);
        gridY = (int)((getY()) / 80);
        drag();
    }
}
