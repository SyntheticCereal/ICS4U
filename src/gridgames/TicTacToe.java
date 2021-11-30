package gridgames;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/***********************************************
 This is the skeleton for a TicTacToe game using Swing.

 Look over this and see if you have any questions so far.

 We're going to start with just the graphics part.
 But we're also going to store the data. The data will be stored as a grid 
 or 2D array of integers. 

 For TicTacToe, it make sense to have empty = 0, and then X and O be +/- 1
 We'll see why later.
 */

public class TicTacToe {

	//CONSTANTS
	final static int GRID = 3;		//size of board & grid
	/*** you can set this to any size, but the winning only works for the top 3x3 corner ***/


	final static Color COLOURGRID = new Color(140, 140,140);	
	final static Color COLOURBACK = new Color(240, 240, 240);

	//GLOBAL VARIABLES
	int board[][] = new int [GRID][GRID]; 
	JFrame frame;
	int XX = -1;
	int OO = 1;
	int turn = XX;
	boolean empty = true;
	boolean xWin = false;
	boolean oWin = false;
	boolean tie = false;
	int d1Count=0;
	int d2Count=0;
	int hCount=0;
	int vCount=0;
	int emptyCount = GRID*GRID;
	int mx, my;
	int col, row;

	public static void main(String[] args) {
		new TicTacToe();
	}

	TicTacToe() {	
		initGame();		
		createAndShowGUI();

	}

	//This will reset the board if you want to play again.
	//It will be called from the method that checks if you win. If the game is over, reset and then play again
	void initGame() {		
		//TBA		
	}

	void createAndShowGUI() {
		frame = new JFrame("TicTacToe");			
		Container content = frame.getContentPane();
		content.setBackground(Color.BLUE);
		content.setLayout(new BorderLayout(2,2));

		//setup top label & panel						


		//make main panel
		DrawingPanel gridPanel = new DrawingPanel();
		content.add(gridPanel, BorderLayout.CENTER);

		//finish setting up the frame
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(500, 450);		
		frame.setLocationRelativeTo(null);  //must be AFTER setSize		
		frame.setVisible(true);

		//Once the panel is visible, initialize the graphics. 
		//*** This is no longer needed here since it's at the beginning of paintComponent()
		//gridPanel.initGraphics();

	}

//	void printBoard() {
//		for(int row=0; row<GRID; row++) {
//			for(int col=0; col<GRID; col++){
//				System.out.printf("%3d", board[col][row]);
//			}
//			System.out.println();
//		}
//		//System.out.println("=========="); //print out dividing line of the correct length
//		for (int i = 0; i < GRID*3 +2; i++) System.out.print("=");System.out.println();		
//	}

	private class DrawingPanel extends JPanel implements MouseListener{

		//instance variables
		int jpanW, jpanH;	//size of JPanel
		int boxW, boxH;	//size of each square		

		//** Because the panel size variables don't get initialized until the panel is displayed,
		//** we can't do a lot of graphics initialization here in the constructor.
		DrawingPanel() {
			this.addMouseListener(this);
			setBackground(COLOURBACK);
		}

		//** WAS called by createAndShowGUI(), now from paintComponent()
		void initGraphics() {
			jpanW = this.getSize().width;		
			jpanH = this.getSize().height;	

			boxW = jpanW/GRID;
			boxH = jpanH/GRID;

		}

		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g); //needed for background colour to paint
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			initGraphics(); //needed if the window is resized.

			g.setColor(COLOURGRID);	
			for (int i = 1; i<GRID; i++) {
				g.drawLine(boxW*i, 0, boxW*i, jpanH); //Vertical
				g.drawLine(0, boxH*i, jpanW, boxH*i); //Horizontal
			}

			//Check every square in board[][] and draw an X or O there.
			//Try and resize the window while playing. Everything works. 
			g.setColor(Color.RED);
			g2.setStroke(new BasicStroke(2));

			for (int x = 0; x<GRID; x++) {
				for (int y = 0; y<GRID; y++) {
					if (board[x][y]==XX) {
						g.drawLine(boxW*x, boxH*y, boxW*(x+1), boxH*(y+1));
						g.drawLine(boxW*x, boxH*(y+1), boxW*(x+1), boxH*y);
					} else if (board[x][y] == OO){
						g.drawOval(boxW*x, boxH*y, boxW, boxH);
					}
				}
			}
		}




		//******************* MouseListener methods *****************//
		@Override
		public void mouseClicked(MouseEvent e) {
			mx = e.getX();
			my = e.getY();

			//calculate which square you clicked on
			col = my/boxH;
			row = mx/boxW ;

			//how to check if click right mouse button
			if (e.getButton() == MouseEvent.BUTTON3) {
				for (int i = 0; i<GRID; i++) {
					for (int j = 0; j<GRID; j++) {
						board[i][j] = 0;
					}
				}
				oWin = false;
				xWin= false;
				turn = XX;
				emptyCount = GRID*GRID;
			}
			
			if (e.getButton() == MouseEvent.BUTTON1) {
			Gameplay();
			}
			
			this.repaint();
//			printBoard(); 
		}	

		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}

	} //end of DrawingPanel class

	public void Gameplay() {

		//Check if the square is empty
		if (xWin == true || oWin == true) {
			empty = false;
		} else if (board[row][col] == 0) {
			empty = true;
		} else {
			empty = false;
		}

		//update board
		if (empty == true) {
			if (turn==XX) {
				board[row][col] = XX;
			}
			else{
				board[row][col] = OO;
			}
		}

		//Checks for vertical win
		for (int x = 0; x<GRID; x++) {
			for (int y = 0; y<GRID; y++ ) {
				vCount = vCount + board[x][y];
				if (vCount == GRID) {
					oWin = true;
				} else if (vCount == -GRID) {
					xWin = true;
				}

			}
			vCount = 0;
		}

		//Checks for horizontal win
		for (int y = 0; y<GRID; y++) {
			for (int x = 0; x<GRID; x++ ) {
				hCount = hCount + board[x][y];
				if (hCount == GRID) {
					oWin = true;
				} else if (hCount == -GRID) {
					xWin = true;
				}

			}
			hCount=0;
		}

		//Checks for diagonal wins
		d1Count = d1Count + board[0][0] + board[1][1] + board[2][2];
		d2Count = d2Count + + board[2][0] + board[0][2] + board[1][1];

		//win for [0][0] to [2][2]
		if (d1Count == GRID) {
			oWin = true;
		} else if (d1Count == -GRID) {
			xWin = true;
		} else d1Count = 0;

		//win for [2][0] to [0][2]
		if (d2Count == GRID) {
			oWin = true;
		} else if (d2Count == -GRID) {
			xWin = true;
		} else d2Count = 0;

		//Displays win
		if (xWin==true) {
			frame.setTitle("X Wins!");
		} else if (oWin ==true) {
			frame.setTitle("O Wins!");
		}

		//check for tie
		if (empty==true) {
			emptyCount--;
		}
		if (emptyCount == 0 && xWin == false && oWin == false) {
			tie = true;
		}

		if (tie==true) {
			frame.setTitle("Cat's Game!");
		}

		//change turn
		if (turn==XX) {
			turn=OO;
		} else {
			turn=XX;
		}
	}

}