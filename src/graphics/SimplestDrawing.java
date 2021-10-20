package graphics;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimplestDrawing {

	public static void main(String[] args) {
		new SimplestDrawing(); 
	}

	//Constants
	//set the size of the drawing panel
	final static int panW = 800;
	final static int panH = 700;

	//Global variables
	GraphicsPanel panel;

	SimplestDrawing(){
		JFrame window = new JFrame("Drawing on a JPanel");
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new GraphicsPanel();
		window.add(panel);  //defaults to BorderLayout.CENTER

		window.pack(); //needed in order to use the GraphicsPanel's size to set the JFrame size
		window.setLocationRelativeTo(null); //centre the window, must be after pack()

		window.setVisible(true); 	
	}

	private class GraphicsPanel extends JPanel {
		GraphicsPanel(){
			this.setBackground(Color.WHITE);
			this.setPreferredSize(new Dimension(panW, panH));
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			//Do all your drawing here

			for (int x=0; x<panW; x++) {
				for (int y=0; y<panH; y++) {
					g.setColor(new Color(200, x%80, 100));
					g.drawLine(x, y, x,y);				
				}
			}
		}
	}
}


