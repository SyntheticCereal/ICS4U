package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FirstDrawing {

	public static void main(String[] args) {
		new FirstDrawing();
	}

	int panW = 800, panH = 800;
	Color customColor = new Color(242, 203, 48, 230);
	
	FirstDrawing(){
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawingPanel panel = new DrawingPanel();
		window.add(panel);
		window.pack(); //sets optimum size
		window.setLocationRelativeTo(null); //centers on screen
		window.setVisible(true);
	}
	
	class DrawingPanel extends JPanel{
		
		DrawingPanel(){
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.decode("#b347ed"));
		}
		
		@Override //replaces a parent method
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //sets background colour, has to be first line
			
			
			Graphics2D g2 = (Graphics2D) g; 
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			
			g2.setStroke(new BasicStroke(5));
			g2.setColor(customColor);
			g2.fillOval(0, 0, 100, 100);
			g2.drawOval(100, 100, 100, 100);
			g2.fillOval(200, 200, 100, 100);
			g2.drawOval(300, 300, 100, 100);
			g2.fillOval(400, 400, 100, 100);
			g2.drawOval(500, 500, 100, 100);
			g2.fillOval(600, 600, 100, 100);
			g2.drawOval(700, 700, 100, 100);
			
			g2.setStroke(new BasicStroke(10));
			g2.setColor(Color.YELLOW);
			g2.drawLine(0, 0, 800, 800);
			
			g2.setFont( new Font( "Comic Sans MS", Font.BOLD, 18) );
			g2.setColor(Color.BLUE);
			g2.drawString("bruh" , 30, 50);
		}
	}
}
