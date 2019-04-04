import acm.graphics.*;
import acm.program.*;
import java.awt.Color;

public class MethodicalPyramide extends GraphicsProgram {

	/**
	 * Returns the color to be used for bricks in the given layer.
	 * 
	 * @param layerIndex
	 *            index of the layer whose color to return. {@code 0} is the bottom
	 *            layer, {@code numberOfLayers - 1} is the top layer.
	 * @param numberOfLayers
	 *            the number of layers in the pyramid.
	 * @return the color to be used for the given layer, or {@code null} if
	 *         {@code layerIndex} is invalid.
	 */
	public Color layerColor(int layerIndex, int numberOfLayers) {

		Color layerColor = new Color(255,255,255);
		if (layerIndex == 0) {
			layerColor = new Color(255, 0, 0);
		}

		if (layerIndex > 0) {
			layerColor = new Color(255, 220 - (220 / (numberOfLayers - 1)) + ((numberOfLayers - 1) - layerIndex),
					220 - (220 / (numberOfLayers - 1)) + ((numberOfLayers - 1) - layerIndex));
		}
		return layerColor;
	}

	/**
	 * Draws the given layer with bricks filled with the given color. If
	 * {@code layerIndex} is invalid, no bricks at all should be drawn.
	 * 
	 * @param layerIndex
	 *            index of the layer to draw. {@code 0} is the bottom layer,
	 *            {@code numberOfLayers - 1} is the top layer.
	 * @param numberOfLayers
	 *            the number of layers in the pyramid.
	 * @param layerColor
	 *            color the layer's bricks should be filled with.
	 */
	public void drawLayer(int layerIndex, int numberOfLayers, Color layerColor) {

		for (int i = layerIndex + 1; i <= numberOfLayers; i++) {
			int x = i * 100 - (layerIndex * 50);
			int y = (numberOfLayers - layerIndex) * 50;

			GRect krass = new GRect(x, y, 100, 50);
			krass.setColor(layerColor);
			krass.setFilled(true);
			add(krass);

		}
	}

	public void run() {
		int numberOfLayers = readInt("Anzahl Blöcke unten:");
		
		for (int j = 1; j <= numberOfLayers; j++) {
			layerColor = layerColor(j-1, numberOfLayers);
			drawLayer(j - 1, numberOfLayers, layerColor);
		}
	}
}