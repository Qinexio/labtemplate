import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerShip extends Ship
{
    private int missleTimer=0;
    private int laserBeamTimer=0;
    private int life=10;
    
    
    /**
     * Act - do whatever the PlayerShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void gotShot(int damage){
        this.life-=damage;
        if(life==0)
        this.getWorld().removeObject(this);
    }
    
    public int getLife(){
        return this.life;
    }
    
    public void act() 
    {
        
        missleTimer--;
        laserBeamTimer--;
        
        // Add your action code here.
        if(Greenfoot.isKeyDown("left")){
            move(-8);
        }
        if(Greenfoot.isKeyDown("right")){
            move(8);
        }
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-6);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+6);
        }
        if(Greenfoot.isKeyDown("control") && missleTimer<=0){
            Arsenal missle=new Missle(this.getX(), this.getY(), this.getWorld());
            missleTimer=500;
        }
        
        if(Greenfoot.isKeyDown("z") && laserBeamTimer<=0){
            Arsenal laserBeam1=new LaserBeam(this.getX()-16, this.getY(), this.getWorld());
            Arsenal laserBeam2=new LaserBeam(this.getX()+16, this.getY(), this.getWorld());
            laserBeamTimer=20;
        }
    }    
}
