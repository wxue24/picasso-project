/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunctions.StringFunction;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.StringToken;

/**
 * @author Garrett Mize
 *
 */
public class StringAnalyzer implements SemanticAnalyzerInterface {
	@Override
	/**
	 * 
	 */
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		return new StringFunction((StringToken) tokens.pop());
	}

}
