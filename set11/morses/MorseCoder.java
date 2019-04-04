package programming.set11.morses;

import programming.set11.brownies.*;

/**
 * the fancy MorseCoder using a tasty Brownie, swweeeeeeeeet.
 * 
 * @author Jakob Wiegert
 *
 */
public class MorseCoder {

	/**
	 * Returns a new string which is the natural-language version of the input
	 * string, which is assumed to be in morse code format. It does not have leading
	 * or trailing whitespace and exactly a single space character between
	 * consecutive words.
	 * 
	 * @param input
	 *            Morse code input string.
	 * @return natural language version or {@code null} if the input string could
	 *         not be properly parsed.
	 */
	public String decode(String input) {
		boolean fail = false;
		String word = ""; // getrennt durch \n
		String letter = ""; // getrennt durch space
		String lettertrans = "";
		String output = "";

		int inputLenght = input.length();

		BrownieMap<String, String> morseAlphabet = new BrownieMap<>(36);
		morseAlphabet.put(".-", "A");
		morseAlphabet.put("-...", "B");
		morseAlphabet.put("-.-.", "C");
		morseAlphabet.put("-..", "D");
		morseAlphabet.put(".", "E");
		morseAlphabet.put("..-.", "F");
		morseAlphabet.put("--.", "G");
		morseAlphabet.put("....", "H");
		morseAlphabet.put("..", "I");
		morseAlphabet.put(".---", "J");
		morseAlphabet.put("-.-", "K");
		morseAlphabet.put(".-..", "L");
		morseAlphabet.put("--", "M");
		morseAlphabet.put("-.", "N");
		morseAlphabet.put("---", "O");
		morseAlphabet.put(".--.", "P");
		morseAlphabet.put("--.-", "Q");
		morseAlphabet.put(".-.", "R");
		morseAlphabet.put("...", "S");
		morseAlphabet.put("-", "T");
		morseAlphabet.put("..-", "U");
		morseAlphabet.put("...-", "V");
		morseAlphabet.put(".--", "W");
		morseAlphabet.put("-..-", "X");
		morseAlphabet.put("-.--", "Y");
		morseAlphabet.put("--..", "Z");
		morseAlphabet.put("-----", "0");
		morseAlphabet.put(".----", "1");
		morseAlphabet.put("..---", "2");
		morseAlphabet.put("...--", "3");
		morseAlphabet.put("....-", "4");
		morseAlphabet.put(".....", "5");
		morseAlphabet.put("-....", "6");
		morseAlphabet.put("--...", "7");
		morseAlphabet.put("---..", "8");
		morseAlphabet.put("----.", "9");

		char inputchars[] = new char[inputLenght];

		for (int i = 0; i < inputLenght; i++) {
			inputchars[i] = input.charAt(i);

		}

		for (int j = 0; j < inputLenght; j++) {

			if (inputchars[j] == '-') {
				letter = letter + "-";
			} else if (inputchars[j] == '.') {
				letter = letter + ".";
			} else if (inputchars[j] == ' ') {
				if (inputchars[j - 1] == ' ') {

				} else {

					if (morseAlphabet.get(letter) == null) {
						return null;
					}

					lettertrans = lettertrans + morseAlphabet.get(letter);

					word = word + lettertrans;
					letter = "";
					lettertrans = "";
				}
			} else if (inputchars[j] == '\n') {

				if (morseAlphabet.get(letter) == null) {
					return null;
				}

				lettertrans = lettertrans + morseAlphabet.get(letter);

				// switch case für letter
				word = word + lettertrans;
				letter = "";
				lettertrans = "";
				if (output == "") {
					output = word;
				} else {
					output = output + " " + word;
				}
				word = "";
			} else {
				fail = true;
			}

		}

		if (morseAlphabet.get(letter) == null) {
			return null;
		}

		lettertrans = lettertrans + morseAlphabet.get(letter);

		// switch case für letter
		word = word + lettertrans;
		letter = "";
		lettertrans = "";
		if (output == "") {
			output = word;
		} else {
			output = output + " " + word;
		}
		word = "";

		if (fail == false) {
			return output;
		} else {
			return null;
		}

	}

}
