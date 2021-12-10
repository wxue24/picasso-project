/**

 * 
 */
package picasso.parser.language.expressions;

import java.awt.Color;
import java.util.Arrays;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunctions.Wrap;

/**
 * @author calebchoe
 *
 */
public class Imagewrap extends MultiArgumentFunction {

	private ExpressionTreeNode xcoordexp, ycoordexp;
	private String path;
	private Pixmap image;

	/**
	 * Create an ImageWrap expression that takes a list of parameters.
	 * 
	 * @param param the expression to ImageWrap
	 */

	public Imagewrap(String path, ExpressionTreeNode xcoordexp, ExpressionTreeNode ycoordexp) {
		super(Arrays.asList(xcoordexp, ycoordexp));
		image = new Pixmap(path);

	}

	@Override
	public RGBColor evaluate(double x, double y) {
		// Evaluate expression
		double xcoord = xcoordexp.evaluate(x, y).getBlue();
		double ycoord = ycoordexp.evaluate(x, y).getBlue();

		// Wrap coordinates
		xcoord = Wrap.wrapvalue(xcoord);
		ycoord = Wrap.wrapvalue(ycoord);

		// Get color from original image at these coordinates
		int[] scaledCoords = scaleCoords(xcoord, ycoord);
		Color originalColor = image.getColor(scaledCoords[0], scaledCoords[1]);

		return new RGBColor(originalColor);

	}

	/**
	 * Returns coordinates of image corresponding to Pixmap coordinates
	 * 
	 * @param x - xcoord in range [-1,1]
	 * @param y - ycoord in range [-1,1]
	 * @return scaled to pixmap coordinates as an integer array, with index at 0 as
	 *         the x-coord and 1 as the y-coord
	 */
	private int[] scaleCoords(double x, double y) {
		// Set range to [0, 2]
		x = x + 1;
		y = y + 1;

		// Get ratio
		double xratio = x / image.getSize().width;
		double yratio = y / image.getSize().height;

		// Get scaled up coordinates
		return new int[] { (int) (x / xratio), (int) (y / yratio) };
	}

}
