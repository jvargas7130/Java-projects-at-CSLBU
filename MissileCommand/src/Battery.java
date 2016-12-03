import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Battery class shows the number of missiles available for launch. Battery also
 * extends rectangle
 * 
 * 
 * @author Jesus Vargas
 *
 */
public class Battery extends Rectangle {
	/**
	 * stores number of missiles
	 */
	private int numMissiles;

	/**
	 * stores color to be added in draw
	 * 
	 */
	private Color color;
	/*
	 * if battery exist, active is true
	 */
	private boolean active;

	/**
	 * Battery constructor  initializes x,y, width, height,active,numMissiles
	 * and colort
	 * 
	 * @param loc Point object
	 * @param c	Color object
	 */
	public Battery(Point loc, Color c) {
		x = (int) loc.getX();
		y = (int) loc.getY();

		width = 100;
		height = 100;

		active = true;
		numMissiles = 10;
		color = c;
	}
	
	/**
	 * draw method draws the rectangle shape  of battery
	 * 
	 * @param g object is passed in
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		// g.drawRect( x, y, width, height);//building
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString(" " + numMissiles, x, y + 50);
	}
	
	/**
	 * getnumMissiles is misssile count accessor
	 * 
	 * @return numMissiles are missiles left in battery 
	 */
	public int getNumMissiles() {
		return numMissiles;
	}
	
	/**
	 * remove missile method removes missiles 
	 * 
	 */
	public void removeMissile() {
		if (numMissiles > 0) {
			numMissiles--;
		}

	}
	
	/**
	 * Point method current point accessor
	 * @return current point 
	 */
	public Point getLocPoint() {
		return new Point(x, y);

	}
	
	/**
	 * is active method accessor
	 * 
	 * @return active true or false
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * checks to see if hit is in battery parameters
	 * 
	 * @param p point object of hit
	 * @return hit if hit was true or false
	 */
	public boolean isHit(Point p) {
		System.out.println(p);
		boolean hit = false;

		if (contains(p)) {
			numMissiles = 0;
			active = false;
			hit = true;
		}

		return hit;
	}

}
