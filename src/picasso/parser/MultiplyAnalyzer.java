package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.BinaryOperators.Multiplication;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the multiply or "multiplication function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author bslater
 * 
 */
public class MultiplyAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the multiply token
		
		// Get right side first, then left
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		return new Multiplication(left, right);
	}

}
