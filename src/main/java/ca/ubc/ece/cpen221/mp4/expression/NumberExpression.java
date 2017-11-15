package ca.ubc.ece.cpen221.mp4.expression;

public class NumberExpression implements Expression{
	private final double value;
	
	public NumberExpression(double value) {
		this.value = value;
	}
	
	public double eval() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return ""+this.value;
	}
}
