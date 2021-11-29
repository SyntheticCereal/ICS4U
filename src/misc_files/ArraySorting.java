package misc_files;

public class ArraySorting {

	public static void main(String[] args) {
		int size = 10;
		int max = 100;

		int randomNumbers [] = new int [size];
		for (int x = 0; x<randomNumbers.length; x++) {
			randomNumbers[x] = (int)(Math.random()*max);
		}
		
		for (int x = 0; x<randomNumbers.length; x++) {
			System.out.print(randomNumbers[x] + " ");
		}

		for (int x = 0; x<randomNumbers.length; x++) {
			int j = x-1;
			//while ()
		}
		
		for (int x = 0; x<randomNumbers.length; x++) {
			System.out.print(randomNumbers[x] + " ");
		}
		
	}
}
