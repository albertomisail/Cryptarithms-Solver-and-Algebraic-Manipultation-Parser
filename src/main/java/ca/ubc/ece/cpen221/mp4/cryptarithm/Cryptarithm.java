package ca.ubc.ece.cpen221.mp4.cryptarithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.ubc.ece.cpen221.mp4.expression.Expression;
import ca.ubc.ece.cpen221.mp4.expression.NonVariableExpression;
import ca.ubc.ece.cpen221.mp4.expression.VariableExpression;
import ca.ubc.ece.cpen221.mp4.expression.WordExpression;
import ca.ubc.ece.cpen221.mp4.operator.*;
import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp4.permutation.Permutation;

/**
 * Cryptarithm - a datatype that represents a cryptarithm
 *
 */
public class Cryptarithm {
	private Map<Character, VariableExpression> variableExpressions;
	private Map<Integer, VariableExpression> variables;
	private List<WordExpression> wordsLeft;
	private List<WordExpression> wordsRight;
	private List<String> operatorsLeft;
	private List<String> operatorsRight;

	private static final Set<String> operators = new LinkedHashSet<String>(Arrays.asList("+", "-", "*", "/"));
	private static final Set<Integer> digits = new LinkedHashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

	/**
	 * Cryptarithm constructor
	 * 
	 * @param cryptarithm
	 *            where each element is a String that represents part of the
	 *            cryptarithm
	 */
	public Cryptarithm(String[] cryptarithm) {
		// TODO implement this constructor
		this.operatorsLeft = new ArrayList<String>();
		this.operatorsRight = new ArrayList<String>();
		this.wordsLeft = new ArrayList<WordExpression>();
		this.wordsRight = new ArrayList<WordExpression>();
		this.variables = new LinkedHashMap<Integer, VariableExpression>();
		this.variableExpressions = new LinkedHashMap<Character, VariableExpression>();

		boolean equals = false;
		for (String word : cryptarithm) {
			if (word.equals("=")) {
				equals = true;
			} else {
				if (equals) {
					if (operators.contains(word)) {
						operatorsRight.add(word);
					} else {
						// wordsRight.add(word);
						for (int i = 0; i < word.length(); i++) {
							VariableExpression variable = new VariableExpression(word.charAt(i) + "");
							if (!variables.containsValue(variable)) {
								variables.put(variables.size(), variable);
								variableExpressions.put(word.charAt(i), variable);
							}
						}
						wordsRight.add(new WordExpression(word, variableExpressions));
					}
				} else {
					if (operators.contains(word)) {
						operatorsLeft.add(word);
					} else {
						// wordsLeft.add(word);
						for (int i = 0; i < word.length(); i++) {
							VariableExpression variable = new VariableExpression(word.charAt(i) + "");
							if (!variables.containsValue(variable)) {
								variables.put(variables.size(), variable);
								variableExpressions.put(word.charAt(i), variable);
							}
						}
						wordsRight.add(new WordExpression(word, variableExpressions));
					}
				}
			}
		}
	}

	/**
	 * Find solutions to the cryptarithm
	 * 
	 * @return a list of all possible solutions to the given cryptarithm. A solution
	 *         is a map that provides the value for each alphabet in the
	 *         cryptarithm.
	 */
	public List<Map<Character, Integer>> solve() throws NoSolutionException {
		// TODO implement this method
		List<Map<Character, Integer>> result = new ArrayList<Map<Character, Integer>>();
		if (variables.size() > 10) {
			throw new NoSolutionException();
		}
		Set<Integer[]> digitSubset = Cryptarithm.generateSubsets(variables.size());
		for (Integer[] subset : digitSubset) {
			Permutation<Integer> permutation = new Permutation<Integer>(subset);
			for (int i = 0; i < permutation.getNumberOfPerms(); i++) {
				Integer[] onePermutation = permutation.getOnePermutation();
				assign(onePermutation);
				if (checkSol()) {
					result.add(generateMap(onePermutation));
				}
			}
		}
		if(result.size()==0) {
			throw new NoSolutionException();
		}
		return result;// change this
	}

	private void assign(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			variables.get(i).store(arr[i]);
		}
	}

	public Map<Character, Integer> generateMap(Integer[] values) {
		Map<Character, Integer> result = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < values.length; i++) {
			Character c = variables.get(i).name().charAt(0);
			result.put(c, values[i]);
		}
		return result;
	}

	private boolean checkSol() {
		if(evaluate(wordsLeft, operatorsLeft)==evaluate(wordsRight, operatorsRight)&&noZeroFirst(wordsLeft)&&
				noZeroFirst(wordsRight)) {
			return true;
		}
		return false;
	}

	private boolean noZeroFirst(List<WordExpression> words) {
		for(WordExpression word : words) {
			if(word.getLetters().get(0).eval()==0) {
				return false;
			}
		}
		return true;
	}
	
	public static double evaluate(List<WordExpression> words, List<String> operators) {
		Expression aux = new NonVariableExpression(words.get(0).eval());
		for (int i = 0; i < operators.size(); i++) {
			BinaryOperator bin = recognize(operators.get(i));
			double computation = bin.apply(aux.eval(), words.get(i + 1).eval());
			aux = new NonVariableExpression(computation);
		}
		return aux.eval();
	}

	public static BinaryOperator recognize(String operator) {
		if (operator.equals("+")) {
			return new Addition();
		} else if (operator.equals("*")) {
			return new Multiplication();
		} else if (operator.equals("-")) {
			return new Subtraction();
		} else {
			return new Division();
		}
	}
	// this works fine

	public static Set<Integer[]> generateSubsets(int k) {
		Set<Integer[]> result = new LinkedHashSet<Integer[]>();
		for (int bitVec = 0; bitVec < 1 << 10; bitVec++) {
			if (Integer.bitCount(bitVec) == k) {
				Integer[] subset = new Integer[k];
				int aux = bitVec;
				int index = 0;
				int number = 0;
				while (aux >= 1) {
					if (aux % 2 == 1) {
						subset[index] = number;
						index++;
					}
					number++;
					aux /= 2;
				}
				result.add(subset);
			}
		}
		return result;
	}

	public static void printArr(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		
	}

	// You will need more methods
}
