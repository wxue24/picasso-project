package picasso.parser;

import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunctions.Ceil;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the ceil function
 * 
 * @author calebchoe
 *
 */

public class CeilAnalyzer extends UnaryFunctionAnalyzer {


		@Override
		public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
			tokens.pop(); // Need to remove the ceil token
			// the parameter is the next token on the stack.
			// But, it needs to be processed
			return new Ceil(SemanticAnalyzer.getInstance().generateExpressionTree(
					tokens));
		}
}
