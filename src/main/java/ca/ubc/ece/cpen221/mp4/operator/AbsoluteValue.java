package ca.ubc.ece.cpen221.mp4.operator;

public class AbsoluteValue implements UnaryOperator{
	private double arg1;
	
	public double apply(double a) {
		return Math.abs(a);
	}
	
	public void setArg1(double a) {
		this.arg1 = a;
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
