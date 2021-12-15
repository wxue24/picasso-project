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
public class BangToken extends CharToken implements OperationInterface {

	/**
	 * @param ch
	 */
	public BangToken() {
			super(CharConstants.BANG);
	}
}
