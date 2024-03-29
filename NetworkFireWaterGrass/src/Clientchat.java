import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Clientchat extends JPanel implements ActionListener, MouseListener, MouseMotionListener, KeyListener {

	JTextField tfInfo;
	JLabel lblColor, lblShapes;
	JCheckBox cbRed, cbBlue;
	ButtonGroup shapes;
	JRadioButton rbCircle, rbSquare;
	JButton fire;
	JButton water;
	JButton grass;

	private String player;
	private String computer;



	private String winner = "dontpaint";

	private String pwins;
	private String cwins;

	/**
	 * used to create a connection with client
	 */
	private Socket sock;

	/**
	 * used to receive messages
	 */
	private BufferedReader read;

	/**
	 * used to write messages to client
	 */
	private PrintStream write;

	/**
	 * Server chat method makes sure there is a connection bettween server and
	 * client
	 * 
	 */
	public Clientchat() {

		// fire = new JButton(new ImageIcon(new
		// ImageIcon("./fire.png").getImage().getScaledInstance(40, 40,
		// Image.SCALE_DEFAULT)));
		fire = new JButton(new ImageIcon(new ImageIcon("./fire.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		water = new JButton(new ImageIcon(new ImageIcon("./water.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		grass = new JButton(new ImageIcon(new ImageIcon("./grass.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

		fire.addActionListener(this);
		water.addActionListener(this);
		grass.addActionListener(this);

		add(fire);
		add(water);
		add(grass);

		try {

			System.out.println("Requesting Connection.....");
			sock = new Socket("localhost", 1235);
			read = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			write = new PrintStream(sock.getOutputStream());
			System.out.println("Connected.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// String str = "" + computer +""  player + winner + "" + pWins + "" + cWins ;
		Thread a = new Thread() {

			public void run() {
				while (true) {

					try {
						

						String line = read.readLine();
						String[] tokens = line.split(",");
						computer = tokens[0];
						player = tokens[1];
						winner = tokens[2];
						pwins = tokens[3];
						cwins = tokens[4];

						repaint();

						// player = 'n';
						// c = 'n';
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		};
		a.start();

	}

	public void paintComponent(Graphics g) {


		super.paintComponent(g);

			
		if(!winner.equals("dontpaint") ){
			g.setColor(Color.GREEN);
			g.drawRect(0, 0, 400, 200);// building
			g.setFont(new Font("Arial", Font.PLAIN, 40));
	
			if (player.equals("f")) {
				g.drawString("Player chose fire", 800, 300);
			} else if (player.equals("w")) {
				g.drawString("Player chose water ", 800, 300);
			} else if (player.equals("g")) {
				g.drawString("Player chose grass ", 800, 300);
			} else {
	
			}
	
			if (computer.equals("f")) {
				g.drawString("Computer chose fire", 800, 350);
			} else if (computer.equals("w")) {
				g.drawString("Computer chose water ", 800, 350);
			} else if (computer.equals("g")) {
				g.drawString("Computer chose grass ", 800, 350);
			} else {
	
			}
	
			g.setFont(new Font("Arial", Font.PLAIN, 40));
	
			// 1.fire beats 3.grass
			// 3.grass beats 2.water
			// 2.water beats 1.fire
			if (winner.equals("Player wins")) {
	
				g.drawString("Player   Wins ", 850, 500);
			} else if (winner.equals("Computer wins")) {
	
				g.drawString("Computer Wins ", 850, 500);
			} else if (winner.equals("Tie")) {
				g.drawString("TIE! ", 850, 500);
			} else {
	
			}
	
			g.setFont(new Font("Arial", Font.PLAIN, 40));
			g.drawString("Computer Score: " + cwins, 50, 50);
			g.drawString("Player   Score: " + pwins, 50, 100);
		}
		}

	

	public static void main(String args[]) {

	}

	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Scanner in = new Scanner(System.in);

		if (e.getSource() == fire) {
			player = "f";

			// char fire = 'f';
			System.out.println("Client ->");
			write.println(player);

		} else if (e.getSource() == water) {
			player = "w";

			System.out.println("Client ->");
			write.println(player);

		} else if (e.getSource() == grass) {
			player = "g";

			System.out.println("Client ->");
			write.println(player);

		}

	}

}
