package ca.ubc.ece.cpen221.mp4.expression;

public class EmptyExpression implements Expression{
	private static boolean emptyExpressionInstantiated = false;
	private static EmptyExpression instantiatedExpression;
	
	private String name;
	private double value;
	
	public EmptyExpression() {
		this.name = "";
		this.value = 1;
	}
	
	public double eval() {
		return value;
	}
	
	public static EmptyExpression getEmptyExpression() {
		if(!emptyExpressionInstantiated) {
			emptyExpressionInstantiated = true;
			instantiatedExpression = new EmptyExpression();
		}
		return instantiatedExpression;
	}
}
