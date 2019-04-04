package ratherCoolPackageName;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.awt.Font;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Game extends GraphicsProgram {

	Model gamemodel;
	ViewWindow view1;
	ViewLight view2;

	/**
	 * This method is activated when the game has been started. From here are the
	 * two views and the model initialized.
	 */
	public void run() {
		addMouseListeners();
		this.setSize(1120, 560);
		int level = 1;
		while (true) {
			gamemodel = new Model(level);
			view1 = new ViewWindow(gamemodel);
			view2 = new ViewLight(gamemodel);

			this.add(view1);
			view2.connect();
			pause(2000);

			while (true) {
				pause(20);
				gamemodel.update();
				view1.update();
				println(gamemodel.getBallPosX());
				view2.update();
				if (gamemodel.isGameOver()) {
					GLabel gameover = new GLabel("GAME OVER");
					gameover.setFont("SimSun-44");
					gameover.setVisible(true);
					this.add(gameover, 450, 230);
					for (int i = 0; i < 150; i++) {
						this.pause(20);
						view2.wasted();
					}
					this.pause(1000);
					this.remove(view1);
					view2.disconnect();
					this.remove(gameover);
					break;
				}

				if (gamemodel.isVictory()) {
					GLabel victory = new GLabel("VICTORY!");
					victory.setFont("SimSun-44");
					victory.setVisible(true);
					this.add(victory, 450, 230);

					for (int i = 0; i < 150; i++) {
						this.pause(20);
						view2.victory();
					}
					this.pause(1000);
					this.remove(view1);
					this.remove(victory);
					level++;
					break;
				}
			}
		}

	}

	/**
	 * This method corresponds when the mouse is moved.
	 * 
	 * @param e
	 *            The MouseEvent which is listened to.
	 */
	public void mouseMoved(MouseEvent e) {
		
		if((e.getX()/4)- (gamemodel.getBarWidth() / 2) < 0 || (e.getX()/4)- (gamemodel.getBarWidth() / 2) + gamemodel.getBarWidth()>281 ){
		
		} else {
			gamemodel.updateBar(e.getX() / 4);
		}
	}
}
