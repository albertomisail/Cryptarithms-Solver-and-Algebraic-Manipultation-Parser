package ca.ubc.ece.cpen221.mp4.parser;

import ca.ubc.ece.cpen221.mp4.expression.Expression;
import ca.ubc.ece.cpen221.mp4.expression.VariableExpression;
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
		// TODO implement this method
		String name = operand1.toString() + operator.toString() + operand2.toString();
		Expression result = new VariableExpression(name);
		return result;		
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
		String name = operator.toString() + operand.toString();
		Expression result = new VariableExpression(name);
		return result;
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
		String name = "" + value;
		Expression result = new VariableExpression(name);
		return result;
	}

}
