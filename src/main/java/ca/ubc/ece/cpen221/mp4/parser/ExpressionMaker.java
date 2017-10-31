package ca.ubc.ece.cpen221.mp4.parser;

import ca.ubc.ece.cpen221.mp4.expression.Expression;
import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp4.operator.UnaryOperator;

/**
 * ExpressionMaker - a helper class for creating Expressions given various
 * Operators and Expressions
 * 
 */
public class ExpressionMaker {

	/**
	 * Creates a binary operation expression.
	 *
	 * @param operator
	 *            the operator
	 * @param operand1
	 *            the opperand1
	 * @param operand2
	 *            the opperand2
	 * @return the expression
	 */
	public Expression createBinaryOperationExpression(BinaryOperator operator, Expression operand1,
			Expression operand2) {
		return null;
		
	}

	/**
	 * Creates a unary operation expression.
	 *
	 * @param operator
	 *            the operator
	 * @param operand
	 *            the operand
	 * @return the expression
	 */
	public Expression createUnaryOperationExpression(UnaryOperator operator, Expression operand) {
		// TODO implement this method
		return null;
	}

	/**
	 * Creates a number expression.
	 *
	 * @param value
	 *            the value
	 * @return the expression
	 */
	public Expression createNumberExpression(double value) {
		// TODO implement this method
		return null;
	}

}
