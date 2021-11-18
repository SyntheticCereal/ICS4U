package timerprograms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BallBounce implements ActionListener {

	public static void main(String[] args) {
		new BallBounce();
	}

	static final int PANW = 800;
	static final int PANH = 700;
	DrawingPanel panel = new DrawingPanel();
	DrawingPanel2 panel2 = new DrawingPanel2();
	Ball ball = new Ball(300,100,40,40);
	
	class Ball {
		//only add this line in if you do NOT extend Rectangle
		int x, y, width, height;
		int vx = 3;
		int vy = 2;
		
		Ball(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			width=w;
			height = h;
		}
	}
	
	BallBounce(){
		//setup Jframe
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );				

		
		frame.add(panel);
		frame.add(panel2, BorderLayout.SOUTH);
		
		frame.pack(); //let panel set the size
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);
		
		Timer timer = new Timer(10,this);
		timer.start();
	}
	
	void moveBall() {
		ball.x += ball.vx;
		ball.y += ball.vy;
		
		//*** Bounce off walls ***
		//Super simple bounce
		/*if (ball.x > PANW) {
			ball.vx = -ball.vx;
		}*/
		
		//More general method to avoid glitches
		if (ball.vx > 0 && ball.x+ball.width > PANW ) {
			ball.vx = -ball.vx;  //reverse direction
			//undo the last move
			ball.x -= ball.vx;
			ball.y -= ball.vy;
		}
		
		//right wall is done. Need to do the other 3 walls
		
		
	}
	
	class DrawingPanel extends JPanel {
		DrawingPanel() {
			this.setPreferredSize(new Dimension (PANW, PANH));
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.fillOval(ball.x, ball.y, ball.width, ball.height);
		}
	}
	
	class DrawingPanel2 extends JPanel {
		DrawingPanel2() {
			this.setPreferredSize(new Dimension (PANW, PANH));
		}
	}

	//this is for the TIMER
	@Override
	public void actionPerformed(ActionEvent e) {
		moveBall();
		panel.repaint();		
	}

}
