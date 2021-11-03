package TicTacToe;

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

	public static void main(String[] args) {
		new TicTacToe();
	}

	TicTacToe() {	
		initGame();		
		createAndShowGUI();

		//		board[0][0] = XX;
		//		board[1][0] = OO;
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

	void printBoard() {
		for(int row=0; row<GRID; row++) {
			for(int col=0; col<GRID; col++){
				System.out.printf("%3d", board[col][row]);
			}
			System.out.println();
		}
		//System.out.println("=========="); //print out dividing line of the correct length
		for (int i = 0; i < GRID*3 +2; i++) System.out.print("=");System.out.println();		
	}

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

			//TODO Find the size of each box in pixels.  Set boxW, boxH
			boxW = jpanW/GRID;
			boxH = jpanH/GRID;

		}

		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g); //needed for background colour to paint
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			initGraphics(); //needed if the window is resized.

			//TODO Draw grid
			g.setColor(COLOURGRID);	
			for (int i = 1; i<GRID; i++) {
				g.drawLine(boxW*i, 0, boxW*i, jpanH); //Vertical
				g.drawLine(0, boxH*i, jpanW, boxH*i); //Horizontal
			}

			//TODO draw all X and Os
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
			int mx = e.getX();
			int my = e.getY();


			//calculate which square you clicked on
			int col,row;
			col = my/boxH;
			row = mx/boxW ;

			//TODO display mouse coords and grid square in title.
			frame.setTitle(mx + "," + my + "   " + row + "," + col);
			//how to check if click right mouse button
			if (e.getButton() == MouseEvent.BUTTON3) {
				//do something
			}

			/*** put these in methods, maybe one master method ***/


			//TODO Check if the square is empty
			if (board[row][col] == 0) {
				empty = true;
			} 
			else {
				empty = false;

			}

			//TODO update board
			if (empty == true) {
				if (turn==XX) {
					board[row][col] = XX;
				}
				else{
					board[row][col] = OO;
				}
			}

			//TODO check for the winner


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

			for (int y = 0; y<GRID; y++) {
				for (int x = 0; x<GRID; x++ ) {
					d1Count = d1Count + board [x][y];
					if (d1Count == GRID) {
						oWin = true;
					} else if (d1Count == -GRID) {
						xWin = true;
					}
					d1Count = 0;
					d2Count = d2Count + board [x][y];
					if (d2Count == GRID) {
						oWin = true;
					} else if (d2Count == -GRID) {
						xWin = true;
					}

				}
				d2Count = 0;
			}

			if (xWin==true) {
				frame.setTitle("X Wins!");
			} else if (oWin ==true) {
				frame.setTitle("O Wins!");
			}

			//TODO check for tie
			if (empty==true) {
				emptyCount--;
			}

			if (emptyCount == 0 && xWin == false && oWin == false) {
				tie = true;
			}

			if (tie==true) {
				frame.setTitle("Cat's Game!");
			}

			//TODO change turn
			if (turn==XX) {
				turn=OO;
			} else {
				turn=XX;
			}

			this.repaint();
			printBoard();
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

}