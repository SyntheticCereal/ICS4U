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

/*
 * Chris Simpauco
 * Spiral Loading Icon
 * Creates a spiral of different colored ovals and then covers them with black ovals
 */

public class LoadingIcon2 extends JPanel{
	
	Timer timer;
	private double x,y; 
	private Color c = Color.BLACK;
	private double angle = 0.0;
	private double r = 0.0;
	private static int panW = 700;
	private static int panH = 700;
	final private int cx,cy;
	private static JFrame frame;
	BufferedImage img;
	int j=0;
	int cc =1;

	public static void main(String[] args) {
		frame = new JFrame("Spiral");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		LoadingIcon2 panel = new LoadingIcon2();		
		frame.add(panel);
		frame.pack();		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}

	LoadingIcon2() {
		cx = panW/2;
		cy = panH/2;
		img = new BufferedImage(panW,panH, BufferedImage.TYPE_INT_RGB);
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(panW, panH));

		timer = new Timer(1, new Timer1());
		timer.setInitialDelay(100);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);	
	}

	class Timer1 implements ActionListener {

		private boolean reverse = false;
		public void actionPerformed(ActionEvent e) {

			Graphics2D g2 = img.createGraphics();

			//Enables AntiAliasing
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			//Creates random values for RGB
			int R = (int)(Math.random()*255);
			int G = (int)(Math.random()*255);
			int B = (int)(Math.random()*255);

			Color c2 = new Color(R, G, B); //Random colours
			Color c3 = new Color(0,j*100%256,j*50%256); //Green and blue
			Color c4 = new Color((j*32)%256,((j+1)*32)%256,((j+2)*32%256)); //Green, red and blue
			Color c5 = new Color((j*32)%256,((j+1)*32)%256,((j+1)*32)%256); //Red and grey blue
			Color c6 = new Color((j*32)%256,(j*32)%256,(j*32)%256); //Monochrome


			g2.setStroke(new BasicStroke(5));

			//Calculates the spiral
			if (!reverse) {
				r += 0.15;
				angle += 0.5*cc;
			}
			else {
				r -= 0.15; 
				angle -= 0.5*cc;
			}

			if (r > 150) {	
				reverse = true;
				j=0;;
			}
			if (r < 0.0) {
				reverse = false;				
				cc*=-1;
				r = 0.0;
				j=0;

			}			
			
			//Calculates where to draw circle
			x = (cx + r*Math.cos(angle));
			y = (cy + r*Math.sin(angle));



			if (reverse) { //Draws black ovals
				g2.setColor(c);
				g2.fillOval((int)x-1,(int)y-1, 15, 15);
				j++;
			} else { //Draws colored ovals}
				g2.setColor(c3);
				g2.fillOval((int)x,(int)y, 10, 10);
				j++;
			}


			repaint();
		}


	}
}