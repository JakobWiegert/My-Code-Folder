package ads.set3.sudoku;

public class SeriousSudokuSolver {

	// Gegeben eine Zahl nelementN>0 definieren wir die Sudoku-Regeln wie folgt:
	// Das Feld besteht aus n2 Zeilen und n2 Spalten
	// Das Feld ist unterteilt in n2 Quadrate mit der Kantenlänge n.
	// In jeder Zeile, jeder Spalte und jedem Quadrat müssen die Zahlen 1 bis n2
	// (inklusive) genau einmal vorkommen.

	// das sudoku
	static int[][] sudoku;

	// array ob bereits eine vorgegebene Zahl da ist
	static boolean[][] already;

	// der rank
	static int n;

	// der rank*rank
	static int nQuadrat;

	/**
	 * Solves the given Sudoku through backtracking.
	 * 
	 * @param rank
	 *            Determines the size of the Sudoku. A Field of rank n will have n^2
	 *            columns and rows.
	 * @param sudoku
	 *            The start configuration of the Sudoku. Empty cells are initialized
	 *            as -1.
	 * @return The solved Sudoku.
	 * @throws IllegalArgumentException
	 *             if the given Sudoku is impossible to solve.
	 */
	public static int[][] solve(int rank, int[][] sudoku) throws IllegalArgumentException {

		SeriousSudokuSolver.n = rank;
		SeriousSudokuSolver.nQuadrat = rank * rank;
		SeriousSudokuSolver.sudoku = sudoku;
		SeriousSudokuSolver.already = new boolean[nQuadrat][nQuadrat];

		for (int l = 0; l < nQuadrat; l++) {
			for (int m = 0; m < nQuadrat; m++) {
				if (sudoku[m][l] != -1) {
					already[m][l] = true;
				} else {
					already[m][l] = false;
				}
			}
		}

		if (!insert(0, 0)) {
			if(!insert(0, 0)) {
			throw new IllegalArgumentException();
			}
		}

		return SeriousSudokuSolver.sudoku;
	}

	
	public static void main(String[] args) {

		SudokuGenerator cool = new SudokuGenerator();
		int[][] cooler = cool.generateSudoku1();

		cooler = SeriousSudokuSolver.solve(3, cooler);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(cooler[i][j] + "  ");
			}
			System.out.println();
		}

	}

	/**
	 * checks if the number is already in the row.
	 * 
	 * @param sudoku
	 *            the given Sudoku
	 * @param col
	 *            the col
	 * @param number
	 *            the number
	 * @return false if the number isnt already in the row, true if the number is
	 *         already in the row
	 */
	private static boolean checkRow(int row, int number) {

		if (number > nQuadrat) {
			return true;
		}

		for (int k = 0; k < nQuadrat; k++) {

			if (sudoku[k][row] == number) {
				return true;
			}

		}

		return false;

	}

	/**
	 * checks if the number is already in the col.
	 * 
	 * @param sudoku
	 *            the given sudoku
	 * @param row
	 *            the row
	 * @param number
	 *            the number
	 * @return true for is already there, false for not
	 */
	private static boolean checkCol(int col, int number) {

		if (number > nQuadrat) {
			return true;
		}

		for (int k = 0; k < nQuadrat; k++) {

			if (sudoku[col][k] == number) {
				return true;
			}

		}

		return false;

	}

	/**
	 * checks if the given number is already in the part.
	 * 
	 * @param posRow
	 *            the row of the number
	 * @param posCol
	 *            the col of the number
	 * @param number
	 *            the number
	 * @return true if its already in the part, false if not
	 */
	private static boolean checkPart(int posRow, int posCol, int number) {

		if (number > nQuadrat) {
			return true;
		}

		int blockOfCheckRow = (posRow / n) * n;
		int blockOfCheckCol = (posCol / n) * n;

		for (int l = blockOfCheckRow; l < blockOfCheckRow + n; l++) {
			for (int m = blockOfCheckCol; m < blockOfCheckCol + n; m++) {
				if (sudoku[m][l] == number) {
					return true;
				}
			}
		}

		return false;

	}

	/**
	 * löst rekursiv das problem
	 * 
	 * @param posCol
	 * @param posRow
	 * @return true, wenn die zahl valide wahr, false wenn backtracking nötig ist
	 */
	private static boolean insert(int posCol, int posRow) {
		int number = 1;

		// debug
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

		while (true) {

			// wenn schon zahl da is
			if (already[posCol][posRow]) {

				// am ende
				if (posRow == nQuadrat - 1 && posCol == nQuadrat - 1) {
					return true;

					// am ende einer Spalte(Col)
				} else if (posRow == nQuadrat - 1) {

					// wenn der nächste funktioniert
					if (insert(posCol + 1, 0)) {
						return true;

						// wenn der nächste nicht funktioniert
					} else {
						return false;
					}

					// der rest
				} else {

					// wenn der nächste funktioniert
					if (insert(posCol, posRow + 1)) {
						return true;

						// wenn der nächste nicht funktioniert
					} else {
						return false;
			
					}

				}

				// wenn noch keine Zahl da ist
			} else {

				// check gelingt
				if ((!checkCol(posCol, number)) && (!checkPart(posRow, posCol, number))
						&& (!checkRow(posRow, number))) {
					sudoku[posCol][posRow] = number;

					// am ende
					if (posRow == nQuadrat - 1 && posCol == nQuadrat - 1) {
						return true;

						// am ende einer Spalte(col)
					} else if (posRow == nQuadrat - 1) {

						// wenn der nächste funktioniert
						if (insert(posCol + 1, 0)) {
							return true;

							// wenn der nächste nicht funktioniert
						} else {
							number++;

							// wenn die einzufügende Numbergröße überschrittn wird
							if (number > nQuadrat) {
								
								return false;
							}

						}

						// der rest
					} else {

						// wenn der nächste funktioniert
						if (insert(posCol, posRow + 1)) {
							return true;

							// wenn der nächste nicht funktionert
						} else {
							number++;

							// wenn die einzufügende Numbergröße überschritten wird
							if (number > nQuadrat) {
								
								return false;
							}

						}

					}
					// check schlägt fehl
				} else {
					number++;

					// wenn die einzufügende Numbergröße überschritten wird
					if (number > nQuadrat) {
						return false;
					}

				}

			}
		}
	}
}
