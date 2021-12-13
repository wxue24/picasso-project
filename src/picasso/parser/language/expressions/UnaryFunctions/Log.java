package picasso.parser.language.expressions.UnaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * 
 * @author calebchoe
 *
 */

public class Log extends UnaryFunction {

	/**
	 * Create a log expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to log
	 */

	public Log(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the log of the
	 * function's parameter.
	 * 
	 * @return the color from evaluating the log of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		double negInf = Double.NEGATIVE_INFINITY;

		if (x < 0) {
			return new RGBColor(-1, -1, -1);
		}
		if (x == negInf) {
			return new RGBColor(50/0, 50/0, 50/0);
		}

		else {
			RGBColor result = param.evaluate(x, y);
			double red = Math.log(result.getRed());
			double green = Math.log(result.getGreen());
			double blue = Math.log(result.getBlue());

			return new RGBColor(red, green, blue);

		}
	}

}
