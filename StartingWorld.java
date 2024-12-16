import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartingWorld extends World
{
    public GreenfootSound bg1 = new GreenfootSound("Ascension for Solo Clarinet and String Orchestra (Radio Edit).mp3");
    /**
     * Constructor for objects of class StartingWorld.
     * 
     */
    public StartingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        setBackground(new GreenfootImage("StartingWorld.png"));
        addObject(new PlayMenu(), 400, 400);
        addObject(new HelpMenu(), 400, 500);
    }
    
    public void stopped(){
        bg1.pause();
    }
        
    public void started(){
        bg1.playLoop();
    }
}
