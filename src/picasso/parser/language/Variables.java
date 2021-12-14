/**
 * 
 */
package picasso.parser.language;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import picasso.parser.tokens.IdentifierToken;

/**
 * Represents the variables
 * 
 * @author wxue
 *
 */
public class Variables {

	private Map<IdentifierToken, ExpressionTreeNode> variables;
	private static Variables ourInstance;

	/**
	 * Make sure that there is only one Variables instance for the application.
	 * 
	 * @return the Variables mapping
	 */
	public static Variables getInstance() {
		if (ourInstance == null) {
			ourInstance = new Variables();
		}
		return ourInstance;
	}

	private Variables() {
		variables = new HashMap<>();
	}

	/**
	 * Adds variable
	 * 
	 * 
	 */
	public void addVariable(IdentifierToken t, ExpressionTreeNode e) {
		for (Entry<IdentifierToken, ExpressionTreeNode> entry : getAll()) {
			if (entry.getKey().getName().equals(t.getName())) {
				variables.remove(entry.getKey());
			}
		}
		variables.put(t, e);
	}

	/**
	 * Gets expression of a variable
	 * 
	 * @param key
	 * @return expression as a stack of tokens
	 */
	public ExpressionTreeNode getVariable(IdentifierToken t) {
		for (Entry<IdentifierToken, ExpressionTreeNode> entry : getAll()) {
			if (entry.getKey().getName().equals(t.getName())) {
				return variables.get(entry.getKey());
			}
		}
		return null;
	}

	public Set<Entry<IdentifierToken, ExpressionTreeNode>> getAll() {
		return variables.entrySet();
	}

	/**
	 * Removes a variable
	 * 
	 * @param key - variable name
	 */
	public void removeVariable(IdentifierToken t) {
		for (Entry<IdentifierToken, ExpressionTreeNode> entry : getAll()) {
			if (entry.getKey().getName().equals(t.getName())) {
				variables.remove(entry.getKey());
			}
		}
	}

	/**
	 * Removes all variables
	 */
	public void removeAll() {
		variables = new HashMap<>();
	}

}
