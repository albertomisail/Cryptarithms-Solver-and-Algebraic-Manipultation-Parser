package ca.ubc.ece.cpen221.mp4.permutation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// add class overview

public class Permutation<T> implements AbstractPermutation<T> {
	
	private T[] elementsArray;
	private Set<T[]> allPermutations;
	private int length;
	/**
	 * Construct a new generic permutation
	 * @param elementsArray the array for which its elements is wanted to be permutated
	 */
	public Permutation(T[] elementsArray) {
		this.elementsArray = elementsArray;
		this.allPermutations = new LinkedHashSet<T[]>();
		this.length = elementsArray.length;
	}
	
	/**
	 * 
	 * @return the number of elements in elementsArray
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Generate all permutations using heap's algorithm
	 * @param counter the position for which all the elements in the array of elements array are going to be permutated
	 * @return a set x of arrays of type T
	 *  		if e is in x then the elements in e are a permutation of the elements in elementsArray
	 * 			if the elements in any array e are a permutation of the elements in elementsArray, then e is part of x
	 */
	public Set<T[]> generateAllPermutations(int counter) {
		if(counter == 1) {
			@SuppressWarnings("unchecked")
			T[] auxiliary = (T[]) Array.newInstance(elementsArray.getClass().getComponentType(), elementsArray.length);
			copyArray(elementsArray, auxiliary);
			this.allPermutations.add(auxiliary);
		}
		
		for(int i = 0; i < counter; i++) {
			generateAllPermutations(counter-1);
			if(counter%2==1) {
				T temporary = elementsArray[0];
				elementsArray[0] = elementsArray[counter-1];
				elementsArray[counter-1] = temporary;
			}
			else {
				T temporary = elementsArray[i];
				elementsArray[i] = elementsArray[counter-1];
				elementsArray[counter-1] = temporary;
			}
		}
		return allPermutations;
	}
	
	/**
	 * Clones the values from an array origin to another array destiny
	 * @param origin the array of values that we want to clone
	 * @param destiny the array in which we are going to store the values of origin
	 */
	private void copyArray(T[] origin, T[] destiny) {
		for(int i = 0; i < origin.length; i++) {
			destiny[i] = origin[i];
		}
	}
	
	@Override
	public T[] getOnePermutation() {
		
		T[] result = elementsArray;
		List<T> auxiliary = Arrays.asList(elementsArray);
		Collections.shuffle(auxiliary);
		for(int i = 0; i < elementsArray.length; i++) {
			result[i] = auxiliary.get(i);
		}
		return result;
	}
}
