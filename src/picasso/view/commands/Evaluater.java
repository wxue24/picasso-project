package picasso.view.commands;

import java.awt.Color;
import java.awt.Dimension;

import picasso.model.Pixmap;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunctions.StringFunction;
import picasso.util.Command;
import picasso.view.ErrorWindow;
import picasso.view.ExpressionHistoryPanel;
import picasso.view.InputPanel;
import picasso.view.VariablesPanel;

/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 */
public class Evaluater implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;
	private ExpressionHistoryPanel exphist;
	private VariablesPanel vpanel;
	
	private ExpressionTreeNode expr;

	public Evaluater(ExpressionHistoryPanel exphist, VariablesPanel vpanel) {
		this.exphist = exphist;
		this.vpanel = vpanel;
	}

	/**
	 * Evaluate an expression for each point in the image.
	 */
	@Override
	public void execute(Pixmap target) {
		try {
			// create the expression to evaluate just once
			expr = createExpression();
			if (expr == null) {
				ErrorWindow.getInstance().showError("Can't evaluate empty expressions");
			} else {
				// Update variables panel
				vpanel.refresh();
				exphist.refresh();
				// evaluate it for each pixel
				Dimension size = target.getSize();
				for (int imageY = 0; imageY < size.height; imageY++) {
					double evalY = imageToDomainScale(imageY, size.height);
					for (int imageX = 0; imageX < size.width; imageX++) {
						double evalX = imageToDomainScale(imageX, size.width);
//						System.out.println(evalY);
						RGBColor rgb = null;
						if (expr instanceof StringFunction) {
							rgb = expr.evaluate(imageX, imageY);
						} else {
							rgb = expr.evaluate(evalX, evalY);
						}
//						System.out.println(rgb);
						Color pixelColor = rgb.toJavaColor();
//						System.out.println(evalY);
						target.setColor(imageX, imageY, pixelColor);
					}
				}
			}
		} catch (Exception e) {
			ErrorWindow.getInstance().showError(e.getMessage());
		}
	}
	
	public RGBColor evaluateCoordinates(double x, double y) {
		if (expr!= null) {
			return expr.evaluate(x, y);
		}
		return new RGBColor(0.0,0.0,0.0);
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

		String text = InputPanel.getText();

		// Add to history
		exphist.addExpression(text);

		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();

		ExpressionTreeNode node = expTreeGen.makeExpression(text);
		if (node != null)
			return node;
		return null;

	}

	public ExpressionTreeNode getExpr() {
		return expr;
	}

}
