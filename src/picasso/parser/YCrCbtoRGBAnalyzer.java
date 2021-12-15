/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunctions.YCrCbtoRGB;
import picasso.parser.tokens.Token;

/**
 * @author calebchoe
 *
 */
public class YCrCbtoRGBAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the YCrCbtoRGB token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new YCrCbtoRGB(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}
}
