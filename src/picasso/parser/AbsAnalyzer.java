/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Abs;
import picasso.parser.language.expressions.Floor;
import picasso.parser.tokens.Token;

/**
 * @author wxue
 *
 */
public class AbsAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the absolute value token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Abs(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
