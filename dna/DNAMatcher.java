package programming.set10.dna;

/**
 * Science ! this matches DNA to create KillerTomatos.
 * 
 * @author Jakob Wiegert
 *
 */
public class DNAMatcher {

	String dna1; // first DNA
	char[] char1;
	int dna1Length;

	/**
	 * the DNA Constructor on which the next DNA will be matched.
	 * 
	 * @param dna1
	 *            the DNA as a String
	 */
	public DNAMatcher(String dna1) {

		if (dna1 == null) {
			throw new IllegalArgumentException("Dude , this isnt even a DNA, at least not on our Planet :O");
		}

		int dna1Length = dna1.length();
		char[] char1 = new char[dna1Length];

		for (int i = 0; i < dna1Length; i++) {
			char1[i] = dna1.charAt(i);
		}

		if (isDna(dna1, char1, dna1Length) == false) {
			throw new IllegalArgumentException("Dude , this isnt even a DNA, at least not on our Planet :O");
		}

		this.dna1 = dna1;
		this.char1 = char1;
		this.dna1Length = dna1Length;
	}

	// in ner schleife mit vieln ifs die überprüfen also check if char 1 if then
	// check 2....
	// das überprüfen in ne extra methode

	/**
	 * Returns the index of the first position in the base DNA string where
	 * candidateDNA can bind, if any.
	 * 
	 * @param candidateDNA
	 *            the DNA string to try to bind to the base DNA.
	 * @return index of the first binding position or {@code -1} if the candidate
	 *         DNA string cannot bind to the base string.
	 * @throws IllegalArgumentException
	 *             if {@code candidateDNA} is {@code null}, empty, or contains
	 *             characters other than A, C, G, and T.
	 */
	public int findFirstBindingPosition(String candidateDNA) {
		if (candidateDNA == null) {
			throw new IllegalArgumentException("Dude , this isnt even a DNA, at least not on our Planet :O");
		}
		int dna2Length = candidateDNA.length();
		char[] char2 = new char[dna2Length];

		for (int i = 0; i < dna2Length; i++) {
			char2[i] = candidateDNA.charAt(i);
		}

		if (isDna(candidateDNA, char2, dna2Length) == false) {
			throw new IllegalArgumentException("Dude you cant combine your DNA with some Alien.");
		}
		int counter;

		for (int j = 0; j < dna1Length; j++) {
			counter = 0;
			if (checkingChars(char1, char2, j, 0)) {

				for (int k = 0; k < dna2Length; k++) {

					if (k + j < dna1Length) {

						if (checkingChars(char1, char2, j + k, k)) {
							counter++;
						}

					} else {
						counter = 0;
					}
				}
				if (counter == dna2Length) {
					return j;
				}

			}

		}
		return -1;
	}

	/**
	 * This method checks if 2 chars of 2 dnas are matchable.
	 * 
	 * @param charArray1
	 *            first dnaChar
	 * @param charArray2
	 *            second charArray
	 * @param indexOf1
	 *            the index of one
	 * @param indexOf2
	 *            the index of two
	 * @return the boolean
	 */
	private boolean checkingChars(char[] charArray1, char[] charArray2, int indexOf1, int indexOf2) {
		boolean matched = false;
		if (charArray1[indexOf1] == 'G') {
			if (charArray2[indexOf2] == 'C') {
				matched = true;
			}
		} else if (charArray1[indexOf1] == 'C') {
			if (charArray2[indexOf2] == 'G') {
				matched = true;
			}
		} else if (charArray1[indexOf1] == 'A') {
			if (charArray2[indexOf2] == 'T') {
				matched = true;
			}
		} else if (charArray1[indexOf1] == 'T') {
			if (charArray2[indexOf2] == 'A') {
				matched = true;
			}
		}

		return matched;

	}

	/**
	 * this is the matching method , oh boy we are not a datin app!.
	 * 
	 * @param dna
	 *            the matching dna as a string
	 * @param dnaArray
	 *            as an array
	 * @param dnaArrayLength
	 *            and the length of this array
	 * @return the boolean
	 */
	public boolean isDna(String dna, char[] dnaArray, int dnaArrayLength) {
		boolean dnaFragezeichen = true;

		if (dna == "") {
			throw new IllegalArgumentException("Dude you cant combine your DNA with some Alien.");
		}

		for (int i = 0; i < dnaArrayLength; i++) {

			if (dnaArray[i] != 'A' & dnaArray[i] != 'T' & dnaArray[i] != 'G' & dnaArray[i] != 'C') {
				dnaFragezeichen = false;
			}
		}
		return dnaFragezeichen;
	}

}