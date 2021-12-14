package picasso.parser.language.expressions.MultiArgumentFunctions;

import java.awt.Color;
import java.util.Arrays;

import picasso.model.ImprovedNoise;
import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.MultiArgumentFunction;
import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the perlinColor function in the Picasso language
 * @author cbassi
 *
 */
public class PerlinColor extends MultiArgumentFunction {
	
	private ExpressionTreeNode xcoordexp, ycoordexp;
	private Pixmap image;
	
	/**
	 * Create an perlinColor expression that takes a list of parameters.
	 * 
	 * @param param the expression to PerlinColor
	 */
	  
	public PerlinColor(ExpressionTreeNode xcoordexp, ExpressionTreeNode ycoordexp) {
		super(Arrays.asList(xcoordexp, ycoordexp));
		this.xcoordexp = xcoordexp;
		this.ycoordexp = ycoordexp;
	}
	
	@Override 
	public RGBColor evaluate(double x, double y) {
		// Evaluate expression
		RGBColor xcoord = xcoordexp.evaluate(x, y);
		RGBColor ycoord = ycoordexp.evaluate(x, y); 
		
		// Generate Perlin noise based on values
		double red = ImprovedNoise.noise(xcoord.getRed() + 0.3, ycoord.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(xcoord.getBlue() + 0.1, ycoord.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(xcoord.getGreen() - 0.8, ycoord.getGreen() - 0.8, 0);
		return new RGBColor(red, green, blue);
	}
}
