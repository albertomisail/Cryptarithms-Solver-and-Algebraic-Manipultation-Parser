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
	
	public Permutation(T[] elementsArray) {
		this.elementsArray = elementsArray;
		this.allPermutations = new LinkedHashSet<T[]>();
		this.length = elementsArray.length;
	}
	
	public int getLength() {
		return length;
	}
	
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
