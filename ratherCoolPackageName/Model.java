package ratherCoolPackageName;

/**
 * This is the model in which the escape game is calculated on meta values.
 * 
 * @author Sven Nivera, Jakob Wiegert
 *
 */
public class Model {

	private int ballPosX;
	private int ballPosY;
	private int ballMovX;
	private int ballMovY;
	private int barPosX;
	private int barPosY;
	private int barWidth;
	private int barHeight;
	private int lifeCount;
	private int blockWidth;
	private int blockHeight;
	private boolean[] activeBloecke = new boolean[28];
	private int[] blockPosX;
	private int[] blockPosY;
	private int falseCount;
	private boolean gameOver;
	private boolean victory;

	/**
	 * This constructor creates a escape game with meta values.
	 */
	public Model(int level) {
		lifeCount = 3;
		ballPosX = 140;
		ballPosY = 90;
		ballMovX = 1;
		ballMovY = 1;
		barPosX = 120;
		barPosY = 130;
		barWidth = 40;
		barHeight = 1;
		blockWidth = 40;
		blockHeight = 10;
		falseCount = 0;
		gameOver = false;
		victory = false;

		switch (level) {
		case 0:
			break;
		case 1:
			blockPosX = new int[28];
			blockPosY = new int[28];
			int k = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 7; j++) {

					activeBloecke[k] = true;
					blockPosX[k] = j * 40;
					blockPosY[k] = i * 10;
					k++;
				}

			}

			break;
		default:
			throw new IllegalArgumentException("Your level is in another castle!");
		}

	}

	public void update() {
		ballPosX += ballMovX;
		ballPosY += ballMovY;

		if (ballPosX == 280) {
			ballMovX = -ballMovX;
		}else if (ballPosX >280) {
			ballMovX = - ballMovX;
			ballPosX-=10;
			
		} else if (ballPosX == 0) {
			ballMovX = -ballMovX;
		}else if(ballPosX<0) {
			ballMovX = -ballMovX;
			ballPosX +=10;
			
		} else if (ballPosY == 0) {
			ballMovY = -ballMovY;
		}else if(ballPosY<0) {
			ballMovY = -ballMovY;
			ballPosY = -ballMovY;
			
		} else if (ballPosY > 140) {
			ballOut();
			
		}

		if (ballPosX >= barPosX && ballPosX <= barPosX + barWidth && ballPosY == barPosY) {
			if (ballPosX >= barPosX && ballPosX <= barPosX + 15) {
				ballMovX = - 1;
				ballMovY = -1;
			} else if(ballPosX >= barPosX +25 && ballPosX <= barPosX + barWidth) {
				ballMovX = +1;
				ballMovY = - 1;
			} else if(ballPosX >= barPosX + 15 && ballPosX <= barPosX +25) {
				ballMovY = - ballMovY;
			}

		}
		for (int i = 0; i < activeBloecke.length; i++) {
			if (activeBloecke[i]) {

				if ((ballPosX == blockPosX[i] || ballPosX == blockPosX[i] + blockWidth) && ballPosY >= blockPosY[i]
						&& ballPosY <= blockPosY[i] + blockHeight) {
					ballMovX = -ballMovX;
					activeBloecke[i] = false;
					falseCount++;
				} else if ((ballPosY == blockPosY[i] || ballPosY == blockPosY[i] + blockHeight)
						&& ballPosX >= blockPosX[i] && ballPosX <= blockPosX[i] + blockWidth) {
					ballMovY = -ballMovY;
					activeBloecke[i] = false;
					falseCount++;
				}

			}
		}

		if (falseCount == activeBloecke.length) {
			victory = true;
		}

		// for // arraay durch gehen spiel beenden falls leer

	}

	/**
	 * This method will be used when the ball flies out of the game area. If the
	 * lifeCount is <= 0 the game is over.
	 */
	public void ballOut() {
		lifeCount--;
		if (lifeCount <= 0) {
			gameOver = true;
		}
		ballPosX = 140;
		ballPosY = 90;
	}

	/**
	 * This method will be activated when the player destroyed all blocks.
	 */
	public boolean isVictory() {
		return victory;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * This method updates the position of the bar.
	 * 
	 * @param newX
	 *            The new X position of the bar.
	 */
	public void updateBar(int newX) {

		barPosX = newX - (barWidth / 2);

		return;
	}

	/**
	 * This getter return the actual X position of the ball.
	 * 
	 * @return The X value of the ball position.
	 */
	public int getBallPosX() {
		return ballPosX;
	}

	/**
	 * This getter return the actual Y position of the ball.
	 * 
	 * @return The Y value of the ball position.
	 */
	public int getBallPosY() {
		return ballPosY;
	}

	/**
	 * This getter return the actual X position of the bar.
	 * 
	 * @return The X value of the bar position.
	 */
	public int getBarPosX() {
		return barPosX;
	}

	/**
	 * This getter return the actual Y position of the bar.
	 * 
	 * @return The Y value of the bar position.
	 */
	public int getBarPosY() {
		return barPosY;
	}

	/**
	 * This method return the actual X value of a block {@code i}.
	 * 
	 * @param i
	 *            The block of which X value you want.
	 * @return The X value of the block i.
	 */
	public int getBlockPosX(int i) {
		return blockPosX[i];
	}

	/**
	 * This method return the actual Y value of a block {@code i}.
	 * 
	 * @param i
	 *            The block of which Y value you want.
	 * @return The Y value of the block i.
	 */
	public int getBlockPosY(int i) {
		return blockPosY[i];
	}

	/**
	 * This method return whether a block is active or not.
	 * 
	 * @param i
	 *            The Block to be checked 0based.
	 * @return {@code true} if block is active. {@code false} if block is inactive.
	 */
	public boolean getActiveBlock(int i) {
		return activeBloecke[i];
	}

	public int getBarWidth() {
		return barWidth;
	}

	public int getBlockWidth() {
		return blockWidth;
	}
}
