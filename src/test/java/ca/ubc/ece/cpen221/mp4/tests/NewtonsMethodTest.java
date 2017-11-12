package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.expression.*;
import ca.ubc.ece.cpen221.mp4.operator.*;

public class NewtonsMethodTest {
	@Test
	public void test0() {
		VariableExpression x = new VariableExpression("x");
		x.store(4);
		GeneralExpression y = new GeneralExpression(2);
		
		Expression f1 = new GeneralExpression(new Addition(), x, y);
		Expression f2 = new GeneralExpression(new Multiplication(), x, x);
		double a = NewtonsMethod(f1, x, 5, 0.0001 );
		double b = NewtonsMethod(f2, x, 0.5, 0.0001);
		
		System.out.println("Approximations are:" + NewtonsMethod(f1, x, 5, 0.0001 ) + " " + NewtonsMethod(f2, x, 0.5, 0.0001) + " " );
	}
}
