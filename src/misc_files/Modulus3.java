package misc_files;

public class Modulus3 {

	public static void main(String[] args) {
		for (int i=1; i<=200; i++) {
			int modulus = i%12; 
			System.out.printf("%3d ", i);
			if (modulus == 0) {
				System.out.print("\n");
			}

		}

	}
}
