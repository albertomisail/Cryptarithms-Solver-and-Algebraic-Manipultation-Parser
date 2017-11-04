package ca.ubc.ece.cpen221.mp4.expression;

public class NewtonMethod {
	public static double newtonsMethod(Expression fn, VariableExpression x, double approxZero, double tolerance) {
		double betterAprox = approxZero;
		do {
			x.store(betterAprox);
			double f = fn.eval();
			Expression derivative = new DerivativeExpression(fn, x);
			double fprime = derivative.eval();
			betterAprox = betterAprox - f*fprime;
		}while(Math.abs(betterAprox)<=Math.abs(tolerance));
		return betterAprox;
	}
}
