package picasso.parser.language.expressions.MultiArgumentFunctions;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.MultiArgumentFunction;
import picasso.parser.language.expressions.RGBColor;


/**
 * Represents the Random function in the Picasso language
 * @author cbassi
 *
 */

public class Random extends ExpressionTreeNode {
	
	protected double red;
	protected double green;
	protected double blue;
	

	/**
	 * Creates a Random expression that generates random color
	 * 
	 * @param param the expression to Random
	 */
	
	public Random() {
		red = Math.random()-1;
		green = Math.random()-1;
		blue = Math.random()-1;
		
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		return new RGBColor(red, green, blue);
	}

}
