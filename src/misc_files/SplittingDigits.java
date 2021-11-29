public class SplittingDigits {
	public static void main (String[] args) {
		
		//Digits are found by dividing the number by 10
		System.out.println("Method using division");
		
		int randomNumber, tensDivision, onesDivision;
		
		randomNumber = (int)(Math.random()*89+10);
		
		tensDivision = randomNumber / 10;
		onesDivision = randomNumber - (tensDivision*10);

		System.out.println(randomNumber);
		System.out.println("int a = " + tensDivision);
		System.out.println("int b = " + onesDivision);
		
		//Digits are found by reading integers as strings
		System.out.println("");
		System.out.println("Method using strings");
		
		String integerString = "" + randomNumber;
		String stringTens, stringOnes;
		
		stringOnes = integerString.substring(0,1);
		stringTens = integerString.substring(1);
		
		System.out.println(randomNumber);
		System.out.println("int a = " + stringOnes);
		System.out.println("int b = " + stringTens);
		
		//Digits are found using %
		System.out.println("");
		System.out.println("Method using %");
		int tensModulos, onesModulos; 
		
		onesModulos = randomNumber%10; 
		tensModulos = (randomNumber - onesModulos)/10;
		
		System.out.println(randomNumber);
		System.out.println("int a = "+ tensModulos);
		System.out.println("int b = "+ onesModulos);
	}
}

