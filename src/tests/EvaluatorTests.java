/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

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
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
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

}
