package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.UnaryOperator;

public class UnaryExpression implements Expression{
	private final String name;	
	private UnaryOperator uniOperator;
	private Expression expLeft;
	
	
	public UnaryExpression(UnaryOperator operator, Expression operand) {
		this.name = "(" + operator.toString() + operand.toString() + ")";
		this.uniOperator = operator;
		this.expLeft = operand;
	}
	

	@Override
	public double eval() {
		return this.uniOperator.apply(this.expLeft.eval());
	}

	@Override
	public String toString() {
		return this.name;
	}
}
