package stringprograms;

public class Numbers {

	public static void main(String[] args) {
		String[] wordlist = {"guyana", "lotion", "chilly", "doggie", "fledgy", "swanky", "crawly", "physic"};
		String word = "digger";
		int mostCommon = 0;

		for(int i = 0; i<wordlist.length; i++){ //Goes through each word in the array
			int cmnLetter = 0;

			for(int j = 0; j<wordlist[i].length(); j++){ //Goes through each letter of the array
				char lttrCompare = wordlist[i].charAt(j);

				for(int h = 0; h<word.length(); h++) {//Compares each letter in base word
					char baseCompare = word.charAt(h);
					if(baseCompare==lttrCompare){
						cmnLetter++;
					}
				}
			}
			
			if(cmnLetter>mostCommon){
				mostCommon=cmnLetter;
			}
		}

		
	}

}
