/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Imagewrap;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.language.expressions.UnaryFunctions.Abs;
import picasso.parser.language.expressions.UnaryFunctions.Atan;
import picasso.parser.language.expressions.UnaryFunctions.Ceil;
import picasso.parser.language.expressions.UnaryFunctions.Clamp;
import picasso.parser.language.expressions.UnaryFunctions.Cos;
import picasso.parser.language.expressions.UnaryFunctions.Exp;
import picasso.parser.language.expressions.UnaryFunctions.Floor;
import picasso.parser.language.expressions.UnaryFunctions.Log;
import picasso.parser.language.expressions.UnaryFunctions.Sin;
import picasso.parser.language.expressions.UnaryFunctions.Tan;
import picasso.parser.language.expressions.UnaryFunctions.Wrap;

/**
 * Tests of the evaluation of x
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {

	private ExpressionTreeGenerator parser;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("[1, -1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	@Test
	public void testTanEvaluation() {
		Tan myTree = new Tan(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.tan(.4), Math.tan(.4), Math.tan(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.tan(.999), Math.tan(.999), Math.tan(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.tan(-.7), Math.tan(-.7), Math.tan(-.7)), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.tan(i), Math.tan(i), Math.tan(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.tan(i), Math.tan(i), Math.tan(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double tanOfTestVal = Math.tan(testVal);
			assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal), myTree.evaluate(testVal, testVal));
		}

	}

	@Test
	public void testCeilEvaluation() {
		Ceil myTree = new Ceil(new X());

		// some straightforward tests
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double ceilOfTestVal = Math.ceil(testVal);
			assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(testVal, testVal));
		}

	}

	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}

	@Test
	public void testCosEvaluation() {
		Cos myTree = new Cos(new X());

		assertEquals(new RGBColor(Math.cos(.4), Math.cos(.4), Math.cos(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.cos(.999), Math.cos(.999), Math.cos(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.cos(-.7), Math.cos(-.7), Math.cos(-.7)), myTree.evaluate(-.7, -1));

		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double cosOfTestVal = Math.cos(testVal);
			assertEquals(new RGBColor(cosOfTestVal, cosOfTestVal, cosOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(cosOfTestVal, cosOfTestVal, cosOfTestVal), myTree.evaluate(testVal, testVal));
		}
	}

	@Test
	public void testFloorEvaluation() {
		Floor myTree = new Floor(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double floorOfTestVal = Math.floor(testVal);
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal),
					myTree.evaluate(testVal, testVal));
		}

	}

	@Test
	public void testAbsEvaluation() {
		Abs myTree = new Abs(new X());

		// some straightforward tests
		assertEquals(new RGBColor(.4, .4, .4), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0.999, .999, .999), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(.7, .7, .7), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			int expected = Math.abs(i);
			assertEquals(new RGBColor(expected, expected, expected), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(expected, expected, expected), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double AbsOfTestVal = Math.abs(testVal);
			assertEquals(new RGBColor(AbsOfTestVal, AbsOfTestVal, AbsOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(AbsOfTestVal, AbsOfTestVal, AbsOfTestVal), myTree.evaluate(testVal, testVal));
		}

	}

	@Test
	public void testSinEvaluation() {
		Sin myTree = new Sin(new X());

		assertEquals(new RGBColor(Math.sin(0.4), Math.sin(0.4), Math.sin(0.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.sin(0.999), Math.sin(0.999), Math.sin(0.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.sin(-0.7), Math.sin(-0.7), Math.sin(-0.7)), myTree.evaluate(-.7, -1));

		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double sinOfTestVal = Math.sin(testVal);
			assertEquals(new RGBColor(sinOfTestVal, sinOfTestVal, sinOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(sinOfTestVal, sinOfTestVal, sinOfTestVal), myTree.evaluate(testVal, testVal));
		}

	}

	@Test
	public void testWrapEvaluation() {
		Wrap myTree = new Wrap(new X());

		assertEquals(new RGBColor(-.5, -.5, -.5), myTree.evaluate(1.5, -1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(3.0, -1));
		assertEquals(new RGBColor(.5, .5, .5), myTree.evaluate(-1.5, -1));

		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}
		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double wrapOfTestVal = testVal;
			assertEquals(new RGBColor(wrapOfTestVal, wrapOfTestVal, wrapOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(wrapOfTestVal, wrapOfTestVal, wrapOfTestVal), myTree.evaluate(testVal, testVal));
		}

	}

	@Test
	public void testClampEvaluation() {
		Clamp myTree = new Clamp(new X());

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1.5, -1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(3.0, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1.5, -1));

		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}
		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double clampOfTestVal = testVal;
			assertEquals(new RGBColor(clampOfTestVal, clampOfTestVal, clampOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(clampOfTestVal, clampOfTestVal, clampOfTestVal),
					myTree.evaluate(testVal, testVal));
		}

	}

	@Test
	public void testImageWrapEvaluation() {
		Imagewrap myTree = new Imagewrap("tanx.jpg", new X(), new Y());
		assertEquals(new RGBColor(0.41960784313725497, 0.41960784313725497, 0.41960784313725497),
				myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(1.0, 1.0, 1.0), myTree.evaluate(4.999, -1));
		assertEquals(new RGBColor(-0.8509803921568627, -0.8509803921568627, -0.8509803921568627),
				myTree.evaluate(-4.7, -1));
	}

	@Test
	public void testAtanEvaluation() {
		Atan myTree = new Atan(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.atan(.4), Math.atan(.4), Math.atan(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.atan(.999), Math.atan(.999), Math.atan(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.atan(-.7), Math.atan(-.7), Math.atan(-.7)), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.atan(i), Math.atan(i), Math.atan(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.atan(i), Math.atan(i), Math.atan(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double tanOfTestVal = Math.atan(testVal);
			assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal), myTree.evaluate(testVal, testVal));
		}
	}
	
	@Test
	public void testExpEvaluation() {
		Exp myTree = new Exp(new X());

		// some straightforward tests
		assertEquals(new RGBColor(Math.exp(.4), Math.exp(.4), Math.exp(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.exp(.999), Math.exp(.999), Math.exp(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.exp(-.7), Math.exp(-.7), Math.exp(-.7)), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double expOfTestVal = Math.exp(testVal);
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(testVal, testVal));
		}

	}

	@Test
	public void testLogEvaluation() {
		Log myTree = new Log(new X());

		assertEquals(new RGBColor(Math.log(0.4), Math.log(0.4), Math.log(0.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.log(0.999), Math.log(0.999), Math.log(0.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.log(0.7), Math.log(0.7), Math.log(0.7)), myTree.evaluate(-.7, -1));

		for (int i = -1; i <= 1; i++) {
			double expectedVal = Math.log(Math.abs(i));
			RGBColor expected = new RGBColor(expectedVal, expectedVal, expectedVal);
			assertEquals(expected, myTree.evaluate(i, -i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double logOfTestVal = Math.log(Math.abs(testVal));
			RGBColor expected = new RGBColor(logOfTestVal, logOfTestVal, logOfTestVal);
			assertEquals(expected, myTree.evaluate(testVal, -1));

		}
	}

	@Test
	public void testExpEvaluation() {
		Exp myTree = new Exp(new X());

		assertEquals(new RGBColor(Math.exp(0.4), Math.exp(0.4), Math.exp(0.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.exp(0.999), Math.exp(0.999), Math.exp(0.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.exp(-0.7), Math.exp(-0.7), Math.exp(-0.7)), myTree.evaluate(-.7, -1));

		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double expOfTestVal = Math.exp(testVal);
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(testVal, testVal));
		}

	}
}
