package picasso.parser;

import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Constant;
import picasso.parser.language.expressions.MultiArgumentFunctions.Random;
import picasso.parser.language.expressions.UnaryFunctions.Floor;
import picasso.parser.tokens.NumberToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the floor function.
 * 
 * @author cbassi
 * 
 */
public class RandomAnalyzer implements SemanticAnalyzerInterface {
	
	private static RandomAnalyzer singleton;
	
	public static RandomAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new RandomAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Random();
	}
}
