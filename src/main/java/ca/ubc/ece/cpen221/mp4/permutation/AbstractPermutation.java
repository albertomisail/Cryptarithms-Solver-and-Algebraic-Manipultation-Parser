package ca.ubc.ece.cpen221.mp4.permutation;

/**
 * Abstract Permutation - an interface
 *
 * @param <T>
 *            generic Array
 */
public interface AbstractPermutation<T> {

	// Here T denotes the type of values in the array that we want to permute
	// We are using Java Generics
	// It is enough to use T to denote the type for the permutation task
	// and you can read more about generics here: 
	// https://docs.oracle.com/javase/tutorial/java/generics/index.html

	/**
	 * get one permutation.
	 * 
	 * @return one generic Array of permutation.
	 */
	T[] getOnePermutation();

}
