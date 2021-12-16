/**
 * 
 */
package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * @author Garrett Mize
 *
 */
public class InverseToken extends CharToken implements OperationInterface {

	/**
	 * @param ch
	 */
	public InverseToken() {
			super(CharConstants.BANG);
	}
}
