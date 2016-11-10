import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 * @author j**
 * This class represents each of the cities the defender must protect.
 *Panel extends rectangle to use its location and collision detection methods
 * 
 * @author jvarg
 *
 */

public class City extends Rectangle {
	boolean active;
	Color color;
	
	public  City(Point loc, Color c){
		
		color = c;
	}

	public void draw(Graphics g, int height, int width ){

	
		


		
		g.setColor(color);
		g.drawRect( width - 1720 , height - 220, 100, 220);//building
		g.drawRect(width - 1520,  height - 250, 130,250 );//building
		
		
		
	
		g.drawRect( width -1320, height - 280, 130,280);//building
		g.drawRect(width - 1120,height  - 220, 100,220 );//building
		
	
	
		
	
		g.drawRect(width - 720,height  - 280, 100,280 );//building
		g.drawRect(width - 520, height  - 250, 130,250 );//building
		g.drawRect(width - 320, height - 150, 130,150 );//building
		


		
		
	}
	
	public boolean isActive(){
		return true;
	}
	
	public Point getLocPoint(){
		return null;
		
	}
	
	
	
}
