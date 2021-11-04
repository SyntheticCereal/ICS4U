package loadingprogram;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/* This is a new version of the program that draws a spiral. 
 * 
 * The idea is to calculate new points and draw them, updating the screen regularly.
 * In this program we do it using a buffered image. Everything is drawn onto the BufferedImage.
 * This means that all of the previous points are saved on the image - something that doesn't 
 * happen when you draw to the screen using paintComponent. 
 * All that paintComponent does is display the image at whatever stage it is at.
 *  
 * Two other advantages to drawing on a buffered image are 
 * (i) you can easily save the drawing (as I've demonstrated in this program)
 * (ii) you can do complex things with moving sprites without having 
 *      the flickering that happens when you only use paintComponent. I haven't tried this yet.
 * (iii) you can also do drawing a lot faster. See comments marked //SPEED\\ 
 */

public class Spiral2 extends JPanel  {
	Timer timer;

	private double x,y; 
	private Color c = Color.BLACK;
	private double angle = 0.0;
	private double r = 0.0;
	private static int panW = 1000;
	private static int panH = 1000;
	final private int cx,cy;
	private static JFrame frame;
	BufferedImage img;
	int j=0;
	

	public static void main(String[] args) {
		frame = new JFrame("Spiral");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);		
		Spiral2 panel = new Spiral2();		
		frame.add(panel); //somehow it paints more smoothly if this is added before setVisible.
		frame.pack();		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}

	Spiral2() {
		cx = panW/2;
		cy = panH/2;
		img = new BufferedImage(panW,panH, BufferedImage.TYPE_INT_RGB);
		this.setBackground(Color.WHITE);	//the JPanel has a white background, but you'll never see it ...
		this.setPreferredSize(new Dimension(panW, panH));

		timer = new Timer(1, new Timer1());
		timer.setInitialDelay(100);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		//Draw onto a BufferedImage (elsewhere) and then display it here
		g.drawImage(img, 0, 0, null);	
	}

	class Timer1 implements ActionListener {

		private boolean reverse = false;
		public void actionPerformed(ActionEvent e) {

			//get the graphics object from the image so that we can draw on it.
			Graphics2D g2 = img.createGraphics();

			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// --- Do all drawing here ---
			
			Color c2 = new Color((j*32)%256,((j+1)*32)%256,((j+2)*32%256));
			Color c3 = new Color((0+j)/256,(0+j)/256,(0+j)/256);
			g2.setStroke(new BasicStroke(5));
			
			if (!reverse) {
				r += 0.15;
				angle += 0.5;
			}
			else {
				r -= 0.15; 
				angle -= 0.5;
			}

			if (r > 500) {	
				reverse = true;
			}
			if (r < 0.0) {
				reverse = false;				
				r = 0.0;
			}			

			x = (cx + r*Math.cos(angle));
			y = (cy + r*Math.sin(angle));

			frame.setTitle(cx  + " " +cy );
			
			if (reverse) { //Draws black ovals
				g2.setColor(c);
				g2.fillOval((int)x-1,(int)y-1, 15, 15);
				j--;
			} else { //Draws colored ovals
				g2.setColor(c2);
				g2.fillOval((int)x,(int)y, 10,10);
				j++;
			}

			repaint(); // to speed things up, don't repaint every single timer tick. Swing coalesces a number of repaints into one
		}
	}



}

