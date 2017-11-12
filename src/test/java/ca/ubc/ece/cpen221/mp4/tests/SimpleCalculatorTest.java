package ca.ubc.ece.cpen221.mp4.tests;


import static org.junit.Assert.*;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.expression.*;
import ca.ubc.ece.cpen221.mp4.operator.*;

// TODO you will need to import other packages that has code to test

public class SimpleCalculatorTest {

	// TODO Add more tests

	@Test
	public void test0() {
		Expression e = new GeneralExpression(-5);
		Expression e2 = new GeneralExpression(10);
		UnaryOperator abs = new AbsoluteValue();
		UnaryOperator neg = new Negation();
		BinaryOperator sum = new Addition();
		BinaryOperator sub = new Subtraction();
		BinaryOperator times = new Multiplication();
		BinaryOperator div = new Division();
		BinaryOperator exp = new Exponentiation();
		Expression a = new GeneralExpression(abs,e);
		Expression b = new GeneralExpression(neg, e2);
		Expression c = new GeneralExpression(sum, e, e2);
		Expression d = new GeneralExpression(sub, e, e2);
		Expression f = new GeneralExpression(times, e, e2);
		Expression g = new GeneralExpression(div, e2, e);
		Expression h = new GeneralExpression(exp, e2, a);
		assertEquals("10.0",e2.toString());
		assertEquals(5,(int)a.eval());
		assertEquals(-10,(int)b.eval());
		assertEquals(5, (int)c.eval());
		assertEquals(-15, (int)d.eval());
		assertEquals(-50, (int)f.eval());
		assertEquals(-2, (int)g.eval());
		assertEquals(100000, (int)h.eval());
	}

}