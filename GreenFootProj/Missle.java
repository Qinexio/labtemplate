import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Missle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Missle extends Arsenal
{
    private int lastY;
    
    public Missle(int x,int y, World world){
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
        this.setLocation(getX(), getY()-8);
        
        if(lastY==this.getY()){
            this.getWorld().removeObject(this);
            return;
        }
        
        shotEnemy();
    }    
    
    private void shotEnemy(){
        
        List<SmallEnemyShip> enemyShips = this.getWorld().getObjects(SmallEnemyShip.class);
        
        
        for(SmallEnemyShip enemyShip:enemyShips){
        
            for(int y=0;y<40;y++)
                for(int x=0;x<40;x++){
                    if((enemyShip.getX()+x == this.getX() || enemyShip.getX()-x == this.getX())&&(enemyShip.getY()+y == this.getY() || enemyShip.getY()-y == this.getY())){
                        //enemyShip.gotShot(enemyShip.getLife());
                        enemyShip.gotShot(10);
                        this.getWorld().removeObject(this);
                        return;
                    }
                }
            
        }
        
    }
}





