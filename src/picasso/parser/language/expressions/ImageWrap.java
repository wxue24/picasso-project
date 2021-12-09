/**

 * 
 */
package picasso.parser.language.expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageWrap;

/**
 * @author calebchoe
 *
 */
public class ImageWrap extends MultiArgumentFunction {

	ExpressionTreeNode xcoordexp, ycoordexp;
	
	/**
	 * Create an ImageWrap expression that takes a list of parameters.
	 * 
	 * @param param the expression to ImageWrap
	 */
	public ImageWrap(String name, ExpressionTreeNode xcoordexp, ExpressionTreeNode ycoordexp ) {
		super(Arrays.asList(xcoordexp, ycoordexp));
		this.xcoordexp = xcoordexp;
		this.ycoordexp = ycoordexp;
		
	}

	public int domainToImageScale​(double value, int bounds) {
		int range = 1 - 1;
		return (int) (((double) value / bounds) * range + (-1));
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor xcolor = xcoordexp.evaluate(x,y);
		RGBColor ycolor = ycoordexp.evaluate(x,y);

		return null;
	}

}
