/**
 * 
 */
package picasso.parser.language;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the variables
 * 
 * @author wxue
 *
 */
public class Variables {

	private Map<String, String> variablesMapping;
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
	}

	/**
	 * 
	 * @return the variables in a map
	 */
	public Map<String, String> getVariablesMapping() {
		return variablesMapping;
	}

	/**
	 * Adds a new variable
	 * 
	 * @param key - variable name
	 * @param val - expression
	 */
	public void addVariable(String key, String val) {
		variablesMapping.put(key, val);
	}

	/**
	 * Parses the new variable into its name and expression, and checks for any
	 * errors
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
