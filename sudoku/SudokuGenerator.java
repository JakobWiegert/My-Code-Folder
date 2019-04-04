package ads.set3.sudoku;

public class SudokuGenerator {
	private int[][] sudoku;

	public int[][] generateSudoku1() {
		sudoku = new int[9][9];

		// sets num
		
		
		//set(0, 1, 2);
		set(0, 6, 9);
		set(0, 7, 6);
		//set(0, 8, 7);
		//set(1, 3, 1);
		//set(1, 4, 9);
		set(1, 5, 5);
		//set(2, 1, 8);
		set(2, 2, 3);
		//set(2, 5, 2);
		//set(2, 6, 1);
		set(3, 0, 7);
		set(3, 3, 2);
		set(3, 6, 3);
		set(3, 7, 9);
		set(4, 3, 9);
		//set(4, 4, 5);
		//set(4, 5, 4);
		//set(4, 7, 8);
		set(5, 0, 8);
		set(5, 2, 1);
		
		set(5, 3, 7);
		//set(5, 6, 5);
		set(6, 0, 2);
		set(6, 1, 6);
		//set(6, 2, 7);
		set(6, 4, 8);
		set(6, 8, 5);
		set(7, 0, 5);
		set(0, 1, 1);
		//set(7, 6, 2);
		//set(7, 7, 3);
		//set(7, 8, 8);
		//set(8, 3, 5);
		set(0, 0, 1);
		
		set(8, 5, 1);

		// sets all the other stuff to -1 as required.
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[i].length; j++) {
				if (sudoku[i][j] == 0)
					sudoku[i][j] = -1;
			}
		}

		return sudoku;
	}

	private void set(int row, int col, int number) {
		sudoku[row][col] = number;
	}

}
