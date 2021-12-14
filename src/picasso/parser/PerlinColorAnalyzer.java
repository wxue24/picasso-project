/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.MultiArgumentFunctions.PerlinColor;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the PerlinColor function
 *  
 * @author cbassi
 *
 */ 

public class PerlinColorAnalyzer implements SemanticAnalyzerInterface {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Pop PerlinColor token
		tokens.pop();

		ExpressionTreeNode rightExp = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode leftExp = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);


		return new PerlinColor(leftExp, rightExp);
	}
}
