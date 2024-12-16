import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class stickEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StickEnemy extends Actor
{
    // Initialize variables
    protected int maxHP, speed, damage, hp;
    protected StatBar hpBar;
    protected GameWorld gw;
    protected long lastAdded;
    public StickEnemy(int MaxHP, int Speed, int Damage){
        maxHP = MaxHP;
        hp = maxHP;
        speed = Speed;
        damage = Damage;
        hpBar = new StatBar (hp, this);
        lastAdded  = System.currentTimeMillis();
    }
    
    public StickEnemy() {
        
    }
    
    public void hitStickEnemy (int damage)
    {
        // Ensure that HP doesn't fall below zero
        if (hp - damage >= 0){
            hp -= damage;
        }else{
            hp = 0;
        }
    }
}
