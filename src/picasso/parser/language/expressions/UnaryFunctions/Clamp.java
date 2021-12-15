package picasso.parser.language.expressions.UnaryFunctions;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;
import picasso.parser.tokens.Token;

/**
 * Represents the clamp function in the Picasso language
 * 
 * @author cbassi
 *
 */

public class Clamp extends UnaryFunction {
	
	/**
	 * Create a clamp expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to clamp
	 */ 
	
	public Clamp(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Creates a clampvalue method that determines whether to clamp value
	 * 
	 * @param value
	 * 
	 * @return returns the given result from wrapping the value
	 */

	
	public static double clampvalue(double value) {
		
		if (value > 1) {
			value = 1;
		}
		
		if (value < -1) {
			value = -1; 
		}
		
		return value; 
	}
	
	
	/**
	 * Evaluates this expression at the given x,y point by evaluating the clamp of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the clamp of the expression's parameter
	 */

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = clampvalue(result.getRed());
		double green = clampvalue(result.getGreen());
		double blue = clampvalue(result.getBlue());

		return new RGBColor(red, green, blue);
	}

	
}
