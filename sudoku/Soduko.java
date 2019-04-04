package programming.set7.sudoku;

/**
 * this programm allows the creation. of Sudokus using NumberBoard HOW AMAZING
 * 
 * @author Jakob Wiegert
 *
 */
public class Sudoku extends NumberBoard {

	/**
	 * Board constructor.
	 */
	public Sudoku() {

		super(9, 9);
	}

	/**
	 * set the value of at the coordinates.
	 * 
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * @param value
	 *            the value
	 * 
	 */
	public void setValueAt(int row, int col, int value) {
		if (isInRange(row, col) && (value == EMPTY || (value >= 1 && value <= 9))) {
			super.setValueAt(row, col, value);
		}

	}

	/**
	 * gives a boolean about the validation of of the given board.
	 * 
	 * @return a boolean
	 */
	public boolean isValid() {
		boolean fail = true;
		for (int i = 0; i < 9; i++) {
			fail = isValidCol(i) & isValidRow(i);
		}

		fail = fail & isValid3x3(0, 0) & isValid3x3(0, 3) & isValid3x3(0, 6) & isValid3x3(3, 0) & isValid3x3(3, 3)
				& isValid3x3(3, 6) & isValid3x3(6, 0) & isValid3x3(6, 3) & isValid3x3(6, 6);

		return fail;
	}

	/**
	 * the row part of the validate method.
	 * 
	 * @param row
	 *            the tested row
	 * @return a boolean
	 */
	public boolean isValidRow(int row) {
		int z = 0;
		boolean fail = true;
		for (int i = 0; i < 9; i++) {
			z = 0;
			for (int j = i; j < 9; j++) {

				if (getValueAt(row, i) == getValueAt(row, j)) {
					z++;
				}
			}
			if (z > 1) {
				fail = false;
			}
		}

		return fail;

	}

	/**
	 * the col part of the validate method.
	 * 
	 * @param col
	 *            the col who is tested
	 * @return a boolean
	 */
	public boolean isValidCol(int col) {
		int z = 0;
		boolean fail = true;
		for (int i = 0; i < 9; i++) {
			z = 0;
			for (int j = i; j < 9; j++) {

				if (getValueAt(i, col) == getValueAt(j, col)) {
					z++;
				}
			}
			if (z > 1) {
				fail = false;
			}
		}

		return fail;

	}

	/**
	 * the 3x3 part of the validate method.
	 * 
	 * @param srow
	 *            the start row
	 * @param scol
	 *            the start col
	 * @return a boolean
	 */
	public boolean isValid3x3(int srow, int scol) {
		boolean fail = true;
		int z = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int q = i; q < 3; q++) {
					for (int w = j; w < 3; w++) {
						if (getValueAt(srow + i, scol + j) == getValueAt(srow + q, scol + w)) {

							z++;
						}
					}
				}
			}
		}
		if (z > 3) {
			fail = false;
		}
		return fail;
	}

	/**
	 * this is the toString method.
	 * 
	 * @return a String
	 */
	public String toString() {
		String string = "";
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; i++) {

				if (getValueAt(i, j) == -1) {
					string += " " + " ";
				} else {

					string += getValueAt(i, j) + " ";
				}
			}
			string += "/n";
		}
		return string;
	}
}