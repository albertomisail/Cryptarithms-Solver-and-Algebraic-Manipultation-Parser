package ca.ubc.ece.cpen221.mp4.parser;

import ca.ubc.ece.cpen221.mp4.expression.Expression;
import ca.ubc.ece.cpen221.mp4.expression.NonVariableExpression;
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
		Expression result = new NonVariableExpression(operator, operand1, operand2);
		//Expression result = new VariableExpression(operator, operand1, operand2);
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
		Expression result = new NonVariableExpression(operator, operand);
		//Expression result = new VariableExpression(operator, operand);
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
		Expression result = new NonVariableExpression(value);
		//Expression result = new VariableExpression(value);
		return result;
	}

}
