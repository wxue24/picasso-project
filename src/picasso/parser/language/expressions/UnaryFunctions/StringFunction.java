/**
 * 
 */
package picasso.parser.language.expressions.UnaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.tokens.operations.StringToken;

import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Garrett Mize
 *
 */

public class StringFunction extends ExpressionTreeNode{
	
	private StringToken filename;
	private BufferedImage myImage;
	/**
	 * Constructor for string
	 * @param param
	 */
	public StringFunction(StringToken param) {
		this.filename = param;	

//		String personalPath = "C:\\Users\\gmmiz\\git\\";
//		String projectPath = "picasso-avengers\\images\\";
		//String personalPath = "..\\..\\..\\";
		//String projectPath = "images\\";
//		File file = new File(personalPath + projectPath + filename.getValue() + ".png");
		File file = new File("images//" + filename.getValue());
		try {
			myImage = ImageIO.read(new File("images//" + filename.getValue()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return new RGBColor(new Color(myImage.getRGB((int)(x),(int)(y))));
	}
}

