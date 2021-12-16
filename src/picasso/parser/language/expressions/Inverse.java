/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Garrett Mize
 *
 */
public class Inverse extends UnaryFunction {

	public Inverse(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * 
	 * @return the inverse color from evaluating TO DO
	 */

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = (result.getRed()*-1);
		double green = (result.getGreen()*-1);
		double blue = (result.getBlue()*-1);

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
		if (!(obj instanceof Inverse)) {
			return false;
		}
		Inverse c = (Inverse) obj;
		return param.equals(c.param);
	}
}
