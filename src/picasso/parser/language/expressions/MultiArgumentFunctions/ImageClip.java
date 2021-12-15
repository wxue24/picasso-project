package picasso.parser.language.expressions.MultiArgumentFunctions;

import java.awt.Color;
import java.util.Arrays;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.MultiArgumentFunction;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunctions.Clamp;
import picasso.parser.language.expressions.UnaryFunctions.Wrap;

/**
 * Represents the imageClip function in the Picasso language
 * 
 * 
 * @author cbassi
 *
 */

public class ImageClip extends ImageFunctions {
	

	/**
	 * Create an ImageClip expression that takes a list of parameters.
	 * 
	 * @param param the expression to ImageClip
	 */

	public ImageClip(String name, ExpressionTreeNode xcoordexp, ExpressionTreeNode ycoordexp) {
		super(name, xcoordexp,ycoordexp);

	} 
	
	@Override
	public RGBColor evaluate(double x, double y) {
		// Evaluate expression
		RGBColor xcoord = xcoordexp.evaluate(x, y);
		RGBColor ycoord = ycoordexp.evaluate(x, y);
		
		double xcoordB = Clamp.clampvalue(xcoord.getBlue());
		double ycoordB = Clamp.clampvalue(ycoord.getBlue());  
  
		// Get color from original image at these coordinates
		int[] scaledCoords = scaleCoords(xcoordB, ycoordB);
		RGBColor originalColor = new RGBColor(new Color(image.getRGB(scaledCoords[0], scaledCoords[1])));
		return originalColor;
	}
 
	/**
	 * Returns coordinates of image corresponding to coordinates
	 * 
	 * @param x - xcoord in range [-1,1]
	 * @param y - ycoord in range [-1,1]
	 * @return scaled to coordinates as an integer array, with index at 0 as
	 *         the x-coord and 1 as the y-coord
	 */
	private int[] scaleCoords(double x, double y) {
		// Set range to [0, 2]
		x = x + 1;
		y = y + 1;

		// Get ratio
		double xratio = x / 2;
		double yratio = y / 2;

		// Get scaled up coordinates
		return new int[] { (int) (xratio * (image.getWidth()-1)), (int) (yratio * (image.getHeight()-1))};
	}

}

