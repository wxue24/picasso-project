/**
 * 
 */

package picasso.parser.language.expressions.BinaryOperators;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.BinaryOperation;
import picasso.parser.language.expressions.RGBColor;

/**
 * @author bslater
 *
 */
public class Multiplication extends BinaryOperation {
	
	public Multiplication(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor l = left.evaluate(x, y);
		RGBColor r = right.evaluate(x, y);
		
		double red = l.getRed() * r.getRed();
		double green = l.getGreen() * r.getGreen();
		double blue = l.getBlue() * r.getBlue();
		return new RGBColor(red, green, blue);
	}
	
	@Override
	public String toString() {
		return left + " * " + right;
	}
	


}