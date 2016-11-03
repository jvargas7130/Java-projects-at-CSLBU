import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *Explosion class is used when a defenders missile reaches its target, an 
 *explosion is triggered at that location. This explosion can destroy the
 *attackers missiles. When the attackers missiles are destroyed , they also cause 
 *and explosion that can destroy other missiles.  Explosion extends rectangle
 * 
 * 
 * @author Jesus Vargas
 *
 */
public class Explosion extends Rectangle {
	private boolean expanding;
	private boolean active;
	
	
	public void Explosion(Point p){
		
	}
	
	public void draw(Graphics g){
		
	}
	
	public boolean move(){
		return active;
		
	}
	
	public boolean isActive(){
		return active;
	}
	
	
	public boolean contains(Point p){
		return expanding;
	}
	
	public Point getLocPoint(){
		return null;
		
	}
	

}
