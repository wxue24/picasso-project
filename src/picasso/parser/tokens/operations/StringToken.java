/**
 * 
 */
package picasso.parser.tokens.operations;

import picasso.parser.tokens.Token;

/**
 * Represents a string token
 * 
 * @author wxue
 *
 */
public class StringToken extends Token {

	private String s;

	public StringToken(String s) {
		super("String token");
		this.s = s;
	}

	/**
	 * 
	 * @return string
	 */
	public String getValue() {
		return s;
	}

	@Override
	public String toString() {
		return super.toString() + ": " + s;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof StringToken)) {
			return false;
		}
		StringToken other = (StringToken) o;
		return s.equals(other.s);
	}

	@Override
	public boolean isConstant() {
		return false;
	}

	@Override
	public boolean isFunction() {
		return false;
	}

}
