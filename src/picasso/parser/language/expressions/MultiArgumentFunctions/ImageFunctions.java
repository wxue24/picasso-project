package picasso.parser.language.expressions.MultiArgumentFunctions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.MultiArgumentFunction;
import picasso.parser.language.expressions.RGBColor;

/**
 * Able to read a filename from the images library
 * Used for the imageWrap and imageClip functions
 * 
 * @author cbassi
 *
 */

public class ImageFunctions extends MultiArgumentFunction {
	
	/**
	 * Create an ImageFunction expression that takes a list of parameters.
	 * 
	 * @param param the expression to ImageFunction
	 */
	
	BufferedImage image;
	ExpressionTreeNode xcoordexp;
	ExpressionTreeNode ycoordexp;
	String fileName;
	
	
	public ImageFunctions(String name, ExpressionTreeNode xcoordexp, ExpressionTreeNode ycoordexp) {
		super(Arrays.asList(xcoordexp, ycoordexp));
		this.xcoordexp = xcoordexp;
		this.ycoordexp = ycoordexp;
		File test = new File("images//"+"foo.jpg");
		System.out.println(test.getAbsolutePath());
		
		try {
			image = ImageIO.read(new File("images//" + name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.fileName = name;
	}


	@Override
	public RGBColor evaluate(double x, double y) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
