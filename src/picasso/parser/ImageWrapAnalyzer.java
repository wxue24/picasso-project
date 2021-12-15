/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.MultiArgumentFunctions.ImageWrap;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the ImageWrap function
 * 
 * @author wxue  
 * 
 */

public class ImageWrapAnalyzer implements SemanticAnalyzerInterface {
 
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Pop ImageWrap token
		tokens.pop();

		ExpressionTreeNode rightExp = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode leftExp = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);

		// Pop string
		StringToken token = (StringToken) tokens.pop();
		String name = token.getValue();

		return new ImageWrap(name, leftExp, rightExp);
	}
}
