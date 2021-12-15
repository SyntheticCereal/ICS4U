package stringprograms;

public class RandomWord {
	public static void main(String[] args) {
		String str = "";
		String vowel = "AEIOUY";
		double numVowel = (Math.random()*2);


		for (int i = 0; i<=5; i++) {
			char letter = (char)((Math.random()*26)+65);
			if (letter == 65 || letter == 69 || letter == 73 || letter == 79 || letter == 85 || letter == 89) {
				letter = (char)((Math.random()*26)+65);
			}
			str = str+letter;
		}

		for (int i = 0; i<=(int)(numVowel); i++) {
			int placeVowel = (int)(Math.random()*6);
			int randVowel = (int)(Math.random()*5);

			StringBuffer sbuff = new StringBuffer(str);
			sbuff.setCharAt(placeVowel, vowel.charAt(randVowel));
			str = sbuff.toString();

		}

		System.out.println(str);

	}
}
