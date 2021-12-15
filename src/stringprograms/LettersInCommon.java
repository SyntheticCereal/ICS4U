package stringprograms;

public class LettersInCommon {

	public static void main(String[] args) {
		String[] wordlist = {"guyana", "lotion", "chilly", "doggie", "fledgy", "swanky", "crawly", "physic"};
		String word = "digger";
		int mostCommon = 0;

		for(int i = 0; i<wordlist.length; i++){ //Goes through each word in the array
			int cmnLetter = 0;

			for(int j = 0; j<wordlist[i].length(); j++){ //Goes through each letter of the array
				char lttrCompare = wordlist[i].charAt(j);

				for(int h = 0; h<word.length(); h++){//Compares each letter in base word
					char baseCompare = word.charAt(h);
					boolean compared = false;
					for(int k=h-1; k>=0; k--){
						if(word.charAt(k) == word.charAt(h)){
							compared = true;
						}
					}
				
					if(baseCompare==lttrCompare && !compared){
						cmnLetter++;
						compared = false;
					}
				}
			}
			
			if(cmnLetter>mostCommon){
				mostCommon=cmnLetter;
			}
		}
		System.out.println(mostCommon);
	}

}

