import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class LaserBeam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LaserBeam extends Arsenal
{
    private int lastY;
    private static boolean isBoss=false;
    
    public LaserBeam(int x,int y, World world){
        this.setLocation(x, y);
        world.addObject(this, x, y);
    }
    
    
    /**
     * Act - do whatever the Missle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        lastY=this.getY();
        this.setLocation(getX(), getY()-12);
        
        if(lastY==this.getY()){
            this.getWorld().removeObject(this);
            return;
        }
            
        this.shotEnemy();
        //this.shotBoss();
    }   
    
    
    private void shotEnemy(){
        List<SmallEnemyShip> smallEnemyShips=this.getWorld().getObjects(SmallEnemyShip.class);
       for(SmallEnemyShip enemyShip:smallEnemyShips){
        for(int y=0;y<=40;y++)
        for(int x=0;x<=40;x++){
            if((enemyShip.getX()+x == this.getX() || enemyShip.getX()-x ==this.getX()) && (enemyShip.getY()+y ==this.getY() || enemyShip.getY()-y ==this.getY())){ 
                enemyShip.gotShot(1);
                this.getWorld().removeObject(this);
                return;
            }
        }
       }
    }
    
    private void shotBoss(){
    
        if(isBoss==false)
            return;
            
       List<Boss> smallEnemyShips=this.getWorld().getObjects(Boss.class);
       for(Boss enemyShip:smallEnemyShips){
        for(int y=0;y<=100;y++) 
        for(int x=0;x<=100;x++){
            if((enemyShip.getX()+x == this.getX() || enemyShip.getX()-x ==this.getX()) && (enemyShip.getY()+y ==this.getY() || enemyShip.getY()-y ==this.getY())){ 
                enemyShip.gotShot(1);
                this.getWorld().removeObject(this);
                return;
            }
        }
       }
        
    }
    
    public static void setIsBoss(boolean isBossParam){
        isBoss=isBossParam;
    }
    
}
