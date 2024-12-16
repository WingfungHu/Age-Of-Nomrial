import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayMenu extends Actor
{
    public PlayMenu(){
        setImage("PlayMenu.png");
    }
    /**
     * Act - do whatever the PlayMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            ((StartingWorld)getWorld()).bg1.stop();
            Greenfoot.setWorld(new GameWorld());
        }
    }
}
