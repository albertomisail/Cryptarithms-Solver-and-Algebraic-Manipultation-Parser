package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;

public class BinaryExpression implements Expression{
	private final String name;
	private BinaryOperator binOperator;
	private Expression expLeft;
	private Expression expRight;
	
	public BinaryExpression(BinaryOperator operator, Expression operand1, Expression operand2) {
		this.name = "(" + operand1.toString() + operator.toString() + operand2.toString() + ")";
		this.expLeft = operand1;
		this.expRight = operand2;
		this.binOperator = operator;
	}
	
	@Override
	public double eval() {
			return this.binOperator.apply(this.expLeft.eval(), this.expRight.eval());
	}

	@Override
	public String toString() {
		return this.name;
	}
}
