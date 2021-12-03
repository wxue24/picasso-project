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
		
		double[] tests = {-.7, -.00001, .000001, .5};
		
		for( double testVal : tests) {
			double cosOfTestVal = Math.cos(testVal);
			assertEquals( new RGBColor(cosOfTestVal, cosOfTestVal, cosOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals( new RGBColor(cosOfTestVal, cosOfTestVal, cosOfTestVal), myTree.evaluate(testVal, testVal));
		}
	}

	// TODO: More tests of evaluation

}
