package picasso.view.commands;

import java.awt.Color;
import java.awt.Dimension;

import picasso.model.Pixmap;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.util.Command;
import picasso.view.ErrorWindow;
import picasso.view.Input;

/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 */
public class Evaluater implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;
	private Input input;
	private ErrorWindow errorWindow;

	public Evaluater(Input input, ErrorWindow errorWindow) {
		this.input = input;
		this.errorWindow = errorWindow;
	}

	/**
	 * Evaluate an expression for each point in the image.
	 */
	public void execute(Pixmap target) {
		// create the expression to evaluate just once
		ExpressionTreeNode expr = createExpression();
		// evaluate it for each pixel
		Dimension size = target.getSize();
		for (int imageY = 0; imageY < size.height; imageY++) {
			double evalY = imageToDomainScale(imageY, size.height);
			for (int imageX = 0; imageX < size.width; imageX++) {
				double evalX = imageToDomainScale(imageX, size.width);
				Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
				target.setColor(imageX, imageY, pixelColor);
			}
		}
	}

	/**
	 * Convert from image space to domain space.
	 */
	protected double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}

	/**
	 * 
	 * A place holder for a more interesting way to build the expression.
	 */
	private ExpressionTreeNode createExpression() {
		// Note, when you're testing, you can use the ExpressionTreeGenerator to
		// generate expression trees from strings, or you can create expression
		// objects directly (as in the commented statement below).

<<<<<<< HEAD
		//String test = "floor(y)";
		String test = "ceil(y)";
		//String test = "x - y";
		//String test = "x * y";
		//String test = "x / y";
=======
//					String test = "floor(y)";
//					String test = "abs(y)";
		// String test = "x + y";
		String test = input.getText();
>>>>>>> main

		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		try {

			ExpressionTreeNode node = expTreeGen.makeExpression(test);
			if(node != null) return node;
			else return handleCreateExpressionError();
			// return new Multiply( new X(), new Y() );
		} catch (Exception e) {
			return handleCreateExpressionError();
		}
	}
	
	/**
	 * Shows any errors when generating the expression tree in an error window
	 * @return Expression tree node for black canvas
	 */
	private ExpressionTreeNode handleCreateExpressionError() {
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		errorWindow.showError("Unable to create image from input");
		// Set canvas to black
		return expTreeGen.makeExpression("-1");
	}

}
