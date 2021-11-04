
public class ArrayMap {

	private static final int SIZE = 10;
	private static int[][] map = new int[SIZE][SIZE];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printBoard();
	}

	static void printBoard() {
		for(int row=0; row<SIZE; row++) {
			for(int col=0; col<SIZE; col++){
				if (col == 0 || col == SIZE-1 || row == 0 || row == SIZE-1)
				{
					System.out.printf("%3d", 10);
				} else if (row == 8 && col == 2) {
					System.out.printf("%3d", 99);
				}else {
					System.out.printf("%3d", map[row][col]);
				}
			}
			
			System.out.println();
		}
		//System.out.println("=========="); //print out dividing line of the correct length
		//		for (int i = 0; i < SIZE*3 +2; i++) System.out.print("=");System.out.println();		
	}

}
