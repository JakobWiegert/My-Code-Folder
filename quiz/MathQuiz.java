package programming.set6.quiz;

import acm.program.*;
import acm.util.RandomGenerator;

/**
 * Das is ein MatheQuiz, es gibt den User tolle mathe Aufgaben :) .
 * 
 * @author Jakob
 *
 */
public class MathQuiz extends ConsoleProgram {

	/**
	 * Das is die run methode hier wird das Quiz initialisiert .
	 * 
	 */
	public void run() {
		println("Willkommen im gloreichen Matthe-macht-SPAß-Quiz ! :)");

		for (int i = 0; i < 5; i++) {
			int op1;
			int op2;
			int operatorInt;
			String operator;

			RandomGenerator rgen = RandomGenerator.getInstance();

			operatorInt = rgen.nextInt(0, 1);
			if (operatorInt == 0) {
				operator = "+";
				op1 = rgen.nextInt(0, 20);
				op2 = rgen.nextInt(0, 20 - op1);
			} else {
				operator = "-";
				op1 = rgen.nextInt(0, 20);
				op2 = rgen.nextInt(0, op1);
			}
			int erg = readInt("What is" + op1 + operator + op2 + "? ");
			boolean isC = isCorrect(op1, operator, op2, erg);

			if (isC == true) {
				println(generateSuccessMessage());
			} else {
				if (operatorInt == 0) {
					int correct = op1 + op2;
					println(generateFailMessage(correct));
				} else {
					int correct = op1 - op2;
					println(generateFailMessage(correct));
				}
			}
		}
	}

	/**
	 * Checks whether the given result is really the result of the operation on the
	 * two operands.
	 * 
	 * @param operand1
	 *            the first operand.
	 * @param operator
	 *            the operator, given as a String. This must be either {@code "+"}
	 *            or {@code "-"}. Otherwise, this method will always return
	 *            {@code false}.
	 * @param operand2
	 *            the second operand.
	 * @param result
	 *            the proposed result.
	 * @return {@code true} if {@code result} is really the result of the
	 *         calculation, {@code false} otherwise.
	 */
	public boolean isCorrect(int operand1, String operator, int operand2, int result) {
		boolean isCorrect;
		if (operator == "+") {
			int correctResult = operand1 + operand2;
			if (correctResult == result) {
				isCorrect = true;
			} else {
				isCorrect = false;
			}
		} else if (operator == "-") {
			if (operand1 - operand2 == result) {
				isCorrect = true;
			} else {
				isCorrect = false;
			}
		} else {
			isCorrect = false;
		}

		return isCorrect;

	}

	/**
	 * Returns a message that can be displayed to the user after successfully
	 * solving a problem. There are at least four messages the method randomly
	 * chooses from to keep it interesting.
	 * 
	 * @return randomly selected success message.
	 */
	public String generateSuccessMessage() {
		RandomGenerator rgen = RandomGenerator.getInstance();
		int x = rgen.nextInt(0, 3);
		String[] sucMes = new String[4];
		sucMes[0] = "Sehr gut , wie ich sehe bist du ein Meister der Rechenkünste, hätte ich Arme würde ich dich drücken";
		sucMes[1] = "WOW ABSOLUT RICHTIG #PROUD #ABITUUUURRRR";
		sucMes[2] = "Richtig und jetzt stell dir vor das würde auch mal ein Mensch zu dir sagen";
		sucMes[3] = "Richtig. Hast du schon nen Bachelor ? ";
		return sucMes[x];
	}

	/**
	 * Returns a message that can be displayed to the user after failing to solve a
	 * problem correctly. There are at least four messages the method randomly
	 * chooses from to keep it interesting. The correct result is included in the
	 * message somewhere to teach the user a lesson.
	 * 
	 * @param correctResult
	 *            the number that would have been the correct result. This number is
	 *            included somehow in the returned messsage.
	 * @return randomly selected fail message.
	 */
	public String generateFailMessage(int correctResult) {

		RandomGenerator rgen = RandomGenerator.getInstance();
		int x = rgen.nextInt(0, 3);
		String[] sucMes = new String[4];
		sucMes[0] = "reinste Inkompetenz, hier is das richtige Ergebniss:" + correctResult;
		sucMes[1] = "einfach nur ein Looser, hier ist das Ergebniss:" + correctResult;
		sucMes[2] = "Ja ich glaube die Menschen sollten aussterben, hier so sollte es sein:" + correctResult;
		sucMes[3] = "Hauptschuleeee? richtig wäre :" + correctResult;
		return sucMes[x];

	}
}
