import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Really strong version of Regular (regular comments apply to this)
 */
public class Heavy extends StickEnemy
{
    private int positionLimit;
    private GifImage stickEnemyGif = new GifImage("Heavy.gif");
    public Heavy (){
        super (5, 1, 2);
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
            }else{
                long curTime = System.currentTimeMillis();
                if (curTime >= lastAdded + 1000){
                    gw.reduceHP(damage);
                    lastAdded = curTime;
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
