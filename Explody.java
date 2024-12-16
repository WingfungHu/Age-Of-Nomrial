import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Goes up to wall and explodes. (some regular comments apply)
 */
public class Explody extends StickEnemy
{
    private int positionLimit;
    private GifImage stickEnemyGif = new GifImage("Explody.gif");
    public Explody (){
        super (2, 3, 10);
    }

    public void addedToWorld (World w){
        gw = (GameWorld)w;
        positionLimit = gw.getRandomChance();
        gw.addObject(hpBar, 0, 0);
    }

    /**
     * Act - do whatever the Regular wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(stickEnemyGif.getCurrentImage());
        if(positionLimit == 0){
            if(getX() < 700){
                move(speed);
            }else{ // To make sure it deals damage and then gets removed.
                long curTime = System.currentTimeMillis();
                if (curTime >= lastAdded + 1000){
                    gw.reduceHP(damage);
                    lastAdded = curTime;
                    getWorld().removeObject(this);
                }
            }
        }else if(positionLimit == 1){
            if(getX() < 625){
                move(speed);
            }else{
                long curTime = System.currentTimeMillis();
                if (curTime >= lastAdded + 1000){
                    gw.reduceHP(damage);
                    lastAdded = curTime;
                    getWorld().removeObject(this);
                }
            }
        }else if(positionLimit == 2){
            if(getX() < 530){
                move(speed);
            }else{
                long curTime = System.currentTimeMillis();
                if (curTime >= lastAdded + 1000){
                    gw.reduceHP(damage);
                    lastAdded = curTime;
                    getWorld().removeObject(this);
                }
            }
        }
        hpBar.update(hp);
        if(hp == 0){
            gw.reduceEnemy();
            getWorld().removeObject(this);
        }
    }
}
