package picasso.parser.language.expressions.UnaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

public class Atan extends UnaryFunction {
/**
 * Create a arcTangent expression that takes as a parameter the given expression
 * 
 * @param param the expression to arcTangent
 * @author cbassi
 */

	public Atan(ExpressionTreeNode param) {
		super(param);
	}
	
	
	/**
	 * Evaluates this expression at the given x,y point by evaluating the arcTangent of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
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
