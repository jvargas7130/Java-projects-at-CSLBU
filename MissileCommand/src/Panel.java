
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel crates an rray of six cities, three batteries , and ArrayLIst for
 * temporary object like missiles and explosions.
 * 
 * 
 * 
 * @author Jesus Vargas
 *
 */
public class Panel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

	private City city[];
	private Battery battery[];
	private Missile[] missile;
	private ArrayList<Explosion> e;
	private Point crossH;

	public Panel() {

		// initialize cross hair
		crossH = new Point(getWidth() + 960, getHeight() + 540);

		// add mouse motion
		addMouseMotionListener(this);

		// set backround of panel blue
		this.setBackground(Color.BLUE);

		// 6 citys
		int counter = 0;
		int xcord = 220;
		city = new City[10];
		for (int i = 0; i < 6; i++) {

			if (counter < 2) {
				city[i] = new City(new Point(xcord, 835), Color.GREEN);
				xcord = xcord + 220;
			} else {
				city[i] = new City(new Point(xcord, 835), Color.GREEN);
				xcord = xcord + 440;
				counter = -1;
			}

			counter++;
		}

		// 3 Batteries
		int xcord2 = 0;
		battery = new Battery[3];
		for (int i = 0; i < 3; i++) {
			battery[i] = new Battery(new Point(xcord2, 905), Color.RED);
			xcord2 = xcord2 + 880;
		}

		
		//missle
		missile = new Missile[3];
		missile[0] = new Missile(new Point(0,960),Color.BLACK); 
		
		// thread repaint
		Thread a = new Thread() {
			public void run() {

				while (true) {
					repaint();
				}

			}
		};
		a.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < 6; i++) {
			city[i].draw(g, getWidth(), getHeight());
		}

		for (int i = 0; i < 3; i++) {
			battery[i].draw(g, getWidth(), getHeight());
		}
		// draw rectanglebuildings

		// Battery b = new Battery(p,Color.RED);
		// b.draw(g,getHeight(), getWidth());

		// Set pointer

		int x = (int) crossH.getX();

		int y = (int) crossH.getY();

		// crosshair
		g.setColor(Color.RED);
		g.drawLine(x - 30, y, x + 30, y);
		g.drawLine(x, y - 30, x, y + 30);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub400

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// crossH = new Point(getWidth() - 960, getHeight() - 540);
		crossH = new Point(e.getX(), e.getY());
		System.out.println(crossH);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
