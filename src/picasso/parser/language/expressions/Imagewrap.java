package picasso.parser.language.expressions;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;

/**
 * @author cbassi calebchoe
 *
 */
public class Imagewrap extends MultiArgumentFunction {

	ExpressionTreeNode xcoordexp, ycoordexp;

	/**
	 * Create an ImageWrap expression that takes a list of parameters.
	 * 
	 * @param param the expression to ImageWrap
	 */

	BufferedImage image;
	String name;
	Pixmap imagetemp;

	public Imagewrap(String name, ExpressionTreeNode xcoordexp, ExpressionTreeNode ycoordexp) {
		super(Arrays.asList(xcoordexp, ycoordexp));

		imagetemp = new Pixmap(name);
		this.image = Pixmap.getImage(imagetemp);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
// 		Find new x and y variables 
		RGBColor xCopy = xcoordexp.evaluate(x, y);
		RGBColor yCopy = ycoordexp.evaluate(x, y);

		double xCopyDouble = xCopy.getRed();
		double yCopyDouble = yCopy.getRed();

		double xScale = domainToImageScale(xCopyDouble, this.image.getWidth());
		double yScale = domainToImageScale(yCopyDouble, this.image.getWidth());

		return evaluate(xScale, yScale);
	}

	protected double domainToImageScale(double value, int bounds) {
		return (int) (-1 * (((1 - value) / 2) - 1) * bounds);
	}

}