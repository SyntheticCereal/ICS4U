package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

import drawing.FirstDrawing.DrawingPanel;

public class DrawingGraphs {

	public static void main(String[] args) {
		new FirstDrawing();
	}

	int panW = 800, panH = 800;
	double 
	
	 DrawingGraphs(){
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
			this.setBackground(Color.decode("#0000FF"));
		}
		
		@Override //replaces a parent method
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //sets background colour, has to be first line
			
			
			Graphics2D g2 = (Graphics2D) g; 
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2.setColor(Color.YELLOW);
			g2.drawOval(0, 0, 100, 100);
			g2.drawLine(0, 0, 800, 800);
			
		}
	}

}
