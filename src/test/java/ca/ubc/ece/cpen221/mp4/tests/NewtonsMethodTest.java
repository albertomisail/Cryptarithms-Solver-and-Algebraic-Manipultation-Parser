package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.expression.*;
import ca.ubc.ece.cpen221.mp4.operator.*;

public class NewtonsMethodTest {
	@Test
	public void test0() throws NoZeroException {
		VariableExpression x = new VariableExpression("x");
		x.store(4);
		Expression y = new NumberExpression(2);
		
		Expression f1 = new BinaryExpression(new Addition(), x, y);
		Expression f2 = new BinaryExpression(new Multiplication(), x, x);
		double a = NewtonsMethod.findZeros(f1, x, -300.0, -0.0001 );
		double b = NewtonsMethod.findZeros(f2, x, 500.0, 0.0001);
		
		assertEquals(0, (int)(Math.abs(a+2)));
		assertEquals(0, (int)(Math.abs(b)));
	}
	
	@Test(expected = NoZeroException.class)
	public void test1() throws NoZeroException{
		VariableExpression x = new VariableExpression("x");
		x.store(4);
		Expression f2 = new BinaryExpression(new Multiplication(), x, x);
		Expression y = new NumberExpression(2);
		Expression f1 = new BinaryExpression(new Addition(), f2, y);
		double a = NewtonsMethod.findZeros(f1, x, 5.0, -0.0001 );
	}
}
