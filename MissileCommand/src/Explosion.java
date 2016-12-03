import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Explosion class is used when a defenders missile reaches its target, an
 * explosion is triggered at that location. This explosion can destroy the
 * attackers missiles. When the attackers missiles are destroyed , they also
 * cause and explosion that can destroy other missiles. Explosion extends
 * rectangle
 * 
 * 
 * @author Jesus Vargas
 *
 */
public class Explosion extends Rectangle {

	/**
	 * expanding is true it explosion is expanding
	 */
	private boolean expanding;

	/**
	 * active is true if explosion exist
	 */
	private boolean active;

	/**
	 * point center of explosion
	 */
	private Point center;

	/**
	 * Explosion constructor where instant variables are initialize and point p
	 * is passed in
	 * 
	 * @param p is the point of explosion
	 *           
	 */
	public Explosion(Point p) {
		active = true;
		expanding = true;
		width = 5;
		height = 5;
		center = new Point((int) p.getX(), (int) p.getY());
		super.setLocation(p);

	}

	/**
	 * draw method where explosion is drawn
	 */
	public void draw(Graphics g) {

		g.setColor(Color.YELLOW);
		g.fillOval((int) center.getX() - width / 2, (int) center.getY() - height / 2, width, height);
	}

	/**
	 * Move method which animates explosion
	 * 
	 * @return expanding if true
	 */
	public boolean move() {

		if (expanding == true) {
			width = width + 3;
			height = height + 3;

			super.setLocation((int) center.getX() - width / 2, (int) center.getY() - height / 2);
			super.setSize(width, height);

			expanding = true;
		}

		if (width >= 250 && height >= 250) {

			expanding = false;
			active = false;

		}

		return expanding;

	}
	
	/**
	 * active method accessor
	 * 
	 * @return active true or false
	 */
	public boolean isActive() {

		return active;
	}
	
	/**
	 * checks if the point is in explosion parameters
	 * 
	 * @return the point if true
	 */
	public boolean contains(Point p) {
		return super.contains(p);

	}
	
	/**
	 * Current point accessor
	 * 
	 * @return current point location
	 */
	public Point getLocPoint() {
		return new Point((int) center.getY(), (int) center.getY());

	}

}
