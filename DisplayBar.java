import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DisplayBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayBar extends Actor
{
    private GreenfootImage displayBar;
    private Font textFont;
    private String textOne, textTwo, textThree;
    private int fontSize;
    private Color background, textColor;
    
    public DisplayBar(){
        fontSize = 24;
        textFont = new Font ("Times New Roman", true, false, fontSize);
        displayBar = new GreenfootImage (300, 130);
        background = new Color(0, 0, 0);
        textColor = new Color(255, 255, 255);
        displayBar.setColor(background);
        displayBar.fill();
        
        this.setImage(displayBar);
        displayBar.setFont(textFont);
    }
    
    public void update(int gold, int castleHP, int waveNumber, int enemiesLeft){
         textOne = ("Castle HP: " + castleHP);
         textTwo = ("Wave: " + waveNumber);
         textThree = ("Enemies Remaining: " + enemiesLeft);
         this.update(textOne, textTwo, textThree);
    }
    
    public void update(String output, String outputTwo, String outputThree){
        // Refill the background with background color
        displayBar.setColor(background);
        displayBar.fill();  
        // Write text over the solid background
        displayBar.setColor(textColor);
        // Draw the text onto the image
        displayBar.drawString(output, 70, 24);
        displayBar.drawString(outputTwo, 110, 73);
        displayBar.drawString(outputThree, 40, 120);
    }
}
