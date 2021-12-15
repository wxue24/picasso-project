package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.Variables;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.language.expressions.BinaryOperators.Addition;
import picasso.parser.language.expressions.MultiArgumentFunctions.ImageClip;
import picasso.parser.language.expressions.MultiArgumentFunctions.ImageWrap;
import picasso.parser.language.expressions.MultiArgumentFunctions.PerlinBW;
import picasso.parser.language.expressions.MultiArgumentFunctions.PerlinColor;
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
 * Tests of creating an expression tree from a string expression. Will have
 * compiler errors until some code is created.
 * 
 * @author Sara Sprenkle
 *   
 */
public class ParsedExpressionTreeTests {

	private ExpressionTreeGenerator parser;

	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
		Variables.getInstance().removeAll();
	}

	@Test
	public void constantExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("[1,-1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
	}

	@Test
	public void variableExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x");
		assertEquals(new X(), e);
	}

	@Test
	public void additionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x + y");
		assertEquals(new Addition(new X(), new Y()), e);

		// no spaces!
		e = parser.makeExpression("x+y");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Addition(new RGBColor(1, .3, -1), new Y()), e);

		e = parser.makeExpression("x + y + [ -.51, 0, 1]");
		assertEquals(new Addition(new Addition(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}

	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("( x + y )");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		assertEquals(new Addition(new X(), new Addition(new Y(), new RGBColor(1, 1, 1))), e);
	}

	@Test
	public void floorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("floor( x )");
		assertEquals(new Floor(new X()), e);

		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Floor(new Addition(new X(), new Y())), e);
	}

	@Test
	public void ceilFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("ceil( x )");
		assertEquals(new Ceil(new X()), e);

		e = parser.makeExpression("ceil( x + y)");
		assertEquals(new Ceil(new Addition(new X(), new Y())), e);

	}

	@Test
	public void absFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("abs( x )");
		assertEquals(new Abs(new X()), e);

		e = parser.makeExpression("abs( x + y )");
		assertEquals(new Abs(new Addition(new X(), new Y())), e);

	}

	@Test
	public void sinFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("sin( x )");
		assertEquals(new Sin(new X()), e);

		e = parser.makeExpression("sin( x + y )");
		assertEquals(new Sin(new Addition(new X(), new Y())), e);

	}

	@Test
	public void cosFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("cos( x )");
		assertEquals(new Cos(new X()), e);

		e = parser.makeExpression("cos( x + y )");
		assertEquals(new Cos(new Addition(new X(), new Y())), e);

	}

	@Test
	public void tanFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("tan( x )");
		assertEquals(new Tan(new X()), e);

		e = parser.makeExpression("tan( x + y )");
		assertEquals(new Tan(new Addition(new X(), new Y())), e);
	}

	@Test
	public void wrapFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("wrap( x )");
		assertEquals(new Wrap(new X()), e);

		e = parser.makeExpression("wrap ( x + y )");
		assertEquals(new Wrap(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void clampFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("clamp( x )");
		assertEquals(new Clamp(new X()), e);

		e = parser.makeExpression("clamp ( x + y )");
		assertEquals(new Clamp(new Addition(new X(), new Y())), e);
	}
 
	@Test
	public void variablesExpressionTests() {
		Variables.getInstance().addVariable("c = floor(x)");
		ExpressionTreeNode e = parser.makeExpression("c + [1,0,0]");
		assertEquals(new Addition(new Floor(new X()), new RGBColor(1, 0, 0)), e);

	} 

	@Test
	public void imageWrapFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("imageWrap(\"floorx.jpg\", x + x, y)");
		assertEquals(new ImageWrap("floorx.jpg", new Addition(new X(), new X()), new Y()), e);
	}
	
	@Test
	public void imageClipFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("imageClip(\"floorx.jpg\", x + x, y)");
		assertEquals(new ImageClip("floorx.jpg", new Addition(new X(), new X()), new Y()), e);
	}
	
	@Test
	public void perlinColorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("perlinColor(x, y)");
		assertEquals(new PerlinColor(new X(), new Y()), e);
		
		e = parser.makeExpression("perlinColor(x, x+x)");
		assertEquals(new PerlinColor(new X(), new Addition(new X(), new X())), e);
	}
	
	@Test
	public void perlinBWFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("perlinBW(x, y)");
		assertEquals(new PerlinBW(new X(), new Y()), e);
		
		e = parser.makeExpression("perlinBW(x, x+x)");
		assertEquals(new PerlinBW(new X(), new Addition(new X(), new X())), e);
	}
	
	@Test
	public void atanFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("atan( x )");
		assertEquals(new Atan(new X()), e);

		e = parser.makeExpression("atan( x + y )");
		assertEquals(new Atan(new Addition(new X(), new Y())), e);

	}

	@Test
	public void expFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("exp( x )");
		assertEquals(new Exp(new X()), e);

		e = parser.makeExpression("exp( x + y )");
		assertEquals(new Exp(new Addition(new X(), new Y())), e);

	}

	@Test
	public void logFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("log( x )");
		assertEquals(new Log(new X()), e);

		e = parser.makeExpression("log( x + y )");
		assertEquals(new Log(new Addition(new X(), new Y())), e);
	}
}