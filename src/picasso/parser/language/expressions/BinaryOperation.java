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
	

}
