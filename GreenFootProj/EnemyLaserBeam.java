import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class EnemyLaserBeam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyLaserBeam extends Arsenal
{
    private int lastY;
    
    
    public EnemyLaserBeam(int x,int y, World world){
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
        this.setLocation(getX(), getY()+12);
        
        if(lastY==this.getY()){
           this.getWorld().removeObject(this);
           return;
        }
        
        shotPlayer();
    }    
    
    
    
    private void shotPlayer(){
       List<PlayerShip> playersShips=getWorld().getObjects(PlayerShip.class); 

       for(PlayerShip playerShip:playersShips){
        for(int y=0;y<=70;y++)
        for(int x=0;x<=70;x++){
            if((playerShip.getX()+x ==this.getX() || playerShip.getX()-x == this.getX()) && (playerShip.getY()+y ==this.getY() || playerShip.getY()-y == this.getY())){ 
                playerShip.gotShot(1);
                ((Space)getWorld()).addPlayerLifeBar();
                this.getWorld().removeObject(this);
                return;
            }
        }
       }
    }
}