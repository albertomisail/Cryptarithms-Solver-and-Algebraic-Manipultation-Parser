package ca.ubc.ece.cpen221.mp4.expression;

/**
 * An expression that represents a variable. Its value may be set as well as
 * read. Unlike other expressions in this assignment, variables are mutable.
 * Using a variable within a containing expression makes the expression a
 * function of the current value of the variable.
 *
 * <p>
 * Variables have immutable string names, which are used in their string
 * representations. If an expression contains multiple distinct variables as
 * subexpressions, it's important that they have different names, or the string
 * representation of the containing expression will be misleading.
 */
public class VariableExpression implements Expression {
	private final String name;
	private double value;
	

	/**
	 * Constructs a variable with the specified name, whose initial value is
	 * zero.
	 * 
	 * @param name
	 *            the name of the variable
	 */
	public VariableExpression(String name) {
		this.name = name;
		this.value = 0;
	}
	
	@Override
	/**
	 * Evaluates an arithmetic expression.
	 * 
	 * @return the value to which this expression evaluates
	 */
	public double eval() {
		return value;
	}

	@Override
	/**
	 * Returns the name of this variable
	 * @return the name of the variable
	 */
	public String toString() {
		return name; 
	}

	/**
	 * Sets the value of this variable.
	 * 
	 * @param value
	 *            the new value of this variable
	 */
	public void store(double value) {
		this.value = value;
	}

	/**
	 * Returns the name of this variable
	 * 
	 * @return the name of the variable
	 */
	public String name() {
		return name;
	}
	
	@Override
	/**
	 * Compares another object with this variable for equality
	 * @return true if both objects are variable expressions with the same name
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof VariableExpression)) {
			return false;
		}
		VariableExpression other = (VariableExpression) obj;
		return this.name().equals(other.name());
	}
}
