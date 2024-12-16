import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class GameWorld extends World
{
    // Initialize variables.
    private long startTime, endTime;
    private long lastAdded = System.currentTimeMillis();
    private double levelDurationSeconds; 
    private int gold, difficultyRate = 1, waveReset = 0, maxCastleHP = 100, castleHP = 100, enemiesToBeSpawned, enemiesLeft, counter = 0, randomChance, timerCounter = 0, wizardCounter = 0, musicCounter = 0;
    private int[] enemiesPerLevel = {10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};
    private static int waveNumber;
    private DisplayBar displayBar;
    private static StickEnemy stickEnemy;
    public GreenfootSound bg2 = new GreenfootSound("Little Dance for Brass Trio and Cajon.mp3");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {                                                                
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        setBackground (new GreenfootImage("Game World.png"));
        if(waveReset == 0){
            waveNumber = 1; // Helps with the lose screen world, and makes sure this only runs once
            waveReset++;
        }
        addObject(new Player(), 620, 225);  
        displayBar = new DisplayBar();
        addObject(displayBar, 270, 80);
    }

    public void musicStart(){
        bg2.playLoop();
    }
    
    public StickEnemy getStickEnemy(){ // Detects the closest enemy to the castle.
        ArrayList<StickEnemy> enemies = (ArrayList<StickEnemy>)getObjects(StickEnemy.class);
        if (enemies.size() == 0){
            return null;
        }
        StickEnemy closestToTower = enemies.get(0);
        for (StickEnemy s : enemies){
            if (s.getX() > closestToTower.getX()){
                closestToTower = s;
            }
        }
        return closestToTower;
        // return stickEnemy;
    }

    public void waveMaker1and2(){ // Sets up waves 1 and 2.
        randomChance = (int)(Math.random() * 3);
        if(randomChance == 0){
            stickEnemy = new Regular();
            addObject(stickEnemy, 50, 525);
        }else if(randomChance == 1){
            stickEnemy = new Regular();
            addObject(stickEnemy, 50, 460);
        }else if(randomChance == 2){
            stickEnemy = new Regular();
            addObject(stickEnemy, 50, 400);
        }
        enemiesToBeSpawned--;
    }
    
    public void waveMaker3and4(){ // Sets up waves 3 and 4.
        randomChance = (int)(Math.random() * 3);
        if(randomChance == 0){
            randomChance = (int)(Math.random() * 2);
            if(randomChance == 0){
                stickEnemy = new Regular();
                addObject(stickEnemy, 50, 525);
            }else if(randomChance == 1){
                stickEnemy = new Speedy();
                addObject(stickEnemy, 50, 525);
            }
        }else if(randomChance == 1){
            randomChance = (int)(Math.random() * 2);
            if(randomChance == 0){
                stickEnemy = new Regular();
                addObject(stickEnemy, 50, 460);
            }else if(randomChance == 1){
                stickEnemy = new Speedy();
                addObject(stickEnemy, 50, 460);
            }
        }else if(randomChance == 2){
            randomChance = (int)(Math.random() * 2);
            if(randomChance == 0){
                stickEnemy = new Regular();
                addObject(stickEnemy, 50, 400);
            }else if(randomChance == 1){
                stickEnemy = new Speedy();
                addObject(stickEnemy, 50, 400);
            }
        }
        enemiesToBeSpawned--;
    }
    
    public void waveMaker5and6(){ // Sets up Wave 5 and 6.
        randomChance = (int)(Math.random() * 3);
        if(randomChance == 0){
            randomChance = (int)(Math.random() * 3);
            if(randomChance == 0){
                stickEnemy = new Regular();
                addObject(stickEnemy, 50, 525);
            }else if(randomChance == 1){
                stickEnemy = new Speedy();
                addObject(stickEnemy, 50, 525);
            }else if(randomChance == 2){
                stickEnemy = new Heavy();
                addObject(stickEnemy, 50, 525);
            }
        }else if(randomChance == 1){
            randomChance = (int)(Math.random() * 3);
            if(randomChance == 0){
                stickEnemy = new Regular();
                addObject(stickEnemy, 50, 460);
            }else if(randomChance == 1){
                stickEnemy = new Speedy();
                addObject(stickEnemy, 50, 460);
            }else if(randomChance == 2){
                stickEnemy = new Heavy();
                addObject(stickEnemy, 50, 460);
            }
        }else if(randomChance == 2){
            randomChance = (int)(Math.random() * 3);
            if(randomChance == 0){
                stickEnemy = new Regular();
                addObject(stickEnemy, 50, 400);
            }else if(randomChance == 1){
                stickEnemy = new Speedy();
                addObject(stickEnemy, 50, 400);
            }else if(randomChance == 2){
                stickEnemy = new Heavy();
                addObject(stickEnemy, 50, 400);
            }
        }
        enemiesToBeSpawned--;
    }
    
    public void waveMaker7AndBeyond(){ // Sets up wave 7 and other waves.
        randomChance = (int)(Math.random() * 3);
        if(randomChance == 0){
            randomChance = (int)(Math.random() * 4);
            if(randomChance == 0){
                stickEnemy = new Regular();
                addObject(stickEnemy, 50, 525);
            }else if(randomChance == 1){
                stickEnemy = new Speedy();
                addObject(stickEnemy, 50, 525);
            }else if(randomChance == 2){
                stickEnemy = new Heavy();
                addObject(stickEnemy, 50, 525);
            }else if(randomChance == 3){
                stickEnemy = new Explody();
                addObject(stickEnemy, 50, 525);
            }
        }else if(randomChance == 1){
            randomChance = (int)(Math.random() * 4);
            if(randomChance == 0){
                stickEnemy = new Regular();
                addObject(stickEnemy, 50, 460);
            }else if(randomChance == 1){
                stickEnemy = new Speedy();
                addObject(stickEnemy, 50, 460);
            }else if(randomChance == 2){
                stickEnemy = new Heavy();
                addObject(stickEnemy, 50, 460);
            }else if(randomChance == 3){
                stickEnemy = new Explody();
                addObject(stickEnemy, 50, 460);
            }
        }else if(randomChance == 2){
            randomChance = (int)(Math.random() * 4);
            if(randomChance == 0){
                stickEnemy = new Regular();
                addObject(stickEnemy, 50, 400);
            }else if(randomChance == 1){
                stickEnemy = new Speedy();
                addObject(stickEnemy, 50, 400);
            }else if(randomChance == 2){
                stickEnemy = new Heavy();
                addObject(stickEnemy, 50, 400);
            }else if(randomChance == 3){
                stickEnemy = new Explody();
                addObject(stickEnemy, 50, 400);
            }
        }
        enemiesToBeSpawned--;
    }
        
    public static int getWaveNumber(){ // For other actors to get wave number.
        return waveNumber;
    }
    
    public int getRandomChance(){ // For other actors to get random chance.
        return randomChance;
    }
    
    public int getWizardCounter(){ // For other actors to get wizards in the game.
        return wizardCounter;
    }
    
    public void reduceEnemy(){ // For other actors to reduce enemies hp.
        enemiesLeft--;
    }

    public void reduceHP(int hpLost){
        // For enemies if they hit the castle.
        if (castleHP - hpLost >= 0){
            castleHP -= hpLost;
        }else{
            castleHP = 0;
        }
    }

    public void act(){
        if(musicCounter == 0){
            musicStart();
            musicCounter++;
        }
        displayBar.update(gold, castleHP, waveNumber, enemiesToBeSpawned);
        if(counter == 0){
            enemiesToBeSpawned = enemiesPerLevel[waveNumber - 1];
            enemiesLeft = enemiesPerLevel[waveNumber - 1];
            counter++;
        }
        if(enemiesToBeSpawned > 0 && difficultyRate == 1){
            long curTime = System.currentTimeMillis();
            if (curTime >= lastAdded + 1000) // ex . 5000ms = 5s
            {
                if(waveNumber <= 2){
                    waveMaker1and2();
                }else if(waveNumber == 3 || waveNumber == 4){
                    waveMaker3and4();
                }
                lastAdded = curTime;
            }
        }else if(enemiesToBeSpawned > 0 && difficultyRate == 2){
            long curTime = System.currentTimeMillis();
            if (curTime >= lastAdded + 500) // ex . 5000ms = 5s
            {
                if(waveNumber == 5 || waveNumber == 6){
                    waveMaker5and6();
                }else if(waveNumber >= 7){
                    waveMaker7AndBeyond();
                }
                lastAdded = curTime;
            }
        }
        if(enemiesLeft == 0){
            waveNumber++;
            counter--;
        }
        if(waveNumber == 5 && wizardCounter == 0){
            addObject(new Wizard(), 495, 145);
            wizardCounter++;
        }
        if(waveNumber == 7 && wizardCounter == 1){
            addObject(new Wizard(), 745, 305); 
            wizardCounter++;
        }
        if(waveNumber == 5 && difficultyRate == 1){
            difficultyRate++;
        }
        if(castleHP == 0){
            bg2.stop();
            Greenfoot.setWorld(new LoseWorld());
        }
    }
}
