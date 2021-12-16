/**
 * 
 */
package picasso.util;

import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Point;

import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunctions.StringFunction;
import picasso.view.Canvas;
import picasso.view.commands.Evaluater;
/**
 * @author Garrett Mize
 * @author Caleb Choe
 *
 */
public class MouseCoordinate extends MouseAdapter {
	
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;
	
	private JLabel coordinateLabel;
	private Canvas view;
	private Evaluater evaluator;
	
	public MouseCoordinate(Canvas view, Evaluater evaluator, JLabel coordinateLabel) {
		this.view = view;
		this.evaluator = evaluator;
		this.coordinateLabel = coordinateLabel;
		
	}
	
	@Override
	public void mouseMoved(MouseEvent a) {
		Point location = new Point(a.getX(), a.getY()); //coordinates of where mouse is
		coordinateLabel.setText(getCoordinatesAndEvaluation(location)); //setting text of coordinate label to domain location of mouse and corresponding color evaluation.
		
	}
	
	/**
	 * Convert from image space to domain space.
	 */
	protected double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN; 
	}
	
	public String getCoordinatesAndEvaluation(Point location) {
		double x;
		double y;
		if (evaluator.getExpr() instanceof StringFunction) { //if opening an image, using canvas location rather than the mapped domain location
			x = location.getX();
			y = location.getY();
		}else {
			x = roundToTwoDecimals(imageToDomainScale((int)(location.getX()), view.getWidth()));
			y = roundToTwoDecimals(imageToDomainScale((int)(location.getY()), view.getHeight()));
		}
		
		Color evaluation = evaluator.evaluateCoordinates(x, y).toJavaColor();
		
		String colorString = "Color: (" + evaluation.getRed() + ", " 
				+ evaluation.getGreen() + ", " + evaluation.getBlue() + ")"; 
		String text = "(" + x +", " + y + ")" + "     " + colorString;
		return text;
	}
	
	private double roundToTwoDecimals(double val) {
		return Math.round(val*100.0)/100.0;
	}
	

	
}