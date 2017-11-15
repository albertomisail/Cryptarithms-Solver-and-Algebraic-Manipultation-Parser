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
		Expression e = new NumberExpression(-5);
		Expression e2 = new NumberExpression(10);
		UnaryOperator abs = new AbsoluteValue();
		UnaryOperator neg = new Negation();
		BinaryOperator sum = new Addition();
		BinaryOperator sub = new Subtraction();
		BinaryOperator times = new Multiplication();
		BinaryOperator div = new Division();
		BinaryOperator exp = new Exponentiation();
		Expression a = new UnaryExpression(abs,e);
		Expression b = new UnaryExpression(neg, e2);
		Expression c = new BinaryExpression(sum, e, e2);
		Expression d = new BinaryExpression(sub, e, e2);
		Expression f = new BinaryExpression(times, e, e2);
		Expression g = new BinaryExpression(div, e2, e);
		Expression h = new BinaryExpression(exp, e2, a);
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