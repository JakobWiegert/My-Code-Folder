import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.Font;

public class MethodicalChessboard extends GraphicsProgram {

	/**
	 * Draws the square identified by {@code x} and {@code y} in the color
	 * {@code color}.
	 * 
	 * @param x
	 *            file index, between 0 and 7.
	 * @param y
	 *            rank index, between 0 and 7.
	 * @param color
	 *            the color to fill the square with.
	 */
	public void drawSquare(int x, int y, Color color) {
		GRect square = new GRect(100 + 100 * x, 100 + 100 * y, 100, 100);
		square.setFilled(true);
		square.setColor(color);
		add(square);
	}

	// draw the Chessboard using drawSquare and some other stuff
	public void drawChessboard() {
		for (int j = 0; j < 8; j++) {
			if (j == 0 || j == 2 || j == 4 || j == 6) { // zeichnet die Reihen die mit schwarzen Feldern beginnen
				for (int i = 0; i < 4; i++) {
					drawSquare(0 + 2 * i, 0 + j, Color.pink);
					drawSquare(1 + 2 * i, 0 + j, Color.white);
				}
			} else {
				for (int i = 0; i < 4; i++) {
					drawSquare(0 + 2 * i, 0 + j, Color.white); // zeichnet die Reihen die mit weißen Feldern beginnen
					drawSquare(1 + 2 * i, 0 + j, Color.pink);
				}
			}
			GRect rand = new GRect(100, 100, 800, 800);
			add(rand);
		}
		char abc = 'A';
		for (int j = 1; j <= 8; j++) { // Schleife wird 8mal wiederholt um 1-8 und A-H zu erreichen
			// Zahlen
			GLabel zl = new GLabel("" + j, 50, 50 + 100 * j);
			add(zl);

			GLabel zr = new GLabel("" + j, 950, 50 + 100 * j);
			add(zr);
			// Buchstaben
			GLabel bo = new GLabel("" + abc, 50 + 100 * j, 50);
			add(bo);

			GLabel bu = new GLabel("" + abc, 50 + 100 * j, 950);
			add(bu);
			abc++;
		}
	}

	/**
	 * Draws a specific chess {@code piece} of a {@code player} at the position of a
	 * specific square identified by {@code x} and {@code y}. Pieces are: 0 pawn, 1
	 * Knight, 2 Bishop, 3 Rook, 4 Queen, 5 King
	 * 
	 * @param x
	 *            file index, between 0 and 7.
	 * @param y
	 *            rank index, between 0 and 7.
	 * @param piece
	 *            0 for a pawn, 1 for a knight, 2 for a bishop, 3 for a rook, 4 for
	 *            a queen, 5 for a king.
	 * @param player
	 *            0 for white, 1 for black.
	 */
	public void drawPiece(int x0, int y0, int piece, int player) {

		int x = 100 + 100 * x0; // Positionierung auf dem Schachbrett in abhängigkeit von der Eingabe
		int y = 185 + 100 * y0;
		GLabel p = new GLabel("error", x, y);

		if (piece == 0 & player == 0) { // Figuren abghängig von player und piece
			p = new GLabel("\u2659", x, y);
		} else if (piece == 1 & player == 0) {
			p = new GLabel("\u2658", x, y);
		} else if (piece == 2 & player == 0) {
			p = new GLabel("\u2657", x, y);
		} else if (piece == 3 & player == 0) {
			p = new GLabel("\u2656", x, y);
		} else if (piece == 4 & player == 0) {
			p = new GLabel("\u2655", x, y);
		} else if (piece == 5 & player == 0) {
			p = new GLabel("\u2654", x, y);
		}

		else if (piece == 0 & player == 1) {
			p = new GLabel("\u265F", x, y);
		} else if (piece == 1 & player == 1) {
			p = new GLabel("\u265E", x, y);
		} else if (piece == 2 & player == 1) {
			p = new GLabel("\u265D", x, y);
		} else if (piece == 3 & player == 1) {
			p = new GLabel("\u265C", x, y);
		} else if (piece == 4 & player == 1) {
			p = new GLabel("\u265B", x, y);
		} else if (piece == 5 & player == 1) {
			p = new GLabel("\u265A", x, y);
		}

		p.setFont(new Font("sansserif", Font.BOLD, 100)); // größere Figuren
		add(p);
	}

	public void run() {
		drawChessboard();
		for (int i = 0; i < 8; i++) { // Bauern
			drawPiece(0 + i, 1, 0, 1);
			drawPiece(0 + i, 6, 0, 0);
		}
		for (int i = 0; i < 2; i++) { // Alle anderen Figuren , i=0 sind die Schwarzen, i=1 sind die Weißen
			drawPiece(0, 0 + i * 7, 3, 1 - i);
			drawPiece(1, 0 + i * 7, 1, 1 - i);
			drawPiece(2, 0 + i * 7, 2, 1 - i);
			drawPiece(3, 0 + i * 7, 5, 1 - i);
			drawPiece(4, 0 + i * 7, 4, 1 - i);
			drawPiece(5, 0 + i * 7, 2, 1 - i);
			drawPiece(6, 0 + i * 7, 1, 1 - i);
			drawPiece(7, 0 + i * 7, 3, 1 - i);

		}
	}

}