package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.Addition;
import ca.ubc.ece.cpen221.mp4.operator.Multiplication;

/**
 * DerivativeExpression - The derivative of specific function.
 *
 */
public class DerivativeExpression implements Expression {

	static final double DELTA_X = 1e-9;
	private Expression fn;
	private VariableExpression independentVar;
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
		double fx = fn.eval();
		independentVar.store(independentVar.eval()+DELTA_X);
		double fxh = fn.eval();
		//restores original variable value
		independentVar.store(independentVar.eval() - DELTA_X);
		return (fxh - fx)/DELTA_X;	
	}
}
