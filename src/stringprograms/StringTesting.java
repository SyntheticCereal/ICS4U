package stringprograms;

public class StringTesting {
	public static void main(String[] args) {
		String str = "";
		String vowel = "AEIOUY";
		double numVowel = (Math.random()+1);


		for (int i = 0; i<=5; i++) {
			char letter = (char)((Math.random()*26)+65);
			if (letter == 65 || letter == 69 || letter == 73 || letter == 79 || letter == 85 || letter == 89) {
				letter = (char)((Math.random()*26)+65);
			}
			str = str+letter;
		}
		
		for (int i = 0; i<=(int)(numVowel); i++) {
			int placeVowel; 
		}
		
		
		System.out.println(str);
	}
}