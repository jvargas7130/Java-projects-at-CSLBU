import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Battery class shows the number of missiles available for launch. 
 * Battery also extends rectangle 
 * 
 * 
 * @author Jesus Vargas
 *
 */
public class Battery extends Rectangle {
	private int numMissiles;
	private Color color;
	
	
	public Battery(Point loc, Color c){
		color = c;
	}
	
	public  void draw(Graphics g, int height,int width){
		g.setColor(color);
		
		g.drawRect(width - 1920,  height - 100, 70,100 );//battery
		g.drawRect(width - 920, height  - 100, 70,100 );//battery
		g.drawRect(width - 120,  height  - 100, 70,100);//battery
	}
	
	public int getNumMissiles(){
		return numMissiles;
	}
	
	public void removeMissile(){
		
	}
	
	public Point getLocPoint(){
		return null;
		
	}
	
	public Boolean isHit(Point p){
		return true;
	}


	
}