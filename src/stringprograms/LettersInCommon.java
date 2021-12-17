package stringprograms;

/*
 * Chris S
 * ICS4U1
 * 16/12/21
 * Checks given word against array of words to determine the maximum amount of common letters
 */

public class LettersInCommon {

	public static void main(String[] args) {
		String[] wordlist = {"guyana", "lotion", "chilly", "doggie", "fledgy", "swanky", "crawly", "physic"}; //Array of words
		String word = "digger"; //Base word to be compared
		int mostCommon = 0;

		for(int i = 0; i<wordlist.length; i++){ //Goes through each word in the array
			int cmnLetter = 0;

			for(int j = 0; j<wordlist[i].length(); j++){ //Goes through each letter of the array
				char lttrCompare = wordlist[i].charAt(j); //Gets letter of each letter in the array

				for(int h = 0; h<word.length(); h++){//Compares each letter in base word
					char baseCompare = word.charAt(h); //Gets letter of base wrod
					boolean compared = false;
					for(int k=h-1; k>=0; k--){ //Goes backwards through array to check for already compared letters
						if(word.charAt(k) == word.charAt(h)){ 
							compared = true;
						}
					}
				
					
					if(baseCompare==lttrCompare && !compared){ //If something is the same and not compared adds to common letter count
						cmnLetter++;
						compared = false;
					}
				}
			}
			
			if(cmnLetter>mostCommon){ //Sets mostCommon to current highest letters in common
				mostCommon=cmnLetter;
			}
		}
		System.out.println(mostCommon); //Prints out mostCommon
	}

}

