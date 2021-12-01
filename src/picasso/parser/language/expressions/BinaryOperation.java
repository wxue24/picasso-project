/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author wxue
 *
 */
public abstract class BinaryOperation extends ExpressionTreeNode {

	protected ExpressionTreeNode left;
	protected ExpressionTreeNode right;

	public BinaryOperation(ExpressionTreeNode left, ExpressionTreeNode right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor l = left.evaluate(x, y);
		RGBColor r = right.evaluate(x, y);
		
		
		
		double red = l.getRed() + r.getRed();
		double green = l.getGreen() + r.getGreen();
		double blue = l.getBlue() + r.getBlue();
		return new RGBColor(red, green, blue);
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BinaryOperation)) {
			return false;
		}
		BinaryOperation other = (BinaryOperation) obj;
		return left.equals(other.left) && right.equals(other.right);
	}

}
