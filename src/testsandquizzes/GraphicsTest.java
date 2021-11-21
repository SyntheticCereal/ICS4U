package testsandquizzes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * Chris Simpauco
 * Graphics test
 * 18/11/2021
 * Program creates ball moves it left to right
 * When ball reaches either side it moves to the opposite side
 * Pause button pauses the movement and becomes resume button
 * Resume button starts movement and becomes pause button
 * Reverse button changes direction of the ball
 */

public class GraphicsTest implements ActionListener {

	public static void main(String[] args) {
		new GraphicsTest();
	}

	//Global Variables
	static final int PANW = 800;
	static final int PANH = 700;
	DrawingPanel panel = new DrawingPanel();
	Ball ball = new Ball(0,PANH/2,40,40);
	JFrame frame = new JFrame();
	JButton pause = new JButton("Pause");

	//Creates ball
	class Ball {
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

	GraphicsTest() {
		
		//setup Jframe
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.BLUE);
		panel2.setPreferredSize(new Dimension (PANW, 100));

		//Adds button for pause
		panel2.add(pause);
		pause.addActionListener(new MyAl());

		//Creates button for reverse
		JButton reverse = new JButton("Reverse");
		panel2.add(reverse);
		reverse.addActionListener(new MyAl());

		frame.add(panel, BorderLayout.CENTER); //Needed so panel isn't hidden
		frame.add(panel2, BorderLayout.SOUTH); //Puts panel2 on the bottom

		frame.pack(); //let panel set the size
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);

		Timer timer = new Timer(10,this);
		timer.start();
	}

	//Method for moving ball
	void moveBall() {
		ball.x += ball.vx; //Moves ball
		//Puts ball on left side when it reaches right side
		if (ball.vx > 0 && ball.x> PANW ) {
			ball.x = 0-ball.width;
		} else if (ball.vx < 0 && ball.x < 0-ball.width) { //Puts ball on right side when it reaches left side
			ball.x = PANW;
		}
	}

	//Sets up panel
	class DrawingPanel extends JPanel {
		DrawingPanel() {
			this.setPreferredSize(new Dimension (PANW, PANH));
		}

		@Override
		//Draws ball
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.fillOval(ball.x, ball.y, ball.width, ball.height);
		}
	}


	//Timer action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setTitle ("Graphics Test | Ball x:" + ball.x + " | Ball vx:" + ball.vx);
		moveBall();
		panel.repaint();		
	}

	//Button action listener 
	class MyAl implements ActionListener {
		int tempvx;
		@Override
		public void actionPerformed(ActionEvent e) {
			//If statement for reverse
			if (e.getActionCommand().equals("Reverse")) {
				ball.vx = ball.vx*-1; //Multiplies vx by -1 to change the direction
			}
			//If statement for pause
			if (e.getActionCommand().equals("Pause")) {
				tempvx = ball.vx; //Saves the vx
				ball.vx = 0; //Sets vx to 0 to stop movement
				pause.setText ("Resume"); //Changes text to resume
			}
			//If statement for resume
			if (e.getActionCommand().equals("Resume")) {
				ball.vx = tempvx; //Changes vx to the saved vx
				pause.setText ("Pause"); //Changes back to pause
			}
		}

	}

}
