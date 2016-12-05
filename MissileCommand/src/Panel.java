
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel crates an array of six cities, three batteries , and ArrayLIst for
 * temporary object like missiles and explosions.
 * 
 * 
 * 
 * @author Jesus Vargas
 *
 */
public class Panel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	
	/**
	 * city arrray 
	 */
	private City city[];
	
	/**
	 * battery array
	 */
	private Battery battery[];
	
	/**
	 * Misssile arraylist 
	 */
	private ArrayList<Missile> m;
	
	/**
	 * Explosion arraylist
	 */
	private ArrayList<Explosion> ex;
	
	/**
	 * Explosion  array chcking clollisions
	 */
	private ArrayList<Explosion> collision;
	
	/**
	 * check boolean checks if city is  active
	 */
	private Boolean Check[];
	
	/*
	 * Point object points to crosshait
	 */
	private Point crossH;
	
	/**
	 * Score keeps track of scores
	 */
	private int score = 0;
	
	/**
	 * enemy missiles object keeps track of enemy missiles
	 */
	private int enemyMissiles = 0;
	
	/**
	 * panel constructor initializes private variables and begins thread
	 * 
	 * 
	 */
	public Panel() {

		Check = new Boolean[6];
		collision = new ArrayList<Explosion>();
		ex = new ArrayList<Explosion>();
		crossH = new Point(getWidth() + 960, getHeight() + 540);
		battery = new Battery[3];
		city = new City[10];
		m = new ArrayList<Missile>();
		// initialize cross hair

		// add mouse motion
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);

		// set backround of panel blue
		this.setBackground(Color.BLUE);

		// 6 citys
		int counter = 0;
		int xcord = 220;

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

		for (int i = 0; i < 3; i++) {
			battery[i] = new Battery(new Point(xcord2, 905), Color.RED);
			xcord2 = xcord2 + 880;
		}

		// missle

		// start point, end point, speed, type, color

		// click misssiles`
		int shots2 = 0;

		Thread a = new Thread() {
			public void run() {
				int count = 0;

				int shots = 0;
				int time = 0;
				int xcord3 = 0;
				int ycord3 = 0;
				int number = 0;

				while (true) {

					int destination = (int) (Math.random() * 2) + 1;

					// enemy missiles
					if (count == time) {
						System.out.println("time" + time);
						if (destination == 1) {
							int c = (int) (Math.random() * 6);
							xcord3 = city[c].x;
							ycord3 = city[c].y;

						} else {
							int b = (int) (Math.random() * 3);
							xcord3 = battery[b].x;
							ycord3 = battery[b].y;

						}

						// enemy starting point
						int enemy = (int) (Math.random() * 1080) + 1;

						m.add(new Missile(new Point(enemy, -100), new Point(xcord3, ycord3), 3, 1, Color.RED));
						shots = shots + 220;
						time = time + 300;

						enemyMissiles++;
						System.out.println(enemyMissiles);
					}
					count++;

					// missile is active and true
					for (int j = 0; j < m.size(); j++) {

						if (m.get(j).isActive() == true) {
							m.get(j).move();

						}
						// missile reaches its destination and is added to
						// explotion
						if (m.get(j).isActive() == false) {

							// make city disapear
							for (int k = 0; k < 6; k++) {

								if (m.get(j).getType() == 1) {
									city[k].isHit(m.get(j).getLocPoint());
								}

							}

							// make battery disapear
							for (int k = 0; k < 3; k++) {
								if (m.get(j).getType() == 1) {
									battery[k].isHit(m.get(j).getLocPoint());
								}

							}

							ex.add(new Explosion(m.get(j).getLocPoint()));

							m.remove(j);

						}

					}

					// missile explodes
					for (int k = 0; k < ex.size(); k++) {

						if (ex.get(k).isActive() == true) {
							ex.get(k).move();

							// missile check
							for (int j = 0; j < m.size(); j++) {

								// checks for collisions

								if (ex.get(k).contains(m.get(j).getLocPoint()) && m.get(j).getType() == 1) {
									score++;
									collision.add(new Explosion((m.get(j).getLocPoint())));
									m.remove(j);

								}
							}

						}

						if (ex.get(k).isActive() == false) {
							ex.remove(k);
						}

					}

					// animates collisions and deletes them
					for (int k = 0; k < collision.size(); k++) {

						if (collision.get(k).isActive() == true) {
							collision.get(k).move();
						}
						if (collision.get(k).isActive() == false) {
							collision.remove(k);
						}

					}

					for (int i = 0; i < 6; i++) {

						Check[i] = city[i].isActive();

					}

					// delete city

					repaint();

					try {
						Thread.sleep(60); // ~60 fps
					} catch (InterruptedException e) {

					}

					boolean destroyed = true;
					for (int i = 0; i < 6; i++) {

						if (Check[i] == true) {
							destroyed = false;

						}

					}

					if ((enemyMissiles == 20 ) || destroyed == true) {

						score = 0;
						enemyMissiles = 0;

						collision = new ArrayList<Explosion>();
						ex = new ArrayList<Explosion>();
						crossH = new Point(getWidth() + 960, getHeight() + 540);
						battery = new Battery[3];
						city = new City[10];
						m = new ArrayList<Missile>();

						int counter = 0;
						int xcord = 220;

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

						for (int i = 0; i < 3; i++) {
							battery[i] = new Battery(new Point(xcord2, 905), Color.RED);
							xcord2 = xcord2 + 880;
						}

					}

				}

			}
		};

		a.start();

	}

	
	/**
	 * paint component draws and fills shapes so they can appear in panel
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.GREEN);
		g.drawRect(0, 0, 400, 200);// building
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString("SCORE: " + score, 50, 50);
		g.drawString("EnemyMissiles: " + enemyMissiles, 50, 100);

		for (int i = 0; i < 6; i++) {
			if (city[i].isActive() == true) {
				city[i].draw(g);
			}

		}

		for (int i = 0; i < 3; i++) {
			if (battery[i].isActive() == true) {
				battery[i].draw(g);
			}
		}

		// if(missile[0].isActive() == true){
		for (int i = 0; i < m.size(); i++) {
			m.get(i).draw(g);
		}

		for (int i = 0; i < ex.size(); i++) {
			ex.get(i).draw(g);
		}

		for (int i = 0; i < collision.size(); i++) {
			collision.get(i).draw(g);
		}

		int x = (int) crossH.getX();

		int y = (int) crossH.getY();

		// crosshair
		g.setColor(Color.RED);
		g.drawLine(x - 30, y, x + 30, y);
		g.drawLine(x, y - 30, x, y + 30);

	}
	
	/**
	 * keypress method creates keybopard function keys to 
	 * begin a command
	 * @param e event obeject is passed in
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		//key board key 1
		if (e.getKeyCode() == KeyEvent.VK_1) {
			if (battery[0].getNumMissiles() > 0) {
				m.add(new Missile(new Point(battery[0].x, battery[0].y),
						new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));
				battery[0].removeMissile();
				System.out.println("Pressed 1");

			}

		}
		
		//keyboard key 2
		if (e.getKeyCode() == KeyEvent.VK_2) {
			if (battery[1].getNumMissiles() > 0) {
				m.add(new Missile(new Point(battery[1].x, battery[1].y),
						new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));
				battery[1].removeMissile();
				System.out.println("Pressed 2");
			}

		}
		
		//keyboard key 3
		if (e.getKeyCode() == KeyEvent.VK_3) {
			if (battery[2].getNumMissiles() > 0) {
				m.add(new Missile(new Point(battery[2].x, battery[2].y),
						new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));
				battery[2].removeMissile();
				System.out.println("Pressed 3");

			}

		}
		
		
		//keyboaerd spacebar key
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			int x2 = (int) crossH.getX();
			int y2 = (int) crossH.getY();

			int size1 = 0;
			int size2 = 0;
			int size3 = 0;

			for (int i = 0; i < 3; i++) {
				int x1 = (int) battery[i].x;
				int y1 = (int) battery[i].y;

				int dx = x2 - x1;
				int dy = y2 - y1;
				if (i == 0) {
					size1 = (int) Math.sqrt((dx * dx) + (dy * dy));
				} else if (i == 1) {
					size2 = (int) Math.sqrt((dx * dx) + (dy * dy));
				} else if (i == 2) {
					size3 = (int) Math.sqrt((dx * dx) + (dy * dy));
				}

			}
			System.out.println("size" + size1);
			System.out.println("size2 +" + size2);
			System.out.println("size3" + size3);
			
			
			//checks if battery closest to cursor and if battery exist.  
			if (size1 < size2 && size1 < size3 && battery[0].getNumMissiles() > 0) {

				m.add(new Missile(new Point(battery[0].x, battery[0].y),
						new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));

				battery[0].removeMissile();

			} else if (size2 < size1 && size2 < size3 && battery[1].getNumMissiles() > 0) {

				m.add(new Missile(new Point(battery[1].x, battery[1].y),
						new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));
				battery[1].removeMissile();

			} else if (size3 < size1 && size3 < size2 && battery[2].getNumMissiles() > 0) {

				m.add(new Missile(new Point(battery[2].x, battery[2].y),
						new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));
				battery[2].removeMissile();

			} else {//checks if battery exist and from closest 
				int batteries_0 = battery[0].getNumMissiles();
				int batteries_1 = battery[1].getNumMissiles();
				int batteries_2 = battery[2].getNumMissiles();
				if (batteries_0 > 0 && batteries_1 > 0) {
					if (size1 < size2) {
						m.add(new Missile(new Point(battery[0].x, battery[0].y),
								new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));

						battery[0].removeMissile();
					} else {
						m.add(new Missile(new Point(battery[1].x, battery[1].y),
								new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));

						battery[1].removeMissile();

					}

				} else if (batteries_0 > 0 && batteries_2 > 0) {
					if (size1 < size3) {
						m.add(new Missile(new Point(battery[0].x, battery[0].y),
								new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));

						battery[0].removeMissile();
					} else {
						m.add(new Missile(new Point(battery[2].x, battery[2].y),
								new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));

						battery[2].removeMissile();

					}

				} else if (batteries_1 > 0 && batteries_2 > 0) {
					if (size2 < size3) {
						m.add(new Missile(new Point(battery[1].x, battery[1].y),
								new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));

						battery[1].removeMissile();
					} else {
						m.add(new Missile(new Point(battery[2].x, battery[2].y),
								new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));

						battery[2].removeMissile();

					}

				} else if (batteries_0 > 0) {
					m.add(new Missile(new Point(battery[0].x, battery[0].y),
							new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));

					battery[0].removeMissile();

				} else if (batteries_1 > 0) {
					m.add(new Missile(new Point(battery[1].x, battery[1].y),
							new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));

					battery[1].removeMissile();

				} else if (batteries_2 > 0) {
					m.add(new Missile(new Point(battery[2].x, battery[2].y),
							new Point((int) crossH.getX(), (int) crossH.getY()), 8, 2, Color.WHITE));

					battery[2].removeMissile();

				}

			}

		}

	}
	
	/**
	 * key release does a function when releasing 
	 * key 
	 * 
	 * @param e event object
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * key typed does a function when typing 
	 * key 
	 * 
	 * @param e event object
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * mouse moved does a function when moving 
	 * mouse
	 * 
	 * @param e event object
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// crossH = new Point(getWidth() - 960, getHeight() - 540);
		crossH = new Point((int) e.getX(), (int) e.getY());
		System.out.println(crossH);
	}
	
	/**
	 * Mouse dragged does a function when dragging 
	 * mouse 
	 * 
	 * @param e event object
	 */
	@Override
	public void mouseDragged(MouseEvent e) {

	}
	
	/**
	 * Mouse clicked does a function when clcking mouse
	 * 
	 * 
	 * @param e event object
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int x2 = (int) e.getX();
		int y2 = (int) e.getY();

		int size1 = 0;
		int size2 = 0;
		int size3 = 0;

		for (int i = 0; i < 3; i++) {
			int x1 = (int) battery[i].x;
			int y1 = (int) battery[i].y;

			int dx = x2 - x1;
			int dy = y2 - y1;
			if (i == 0) {
				size1 = (int) Math.sqrt((dx * dx) + (dy * dy));
			} else if (i == 1) {
				size2 = (int) Math.sqrt((dx * dx) + (dy * dy));
			} else if (i == 2) {
				size3 = (int) Math.sqrt((dx * dx) + (dy * dy));
			}

		}
		System.out.println("size" + size1);
		System.out.println("size2 +" + size2);
		System.out.println("size3" + size3);

		if (size1 < size2 && size1 < size3 && battery[0].getNumMissiles() > 0) {

			m.add(new Missile(new Point(battery[0].x, battery[0].y), new Point((int) e.getX(), (int) e.getY()), 8, 2,
					Color.WHITE));

			battery[0].removeMissile();

		} else if (size2 < size1 && size2 < size3 && battery[1].getNumMissiles() > 0) {

			m.add(new Missile(new Point(battery[1].x, battery[1].y), new Point((int) e.getX(), (int) e.getY()), 8, 2,
					Color.WHITE));
			battery[1].removeMissile();

		} else if (size3 < size1 && size3 < size2 && battery[2].getNumMissiles() > 0) {

			m.add(new Missile(new Point(battery[2].x, battery[2].y), new Point((int) e.getX(), (int) e.getY()), 8, 2,
					Color.WHITE));
			battery[2].removeMissile();

		} else {
			int batteries_0 = battery[0].getNumMissiles();
			int batteries_1 = battery[1].getNumMissiles();
			int batteries_2 = battery[2].getNumMissiles();
			if (batteries_0 > 0 && batteries_1 > 0) {
				if (size1 < size2) {
					m.add(new Missile(new Point(battery[0].x, battery[0].y), new Point((int) e.getX(), (int) e.getY()),
							8, 2, Color.WHITE));

					battery[0].removeMissile();
				} else {
					m.add(new Missile(new Point(battery[1].x, battery[1].y), new Point((int) e.getX(), (int) e.getY()),
							8, 2, Color.WHITE));

					battery[1].removeMissile();

				}

			} else if (batteries_0 > 0 && batteries_2 > 0) {
				if (size1 < size3) {
					m.add(new Missile(new Point(battery[0].x, battery[0].y), new Point((int) e.getX(), (int) e.getY()),
							8, 2, Color.WHITE));

					battery[0].removeMissile();
				} else {
					m.add(new Missile(new Point(battery[2].x, battery[2].y), new Point((int) e.getX(), (int) e.getY()),
							8, 2, Color.WHITE));

					battery[2].removeMissile();

				}

			} else if (batteries_1 > 0 && batteries_2 > 0) {
				if (size2 < size3) {
					m.add(new Missile(new Point(battery[1].x, battery[1].y), new Point((int) e.getX(), (int) e.getY()),
							8, 2, Color.WHITE));

					battery[1].removeMissile();
				} else {
					m.add(new Missile(new Point(battery[2].x, battery[2].y), new Point((int) e.getX(), (int) e.getY()),
							8, 2, Color.WHITE));

					battery[2].removeMissile();

				}

			} else if (batteries_0 > 0) {
				m.add(new Missile(new Point(battery[0].x, battery[0].y), new Point((int) e.getX(), (int) e.getY()), 8,
						2, Color.WHITE));

				battery[0].removeMissile();

			} else if (batteries_1 > 0) {
				m.add(new Missile(new Point(battery[1].x, battery[1].y), new Point((int) e.getX(), (int) e.getY()), 8,
						2, Color.WHITE));

				battery[1].removeMissile();

			} else if (batteries_2 > 0) {
				m.add(new Missile(new Point(battery[2].x, battery[2].y), new Point((int) e.getX(), (int) e.getY()), 8,
						2, Color.WHITE));

				battery[2].removeMissile();

			}

		}

		crossH = new Point(e.getX(), e.getY());
		System.out.println(crossH);

		if (contains(crossH)) {
			System.out.println("clicked in panel");
		}

	}


	/**
	 *Mouse entered does a function when mouse is entered 
	 *  
	 * 
	 * @param e event object
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Mouse exited does a function when mouse is exited
	 * 
	 * @param e event object
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Mouse pressed does a function when mouse is presssed
	 * 
	 * @param e event object
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Mouse release does a function when mouse is released
	 * 
	 * @param e event object
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
