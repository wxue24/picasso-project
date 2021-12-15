/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunctions.RgbToYCrCb;
import picasso.parser.tokens.Token;

/**
 * @author calebchoe
 *
 */
public class RgbToYCrCbAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the floor token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new RgbToYCrCb(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}
}
