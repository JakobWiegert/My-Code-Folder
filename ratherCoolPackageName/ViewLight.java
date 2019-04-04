package ratherCoolPackageName;

import java.io.IOException;

public class ViewLight {

	private Model model;
	byte[] data = new byte[14 * 28 * 3];
	LighthouseDisplay display = new LighthouseDisplay("Cowboys2", "API-TOK_qta0-YEAy-BjMZ-sqrd-ohbo",1);

	public ViewLight(Model model) {
		this.model = model;
	}

	public void update() {

		

		// Send data to the display
		try {
			// This array contains for every window (14 rows, 28 columns) three
			// bytes that define the red, green, and blue component of the color
			// to be shown in that window. See documentation of LighthouseDisplay's
			// send(...) method.

			for (int i = 0; i < 1176; i++) {
				data[i] = 0;
			}

			setBloeckePos();
			setBarPos();
			setBallPos();

			// Fill array

			display.send(data);
		} catch (IOException e) {
			System.out.println("Connection failed: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void connect() {
		
		// Try connecting to the display
				try {
					display.connect();
				} catch (Exception e) {
					System.out.println("Connection failed: " + e.getMessage());
					e.printStackTrace();
				}
		
	}

	/**
	 * This method set the window where the ball should be.
	 */
	public void setBallPos() {
		setWindow(model.getBallPosX() / 10, model.getBallPosY() / 10, 254, 140, 0);

	}

	/**
	 * This method sets the windows where the bar should be.
	 */
	public void setBarPos() {
		for (int i = 0; i < model.getBarWidth() / 10; i++) {

			setWindow(model.getBarPosX() / 10 + i, model.getBarPosY() / 10, 200, 0, 200);

		}

	}

	/**
	 * This method sets the windows where the blocks should be.
	 */
	public void setBloeckePos() {

		for (int i = 0; i < 7; i++) {
			if (model.getActiveBlock(i)) {
				for (int q = 0; q < model.getBlockWidth() / 10; q++) {
					setWindow((model.getBlockPosX(i) / 10) + q, model.getBlockPosY(i) / 10, 0, 0, 254);
				}
			}
		}

		for (int j = 7; j < 14; j++) {
			if (model.getActiveBlock(j)) {
				for (int q = 0; q < model.getBlockWidth() / 10; q++) {
					setWindow(model.getBlockPosX(j) / 10 + q, model.getBlockPosY(j) / 10, 254, 0, 0);
				}
			}
		}

		for (int k = 14; k < 21; k++) {
			if (model.getActiveBlock(k)) {
				for (int q = 0; q < model.getBlockWidth() / 10; q++) {
					setWindow(model.getBlockPosX(k) / 10 + q, model.getBlockPosY(k) / 10, 0, 254, 0);
				}
			}
		}

		for (int l = 21; l < 28; l++) {
			if (model.getActiveBlock(l)) {
				for (int q = 0; q < model.getBlockWidth() / 10; q++) {
					setWindow(model.getBlockPosX(l) / 10 + q, model.getBlockPosY(l) / 10, 155, 50, 50);
				}
			}
		}

	}

	public void disconnect() {
		display.close();
	}

	public void victory() {

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 28; j++) {
				setWindow(j, i, 0, 254, 0);
			}
		}

		try {
			display.send(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void wasted() {
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 28; j++) {
				setWindow(j, i, 254, 0, 0);
			}
		}

		try {
			display.send(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method converts a (x/y) position + RGB into the correct window inside
	 * the array for send.
	 * 
	 * @param x
	 *            The X position of the window.
	 * @param y
	 *            The Y position of the window.
	 * @param r
	 *            The R value of the window.
	 * @param g
	 *            The G value of the window.
	 * @param b
	 *            The B value of the window.
	 */
	private void setWindow(int x, int y, int r, int g, int b) {

		assert x < 28 && x > -1 : "X value must be 0 - 27, not " + x;
		assert y < 14 && y > -1 : "Y value must be 0 - 13, not " + y;
		assert r < 255 && r > -1 : "R value must be 0 - 254, not " + r;
		assert g < 255 && g > -1 : "G value must be 0 - 254, not " + g;
		assert b < 255 && b > -1 : "B value must be 0 - 254, not " + b;

		int k = 0;
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 28; j++) {
				k += 3;
				if (j == x && i == y) {
					data[k - 1] = (byte) b;
					data[k - 2] = (byte) g;
					data[k - 3] = (byte) r;
				}
			}
		}

	}

}
