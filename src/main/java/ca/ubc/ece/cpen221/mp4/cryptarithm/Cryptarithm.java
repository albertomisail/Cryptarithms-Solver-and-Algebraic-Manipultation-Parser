package ca.ubc.ece.cpen221.mp4.cryptarithm;

import java.util.ArrayList;
//<<<<<<< HEAD
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
//=======
//>>>>>>> 9a7ab7ce4a1a660043c109e9cc2cb6a1d626ca47
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.ubc.ece.cpen221.mp4.expression.Expression;
import ca.ubc.ece.cpen221.mp4.expression.GeneralExpression;
import ca.ubc.ece.cpen221.mp4.expression.VariableExpression;
import ca.ubc.ece.cpen221.mp4.expression.WordExpression;
import ca.ubc.ece.cpen221.mp4.operator.*;
import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp4.permutation.Permutation;

import ca.ubc.ece.cpen221.mp4.expression.GeneralExpression;
import ca.ubc.ece.cpen221.mp4.expression.VariableExpression;
import ca.ubc.ece.cpen221.mp4.operator.Addition;
import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp4.operator.Division;
import ca.ubc.ece.cpen221.mp4.operator.Multiplication;
import ca.ubc.ece.cpen221.mp4.operator.Subtraction;

/**
 * Cryptarithm - a data type that represents a cryptarithm
 * REP INVARIANT:
 * ADT:
 */
public class Cryptarithm {
	private GeneralExpression lhs;
	private GeneralExpression rhs;
	private List<VariableExpression> letters;
	private List<VariableExpression> firstLetters;
	private int numberOfLetters;

	/**
	 * Cryptarithm constructor
	 * 
	 * @param cryptarithm
	 *            where each element is a String that represents part of the
	 *            cryptarithm
	 * @throws InvalidCryptarithmException
	 */
	public Cryptarithm(String[] cryptarithm) throws InvalidCryptarithmException{
		if(!Arrays.asList(cryptarithm).contains("=")) {
			throw new InvalidCryptarithmException();
		}
		letters = new ArrayList<VariableExpression>();
		firstLetters = new ArrayList<VariableExpression>();
		numberOfLetters = 0;
		lhs = null;
		rhs = null;
		GeneralExpression word;
		BinaryOperator op = null;
		int i = 0;
		//if the cryptarithm is valid, each even indexed array entry should be a word
		//each odd entry should be an operator 
		for (i = 0; !cryptarithm[i].equals("="); i++) {
			if (i % 2 == 0) {
				word = wordConstructor(cryptarithm[i]);
				if (op == null)
					lhs = word;
				else
					lhs = new GeneralExpression(op, lhs, word);
			} else {
				op = (operationConstructor(cryptarithm[i]));
			}
		}
		op = null;
		for (i = i+1 ; i<cryptarithm.length; i++) {
			if (i % 2 == 0) {
				word = wordConstructor(cryptarithm[i]);
				if (op == null)
					rhs = word;
				else
					rhs = new GeneralExpression(op, rhs, word);
			} else {
				op = (operationConstructor(cryptarithm[i]));
			}
		}
		if(lhs==null||rhs==null) {
			throw new InvalidCryptarithmException();
		}
	}

	/**
	 * Reads a string and returns the corresponding binary operator
	 * 
	 * @param s
	 *            a String representing a valid operator, +, -, *, \
	 * @return a BinaryOperator represented by the string
	 * @throws InvalidCryptarithmException when s isn't valid (e.g. a non-approved operator, a misplaced word)
	 */
	private BinaryOperator operationConstructor(String s) throws InvalidCryptarithmException {
		BinaryOperator op = null;
		switch (s) {
		case "+":
			op = new Addition();
			break;
		case "-":
			op = new Subtraction();
			break;
		case "*":
			op = new Multiplication();
			break;
		case "/":
			op = new Division();
			break;
		case "=":
			break;
		default:
			throw new InvalidCryptarithmException();
		}
		return op;
	}

	/**
	 * PARSES WORDS
	 * 
	 * @param word
	 *            the word to parse
	 * @return a NonVariableExpression representing the word
	 */
	private GeneralExpression wordConstructor(String word) throws InvalidCryptarithmException{
		GeneralExpression parsedLetter;
		GeneralExpression parsedWord = null;

		int iterator = word.length() - 1;

		for (char c : word.toCharArray()) {
			VariableExpression letter = null;
			VariableExpression magnitude = new VariableExpression("magnitude");
			magnitude.store(Math.pow(10, iterator--));
			for (VariableExpression var : letters) {
				if (var.name().equals(""+c)) {
					letter = var;
					if (c == word.charAt(0)) {
						firstLetters.add(letter);
					}
				}
			}
			if (letter == null) {
				letter = new VariableExpression("" + c);
				letters.add(letter);
				numberOfLetters++;
				if(numberOfLetters>10) {
					throw new InvalidCryptarithmException();
				}
				if (c == word.charAt(0)) {
					firstLetters.add(letter);
				}
			}
			parsedLetter = new GeneralExpression(new Multiplication(), letter, magnitude);

			if (parsedWord == null) {
				parsedWord = parsedLetter;
			} else {
				parsedWord = new GeneralExpression(new Addition(), parsedWord, parsedLetter);
			}
		}
		return parsedWord;
	}
	
	/*
	 * 
	 * /** Find solutions to the cryptarithm
	 * 
	 * @return a list of all possible solutions to the given cryptarithm. A solution
	 * is a map that provides the value for each alphabet in the cryptarithm.
	 */

	public List<Map<Character, Integer>> solve() throws NoSolutionException {
		List<Map<Character, Integer>> result = new ArrayList<Map<Character, Integer>>();
		
		Set<Integer[]> digitSubset = Cryptarithm.generateSubsets(letters.size());
		for (Integer[] subset : digitSubset) {
			Permutation<Integer> permutation = new Permutation<Integer>(subset);
			Set<Integer[]> permutations = permutation.generateAllPermutations(permutation.getLength());
			for(Integer[] onePerm : permutations) {
				assign(onePerm);
				if (checkSol()) {
					result.add(generateMap(onePerm));
				}
			}
		}
		if(result.size()==0) {
			throw new NoSolutionException();
		}
		return result;
	}

	private void assign(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			letters.get(i).store(arr[i]);
		}
	}

	private Map<Character, Integer> generateMap(Integer[] values) {
		Map<Character, Integer> result = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < values.length; i++) {
			result.put(letters.get(i).name().charAt(0), values[i]);
		}
		return result;
	}

	/**
	 * Checks if a set of values for the different characters/variables is a valid solution to the cryptarithm
	 * @return true if solution is valid; false otherwise
	 */
	private boolean checkSol() {
		//first letters have to be non-zero and left hand side equal to right hand side
		if(noZero(firstLetters) && lhs.eval()==rhs.eval()) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a list of variables contains any zeroes
	 * @return false if the list contains one or more variables with the value zero; true otherwise
	 */
	private boolean noZero(List<VariableExpression> words) {
		for(VariableExpression var : words) {
			if(var.eval()==0) {
				return false;
			}
		}
		return true;
	}	

	/** I"M NOT SURE IF INTERPRETED THIS CORRECTLY
	 * Returns all the possible subsets of of size k
	 * @param k
	 * @return A set of integer arrays such that each array contains k
	 */
	private static Set<Integer[]> generateSubsets(int k) {
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
}