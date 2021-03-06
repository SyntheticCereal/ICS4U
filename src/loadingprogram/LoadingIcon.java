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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class LoadingIcon extends JPanel{
	Timer timer;

	private double x,y; 
	private Color c = Color.BLACK;
	private double angle = 0.0;
	private double r = 0.0;
	private static int panW = 700;
	private static int panH = 700;
	final private int cx=panW/2, cy=panH/2;
	private static JFrame frame;
	BufferedImage img;
	int j=0;
	int cc =1;
	Oval oval = new Oval (x, y, r, angle, cx, cy);

	public static void main(String[] args) {
		frame = new JFrame("Spiral");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		LoadingIcon panel = new LoadingIcon();		
		frame.add(panel); //somehow it paints more smoothly if this is added before setVisible.
		frame.pack();		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}

	LoadingIcon() {
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

			//Generates random RGB values
			int R = (int)(Math.random()*255);
			int G = (int)(Math.random()*255);
			int B = (int)(Math.random()*255);

			Color c2 = new Color(R, G, B); //Random Numbers
			Color c3 = new Color(0,j*100%256,j*50%256); //Green and blue
			Color c4 = new Color((j*32)%256,((j+1)*32)%256,((j+2)*32%256)); //Green, red and blue
			Color c5 = new Color((j*32)%256,((j+1)*32)%256,((j+1)*32)%256); //Red and Greyish Blue
			Color c6 = new Color((j*32)%256,(j*32)%256,(j*32)%256); //Monochrome
			
			g2.setStroke(new BasicStroke(5));

			//Makes circles draw in a spiral
//			if (!reverse) {
//				r += 0.15;
//				angle += 0.5*cc;
//			}
//			else {
//				r -= 0.15; 
//				angle -= 0.5*cc;
//			}
//
//			if (r > 150) {	
//				reverse = true;
//				j=0;;
//			}
//			if (r < 0.0) {
//				reverse = false;				
//				cc*=-1;
//				r = 0.0;
//				j=0;
//
//			}			

			//Calculate where the ovals are drawn
//			x = (cx + r*Math.cos(angle));
//			y = (cy + r*Math.sin(angle));



			if (reverse) { //Draws black ovals
				g2.setColor(c);
				oval.DrawReverseOval(g2);
				j++;
			} else { //Draws colored ovals
				g2.setColor(c3);
				oval.DrawOval(g2);
				j++;
			}
			repaint(); // to speed things up, don't repaint every single timer tick. Swing coalesces a number of repaints into one
		}
	}
}






