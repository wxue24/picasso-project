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
	 * Creates a wrapvalue method that determines whether to continuously add 
	 * or subtract 2 to value until it reaches the given range.
	 * 
	 * @param value 
	 * 
	 * @return returns the given result from wrapping the value
	 */

	public static double wrapvalue(double value) {
		double remainder = 0;
		double quotient;
		double result = 0;

		if (value > 1) {
			while (value > 1) {
				value -= 2;

			}
			remainder = value % 1;

		}
		if (value < -1) {
			while (value < -1) {
				value += 2;
			}
			remainder = value % 1;
			result = ((value));

		} else {
			result = value;
		}
		return result;

	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the wrap of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the wrap of the expression's parameter
	 */

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = wrapvalue(result.getRed());
		double green = wrapvalue(result.getGreen());
		double blue = wrapvalue(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
