import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SmallEnemyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Ship
{
    private int laserBeamTimer=Greenfoot.getRandomNumber(30)+20;
    
    
    private int random=Greenfoot.getRandomNumber(800)+300;
    private long last_time=System.currentTimeMillis();
    private long last_time2=System.currentTimeMillis();
    private boolean forward_backward=true;
    
    
    private int random_width=Greenfoot.getRandomNumber(400)+200;
    private long last_time_width=System.currentTimeMillis();
    private long last_time2_width=System.currentTimeMillis();
    private boolean forward_backward_width=true;
    
    
    private int life=10;
    /**
     * Act - do whatever the PlayerShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void gotShot(int damage){
        this.life-=damage;
        if(life<=0)
            this.getWorld().removeObject(this);
    }
    
    public int getLife(){
        return this.life;
    }
    
    public void act() 
    {
        long now=System.currentTimeMillis();
        if(now-last_time<random && forward_backward==true){
            this.setLocation(this.getX(), this.getY()+4);
            last_time2=System.currentTimeMillis();
        }else{
            forward_backward=false;
            if(now-last_time2<random && forward_backward==false){
                this.setLocation(this.getX(), this.getY()-4);
            }
                else{
                    random=Greenfoot.getRandomNumber(800)+300;
                    forward_backward=true;
                    last_time=System.currentTimeMillis();
                }
        }
        
        
        long now_width=System.currentTimeMillis();
        if(now_width-last_time_width<random_width && forward_backward_width==true){
            this.setLocation(this.getX()+2, this.getY());
            last_time2_width=System.currentTimeMillis();
        }else{
            forward_backward_width=false;
            if(now_width-last_time2_width<random_width && forward_backward_width==false){
                this.setLocation(this.getX()-2, this.getY());
            }
                else{
                    random_width=Greenfoot.getRandomNumber(400)+200;
                    forward_backward_width=true;
                    last_time_width=System.currentTimeMillis();
                }
        }
        
        
        
        laserBeamTimer--;
        if(laserBeamTimer<=0){
            Arsenal laserBeam1=new EnemyLaserBeam(this.getX()-10, this.getY(), this.getWorld());
            Arsenal laserBeam2=new EnemyLaserBeam(this.getX()+10, this.getY(), this.getWorld());
            laserBeamTimer=Greenfoot.getRandomNumber(90)+10;
        }
    }  
}







