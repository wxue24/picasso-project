package picasso.parser.language.expressions.MultiArgumentFunctions;

import java.awt.Color;
import java.util.Arrays;

import picasso.model.ImprovedNoise;
import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.MultiArgumentFunction;
import picasso.parser.language.expressions.RGBColor;


/**
 * Represents the perlinBW function in the Picasso language
 * @author cbassi
 *
 */
public class PerlinBW extends MultiArgumentFunction {
	
	private ExpressionTreeNode xcoordexp, ycoordexp;
	private Pixmap image;
	
	/**
	 * Create an perlinBW expression that takes a list of parameters.
	 * 
	 * @param param the expression to PerlinBW
	 */
	
	public PerlinBW(ExpressionTreeNode xcoordexp, ExpressionTreeNode ycoordexp) {
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
		double grey = ImprovedNoise.noise(xcoord.getRed() + ycoord.getRed(), xcoord.getGreen() + ycoord.getGreen(),
				xcoord.getBlue() + ycoord.getBlue());
		return new RGBColor(grey, grey, grey); 
	}
}

 