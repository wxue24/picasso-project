
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunctions.Cos;
import picasso.parser.tokens.Token;

/**
 * @author Garrett Mize
 *
 */
public class CosAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		
		return new Cos(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}