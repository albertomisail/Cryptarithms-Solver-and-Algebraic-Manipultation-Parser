package ca.ubc.ece.cpen221.mp4.operator;

public class AbsoluteValue implements UnaryOperator{
	public double apply(double a) {
		return Math.abs(a);
	}
	
	public String toString() {
		return "abs";
	}
}
