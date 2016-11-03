import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Missile class is used for both the attackers for launch
 * Missile extends rectangle
 * 
 * @author Jesus Vargas
 *
 */
public class Missile extends Rectangle {
	private Point start; 
	private Point location;
	private Point end;
	private int speed;
	private Color color;
	private int type;
	private boolean active;
	
	
	public  Missile(Point s, Point e){
		
	}
	
	public void move(){
		
	}
	
	public void draw(Graphics g){
		
	}
	
	public boolean isActive(){
		return active;
		
	}
	
	public Point getLocPoint(){
		return end;
		
	}
	
}
