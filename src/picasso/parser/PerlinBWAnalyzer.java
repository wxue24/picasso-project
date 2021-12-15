/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.MultiArgumentFunctions.PerlinBW;
import picasso.parser.language.expressions.MultiArgumentFunctions.PerlinColor;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the PerlinBW function
 *  
 * @author cbassi
 *
 */


public class PerlinBWAnalyzer implements SemanticAnalyzerInterface {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Pop PerlinBW token
		tokens.pop();

		ExpressionTreeNode rightExp = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode leftExp = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);

		return new PerlinBW(leftExp, rightExp);
	}
}
