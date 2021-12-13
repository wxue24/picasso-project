package picasso.parser.language.expressions.UnaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * Represents the exponent function in the Picasso language.
 * 
 * @author cbassi
 * 
 */

public class Exp extends UnaryFunction {
	
	/**
	 * Create an exponent expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */
	
	public Exp(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates this expression at the given x,y point by evaluating the exponent of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the exponent of the expression's parameter
	 */

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.exp(result.getRed());
		double green = Math.exp(result.getGreen());
		double blue = Math.exp(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
