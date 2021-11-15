package picasso.parser.language;

import java.util.Map;
import java.util.TreeMap;

import picasso.parser.language.expressions.RGBColor;

/**
 * All elements of the language (e.g., that make up ExpressionTree) should
 * extend ExpressionTreeNode.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 */
public abstract class ExpressionTreeNode implements EvaluatableExpression {

	/**
	 * Evaluate this expression, given x and y
	 * 
	 * @param x
	 * @param y
	 * 
	 * @return the result of evaluating the expression
	 */
	public abstract RGBColor evaluate(double x, double y);

	// TODO: Not being utilized yet. Why would it be useful?
	// keep a mapping of the element to its value.
	static protected Map<ExpressionTreeNode, Object> gelementsToValue = new TreeMap<ExpressionTreeNode, Object>();
}
