import acm.program.*;

import java.awt.Color;

import acm.graphics.*;

public class Chessboard extends GraphicsProgram {
	public void run() {

		char abc = 'A';

		for (int i = 0; i <= 3; i++) {											//Schleife wird 4mal wiederholt um auf die 8 reihen zu kommen

			for (int r1 = 0; r1 <= 3; r1++) {
				GRect b = new GRect(200 + 200 * r1, 200 + 200 * i, 100, 100);	//gerade Reihe
				b.setFilled(true);
				b.setColor(Color.pink);
				add(b);

			}
			for (int r2 = 0; r2 <= 3; r2++) {
				GRect b2 = new GRect(100 + 200 * r2, 100 + 200 * i, 100, 100);	//ungerade Reihe
				b2.setFilled(true);
				b2.setColor(Color.pink);
				add(b2);

			}

		}
		for (int j = 1; j <= 8; j++) {											//Schleife wird 8mal wiederholt um 1-8 und A-H zu erreichen
																				//Zahlen
			GLabel zl = new GLabel("" + j, 50, 50 + 100 * j);
			add(zl);

			GLabel zr = new GLabel("" + j, 950, 50 + 100 * j);
			add(zr);
																				//Buchstaben
			GLabel bo = new GLabel("" + abc, 50 + 100 * j, 50);
			add(bo);

			GLabel bu = new GLabel("" + abc, 50 + 100 * j, 950);
			add(bu);
			abc++;
		}
	}
}
