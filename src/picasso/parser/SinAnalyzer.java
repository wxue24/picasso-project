/**
 * 
 */
package picasso.parser;

import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunctions.Floor;
import picasso.parser.language.expressions.UnaryFunctions.Sin;
import picasso.parser.tokens.Token;

/**
 * @author bslater
 *
 */
public class SinAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		
		return new Sin(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}