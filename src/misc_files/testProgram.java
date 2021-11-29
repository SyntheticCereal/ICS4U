public class testProgram {
	public static void main(String[] args) {
		int randomNumber[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		int smallestNumber = 101;
		int largestNumber = 0;
		
		for (int x = 0; x<randomNumber.length; x++) {
			randomNumber[x]= (int)(Math.random()*100);
			
			if (smallestNumber>randomNumber[x]) {
				smallestNumber = randomNumber[x];
			}
			
			if (largestNumber<randomNumber[x]) {
				largestNumber = randomNumber[x];
			}
		}
		
		for (int x = 0; x<randomNumber.length; x++) {
			System.out.println(randomNumber[x]);
		}
		
		System.out.println();
		System.out.println("Smallest Number: " + smallestNumber);
		System.out.println();
		System.out.println("Largest Number: " + largestNumber);
		
	}
}
