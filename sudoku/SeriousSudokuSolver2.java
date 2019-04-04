package ads.set3.sudoku;

/**
 * solves sudokus!.
 * 
 * @author Jakob Wiegert
 *
 */
public class SeriousSudokuSolver2 {

	// Gegeben eine Zahl nelementN>0 definieren wir die Sudoku-Regeln wie folgt:
	// Das Feld besteht aus n2 Zeilen und n2 Spalten
	// Das Feld ist unterteilt in n2 Quadrate mit der Kantenlänge n.
	// In jeder Zeile, jeder Spalte und jedem Quadrat müssen die Zahlen 1 bis n2
	// (inklusive) genau einmal vorkommen.

	static int[][] sudoku;// [row] [col]
	static boolean[][] already;// array, if there is already a number
	static int rank;
	static int rankQuadrat;

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

		SeriousSudokuSolver2.rank = rank;
		SeriousSudokuSolver2.rankQuadrat = SeriousSudokuSolver2.rank * SeriousSudokuSolver2.rank;
		SeriousSudokuSolver2.sudoku = sudoku;
		SeriousSudokuSolver2.already = new boolean[SeriousSudokuSolver2.rankQuadrat][SeriousSudokuSolver2.rankQuadrat];

		// filling the already array
		for (int i = 0; i < rankQuadrat; i++) {
			for (int j = 0; j < rankQuadrat; j++) {
				if (sudoku[i][j] != -1) {
					already[i][j] = true;
				} else {
					already[i][j] = false;
				}

			}
		}

		if (!checkAll()) {
			throw new IllegalArgumentException("no sudoku");
		}

		if (!insert(0, 0)) {
			throw new IllegalArgumentException("fail");
		}

		return sudoku;

	}

	/**
	 * checks if the given number is already in the col.
	 * 
	 * @param col
	 *            the col
	 * @param checkNumber
	 *            the number
	 * @return true if it isnt already in, false if it is
	 */
	static private boolean checkCol(int col, int checkNumber) {
		int o = 0;

		for (int i = 0; i < rankQuadrat; i++) {
			if (sudoku[i][col] == checkNumber) {
				o++;
				if (o > 1) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * checks if the number is already in the Row.
	 * 
	 * @param row
	 *            the row
	 * @param checkNumber
	 *            the number to check
	 * @return true if it isnt already in, false if it is
	 */
	static private boolean checkRow(int row, int checkNumber) {
		int o = 0;
		for (int i = 0; i < rankQuadrat; i++) {
			if (sudoku[row][i] == checkNumber) {
				o++;
				if (o > 1) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * checks if the number is already in the rank*rank Field.
	 * 
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * @param checkNumber
	 *            the number to check
	 * @return true if isnt already in, false if it is
	 */
	static private boolean checkField(int row, int col, int checkNumber) {
		int o = 0;
		int blockToCheckRow = (row / rank) * rank;
		int blockToCheckCol = (col / rank) * rank;

		for (int i = blockToCheckRow; i < blockToCheckRow + rank; i++) {
			for (int j = blockToCheckCol; j < blockToCheckCol + rank; j++) {
				if (sudoku[i][j] == checkNumber) {
					o++;
					if (o > 1) {
						return false;
					}
				}
			}
		}

		return true;

	}

	/**
	 * checks if the Sudoku is valid.
	 * 
	 * @return true if it is valid, false if it is not
	 */
	static private boolean checkAll() {

		for (int i = 0; i < rankQuadrat; i++) {
			for (int j = 0; j < rankQuadrat; j++) {

				if (sudoku[i][j] != -1) {
					if (sudoku[i][j] > rankQuadrat) {
						return false;
					} else {
						if (!(checkCol(j, sudoku[i][j]) && checkRow(i, sudoku[i][j])
								&& checkField(i, j, sudoku[i][j]))) {

							return false;
						}
					}
				}
			}
		}

		return true;

	}

	/**
	 * insert the right number at the given Position. with recursion its solves the
	 * sudoku
	 * 
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * @return true if a number could be put in, false if not
	 */
	static private boolean insert(int row, int col) {

		int number = 1;

		while (true) {

			// already a number
			if (already[row][col]) {

				// end of the sudoku
				if (row == rankQuadrat - 1 && col == rankQuadrat - 1) {
					return true;

					// end of the row
				} else if (col == rankQuadrat - 1) {

					// next one works
					if (insert(row + 1, 0)) {
						return true;

						// next one doesnt work
					} else {
						return false;
					}

					// anywhere else
				} else {

					// next one work
					if (insert(row, col + 1)) {
						return true;

						// next one doesnt work
					} else {
						return false;
					}

				}

				// not already a number
			} else {

				sudoku[row][col] = number;

				// number is valid
				if (checkCol(col, number) && checkField(row, col, number) && checkRow(row, number)) {

					// end of the sudoku
					if (col == rankQuadrat - 1 && row == rankQuadrat - 1) {

						return true;

						// end of the row
					} else if (col == rankQuadrat - 1) {

						// next one works
						if (insert(row + 1, 0)) {
							return true;

							// next one doesnt work
						} else {
							number++;

							// no number possible
							if (number == rankQuadrat + 1) {
								sudoku[row][col] = -1;
								return false;
							}
						}

						// anywhere else
					} else {

						// next one work
						if (insert(row, col + 1)) {
							return true;

							// next one doesnt work
						} else {
							number++;

							// no number possible
							if (number == rankQuadrat + 1) {
								sudoku[row][col] = -1;
								return false;
							}
						}
					}

					// number isnt valid
				} else {
					number++;

					// no number is possilbe
					if (number == rankQuadrat + 1) {
						sudoku[row][col] = -1;
						return false;
					}

				}

			}

		}

	}

}
