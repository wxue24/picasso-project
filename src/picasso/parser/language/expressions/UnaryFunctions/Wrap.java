package picasso.parser.language.expressions.UnaryFunctions;

import picasso.parser.language.ExpressionTreeNode;

import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;


/**
 * Represents the wrap function in the Picasso language
 * 
 * @author calebchoe
 *
 */

public class Wrap extends UnaryFunction {

	/**
	 * Create a wrap expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to wrap
	 */

	public Wrap(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the wrap of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the wrap of the expression's parameter
	 */

	@Override
	public RGBColor evaluate(double x, double y) {
		// need to wrap somehow, Math.wrap does not exist
		RGBColor result = param.evaluate(x, y);
		double red = (result.getRed());
		double green = (result.getGreen());
		double blue = (result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
