package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.Addition;
import ca.ubc.ece.cpen221.mp4.operator.Multiplication;

public class NewtonsMethod {
	/**
	 * Calculates approximately the roots of a function given a tolerance using Newton's method
	 * @param function the function for which we want to calculate the zeros
	 * @param x the variable for which the function is going to be differentiated
	 * @param approxZero a first guess of what the zero of the function is
	 * @param tolerance the tolerance for which the zero of the function wants to be calculated
	 * @return a value y such that |tolerance|>|f(y)|
	 * @throws NoZeroException if after Integer.MAX_VALUE-1 iterations a zero was not found
	 */
	public static double findZeros(Expression function, VariableExpression x, double approxZero, double tolerance) throws NoZeroException {
		int count = 0;
		final double initialxval = x.eval();
		double betterAprox = approxZero;
		x.store(betterAprox);
		while(Math.abs(function.eval())>Math.abs(tolerance)) {
			double f_x_i = function.eval();
			Expression derivative = new DerivativeExpression(function, x);
			double df_x_i = derivative.eval();
			betterAprox = betterAprox - f_x_i/df_x_i;
			x.store(betterAprox);
			count++;
			if(count>100000000) {
				x.store(initialxval);
				throw new NoZeroException();
			}
		}
		x.store(initialxval);
		return betterAprox;
	}
}