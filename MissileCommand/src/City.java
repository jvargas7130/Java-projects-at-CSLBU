import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 * This class represents each of the cities the defender must
 * protect. Panel extends rectangle to use its location and collision
 *  detection methods
 * 
 * @author jvarg
 *
 */

public class City extends Rectangle {
	
	/**
	 * acitve is true if city exist
	 */
	private boolean active;
	
	/**
	 * color of city
	 */
	private Color color;
	
	/**
	 * city constructor where variables are initialize
	 * 
	 * @param loc point object is passed in 
	 * @param c color of city
	 */
	public City(Point loc, Color c) {
		active = true;
		x = (int) loc.getX();
		y = (int) loc.getY();
		height = 170;
		width = 100;

		color = c;
	}
	
	
	/**
	 * draw method where city is drawn
	 * 
	 * @param g object is passed in 
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		// g.drawRect( x, y, height, width);//building
	}
	
	/**
	 * is active method accessor
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 *Point method accessor
	 * 
	 * @return current point
	 */
	public Point getLocPoint() {
		return new Point(x, y);

	}
	
	/**
	 * checks to see if hit is in battery parameters
	 * 
	 * @param p point object of hit
	 * @return hit if hit was true or false
	 */
	public boolean isHit(Point p) {
		boolean hit = false;
		System.out.println("point" + p);
		System.out.println("contains " + contains(p));
		if (this.contains(p)) {
			System.out.println("inside contains");

			active = false;
			hit = true;
		}

		return hit;
	}

}
