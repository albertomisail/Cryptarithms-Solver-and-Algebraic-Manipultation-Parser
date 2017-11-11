package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.Addition;
import ca.ubc.ece.cpen221.mp4.operator.Multiplication;

public class NewtonsMethod {
	public static double NewtonsMethod(Expression function, VariableExpression x, double approxZero, double tolerance) {
		final double initialxval = x.eval();
		double betterAprox = approxZero;
		x.store(betterAprox);
		while(Math.abs(function.eval())>Math.abs(tolerance)) {
			double f_x_i = function.eval();
			Expression derivative = new DerivativeExpression(function, x);
			double df_x_i = derivative.eval();
			betterAprox = betterAprox - f_x_i/df_x_i;
			x.store(betterAprox);
		}
		x.store(initialxval);
		return betterAprox;
	}
}