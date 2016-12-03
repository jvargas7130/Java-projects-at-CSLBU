import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Missile class is used for both the attackers for launch Missile extends
 * rectangle
 * 
 * @author Jesus Vargas
 *
 */
public class Missile extends Rectangle {

	/**
	 * where point starts
	 * 
	 */
	private Point start;

	/**
	 * current location
	 */
	private Point location;

	/**
	 * 
	 * where point ends
	 */
	private Point end;

	/**
	 * speed of missile
	 */
	private double speed;

	/**
	 * color of missile
	 */
	private Color color;

	/**
	 * type of missile
	 */
	private int type;

	/**
	 * acitve is true if missile exist
	 */
	private boolean active = true;
	/**
	 * dx is change of x, dy is change of y and size is magnitude or triangle
	 */
	private double dx, dy, size;

	// start point, end point, speed, type, color

	/**
	 * missile constructor where missile variables are initialize
	 * 
	 * @param s is start point
	 *           
	 * @param e is end point
	 *            
	 * @param sp is the speed
	 *           
	 * @param t is the type
	 *            
	 * @param c is the color
	 *            
	 */
	public Missile(Point s, Point e, double sp, int t, Color c) {

		start = s;
		end = e;
		speed = sp;
		type = t;
		color = c;

		location = s;

	}
	
	/**
	 * move method animates the missile as long as it is active
	 */
	public void move() {

		double x1 = (double) start.getX();
		double y1 = (double) start.getY();

		double x2 = (double) end.getX();
		double y2 = (double) end.getY();

		dx = x2 - x1;
		dy = y2 - y1;
		size = Math.sqrt((dx * dx) + (dy * dy));

		double R = speed;

		double newX = location.getX() + (dx * (R / size));
		double newY = location.getY() + (dy * (R / size));

		if (size <= speed) {
			System.out.println("newx " + newX);
			System.out.println("newy " + newY);
			location = new Point((int) end.getX(), (int) end.getY());
			active = false;
		} else {
			location.setLocation(newX, newY);
		}

	}
	
	/**
	 * draw method draws the missile
	 * 
	 * @param g object is passed in
	 */
	public void draw(Graphics g) {
		g.setColor(color);

		g.fillRect((int) location.getX(), (int) location.getY(), 20, 20);

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
	 * current point accessor
	 * 
	 * @return location current location
	 */
	public Point getLocPoint() {
		return location;

	}
	
	/**
	 * type method acessor
	 * 
	 * @return type of missile
	 */
	public int getType() {
		return type;

	}

}
