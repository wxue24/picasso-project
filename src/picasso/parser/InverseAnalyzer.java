/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Inverse;
import picasso.parser.tokens.Token;

/**
 * @author Garrett Mize
 *
 */
public class InverseAnalyzer extends UnaryFunctionAnalyzer {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the ceil token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Inverse(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
