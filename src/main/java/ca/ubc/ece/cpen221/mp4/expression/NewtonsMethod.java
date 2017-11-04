package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.Addition;
import ca.ubc.ece.cpen221.mp4.operator.Multiplication;

public class NewtonsMethod {
	public static double NewtonsMethod(Expression fn, VariableExpression x, double approxZero, double tolerance) {
		double initialxval = x.eval();
		double betterAprox = approxZero;
		do {
			x.store(betterAprox);
			double f = fn.eval();
			Expression derivative = new DerivativeExpression(fn, x);
			double fprime = derivative.eval();
			betterAprox = betterAprox - f*fprime;
		}while(Math.abs(betterAprox)<=Math.abs(tolerance));
		x.store(initialxval);
		return betterAprox;
	}
	public static void main(String[] args) {
		VariableExpression x = new VariableExpression("x");
		x.store(4);
		NonVariableExpression y = new NonVariableExpression(2);
		
		Expression f1 = new NonVariableExpression(new Addition(), x, y);
		Expression f2 = new NonVariableExpression(new Multiplication(), x, x);
		
		System.out.println("Approximations are:" + NewtonsMethod(f1, x, 5, 0.0001 ) + " " + NewtonsMethod(f2, x, 3, 0.0001) + " " );
	}
}