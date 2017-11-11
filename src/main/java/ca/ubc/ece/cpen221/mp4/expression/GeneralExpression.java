package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp4.operator.UnaryOperator;

public class GeneralExpression implements Expression{
	private final String name;
	private double value;
	
	private UnaryOperator uniOperator;
	private BinaryOperator binOperator;
	private Expression expLeft;
	private Expression expRight;
	
	public GeneralExpression(BinaryOperator operator, Expression operand1, Expression operand2) {
		this.name = "(" + operand1.toString() + operator.toString() + operand2.toString() + ")";
		this.expLeft = operand1;
		this.expRight = operand2;
		this.binOperator = operator;
	}
	
	public GeneralExpression(UnaryOperator operator, Expression operand) {
		this.name = "(" + operator.toString() + operand.toString() + ")";
		this.uniOperator = operator;
		this.expLeft = operand;
	}
	
	public GeneralExpression(double value) {
		this.name = "" + value;
		this.store(value);
	}
	
	@Override
	public double eval() {
		// TODO implement this method
		if(this.expLeft==null) {
			return this.value;
		}
		else if(this.expRight==null) {
			return this.uniOperator.apply(this.expLeft.eval());
		}
		else {
			return this.binOperator.apply(this.expLeft.eval(), this.expRight.eval());
		}
	}

	@Override
	public String toString() {
		return this.name;
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
