package ca.ubc.ece.cpen221.mp4.operator;

public class AbsoluteValue {
	private final double arg1;
	
	public AbsoluteValue(double arg1) {
		this.arg1 = arg1;
	}
	
	public double apply(double a) {
		return Math.abs(a);
	}

	public double getArg1() {
		return arg1;
	}
	
	public double apply() {
		return Math.abs(arg1);
	}
	
	public String toString() {
		return "|" + this.arg1 + "|";
	}
}
