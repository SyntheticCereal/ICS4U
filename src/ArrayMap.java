
public class ArrayMap {

	/*
	 * Chris Simpauco
	 * 18/11/21 
	 * Creates array and fills with values
	 * Edges are 10 (2,8) is 99
	 */
	
	private static final int SIZE = 10;
	private static int[][] map = new int[SIZE][SIZE];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fillMap();
		printMap();

	}

	static void printMap() {
		for(int row=0; row<SIZE; row++) {
			for(int col=0; col<SIZE; col++){
				System.out.printf("%3d", map[row][col]);
			}
			System.out.println();
		}
		for (int i = 0; i < SIZE*3 +2; i++) System.out.print("=");System.out.println();		
	}
	
	static void fillMap () {
		for (int i = 0; i <SIZE; i++) {
			map[i][0] = 10;
			map[0][i] = 10;
			map[i][SIZE-1] = 10;
			map[SIZE-1][i] = 10;
			map[8][2] = 99;
		}
	}

}
