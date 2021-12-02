/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author bslater
 *
 */
public class Sin extends UnaryFunction {

	/**
	 * Create a sine expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */
	public Sin(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the sine of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the sine of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.sin(result.getRed());
		double green = Math.sin(result.getGreen());
		double blue = Math.sin(result.getBlue());

		return new RGBColor(red, green, blue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Sin)) {
			return false;
		}
		Sin a = (Sin) obj;
		return param.equals(a.param);
	}
}