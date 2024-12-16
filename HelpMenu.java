import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpMenu extends Actor
{
    public HelpMenu(){
        setImage("HelpMenu.png");
    }
    
    /**
     * Act - do whatever the HelpMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            ((StartingWorld)getWorld()).bg1.stop();
            Greenfoot.setWorld(new HelpWorld());
        }
    }
}
