package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.expression.*;
import ca.ubc.ece.cpen221.mp4.operator.*;

public class DerivativeTest {
	@Test
	public void test0() {
		VariableExpression x = new VariableExpression("x");
		x.store(4);
		GeneralExpression y = new GeneralExpression(2);
		
		Expression e1 = new GeneralExpression(new Addition(), x, y);
		Expression e2 = new GeneralExpression(new Multiplication(), x, x);
		DerivativeExpression d1 = new DerivativeExpression(e1, x);
		DerivativeExpression d2 = new DerivativeExpression(e2, x);
		assertEquals(0,(int)Math.abs(d1.eval()-1));
		assertEquals(0,(int)Math.abs(d2.eval()-8));
	}
	
	@Test
	public void test1() {
		VariableExpression x = new VariableExpression("x");
		x.store(4);
		Expression e = new GeneralExpression(new Multiplication(), x, x);
		DerivativeExpression d = new DerivativeExpression(e, x);
		DerivativeExpression d2 = new DerivativeExpression(d, x);
		assertEquals(0,(int)Math.abs(d.eval()-8));
		assertEquals(0, (int)Math.abs(d2.eval()-2));
	}
}
