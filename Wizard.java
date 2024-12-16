import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Automatic tower.
 */
public class Wizard extends Actor
{
    private int fireCooldown, cooldownCounter;
    private GameWorld gw;
    public Wizard(){
        fireCooldown = 50;
        setImage("Wizard.png");
    }
    
    public void addedToWorld (World w){
        gw = (GameWorld)w;
    }
    
    /**
     * Act - do whatever the AutomaticPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){ // Runs cooldown and makes sure enemies are available to shoot.
        if (cooldownCounter > 0){
            cooldownCounter--;
        }
        if (!getWorld().getObjects(StickEnemy.class).isEmpty()){
            fire();             
        }
    }
    
    public void fire(){ // Called when the cooldown is over, fires at enemies.
        int wizardCounter = gw.getWizardCounter();
        if(cooldownCounter == 0 && wizardCounter == 1){
            getWorld().addObject(new MagicMissle(), 475, 155);
            cooldownCounter = fireCooldown;
        }else if(cooldownCounter == 0 && wizardCounter == 2){
            getWorld().addObject(new MagicMissle(), 475, 155);
            getWorld().addObject(new MagicMissle(), 725, 315);
            cooldownCounter = fireCooldown;
        }
    }
}
