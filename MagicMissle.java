import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AutomaticArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicMissle extends Actor
{
    int speed;
    int damage = 1;    
    int turned = 0;
    private StickEnemy stickEnemy;
    public MagicMissle (){
        speed = 10;
    }

    /**
     * Act - do whatever the AutomaticArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GameWorld gw = (GameWorld)getWorld();
        stickEnemy = gw.getStickEnemy();
        // if(!getWorld().getObjects(StickEnemy.class).isEmpty()){
        if (stickEnemy != null){
            this.turnTowards(stickEnemy.getX(), stickEnemy.getY());
        }
        move(speed);
        if (atWorldEdge()){
            getWorld().removeObject(this);
        }else{
            // See if I collided with a stick enemy
            StickEnemy se = (StickEnemy)getOneObjectAtOffset(-1, 0, StickEnemy.class);
            // If I did collide wth a stick enemy, send damage to that stick enemy
            // and remove myself from the World
            if (se != null){
                se.hitStickEnemy(damage);
                getWorld().removeObject(this);
            }
        }
    }

    public boolean atWorldEdge(){  
        if(getX() < 10 || getX() > getWorld().getWidth() - 10)  
            return true;  
        if(getY() < 10 || getY() > getWorld().getHeight() - 10)  
            return true;  
        else 
            return false;  
    }  
}
