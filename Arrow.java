import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    int speed;
    int damage = 1;    
    int turned;
    public Arrow (){
        speed = 9;
    }
    
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // To make the arrow follow the direction where the mouse was clicked.
        if(turned == 0){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            this.turnTowards(mouse.getX(), mouse.getY());
            turned++;
        }
        move (speed);
        // remove this arrow if it reaches the edge of the World
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
