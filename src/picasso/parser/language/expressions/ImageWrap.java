/**

 * 
 */
package picasso.parser.language.expressions;

import javax.imageio.ImageIO;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageWrap;
import picasso.parser.language.expressions.UnaryFunctions.Wrap;
import picasso.view.ErrorWindow;

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
	BufferedImage image;
	String name;
	Pixmap imagetemp;

	public ImageWrap(String name, ExpressionTreeNode xcoordexp, ExpressionTreeNode ycoordexp) {
		super(Arrays.asList(xcoordexp, ycoordexp));

		imagetemp = new Pixmap(name);
		this.image = Pixmap.getImage(imagetemp);

	}

	@Override
	public RGBColor evaluate(double x, double y) {
		xRed = xcoordexp.getRed();
		y = ycoordexp.;
		
		double xcoord = Wrap.wrapvalue(left.getBlue());
		double ycoord = Wrap.wrapvalue(right.getBlue());
		
		
	

		return null;
	}
	
	protected double domainToImageScale(double value, int bounds) {
		return (-1 * (((1 - value ) / 2) - 1 ) * bounds);
	}
	

}
