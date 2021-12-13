package gridgames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Chris S
 * 11/12/21
 * MapContinent Program
 * Generates an equal amount of land to empty spaces
 * Fills empty space if clicked on, filled with ocean if touching the edge, if not fills with lake
 */

//Starting class for MapContinent2 program

public class MapContinent2 {
	public static void main(String[] args) {
		new MapContinent2();
	}

	// constants
	final static int GRID = 32; // size of grid/board
	final static int SQSIZE = 20; // size of each square in pixels
	final static int NUM_LAND = (GRID * GRID / 2); // number of land tiles

	// terrain
	final static int EMPTY = 0; // constant for empty tile. This is the terrain that needs to be a specific
	// value (since arrays are initialized to zero)
	final static int LAND = 1; // contant for land tile
	final static int LAKE = 33; // this is just any number used for LAKE and OCEAN
	final static int OCEAN = 89;
	// colours: you can change these
	final static Color COLOURBACK = new Color(242, 242, 242);
	final static Color COLOUREMPTY = new Color(222, 222, 222);
	final static Color COLOURLAND = new Color(100, 200, 100);
	final static Color COLOURLAKE = new Color(100, 100, 255);
	final static Color COLOUROCEAN = new Color(10, 10, 130);

	// global variables
	int[][] board = new int[GRID][GRID];
	int landTiles = 0;
	JFrame frame = new JFrame("MapContinent");
	int numCont = (int)(Math.random()*9)+1;

	MapContinent2() { // constructor
		initGame();
		createAndShowGUI();
	}

	// PROBLEM 4: When half of the squares are land, the land is scattered quite a
	// lot into little islands.
	// Find a way to make a random map that has the land in bigger chunks.
	void initGame() {
		// clear board
		for (int i = 0; i < GRID; i++) {
			for (int j = 0; j < GRID; j++) {
				board[i][j] = EMPTY;
			}
		}
		makeOrigin();
		//		makeRandomMap();
		//		makeContinents();
	}
	
	//Fills board with random land tiles
	void makeRandomMap() {
		int i, j;
		i = j = 0;
		boolean done = false;
		// PROBLEM 1: Make an equal number of land and water squares, but make sure that
		// the land is randomly distributed.
		while (landTiles < NUM_LAND) {
			for (j = 0; j < GRID; j++) {
				for (i = 0; i < GRID; i++) {
					if (Math.random() < 0.5) {
						board[i][j] = LAND;
						landTiles++;
					}
					if (landTiles == NUM_LAND) {
						break;
					}

				}
				if (landTiles == NUM_LAND) {
					break;
				}
			}
		}
	}
	
	//Creates random origin points
	void makeOrigin(){
		double h;
		double v;
		for(int i = 0; i<numCont; i++) {
			//Creates random coordinates
			h = Math.random()*GRID;
			v = Math.random()*GRID;
			//Only fills if its land
			if (board[(int)h][(int)v] == EMPTY) {
				landTiles++;
				board[(int)h][(int)v] = LAND;
			} else { //If not creates new coordinates
				h = Math.random()*GRID;
				v = Math.random()*GRID;
			}
		}
		createLand();
	}

	//Creates land tiles, increases chance of land if its adjacent to land
	void createLand (){
		while (landTiles < NUM_LAND) {
			for (int j = 0; j<GRID; j++) {
				for (int i = 0; i<GRID; i++) {
					double chance = Math.random();

					//Increases chance of land
					if (i-1 >= 0) {
						if (board[i-1][j] == LAND) {
							chance -= 0.3;
						}
					}

					if (i+1 < GRID) {
						if (board[i+1][j] == LAND) {
							chance -= 0.3;
						}
					}
					if (j-1 >= 0) {
						if (board[i][j-1] == LAND) {
							chance -= 0.3;
						}
					}
					if ( j+1 < GRID) {
						if (board[i][j+1] == LAND) {
							chance -= 0.3;
						}
					}

					//If its a valid square and if chance is <0.1 it creates land
					if (board[i][j] == EMPTY) {
						if (chance < 0.1) {
							board[i][j] = LAND;
							landTiles++;
						}
					}

					if (landTiles == NUM_LAND) { //Breaks horizontal for loop
						break;
					}	
				}
				if (landTiles == NUM_LAND) { //Breaks vertical for loop
					break;
				}
			}
			if (landTiles == NUM_LAND) { //Breaks while loop
				break;
			}
		}
	}
	
	//Scrapped code I didn't want to get rid of
	void makeContinents() {
		makeOrigin();
		int h = (int) (Math.random() * GRID - 1);
		int v = (int) (Math.random() * GRID - 1);

		board[h][v] = LAKE;
		landTiles++;

		if (landTiles >= NUM_LAND) return;
		makeContinentsNW(h, v);
		if (landTiles >= NUM_LAND) return;
		makeContinentsNE(h, v);
		if (landTiles >= NUM_LAND) return;
		makeContinentsSW(h, v);
		if (landTiles >= NUM_LAND) return;
		makeContinentsSE(h, v);

		while (landTiles < NUM_LAND) {
			makeContinents();
		}

		if (landTiles != NUM_LAND) {
			makeContinents();
		}
	}

	//Scrapped code I didn't want to get rid of
	void makeContinentsNE(int h, int v) {
		if (h + 1 < GRID) {
			board[h + 1][v] = LAND;
			landTiles++;
			if (landTiles < NUM_LAND) {
				if (Math.random()<0.65) {
					makeContinentsNE(h + 1, v);
				}
			}
		}

		if (v - 1 >= 0) {
			board[h][v - 1] = LAND;
			landTiles++;
			if (landTiles < NUM_LAND) {
				if (Math.random()<0.65)  {
					makeContinentsNE(h, v - 1);
				}
			}
		}
	}

	//Scrapped code I didn't want to get rid of
	void makeContinentsNW(int h, int v) {
		if (h - 1 >= 0) {
			board[h - 1][v] = LAND;
			landTiles++;
			if (landTiles < NUM_LAND) {
				if (Math.random()<0.65) {
					makeContinentsNW(h - 1, v);
				}
			}
		}

		if (v - 1 >= 0) {
			board[h][v - 1] = LAND;
			landTiles++;
			if (landTiles < NUM_LAND) {
				if (Math.random()<0.65) {
					makeContinentsNW(h, v - 1);
				}
			}
		}
	}

	//Scrapped code I didn't want to get rid of
	void makeContinentsSW(int h, int v) {
		if (h - 1 >= 0) {
			board[h - 1][v] = LAND;
			landTiles++;
			if (landTiles < NUM_LAND) {
				if (Math.random()<0.65) {
					makeContinentsSW(h - 1, v);
				}
			}
		}

		if (v + 1 < GRID) {
			board[h][v + 1] = LAND;
			landTiles++;
			if (landTiles < NUM_LAND) {
				if (Math.random()<0.65) {
					makeContinentsSW(h, v + 1);
				}
			}
		}
	}

	//Scrapped code I didn't want to get rid of
	void makeContinentsSE(int h, int v) {
		if (h + 1 < GRID) {
			board[h + 1][v] = LAND;
			landTiles++;
			if (landTiles < NUM_LAND) {
				if (Math.random()<0.65) {
					makeContinentsSE(h + 1, v);
				}
			}
		}

		if (v + 1 < GRID) {
			board[h][v + 1] = LAND;
			landTiles++;
			if (landTiles < NUM_LAND) {
				if (Math.random()<0.65) {
					makeContinentsSE(h, v + 1);
				}
			}
		}
	}
	
	//Uses recursion to fill with lakes
	//Method calls itself for going up, down, left and right
	void findLakes(int x, int y) {
		if (board[x][y] == EMPTY) {
			board[x][y] = LAKE;
		}

		if (x + 1 < GRID) {
			if (board[x + 1][y] == EMPTY) {
				board[x + 1][y] = LAKE;
				findLakes(x + 1, y);
			}
		}
		if (x - 1 >= 0) {
			if (board[x - 1][y] == EMPTY) {
				board[x - 1][y] = LAKE;
				findLakes(x - 1, y);
			}
		}

		if (y + 1 < GRID) {
			if (board[x][y + 1] == EMPTY) {

				board[x][y + 1] = LAKE;
				findLakes(x, y + 1);
			}
		}

		if (y - 1 >= 0) {
			if (board[x][y - 1] == EMPTY) {
				board[x][y - 1] = LAKE;
				findLakes(x, y - 1);
			}
		}

		if (x == 0 || y == 0) {
			findOceans(x, y);
		}
		if (y == GRID - 1 || x == GRID - 1) {
			findOceans(x, y);
		}

	}

	//Checks if any lake tile is touching the edge, if so uses recursion to fill with ocean
	void findOceans(int x, int y) {
		if (board[x][y] == LAKE) {
			board[x][y] = OCEAN;
		}

		if (x + 1 < GRID) {
			if (board[x + 1][y] == LAKE || board[x + 1][y] == EMPTY) {
				board[x + 1][y] = OCEAN;
				findOceans(x + 1, y);
			}
		}

		if (x - 1 >= 0) {
			if (board[x - 1][y] == LAKE || board[x - 1][y] == EMPTY) {
				board[x - 1][y] = OCEAN;
				findOceans(x - 1, y);
			}
		}

		if (y + 1 < GRID) {
			if (board[x][y + 1] == LAKE || board[x][y + 1] == EMPTY) {
				board[x][y + 1] = OCEAN;
				findOceans(x, y + 1);
			}
		}

		if (y - 1 >= 0) {
			if (board[x][y - 1] == LAKE || board[x][y - 1] == EMPTY) {
				board[x][y - 1] = OCEAN;
				findOceans(x, y - 1);
			}
		}
	}

	void createAndShowGUI() {
		DrawingPanel panel = new DrawingPanel();

		// JFrame.setDefaultLookAndFeelDecorated(true);
		//		JFrame frame = new JFrame("MapContinent2 Problem #1-4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = frame.getContentPane();
		// content.setLayout(new BorderLayout(2,2));
		content.add(panel, BorderLayout.CENTER);
		// frame.setSize(SCRSIZE, SCRSIZE); //may not be needed since my JPanel has a
		// preferred size
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// once the panel is visible, initialize the graphics. (Is this before
		// paintComponent is run?)
		panel.initGraphics();

	}

	class DrawingPanel extends JPanel // inner class
	{
		int jpanW, jpanH;
		int blockX, blockY;

		public DrawingPanel() {
			setBackground(COLOURBACK);
			// Because the panel size variables don't get initialized until the panel is
			// displayed,
			// we can't do a lot of graphics initialization here in the constructor.
			this.setPreferredSize(new Dimension(GRID * SQSIZE, GRID * SQSIZE));
			MyMouseListener ml = new MyMouseListener();
			addMouseListener(ml);
		}

		// ** Called by createGUI()
		void initGraphics() {
			jpanW = this.getSize().width;
			jpanH = this.getSize().height;
			blockX = (int) ((jpanW / GRID) + 0.5);
			blockY = (int) ((jpanH / GRID) + 0.5);
			// System.out.println("init");
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Draw white grid
			g.setColor(Color.WHITE);
			for (int i = 0; i < GRID; i++) {
				g.drawLine(blockX * i, 0, blockX * i, jpanH);
				g.drawLine(0, blockY * i, jpanW, blockY * i);
			}

			for (int i = 0; i < GRID; i++) {
				for (int j = 0; j < GRID; j++) {
					colourRect(i, j, g);
				}
			}
		}

		void colourRect(int i, int j, Graphics g) {

			int terrain = board[i][j];

			if (terrain == EMPTY) {
				g.setColor(COLOUREMPTY);
				g.fillRect(blockX * i + 1, blockY * j + 1, blockX - 2, blockY - 2);
			}
			if (terrain == LAND) {
				g.setColor(COLOURLAND);
				g.fillRect(blockX * i + 1, blockY * j + 1, blockX - 2, blockY - 2);
			}
			if (terrain == LAKE) {
				g.setColor(COLOURLAKE);
				g.fillRect(blockX * i + 1, blockY * j + 1, blockX - 2, blockY - 2);
			}
			if (terrain == OCEAN) {
				g.setColor(COLOUROCEAN);
				g.fillRect(blockX * i + 1, blockY * j + 1, blockX - 2, blockY - 2);
			}
		}

		class MyMouseListener extends MouseAdapter { // inner class inside DrawingPanel
			public void mouseClicked(MouseEvent e) {

				int x = e.getX();
				int y = e.getY();
				// calculate which square you clicked on
				int i = (int) x / blockX;
				int j = (int) y / blockY; // blockY/y

				// allow the right mouse button to toggle/cycle the terrain
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

				findLakes(i, j);
				repaint();
			}
		} // end of MyMouseListener class

	} // end of DrawingPanel class

}