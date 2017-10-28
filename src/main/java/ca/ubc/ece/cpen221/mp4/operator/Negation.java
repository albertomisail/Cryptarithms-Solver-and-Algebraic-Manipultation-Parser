package ca.ubc.ece.cpen221.mp4.operator;

public class Negation {
	private final double arg1;
	
	public Negation(double arg1) {
		this.arg1 = arg1;
	}
	
	public double apply(double a) {
		return -a;
	}

	public double getArg1() {
		return arg1;
	}
	
	public double apply() {
		return -this.arg1;
	}
	
	public String toString() {
		return "-" + this.arg1;
	}
}
