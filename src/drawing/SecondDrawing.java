package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Chris Simpauco
 * Oct 20, 2021
 * Trying to recreate PacMan
 */

public class SecondDrawing {

	public static void main(String[] args) {
		new SecondDrawing();
	}

	int panW = 800, panH = 800;
	Color customColor = new Color(237, 222, 164);
	Color customColor2 = new Color(250, 241, 207);
	Color customColor3 = new Color(50, 77, 230);
	Color customColor4 = new Color(38, 52, 240, 250);
	Color customColor5 = new Color(242, 184, 214, 230);
	Color customColor6 = new Color(48, 255, 231);
	Color customColor7 = new Color(34, 66, 227);
	
	SecondDrawing(){
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setTitle("Sort of PacMan");
		DrawingPanel panel = new DrawingPanel();
		window.add(panel);
		window.pack(); //sets optimum size
		window.setLocationRelativeTo(null); //centers on screen
		window.setVisible(true);
	}
	
	class DrawingPanel extends JPanel{
		
		DrawingPanel(){
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.decode("#000000"));
		}
		
		@Override //replaces a parent method
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //sets background colour, has to be first line
			
			
			Graphics2D g2 = (Graphics2D) g; 
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			//Creates Pac Man
			g2.setStroke(new BasicStroke(10));
			g2.setColor(Color.YELLOW);
			g2.fillArc (100, 20, 100, 100, 30, 300);
			
			//Draws "100"
			g2.setFont( new Font( "SansSerif", Font.BOLD, 30) );
			g2.setColor(Color.WHITE);
			g2.drawString("100" , 30, 80);
			
			//Draws normal pellets
			g2.setColor(customColor);
			g2.fillOval(205, 55, 30, 30);
			g2.fillOval(305, 55, 30, 30);
			g2.fillOval(405, 55, 30, 30);
			g2.fillOval(505, 55, 30, 30);
			g2.fillOval(605, 55, 30, 30);
			
			g2.fillOval(5, 510, 30, 30);
			g2.fillOval(105, 510, 30, 30);
			g2.fillOval(205, 510, 30, 30);
			g2.fillOval(305, 510, 30, 30);
			g2.fillOval(405, 510, 30, 30);
			g2.fillOval(505, 510, 30, 30);
			g2.fillOval(605, 510, 30, 30);
			g2.fillOval(705, 510, 30, 30);
			
			g2.fillOval(705, 210, 30, 30);
			g2.fillOval(705, 310, 30, 30);
			g2.fillOval(705, 410, 30, 30);
			g2.fillOval(705, 610, 30, 30);
			g2.fillOval(705, 710, 30, 30);
			g2.fillOval(705, 810, 30, 30);
			
			//Draws power pellets 
			g2.setColor(customColor2);
			g2.fillOval(700, 50, 40, 40);
			
			//Draws chamber door
			g2.setStroke(new BasicStroke(5));
			g2.setColor(customColor5);
			g2.drawLine(0, 150, 650, 150);

			//Draws maze walls
			g2.setStroke(new BasicStroke(10));
			g2.setColor(customColor4);
			g2.drawLine(0, 150, 150, 150);
			g2.drawLine(350, 150, 650, 150);
			g2.drawLine(650, 450, 650, 150);
			g2.drawLine(650, 455, 0, 455);
			g2.drawLine(650, 605, 0, 605);
			g2.drawLine(650, 610, 650, 800);
			g2.drawLine(795, 0, 795, 800);
			
			//Creates bottom of first ghost
			Polygon triangle1 = new Polygon();
			triangle1.addPoint(680, 265);
			triangle1.addPoint(700, 265);
			triangle1.addPoint(680, 285);
			
			Polygon triangle2 = new Polygon();
			triangle2.addPoint(700, 265);
			triangle2.addPoint(720, 265);
			triangle2.addPoint(720, 285);
			
			Polygon triangle3 = new Polygon();
			triangle3.addPoint(727, 265);
			triangle3.addPoint(747, 265);
			triangle3.addPoint(727, 285);
			
			Polygon triangle4 = new Polygon();
			triangle4.addPoint(769, 265);
			triangle4.addPoint(747, 265);
			triangle4.addPoint(769, 285);

			//Draws first ghost
			g2.setColor(customColor3);
			g2.fillOval(675, 160, 100, 100);
			g2.fillRect(676, 200, 98, 75);
			g2.drawPolygon(triangle1);
			g2.drawPolygon(triangle2);
			g2.drawPolygon(triangle3);
			g2.drawPolygon(triangle4);
			
			//Draws first ghost mouth
			g2.setColor(Color.WHITE);
			g2.fillOval(685, 190, 35, 35);
			g2.fillOval(730, 190, 35, 35);
			g2.setStroke(new BasicStroke(3));
			g2.drawLine(685, 250, 695, 240);
			g2.drawLine(695, 240, 705, 250);
			g2.drawLine(705, 250, 715, 240);
			g2.drawLine(715, 240, 725, 250);
			g2.drawLine(725, 250, 735, 240);
			g2.drawLine(735, 240, 745, 250);
			g2.drawLine(745, 250, 755, 240);
			g2.drawLine(755, 240, 765, 250);
			
			//Creates bottom of second ghost
			Polygon triangle5 = new Polygon();
			triangle5.addPoint(480, 335);
			triangle5.addPoint(500, 335);
			triangle5.addPoint(480, 355);
			
			Polygon triangle6 = new Polygon();
			triangle6.addPoint(500, 335);
			triangle6.addPoint(520, 335);
			triangle6.addPoint(520, 355);
			
			Polygon triangle7 = new Polygon();
			triangle7.addPoint(527, 335);
			triangle7.addPoint(547, 335);
			triangle7.addPoint(527, 355);
			
			Polygon triangle8 = new Polygon();
			triangle8.addPoint(569, 335);
			triangle8.addPoint(547, 335);
			triangle8.addPoint(569, 355);
			
			//Draws second ghost
			g2.setStroke(new BasicStroke(10));
			g2.setColor(customColor6);
			g2.fillOval(475, 230, 100, 100);
			g2.fillRect(476, 270, 98, 75);
			g2.drawPolygon(triangle5);
			g2.drawPolygon(triangle6);
			g2.drawPolygon(triangle7);
			g2.drawPolygon(triangle8);
			
			//Draws second ghost eyes
			g2.setColor(Color.WHITE);
			g2.fillOval(485, 260, 35, 35);
			g2.fillOval(530, 260, 35, 35);
			
			//Draws second ghost pupils
			g2.setColor(customColor7);
			g2.fillOval(485, 267, 20, 20);
			g2.fillOval(530, 267, 20, 20);
		}
		
	}
}
