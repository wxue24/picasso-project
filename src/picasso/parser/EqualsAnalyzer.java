/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.Variables;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;

/**
 * @author wxue
 *
 */
public class EqualsAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// remove equals token
		tokens.pop();

		// gets expression and calculates it
		ExpressionTreeNode expression = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		// gets variable
		IdentifierToken variable = (IdentifierToken) tokens.pop();
		// add to variables mapping
		Variables.getInstance().addVariable(variable, expression);
		return expression;

	}

}
