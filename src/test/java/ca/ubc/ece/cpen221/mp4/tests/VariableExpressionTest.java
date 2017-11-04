package ca.ubc.ece.cpen221.mp4.tests;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.expression.*;
import ca.ubc.ece.cpen221.mp4.operator.*;

public class VariableExpressionTest {
	@Test
	public void test1() {
		String var = "x";
		VariableExpression x = new VariableExpression(var);
		Expression two = new NonVariableExpression(2);
		for(int i = 0; i <= 5; i++) {
			x.store(i);
			Expression xx = new NonVariableExpression(new Multiplication(), x, x);
			Expression xx2 = new NonVariableExpression(new Subtraction(), xx, two);
			System.out.println(i);
			System.out.println(xx2);
			System.out.println(xx2.eval());
		}
	}
}
