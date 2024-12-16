import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Defense here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int fireCooldown, cooldownCounter;
    public Player(){
        fireCooldown = 20;
        setImage("Archer.png");
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (cooldownCounter > 0){
            cooldownCounter--;
        }
        MouseInfo m = Greenfoot.getMouseInfo();
        if (m != null){
            int buttonNumber = m.getButton();
            if (buttonNumber == 1){
                fire();
            }
        }
    }
    
    public void fire(){
        if(cooldownCounter == 0){
            getWorld().addObject(new Arrow(), 615, 225);
            cooldownCounter = fireCooldown;
        }
    }
}
