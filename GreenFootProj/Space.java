import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    private PlayerShip playerShip=new PlayerShip();
    private List<SmallEnemyShip> smallEnemyShips=new ArrayList<SmallEnemyShip>();
    private List<LifeBar> playerLifeBars=new ArrayList<LifeBar>();
    private Boss boss;
    
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1120, 580, 1); 
        this.addPlayerShip();
        this.createSmallEnemyShip(7);
        this.addSmallEnemyShip(160);
        
        addPlayerLifeBar();
    }
    
    public void addPlayerLifeBar(){
        this.removeObjects(playerLifeBars);
        List<PlayerShip> playerShips = this.getObjects(PlayerShip.class);
        for(PlayerShip playerShip:playerShips){
            for(int lifeBar=0; lifeBar<playerShip.getLife();lifeBar++){
                LifeBar playerLifeBar = new LifeBar();
                playerLifeBars.add(playerLifeBar);
                this.addObject(playerLifeBar, 20+lifeBar*10, 560);
            }
        }
    }
    
    private void addPlayerShip(){
        this.addObject(playerShip, 560, 500);
    }
    
    public PlayerShip getPlayerShip(){
        return this.playerShip;
    }
    
    private void createSmallEnemyShip(int shipsNumber){
        for(int i=0;i<shipsNumber;i++){
            smallEnemyShips.add(new SmallEnemyShip());
        }
    }
    
    private void addSmallEnemyShip(int shipDistance){
        
        int distance=50;
        
        for(Ship smallEnemyShip:smallEnemyShips){
            this.addObject(smallEnemyShip, distance, 50);
            distance+=shipDistance;
            
        }
    }
    
    public List<SmallEnemyShip> getSmallEnemyShips(){
        return this.smallEnemyShips;
    }
    
    public void enemyDown(SmallEnemyShip enemyShip){
        smallEnemyShips.remove(enemyShip);
        if(smallEnemyShips.isEmpty()){
            LaserBeam.setIsBoss(true);
            boss=new Boss();
            this.addObject(boss, 560, 50);
        }
    }
}
