package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunctions.Exp;
import picasso.parser.language.expressions.UnaryFunctions.Floor;
import picasso.parser.tokens.Token;

public class ExpAnalyzer extends UnaryFunctionAnalyzer {


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the floor token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Exp(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}