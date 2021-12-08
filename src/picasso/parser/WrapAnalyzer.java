package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunctions.Wrap;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the wrap function
 * 
 * @author calebchoe
 *
 */

public class WrapAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the wrap token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Wrap(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
