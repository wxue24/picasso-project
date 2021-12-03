package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Tan extends UnaryFunction {
	
	
	/**
	 * Create a tangent expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to tangent
	 */
	public Tan(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the tangent of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.tan(result.getRed());
		double green = Math.tan(result.getGreen());
		double blue = Math.tan(result.getBlue());

		return new RGBColor(red, green, blue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Tan)) {
			return false;
		}
		Tan f = (Tan) obj;
		return param.equals(f.param);
	}

}

