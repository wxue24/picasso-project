/**
 * 
 */
package picasso.parser.language.expressions;

import java.util.List;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes multiple arguments
 * 
 * @author wxue
 *
 */
public abstract class MultiArgumentFunction extends ExpressionTreeNode {

	protected List<ExpressionTreeNode> params;

	/**
	 * 
	 * @param params 
	 */
	public MultiArgumentFunction(List<ExpressionTreeNode> params) {
		this.params = params;
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// converts list of parameters into a string
		String sparams = params.get(0).toString();
		for (int i = 1; i < params.size(); i++) {
			sparams = sparams + "," + params.get(i).toString();
		}
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".") + 1) + "(" + sparams + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof MultiArgumentFunction)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		MultiArgumentFunction mf = (MultiArgumentFunction) o;

		// check if their parameters are equal
		if (!this.params.equals(mf.params)) {
			return false;
		}
		return true;
	}

}
