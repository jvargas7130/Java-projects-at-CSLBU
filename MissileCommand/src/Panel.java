
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
public class Panel extends JPanel implements MouseListener,MouseMotionListener, KeyListener{

	private  String Citi [];
	private  String Battery [];
	private  ArrayList<Missile> m ;
	private  ArrayList<Explosion> e;
	
	
	public Panel(){
		this.setBackground(Color.BLUE);
	}
	
	
	
	public void paintComponent(Graphics g){
			super.paintComponent(g);
		
		//Set pointer	
		Point p = new Point(getWidth() - 960,getHeight() - 540);	
		
		//city object
		City c = new City(p,Color.GREEN);
		c.draw(g,getHeight(), getWidth() );//draw rectanglebuildings
		
		
		Battery b = new Battery(p,Color.RED);
	    b.draw(g,getHeight(), getWidth());
	    
	    
	    
	    Thread a = new Thread("A");
		
		int x = (int) p.getX();
	
		int y =	(int) p.getY();
	
		//crosshair
	g.setColor(Color.RED);
	g.drawLine(x-30, y, x+30,y);
	g.drawLine(x, y-30, x,y+30);

		
		
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
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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