package actionListeners;


	import java.awt.BasicStroke;
//	ICS4U1
/* showing how to draw using Swing */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEvents implements MouseListener, MouseMotionListener {

	public static void main(String[] args) {
		new MouseEvents();
	}

	//Global variables
	int panW = 800, panH = 800;
	Rectangle box = new Rectangle (50, 50, 50, 50);
	int mx, my;
	int numsClick = 0;
	
	DrawingPanel panel = new DrawingPanel();
	JFrame window = new JFrame("Drawing on JPanel");	
	
	MouseEvents(){
		//setup JFrame
		window = new JFrame("Drawing on JPanel");		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new DrawingPanel();
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		
		window.add(panel);
		window.pack(); 		//sets optimum size
		window.setLocationRelativeTo(null);  //centre on screen
		window.setVisible(true);
	}
	
	class DrawingPanel extends JPanel {
		
		DrawingPanel() {
			//this controls the size ***
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.decode("#000000"));
		}
		
		//all drawing goes in here
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //clear and set BGcolor
			
			g.setColor(Color.ORANGE);
			g.fillRect(box.x, box.y, 50, 100);
			
			g.drawLine(panW/2, panH/2, mx, my);
			
		}
		
	}

	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		panel.repaint();
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		
		numsClick++;
		window.setTitle (numsClick + " clicks");
		if (box.contains(e.getPoint())) {
			numsClick++;
			panel.setBackground(Color.BLACK);
			box.x = (int) (Math.random()*800);
			box.y = (int) (Math.random()*800);
			panel.repaint();
		}
		window.setTitle (numsClick + " clicks");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}	
}

