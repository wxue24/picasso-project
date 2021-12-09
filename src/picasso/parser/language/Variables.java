/**
 * 
 */
package picasso.parser.language;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import picasso.parser.Tokenizer;
import picasso.parser.tokens.Token;

/**
 * Represents the variables
 * 
 * @author wxue
 *
 */
public class Variables {

	private Map<String, List<Token>> variablesMapping;
	private Map<String, String> variablesMappingString;
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
		variablesMapping = new HashMap<>();
		variablesMappingString = new HashMap<>();
	}

	/**
	 * 
	 * @return the variables in a map of String
	 */
	public Map<String, String> getVariablesMapping() {
		return variablesMappingString;
	}

	/**
	 * Adds variable
	 * 
	 * @param input contains variable name on right hand side and expression on left
	 *              hand side, separated by '=' in between
	 * @return String array with index at 0 as the key, and index at 1 as the
	 *         expression
	 */
	public String[] addVariable(String input) {
		// parses input
		String[] v = parse(input);

		// tokenizes expression
		Tokenizer tokenizer = new Tokenizer();
		List<Token> exp = tokenizer.parseTokens(v[1]);

		// adds to mappings
		variablesMapping.put(v[0], exp);
		variablesMappingString.put(v[0], v[1]);
		return v;
	}

	/**
	 * Gets expression of a variable
	 * 
	 * @param key
	 * @return expression as a stack of tokens
	 */
	public List<Token> getVariable(String key) {
		return variablesMapping.get(key);
	}

	/**
	 * Removes a variable
	 * 
	 * @param key - variable name
	 */
	public void removeVariable(String key) {
		variablesMapping.remove(key);
		variablesMappingString.remove(key);
	}

	/**
	 * Removes all variables
	 */
	public void removeAll() {
		variablesMapping = new HashMap<>();
		variablesMappingString = new HashMap<>();
	}

	/**
	 * Parses the new variable into its name and expression, and checks for any
	 * errors. Valid variable names should be letters or words that aren't x or y or
	 * function names
	 * 
	 * @param input - new variable that user adds
	 * @return array of String with first value being variable name, and second
	 *         being expression
	 * @throws IllegalArgumentException if input is not a valid expression
	 */
	public String[] parse(String input) throws IllegalArgumentException {
		int index = input.indexOf('=');
		if (index < 0) {
			throw new IllegalArgumentException("Please include '=' when assigning a variable");
		} else {
			String key = input.substring(0, index).replaceAll(" ", "");
			String val = input.substring(index + 1, input.length()).replaceAll(" ", "");

			if (BuiltinFunctionsReader.getFunctionsList().contains(key)) {
				throw new IllegalArgumentException("Can't use function names for variables");
			} else if (key.toLowerCase().equals("x") || key.toLowerCase().equals("y")) {
				throw new IllegalArgumentException("Can't use 'x' or 'y' for variables");
			} else
				return new String[] { key, val };
		}
	}

}
