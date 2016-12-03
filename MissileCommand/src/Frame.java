import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Frame is the location of the main method and also 
 * creates an instance of the panel.
 * 
 * @author Jesus Vargas
 *
 */
public class Frame extends JFrame{
	
	/**
	 * panel instant variable
	 */
	private Panel p;
	
	/**
	 * frame constructor where new panel is created
	 * 
	 */
	public Frame(){
		setBounds(0,0,1920,1080);
		p = new Panel();
		getContentPane().add(p);
		
	}
	
	/**
	 * main method where nnew frame is created 
	 * 
	 * @param args is passed in
	 */
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setTitle("Missile Command");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);//to make window appear
		
	}
	
	
	
}
