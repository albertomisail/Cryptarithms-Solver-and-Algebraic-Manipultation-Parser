package ca.ubc.ece.cpen221.mp4.expression;

import java.util.Stack;

import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp4.operator.Operator;
import ca.ubc.ece.cpen221.mp4.operator.UnaryOperator;

/**
 * An expression that represents a variable. Its value may be set as well as
 * read. Unlike other expressions in this assignment, variables are mutable.
 * Using a variable within a containing expression makes the expression a
 * function of the current value of the variable.
 *
 * <p>
 * Variables have immutable string names, which are used in their string
 * representations. If an expression contains multiple distinct variables as
 * subexpressions, it's important that they have different names, or the string
 * representation of the containing expression will be misleading.
 */
public class VariableExpression implements Expression {

	private final String name;
	private double value;
	
	
	/*private UnaryOperator uniOperator;
	private BinaryOperator binOperator;
	private Expression expLeft;
	private Expression expRight;*/

	/**
	 * Constructs a variable with the specified name, whose initial value is
	 * zero.
	 * 
	 * @param name
	 *            the name of the variable
	 */
	public VariableExpression(String name) {
		this.name = name;
		this.value = 0;
	}
	
	/*public VariableExpression(BinaryOperator operator, Expression operand1, Expression operand2) {
		this.name = operand1.toString() + operator.toString() + operand2.toString();
		this.expLeft = operand1;
		this.expRight = operand2;
		this.binOperator = operator;
	}
	
	public VariableExpression(UnaryOperator operator, Expression operand) {
		this.name = operator.toString() + operand.toString();
		this.uniOperator = operator;
		this.expLeft = operand;
	}
	
	public VariableExpression(double value) {
		this.name = "" + value;
		this.store(value);
	}
	
	public VariableExpression(char c) {
		this.name = "" + c;
	}*/
	
	@Override
	/**
	 * Evaluates an arithmetic expression.
	 * 
	 * @return the value to which this expression evaluates
	 */
	public double eval() {

		// TODO implement this method
		return value;
		/*if(this.expLeft==null) {
			return this.variable;
		}
		else if(this.expRight==null) {
			return this.uniOperator.apply(this.expLeft.eval());
		}
		else {
			return this.binOperator.apply(this.expLeft.eval(), this.expRight.eval());
		}*/
	}

	@Override
	public String toString() {
		return "(" + name + ")"; 
	}

	/**
	 * Sets the value of this variable.
	 * 
	 * @param value
	 *            the new value of this variable
	 */
	public void store(double value) {
		this.value = value;
	}

	/**
	 * Returns the name of this variable
	 * 
	 * @return the name of the variable
	 */
	public String name() {
		return name;
	}
}
