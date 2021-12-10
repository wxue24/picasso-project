package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.BinaryOperators.Division;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the divide or "division function".
 * 
 * @author Robert C. Duvall
 * @author bslater
 * 
 */
public class DivideAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the divide token
		
		// Get right side first, then left
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		return new Division(left, right);
	}

}
