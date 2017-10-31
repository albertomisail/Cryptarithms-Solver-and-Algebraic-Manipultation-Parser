package ca.ubc.ece.cpen221.mp4.operator;

public class Negation implements UnaryOperator{
	
	public double apply(double a) {
		return -a;
	}
	
	public String toString() {
		return " -x ";
	}
}
