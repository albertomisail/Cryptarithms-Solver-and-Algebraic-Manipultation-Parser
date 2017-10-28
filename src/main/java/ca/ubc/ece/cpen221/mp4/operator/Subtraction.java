package ca.ubc.ece.cpen221.mp4.operator;

public class Subtraction {
	private final double arg1;
	private final double arg2;
	
	public Subtraction(double arg1, double arg2) {
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	public double apply(double a, double b) {
		return a - b;
	}

	public double getArg1() {
		return arg1;
	}

	public double getArg2() {
		return arg2;
	}
	
	public double apply() {
		return this.arg1 - this.arg2;
	}
	
	public String toString() {
		return this.arg1 + "-" + this.arg2;
	}
}
