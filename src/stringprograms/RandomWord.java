package stringprograms;

/*
 * Chris S
 * ICS4U
 * 16/12/21
 * Creates a 6 letter word with random letters
 * Adds exactly 1 or 2 (Determined when program is initially run) vowels in random spots
 */

public class RandomWord {
	public static void main(String[] args) {
		String str = ""; //Base word to be filled with letters
		String vowel = "AEIOUY"; //Word containing all vowels
		double numVowel = (Math.random()*2);
		int tempPlace =-1;


		for (int i = 0; i<=5; i++) { 
			char letter = (char)((Math.random()*26)+65); //Finds a capital letter
			//If its calculates the ASCII value of vowels it calculates a new letter
			while (letter == 65 || letter == 69 || letter == 73 || letter == 79 || letter == 85 || letter == 89) {
				if (letter == 65 || letter == 69 || letter == 73 || letter == 79 || letter == 85 || letter == 89) {
					letter = (char)((Math.random()*26)+65);
				}
			}
			str = str+letter; //Adds calculated letters
		}

		for (int i = 0; i<=(int)(numVowel); i++) {
			int placeVowel = (int)(Math.random()*6); //Calculates where to put the vowel
			int randVowel = (int)(Math.random()*5); //Calculate which vowel

			while (tempPlace == placeVowel) { //Makes sure two values aren't put on the same spot
				if (tempPlace == placeVowel) {
					placeVowel = (int)(Math.random()*6);
				}
			}

			tempPlace = placeVowel;

			//Replaces letters with vowels
			StringBuffer sbuff = new StringBuffer(str);
			sbuff.setCharAt(placeVowel, vowel.charAt(randVowel));
			str = sbuff.toString();

		}

		System.out.println(str);

	}
}
