import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseWorld extends World
{
    private WaveBar waveBar;
    public GreenfootSound bg3 = new GreenfootSound("Were You There for Brass Trio.mp3");
    private int mCounter = 0;
    /**
     * Constructor for objects of class LoseWorld.
     * 
     */
    public LoseWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        setBackground(new GreenfootImage("LoseWorld.png"));
        waveBar = new WaveBar();
        addObject(waveBar, 530, 250);
        if(mCounter == 0){
            bg3.playLoop();
            mCounter++;
        }
    }
    
    public void act(){
        waveBar.update(GameWorld.getWaveNumber());
        if(Greenfoot.mouseClicked(this)){
            bg3.stop();
            Greenfoot.setWorld(new StartingWorld());
        }
    }
}
