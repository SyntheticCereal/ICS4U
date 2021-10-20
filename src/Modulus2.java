
public class Modulus2 {

	public static void main(String[] args) {

		for (int i=1; i<=200; i++) {
			int modulus = i%13; 
			if (modulus == 0) {
				System.out.print(i + " ");
			}

		}

	}
}