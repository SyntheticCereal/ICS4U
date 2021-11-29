package gridgames;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Starting class for MapContinent program

public class MapContinent
{
	public static void main(String[] args) {
		new MapContinent();
	}

	//constants	
	final static int GRID = 32; //size of grid/board
	final static int SQSIZE = 23; // size of each square in pixels
	final static int NUM_LAND = (GRID * GRID /2); //number of land tiles

	//terrain
	final static int EMPTY = 0;		//constant for empty tile. This is the terrain that needs to be a specific value (since arrays are initialized to zero)
	final static int LAND = 1;		//contant for land tile
	final static int LAKE = 33;		//this is just any number used for LAKE and OCEAN
	final static int OCEAN = 89;
	//colours: you can change these
	final static Color COLOURBACK = new Color(242,242,242);	
	final static Color COLOUREMPTY = new Color(222,222,222);
	final static Color COLOURLAND = new Color(100,200,100);
	final static Color COLOURLAKE = new Color(100,100,255);
	final static Color COLOUROCEAN = new Color(10,10,130);

	//global variables
	int[][] board = new int[GRID][GRID];
	boolean adjEmpty = false;
	int h = (int)(Math.random()*GRID-1);
	int v = (int)(Math.random()*GRID-1);
	int landTiles = 0;
	
	MapContinent() {	//constructor
		initGame();
		createAndShowGUI();
	}

	//PROBLEM 4: When half of the squares are land, the land is scattered quite a lot into little islands.
	//           Find a way to make a random map that has the land in bigger chunks.
	void initGame() {		
		//clear board
		for (int i=0;i<GRID;i++) {
			for (int j=0;j<GRID;j++) {
				board[i][j]=EMPTY;
			}
		}
		//				makeRandomMap();
		makeContinentsNE(h, v);	//this doesn't exist yet. It is for Problem#4.
		makeContinentsSW(h, v);
	}

	void makeRandomMap() {
		int i,j;
		int random;
		i=j=0;
		boolean done = false;
		//PROBLEM 1: Make an equal number of land and water squares, but make sure that the land is randomly distributed.
		for (j = 0;  j < GRID; j++) {
			for (i = 0;  i < GRID; i++) {
				random = (int)(Math.random()*100);
				if (random > 50) {
					board[i][j] = LAND;
					landTiles++;
				}
				if (landTiles == NUM_LAND) {
					done = true;
				}
			}
		}
	}

	void makeContinentsNE(int h, int v) {
		
		//		int nmbrContinents = (int)(Math.random()*5);
		//		for (int k = 0; k < nmbrContinents; k++) { 



//		if (h+1 < GRID) {
//			board[h+1][v] = LAND;
//			if(50<(int)(Math.random()*100)) {
//				makeContinents(h+1, v);
//			}
//		}
//
//		if (v-1 >= 0) {
//			board[h][v-1] = LAND;
//			if(50<(int)(Math.random()*100)) {
//				makeContinents(h, v-1);
//			}
//		}

		if (h-1 >= 0) {
			board[h-1][v] = LAND;
			landTiles++;
			if(50<(int)(Math.random()*100)) {
				makeContinentsNE(h-1, v);
			}
		}

		if (v+1 <v+5) {
			board[h][v+1] = LAND;
			landTiles++;
			if(50<(int)(Math.random()*100)) {
				makeContinentsNE(h, v+1);
			}
		}
		
//		if (landTiles < NUM_LAND) {
//			h = (int)(Math.random()*GRID);
//			v = (int)(Math.random()*GRID);
//			
//			makeContinents(h, v);
//		}
		

	}
	
	void makeContinentsSW(int h, int v) {
		
		//		int nmbrContinents = (int)(Math.random()*5);
		//		for (int k = 0; k < nmbrContinents; k++) { 



		if (h+1 < GRID) {
			board[h+1][v] = LAND;
			if(50<(int)(Math.random()*100)) {
				makeContinentsSW(h+1, v);
			}
		}

		if (v-1 >= 0) {
			board[h][v-1] = LAND;
			if(50<(int)(Math.random()*100)) {
				makeContinentsSW(h, v-1);
			}
		}
	}	
	

	//PROBLEM 2: Fix the function "findLakes()" so that it colours all empty squares that are adjacent to this one.
	//PROBLEM 3: Once you have solved problem 2, now set things up so that if any part 
	//           of a lake touches the edge of the board it becomes an ocean.	
	void findLakes(int x, int y) {
		//call subroutine to colour in all contiguous lake squares


		if (board[x][y] == EMPTY) {
			board [x][y]  = LAKE;
		}

		if (x+1 < GRID) {
			if (board[x+1][y] == EMPTY){
				board[x+1][y] = LAKE;
				findLakes(x+1, y);
			}
		}
		if (x-1 >= 0) {
			if (board[x-1][y] == EMPTY){
				board[x-1][y] = LAKE;
				findLakes(x-1, y);
			}
		}

		if (y+1 < GRID) {
			if (board[x][y+1] == EMPTY){ 

				board[x][y+1] = LAKE;
				findLakes(x, y+1);
			}
		}

		if (y-1 >= 0) {
			if (board[x][y-1] == EMPTY){
				board[x][y-1] = LAKE;
				findLakes(x, y-1);
			}
		}

		if (x == 0 || y == 0) {
			findOceans(x,y);
		}
		if (y == GRID-1 || x == GRID-1) {
			findOceans(x,y);
		}

	}
	void findOceans(int x, int y) {
		if (board[x][y] == LAKE) {
			board [x][y]  = OCEAN;
		}

		if (x+1 < GRID) {
			if (board[x+1][y] == LAKE || board[x+1][y] == EMPTY){
				board[x+1][y] = OCEAN;
				findOceans(x+1, y);
			}
		}

		if ( x-1 >= 0) {
			if (board[x-1][y] == LAKE || board[x-1][y] == EMPTY){
				board[x-1][y] = OCEAN;
				findOceans(x-1, y);
			}
		}

		if ( y+1 < GRID) {
			if (board[x][y+1] == LAKE || board[x][y+1] == EMPTY){
				board[x][y+1] = OCEAN;
				findOceans(x, y+1);
			}
		}

		if ( y-1 >= 0) {
			if (board[x][y-1] == LAKE || board[x][y-1] == EMPTY){
				board[x][y-1] = OCEAN;
				findOceans(x, y-1);
			}
		}
	}


	void createAndShowGUI() {
		DrawingPanel panel = new DrawingPanel();

		//JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Minesweeper Problem #1-4");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Container content = frame.getContentPane();
		// content.setLayout(new BorderLayout(2,2));	
		content.add(panel, BorderLayout.CENTER);		
		//frame.setSize(SCRSIZE, SCRSIZE); //may not be needed since my JPanel has a preferred size
		frame.setResizable(false);		
		frame.pack();
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);

		//once the panel is visible, initialize the graphics. (Is this before paintComponent is run?)
		panel.initGraphics();

	}

	class DrawingPanel extends JPanel	//inner class
	{		
		int jpanW, jpanH;
		int blockX, blockY;		

		public DrawingPanel() {
			setBackground(COLOURBACK);
			//Because the panel size variables don't get initialized until the panel is displayed,
			//we can't do a lot of graphics initialization here in the constructor.
			this.setPreferredSize(new Dimension(GRID*SQSIZE,GRID*SQSIZE));
			MyMouseListener ml = new MyMouseListener();
			addMouseListener(ml);			
		}

		//** Called by createGUI()
		void initGraphics() {
			jpanW = this.getSize().width;		
			jpanH = this.getSize().height;	
			blockX = (int)((jpanW/GRID)+0.5);
			blockY = (int)((jpanH/GRID)+0.5);
			// System.out.println("init");
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			//Draw white grid
			g.setColor(Color.WHITE);
			for (int i=0;i<GRID;i++) {
				g.drawLine(blockX*i,0,blockX*i,jpanH);
				g.drawLine(0,blockY*i,jpanW,blockY*i);
			}

			for (int i=0;i<GRID;i++) {
				for (int j=0;j<GRID;j++) {
					colourRect(i,j,g);						
				}
			}			
		}

		void colourRect(int i, int j, Graphics g) {

			int terrain = board[i][j];

			if (terrain == EMPTY) {
				g.setColor(COLOUREMPTY);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}
			if (terrain == LAND) {
				g.setColor(COLOURLAND);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}			
			if (terrain == LAKE) {
				g.setColor(COLOURLAKE);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}
			if (terrain == OCEAN) {
				g.setColor(COLOUROCEAN);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}			
		}		

		class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				//calculate which square you clicked on
				int i = (int)  x/blockX;
				int j = (int) y/blockY;	// blockY/y

				//allow the right mouse button to toggle/cycle the terrain
				if (e.getButton() != MouseEvent.BUTTON1) {
					switch (board[i][j]) {
					case LAND:
						board[i][j] = EMPTY;
						break;
					default:
						board[i][j] = LAND;
					}
					repaint();
					return;
				}

				findLakes(i,j);								
				repaint();
			}		
		} //end of MyMouseListener class

	} //end of DrawingPanel class

}