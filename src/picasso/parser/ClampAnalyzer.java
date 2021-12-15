package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunctions.Clamp;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the clamp function
 * 
 * @author cbassi
 *
 */

public class ClampAnalyzer extends UnaryFunctionAnalyzer {
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the wrap token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Clamp(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}
}
