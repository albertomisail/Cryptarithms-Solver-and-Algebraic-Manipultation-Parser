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
	
	
	/*private int iterator = 0;
	private int it2 = 0;
	private Map<Object, Integer> map;
	private int size;
	private int[] arr;
	private List<int[]> allPerms;

	/**
	 * 
	 * @param Collection
	 *//*
	public Permutation(String s) {
		int length = s.length();
		int j = 0;
		map = new HashMap<Object, Integer>();
		for (int i = 0; i < length; i++) {
			if (!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), j++);
		}
		size = map.size();
		arr = new int[size];
		for (int i : map.values())
			arr[i] = i;
		allPerms = new LinkedList<int[]>();
	}

	// you may need more here
	
	@Override
	public int[] getOnePermutation() {
		it2++;
		return allPerms.get(iterator);
	}

	/*
	 * // heap's algorithm //referenced:
	 * http://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
	 * void heapPermutation(int size) { if (size == 1) { allPerms.add(arr);
	 * System.out.println(arr); }
	 * 
	 * for (int i = 0; i < size; i++) { heapPermutation(size - 1);
	 * 
	 * // if size is odd, swap first and last // element if (size % 2 == 1) { int
	 * temp = arr[0]; arr[0] = arr[size - 1]; arr[size - 1] = temp; }
	 * 
	 * // If size is even, swap ith and last // element else { int temp = arr[i];
	 * arr[i] = arr[size - 1]; arr[size - 1] = temp; } } }
	 */
	// Prints the array
	/*
	void printArr(int a[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	// WILL NEED TO CHANGE HEAP PERMUTATION CODE LOTS AS IT IS MAINLY CODE FROM THIS
	// WEBSITE:
	// http://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
	// Generating permutation using Heap Algorithm
	void heapPermutation(int a[], int size, int n) {
		// if size becomes 1 then prints the obtained
		// permutation
		if (size == 1) {
			printArr(a, n);
			// new weird bug here... doesn't place a's next to each other.. leaves empty entries in allPerms.
			allPerms.add(iterator++, a);
			// original weird bug here.. **replaces first element of allPerms with a
			//allPerms.add(a);
		}

		for (int i = 0; i < size; i++) {
			heapPermutation(a, size - 1, n);

			// if size is odd, swap first and last
			// element
			if (size % 2 == 1) {
				int temp = a[0];
				a[0] = a[size - 1];
				a[size - 1] = temp;
			}

			// If size is even, swap ith and last
			// element
			else {
				int temp = a[i];
				a[i] = a[size - 1];
				a[size - 1] = temp;
			}
		}
	}

	int getSize() {
		return this.size;
	}

	int[] getArray() {
		return arr;
	}

	public static void main(String[] args) {
		String s = "abb";
		Permutation p = new Permutation(s);
		p.heapPermutation(p.getArray(), 2, 3);
	}*/

}
