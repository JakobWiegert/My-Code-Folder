import acm.program.GraphicsProgram;

import acm.util.RandomGenerator;

import java.awt.Color;

import acm.graphics.*;


/**
 * This program approximate Pi, using a circle.
 * 
 * @author Jakob Wiegert
 */
public class PiApproximator extends GraphicsProgram {

	/**
	 * Randomly generates a new point whose x and y coordinates lie between -1 and
	 * 1.
	 * 
	 * @return random point.
	 */
	public GPoint randomPoint() {

		RandomGenerator rgen = RandomGenerator.getInstance();
		double x = rgen.nextDouble(-1.0, 1.0);
		double y = rgen.nextDouble(-1.0, 1.0);

		GPoint randomPoint = new GPoint(x, y);

		return randomPoint;
	}

	/**
	 * Checks if the point with the given coordinates is inside the circle with.
	 * radius 1 centered at the coordinate system's origin.
	 * 
	 * @param unitPoint
	 *            the point to check.
	 * @return {@code true} if the point is inside the circle, {@code false} if it's
	 *         not.
	 */
	public boolean isInCircle(GPoint unitPoint) {
		boolean pInCirlce;
		double x = unitPoint.getX();
		double y = unitPoint.getY();
		double d = Math.sqrt(x * x + y * y);
		if (d < 1) {
			pInCirlce = true;
		} else {
			pInCirlce = false;
		}
		return pInCirlce;
	}

	/**
	 * This overrides the run method of GraphicsProgram, which is part of ACM-libary.
	 */
	public void run() {
		GRect square = new GRect(0, 0, 400, 400);
		add(square);

		int n = 0;

		for (int i = 1; i <= 10000; i++) {

			GPoint randomPoint = randomPoint();
			boolean pInCircle = isInCircle(randomPoint);
			GOval point = new GOval(randomPoint.getX() * 200 + 200, randomPoint.getY() * 200 + 200, 1.0, 1.0);
			point.setFilled(true);
			if (pInCircle == true) {
				n++;
				point.setColor(Color.blue);
			} else {
				point.setColor(Color.black);
			}

			add(point);
		}
		double pi = (n / 10000.0) * 4.0;

		println("" + pi);
	}
}
