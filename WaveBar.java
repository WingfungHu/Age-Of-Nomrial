import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaveBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveBar extends Actor
{
    private GreenfootImage waveBar;
    private Font textFont;
    private String text;
    private int fontSize;
    private Color background, textColor;
    private GameWorld gw;
    public WaveBar(){
        fontSize = 32;
        textFont = new Font ("Courier New", true, false, fontSize);
        waveBar = new GreenfootImage (200, 70);
        background = new Color(0, 0, 0, 0);
        textColor = new Color(255, 255, 255);
        waveBar.setColor(background);
        waveBar.fill();
        
        this.setImage(waveBar);
        waveBar.setFont(textFont);
    }
    
    public void update(int waveNumber){
        text = ("Wave " + waveNumber);    
        this.update(text);
    }
    
    public void update(String output){
        // Refill the background with background color
        waveBar.setColor(background);
        waveBar.fill();  
        // Write text over the solid background
        waveBar.setColor(textColor);
        // Draw the text onto the image
        waveBar.drawString(output, 30, 39);
    }
}
