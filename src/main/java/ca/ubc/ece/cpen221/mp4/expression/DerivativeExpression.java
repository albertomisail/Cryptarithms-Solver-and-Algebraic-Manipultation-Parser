package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.Addition;
import ca.ubc.ece.cpen221.mp4.operator.Multiplication;

/**
 * DerivativeExpression - The derivative of specific function.
 *
 */
public class DerivativeExpression implements Expression {
<<<<<<< HEAD
	
	
=======
	static final double DELTA_X = 1e-9;
	private Expression fn;
	private VariableExpression independentVar;
		
>>>>>>> 29ffe8453d3818448b545b2bdcfc1fb1105a8ce8
	/**
	 * Create an expression representing the derivative of the specified
	 * function with respect to the specified variable.
	 * 
	 * @param fn the function whose derivative this expression represents
	 * @param independentVar the variable with respect to which we're
	 * 		  differentiating
	 */
	public DerivativeExpression(Expression fn, 
					VariableExpression independentVar) {
		this.fn = fn;
		this.independentVar = independentVar;
		
	}

	@Override
	public double eval() {
<<<<<<< HEAD
		// TODO implement this method
		
		return 0; // change this
=======
				
		double fx = fn.eval();
		independentVar.store(independentVar.eval()+DELTA_X);
		double fxh = fn.eval();
		return (fxh - fx)/DELTA_X;
		
	}
	
	public static void main(String[] args) {
		VariableExpression x = new VariableExpression("x");
		x.store(4);
		NonVariableExpression y = new NonVariableExpression(2);
		
		Expression e1 = new NonVariableExpression(new Addition(), x, y);
		Expression e2 = new NonVariableExpression(new Multiplication(), x, x);
		DerivativeExpression d1 = new DerivativeExpression(e1, x);
		DerivativeExpression d3 = new DerivativeExpression(e2, x);
		
		System.out.println("Values are:" + d1.eval() + " " + d3.eval() + " " );
	
>>>>>>> 29ffe8453d3818448b545b2bdcfc1fb1105a8ce8
	}
	
	/**
	* Returns a zero of the specified function using
	* Newton’s method with approxZero as the initial estimate.
	*
	* @param fn the function whose zero is to be found
	* @param x the independent variable of the function
	* @param approxZero initial approximation for the
	* zero of the function
	* @param tolerance how close zero the returned
	* zero has to be
	*/
	

}
