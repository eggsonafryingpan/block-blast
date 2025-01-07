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
    /**
     * Act - do whatever the Shadow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Preview() {
        GreenfootImage image = getImage();
        image.scale((int)(image.getWidth() * 0.8), (int)(image.getHeight() * 0.8));
        two();
    }
    public void drag() {
        if (Greenfoot.mouseDragged(this)){
         if (!Greenfoot.mouseDragEnded(Block.class)){
             setLocation(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
            }
        }
    }
    public void two() {
        Preview two1 = new Preview();
        getWorld().addObject(two1, getX() + 80, getY() +80);
    }
    public void act()
    {
        
        gridX = (int)((getX()) / 80);
        gridY = (int)((getY()) / 80);
        drag();
    }
}
