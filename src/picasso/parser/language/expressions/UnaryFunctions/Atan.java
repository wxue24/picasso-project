package picasso.parser.language.expressions.UnaryFunctions;

import picasso.parser.language.ExpressionTreeNode;


import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * 
 * @author calebchoe
 *
 */
public class Atan extends UnaryFunction {

	/**
	 * Create an arctan expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to arctan
	 */

	public Atan(ExpressionTreeNode param) {
		super(param);

	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the arctan
	 * value of the function's parameter.
	 * 
	 * @return the color from evaluating the inverse tangent of the expression's
	 *         parameter
	 */
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.atan(result.getRed());
		double green = Math.atan(result.getGreen());
		double blue = Math.atan(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
