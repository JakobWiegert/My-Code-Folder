package programming.set11.bff;

/**
 * literally Brainfuck.
 * 
 * @author jakob Wiegert
 *
 */
public class BrainfuckInterpreter {

	int currentCell;
	char[] charArray;
	byte[] byteArray = new byte[99999];

	/**
	 * first constructor.
	 * 
	 * @param stringInput
	 *            der Input als String
	 */
	public BrainfuckInterpreter(String stringInput) {

		int stringInputLength = stringInput.length();
		charArray = new char[stringInputLength];

		for (int i = 0; i < stringInputLength; i++) {

			charArray[i] = stringInput.charAt(i);

		}

	}

	/**
	 * second constructor.
	 * 
	 * @param arrayInput
	 *            the input as an array
	 */
	public BrainfuckInterpreter(char[] arrayInput) {
		charArray = arrayInput;
	}

	/**
	 * interpretator for the given Brainfuck.
	 * 
	 * @return the Output of the Brainfuck
	 */
	public String interpret() {
		currentCell = 0;
		String output = "";
		int charArrayLength = charArray.length;

		int counter = 0;

		for (int i = 0; i < charArrayLength; i++) {

			switch (charArray[i]) {

			case '<':
				currentCell = currentCell - 1;
				break;
			case '>':
				currentCell = currentCell + 1;
				break;
			case '+':
				byteArray[currentCell] = (byte) (byteArray[currentCell] + 1);
				break;
			case '-':
				byteArray[currentCell] = (byte) (byteArray[currentCell] - 1);
				break;
			case '/':
				byteArray[currentCell] = (byte) (byteArray[currentCell] * 2);
				break;
			case '.':
				output = output + (char) byteArray[currentCell];
				break;
			default:
				break;
			case '[':
				// [ [ ] ]
				if (byteArray[currentCell] == 0) {
					i++;
					while (counter > 0 || charArray[i] != ']') {

						if (charArray[i] == '[') {
							counter++;
						}
						if (charArray[i] == ']') {
							counter--;
						}
						i++;
					}

					// positionOfCoresspondingThing
				} else {
					break;
				}

			case ']':
				if (byteArray[currentCell] == 0) {
					break;
				} else {
					i--;

					while (counter > 0 || charArray[i] != '[') {
						if (charArray[i] == ']')
							counter++;
						if (charArray[i] == '[')
							counter--;
						i--;

					}
					i--;

					// back
				}

			}

		}

		return output;

	}

	/**
	 * test.
	 * 
	 * @param arg
	 *            test
	 */
	public static void main(String[] arg) {
		BrainfuckInterpreter test = new BrainfuckInterpreter("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>\r\n"
				+ "---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.");
		System.out.print(test.interpret());
	}

}
