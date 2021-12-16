
package picasso.parser.language.expressions.BinaryOperators;
import static java.lang.Math.sqrt;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.BinaryOperation;
import picasso.parser.language.expressions.RGBColor;

/**
 * @author bslater
 *
 */
public class Exponentiation extends BinaryOperation {
	
	public Exponentiation(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor l = left.evaluate(x, y);
		RGBColor r = right.evaluate(x, y);
		
		double red = Math.pow(l.getRed(), r.getRed());
		double green = Math.pow(l.getGreen(), r.getGreen());
		double blue = Math.pow(l.getBlue(), r.getBlue());
		return new RGBColor(red, green, blue);
	}
	
	@Override
	public String toString() {
		return left + " ^ " + right;
	}
	


}