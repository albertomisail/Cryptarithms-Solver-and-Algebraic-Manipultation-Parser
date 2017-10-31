package ca.ubc.ece.cpen221.mp4.operator;

public class Exponentiation implements BinaryOperator {
	public double apply(double a, double b) {
		return Math.pow(a, b);
	}
	public String toString() {
		return " ^ ";
	}
}
