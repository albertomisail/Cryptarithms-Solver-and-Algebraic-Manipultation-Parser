package ca.ubc.ece.cpen221.mp4.permutation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// add class overview

public class Permutation<T> implements AbstractPermutation<T> {
	
	private T[] elementsArray;
	private List<T[]> allPermutations;
	private int counter;
	private int numberOfPerms;
	
	public Permutation(T[] elementsArray) {
		this.elementsArray = elementsArray;
		this.allPermutations = new ArrayList<T[]>();
		this.counter = 0;
		this.numberOfPerms = 0;
		//maybe shouldnt be here
		this.generateAllPermutations(elementsArray.length);
	}
	
	private void generateAllPermutations(int counter) {
		if(counter == 1) {
			@SuppressWarnings("unchecked")
			T[] auxiliary = (T[]) Array.newInstance(elementsArray.getClass().getComponentType(), elementsArray.length);
			copyArray(elementsArray, auxiliary);
			this.allPermutations.add(auxiliary);
			this.numberOfPerms++;
			printArr(auxiliary);
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
	}
	
	private void copyArray(T[] origin, T[] destiny) {
		for(int i = 0; i < origin.length; i++) {
			destiny[i] = origin[i];
		}
	}
	
	@Override
	public T[] getOnePermutation() {
		this.counter++;
		printArr(this.allPermutations.get(counter%this.numberOfPerms));
		return this.allPermutations.get(counter%this.numberOfPerms);
	}
	
	public void printArr(T[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Integer[] arr = {0, 1,2};
		Permutation<Integer> perms = new Permutation<Integer>(arr);
		System.out.println("done with all the perms :)");
		for(int i = 0; i < 12; i++) {
			perms.getOnePermutation();
		}
		String[] arr2 = {"ab","cd","ef"};
		Permutation<String> perms2 = new Permutation<String>(arr2);
	}
}
