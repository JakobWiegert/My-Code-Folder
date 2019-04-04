package ratherCoolPackageName;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GRect;

/**
 * This is the view for a window. It is a GCompound which can be added to a
 * Game.
 * 
 * @author Sven Nivera, Jakob Wiegert
 *
 */
public class ViewWindow extends GCompound {

	Model model = null;
	GOval ball = new GOval(10, 10);
	GRect bar = new GRect(160, 4);
	GRect block1 = new GRect(160, 40);
	GRect block2 = new GRect(160, 40);
	GRect block3 = new GRect(160, 40);
	GRect block4 = new GRect(160, 40);
	GRect block5 = new GRect(160, 40);
	GRect block6 = new GRect(160, 40);
	GRect block7 = new GRect(160, 40);
	GRect block8 = new GRect(160, 40);
	GRect block9 = new GRect(160, 40);
	GRect block10 = new GRect(160, 40);
	GRect block11 = new GRect(160, 40);
	GRect block12 = new GRect(160, 40);
	GRect block13 = new GRect(160, 40);
	GRect block14 = new GRect(160, 40);
	GRect block15 = new GRect(160, 40);
	GRect block16 = new GRect(160, 40);
	GRect block17 = new GRect(160, 40);
	GRect block18 = new GRect(160, 40);
	GRect block19 = new GRect(160, 40);
	GRect block20 = new GRect(160, 40);
	GRect block21 = new GRect(160, 40);
	GRect block22 = new GRect(160, 40);
	GRect block23 = new GRect(160, 40);
	GRect block24 = new GRect(160, 40);
	GRect block25 = new GRect(160, 40);
	GRect block26 = new GRect(160, 40);
	GRect block27 = new GRect(160, 40);
	GRect block28 = new GRect(160, 40);

	/**
	 * This is the constructor for the view. It requires a model from which it can
	 * gather it's data.
	 */
	public ViewWindow(Model model) {

		this.model = model;
		ball.setFilled(true);
		ball.setFillColor(Color.orange);
		ball.setVisible(true);
		this.add(ball);
		bar.setFilled(true);
		bar.setFillColor(Color.black);
		bar.setVisible(true);
		this.add(bar);

		block1.setFilled(true);
		block1.setFillColor(Color.cyan);
		block1.setVisible(true);
		this.add(block1, model.getBlockPosX(0) * 4, model.getBlockPosY(0) * 4);

		block2.setFilled(true);
		block2.setFillColor(Color.cyan);
		block2.setVisible(true);
		this.add(block2, model.getBlockPosX(1) * 4, model.getBlockPosY(1) * 4);

		block3.setFilled(true);
		block3.setFillColor(Color.cyan);
		block3.setVisible(true);
		this.add(block3, model.getBlockPosX(2) * 4, model.getBlockPosY(2) * 4);

		block4.setFilled(true);
		block4.setFillColor(Color.cyan);
		block4.setVisible(true);
		this.add(block4, model.getBlockPosX(3) * 4, model.getBlockPosY(3) * 4);

		block5.setFilled(true);
		block5.setFillColor(Color.cyan);
		block5.setVisible(true);
		this.add(block5, model.getBlockPosX(4) * 4, model.getBlockPosY(4) * 4);

		block6.setFilled(true);
		block6.setFillColor(Color.cyan);
		block6.setVisible(true);
		this.add(block6, model.getBlockPosX(5) * 4, model.getBlockPosY(5) * 4);

		block7.setFilled(true);
		block7.setFillColor(Color.cyan);
		block7.setVisible(true);
		this.add(block7, model.getBlockPosX(6) * 4, model.getBlockPosY(6) * 4);

		block8.setFilled(true);
		block8.setFillColor(Color.red);
		block8.setVisible(true);
		this.add(block8, model.getBlockPosX(7) * 4, model.getBlockPosY(7) * 4);

		block9.setFilled(true);
		block9.setFillColor(Color.red);
		block9.setVisible(true);
		this.add(block9, model.getBlockPosX(8) * 4, model.getBlockPosY(8) * 4);

		block10.setFilled(true);
		block10.setFillColor(Color.red);
		block10.setVisible(true);
		this.add(block10, model.getBlockPosX(9) * 4, model.getBlockPosY(9) * 4);

		block11.setFilled(true);
		block11.setFillColor(Color.red);
		block11.setVisible(true);
		this.add(block11, model.getBlockPosX(10) * 4, model.getBlockPosY(10) * 4);

		block12.setFilled(true);
		block12.setFillColor(Color.red);
		block12.setVisible(true);
		this.add(block12, model.getBlockPosX(11) * 4, model.getBlockPosY(11) * 4);

		block13.setFilled(true);
		block13.setFillColor(Color.red);
		block13.setVisible(true);
		this.add(block13, model.getBlockPosX(12) * 4, model.getBlockPosY(12) * 4);

		block14.setFilled(true);
		block14.setFillColor(Color.red);
		block14.setVisible(true);
		this.add(block14, model.getBlockPosX(13) * 4, model.getBlockPosY(13) * 4);

		block15.setFilled(true);
		block15.setFillColor(Color.green);
		block5.setVisible(true);
		this.add(block15, model.getBlockPosX(14) * 4, model.getBlockPosY(14) * 4);

		block16.setFilled(true);
		block16.setFillColor(Color.green);
		block16.setVisible(true);
		this.add(block16, model.getBlockPosX(15) * 4, model.getBlockPosY(15) * 4);

		block17.setFilled(true);
		block17.setFillColor(Color.green);
		block17.setVisible(true);
		this.add(block17, model.getBlockPosX(16) * 4, model.getBlockPosY(16) * 4);

		block18.setFilled(true);
		block18.setFillColor(Color.green);
		block18.setVisible(true);
		this.add(block18, model.getBlockPosX(17) * 4, model.getBlockPosY(17) * 4);

		block19.setFilled(true);
		block19.setFillColor(Color.green);
		block19.setVisible(true);
		this.add(block19, model.getBlockPosX(18) * 4, model.getBlockPosY(18) * 4);

		block20.setFilled(true);
		block20.setFillColor(Color.green);
		block20.setVisible(true);
		this.add(block20, model.getBlockPosX(19) * 4, model.getBlockPosY(19) * 4);

		block21.setFilled(true);
		block21.setFillColor(Color.green);
		block21.setVisible(true);
		this.add(block21, model.getBlockPosX(20) * 4, model.getBlockPosY(20) * 4);

		block22.setFilled(true);
		block22.setFillColor(Color.pink);
		block22.setVisible(true);
		this.add(block22, model.getBlockPosX(21) * 4, model.getBlockPosY(21) * 4);

		block23.setFilled(true);
		block23.setFillColor(Color.pink);
		block23.setVisible(true);
		this.add(block23, model.getBlockPosX(22) * 4, model.getBlockPosY(22) * 4);

		block24.setFilled(true);
		block24.setFillColor(Color.pink);
		block24.setVisible(true);
		this.add(block24, model.getBlockPosX(23) * 4, model.getBlockPosY(23) * 4);

		block25.setFilled(true);
		block25.setFillColor(Color.pink);
		block25.setVisible(true);
		this.add(block25, model.getBlockPosX(24) * 4, model.getBlockPosY(24) * 4);

		block26.setFilled(true);
		block26.setFillColor(Color.pink);
		block26.setVisible(true);
		this.add(block26, model.getBlockPosX(25) * 4, model.getBlockPosY(25) * 4);

		block27.setFilled(true);
		block27.setFillColor(Color.pink);
		block27.setVisible(true);
		this.add(block27, model.getBlockPosX(26) * 4, model.getBlockPosY(26) * 4);

		block28.setFilled(true);
		block28.setFillColor(Color.pink);
		block28.setVisible(true);
		this.add(block28, model.getBlockPosX(27) * 4, model.getBlockPosY(27) * 4);
	}

	/**
	 * This method updates the view with the actual positions of the ball and
	 * everything else.
	 */
	public void update() {
		ball.setLocation((model.getBallPosX() * 4) - 5, (model.getBallPosY() * 4) - 5);
		bar.setLocation(model.getBarPosX() * 4, model.getBarPosY() * 4);

		block1.setVisible(model.getActiveBlock(0));
		block2.setVisible(model.getActiveBlock(1));
		block3.setVisible(model.getActiveBlock(2));
		block4.setVisible(model.getActiveBlock(3));
		block5.setVisible(model.getActiveBlock(4));
		block6.setVisible(model.getActiveBlock(5));
		block7.setVisible(model.getActiveBlock(6));
		block8.setVisible(model.getActiveBlock(7));
		block9.setVisible(model.getActiveBlock(8));
		block10.setVisible(model.getActiveBlock(9));
		block11.setVisible(model.getActiveBlock(10));
		block12.setVisible(model.getActiveBlock(11));
		block13.setVisible(model.getActiveBlock(12));
		block14.setVisible(model.getActiveBlock(13));
		block15.setVisible(model.getActiveBlock(14));
		block16.setVisible(model.getActiveBlock(15));
		block17.setVisible(model.getActiveBlock(16));
		block18.setVisible(model.getActiveBlock(17));
		block19.setVisible(model.getActiveBlock(18));
		block20.setVisible(model.getActiveBlock(19));
		block21.setVisible(model.getActiveBlock(20));
		block22.setVisible(model.getActiveBlock(21));
		block23.setVisible(model.getActiveBlock(22));
		block24.setVisible(model.getActiveBlock(23));
		block25.setVisible(model.getActiveBlock(24));
		block26.setVisible(model.getActiveBlock(25));
		block27.setVisible(model.getActiveBlock(26));
		block28.setVisible(model.getActiveBlock(27));

	}

}
