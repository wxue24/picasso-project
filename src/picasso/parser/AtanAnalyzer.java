package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunctions.Atan;
import picasso.parser.language.expressions.UnaryFunctions.Tan;
import picasso.parser.tokens.Token;

public class AtanAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the floor token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Atan(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
