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
import ca.ubc.ece.cpen221.mp4.expression.NonVariableExpression;
import ca.ubc.ece.cpen221.mp4.expression.VariableExpression;
import ca.ubc.ece.cpen221.mp4.expression.WordExpression;
import ca.ubc.ece.cpen221.mp4.operator.*;
import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp4.permutation.Permutation;

import ca.ubc.ece.cpen221.mp4.expression.NonVariableExpression;
import ca.ubc.ece.cpen221.mp4.expression.VariableExpression;
import ca.ubc.ece.cpen221.mp4.operator.Addition;
import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp4.operator.Division;
import ca.ubc.ece.cpen221.mp4.operator.Multiplication;
import ca.ubc.ece.cpen221.mp4.operator.Subtraction;

/**
 * Cryptarithm - a datatype that represents a cryptarithm
 *
 */
public class Cryptarithm {
	/*
	 * private Map<Character, VariableExpression> variableExpressions; private
	 * Map<Integer, VariableExpression> variables; private List<WordExpression>
	 * wordsLeft; private List<WordExpression> wordsRight; private List<String>
	 * operatorsLeft; private List<String> operatorsRight;
	 * 
	 * private static final Set<String> operators = new
	 * LinkedHashSet<String>(Arrays.asList("+", "-", "*", "/"));
	 */
	private static final Set<Integer> digits = new LinkedHashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

	// left hand side and right hand side of the expression
	private NonVariableExpression lhs;
	private NonVariableExpression rhs;
	private List<VariableExpression> letters;
	private List<VariableExpression> firstLetters;

	/**
	 * Cryptarithm constructor
	 * 
	 * @param cryptarithm
	 *            where each element is a String that represents part of the
	 *            cryptarithm
	 */
	// ** CAN WE ASSUME THAT THEY PASS A VALID CRYPTARITHM?
	public Cryptarithm(String[] cryptarithm) {
		/*
		 * //<<<<<<< HEAD // TODO implement this constructor this.operatorsLeft = new
		 * ArrayList<String>(); this.operatorsRight = new ArrayList<String>();
		 * this.wordsLeft = new ArrayList<WordExpression>(); this.wordsRight = new
		 * ArrayList<WordExpression>(); this.variables = new LinkedHashMap<Integer,
		 * VariableExpression>(); this.variableExpressions = new
		 * LinkedHashMap<Character, VariableExpression>();
		 * 
		 * boolean equals = false; for (String word : cryptarithm) { if
		 * (word.equals("=")) { equals = true; } else { if (equals) { //TODO //change to
		 * mod 2 thin if (operators.contains(word)) { operatorsRight.add(word); } else {
		 * // wordsRight.add(word); for (int i = 0; i < word.length(); i++) {
		 * VariableExpression variable = new VariableExpression(word.charAt(i) + ""); if
		 * (!variables.containsValue(variable)) { variables.put(variables.size(),
		 * variable); variableExpressions.put(word.charAt(i), variable); } }
		 * wordsRight.add(new WordExpression(word, variableExpressions)); } } else { if
		 * (operators.contains(word)) { operatorsLeft.add(word); } else { //
		 * wordsLeft.add(word); for (int i = 0; i < word.length(); i++) {
		 * VariableExpression variable = new VariableExpression(word.charAt(i) + ""); if
		 * (!variables.containsValue(variable)) { variables.put(variables.size(),
		 * variable); variableExpressions.put(word.charAt(i), variable); } }
		 * wordsRight.add(new WordExpression(word, variableExpressions)); } } } }
		 * //=======
		 */
		letters = new ArrayList<VariableExpression>();
		firstLetters = new ArrayList<VariableExpression>();
		NonVariableExpression word;
		BinaryOperator op = null;

		for (int i = 0; cryptarithm[i] != "="; i++) {
			if (i % 2 == 0) {
				word = WordConstructor(cryptarithm[i]);
				if (op == null)
					lhs = word;
				else
					lhs = new NonVariableExpression(op, lhs, word);
			} else {
				op = (OperationConstructor(cryptarithm[i]));
			}
		}
		op = null;
		for (int i = cryptarithm.length - 1; cryptarithm[i] != "="; i--) {
			if (i % 2 == 0) {
				word = WordConstructor(cryptarithm[i]);
				if (op == null)
					rhs = word;
				else
					rhs = new NonVariableExpression(op, rhs, word);
			} else {
				op = (OperationConstructor(cryptarithm[i]));
			}
		}
		System.out.println("askldfj");
	}

	/**
	 * PARSES OPERATORS
	 * 
	 * @param s
	 *            a String representing a valid operator, +, -, *, \
	 * @return A BinaryOperator represented by the string
	 */
	private BinaryOperator OperationConstructor(String s) {
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
		// can use if we want to check for invalid operations
		// default: throw new NoSolutionException();
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
	private NonVariableExpression WordConstructor(String word) {
		// VariableExpression letter;
		// VariableExpression magnitude = new VariableExpression("magnitude");
		NonVariableExpression parsedLetter;
		NonVariableExpression parsedWord = null;

		int iterator = word.length() - 1;

		for (char c : word.toCharArray()) {
			VariableExpression letter = null;
			VariableExpression magnitude = new VariableExpression("magnitude");
			magnitude.store(Math.pow(10, iterator--));
			for (VariableExpression var : letters) {
				if (var.name().equals("" + c)) {
					letter = var;
				}
			}
			if (letter == null) {
				letter = new VariableExpression("" + c);
				letters.add(letter);
				if (c == word.charAt(0)) {
					firstLetters.add(letter);
				}
			}
			parsedLetter = new NonVariableExpression(new Multiplication(), letter, magnitude);

			if (parsedWord == null) {
				parsedWord = parsedLetter;
			} else {
				parsedWord = new NonVariableExpression(new Addition(), parsedWord, parsedLetter);
			}
		}
		// FIXED bug: *currently every letter in the same word has the same magnitude*
		// need to make a new copy of magnitude somehow... and use it for each
		// parsedLetter
		return parsedWord;
	}

	// test constructor
	public static void main(String[] args) throws NoSolutionException{
		String[] crypto = { "SEND", "+", "MORE", "=", "MONEY" };
		Cryptarithm parsedCrypto = new Cryptarithm(crypto);
		System.out.println(parsedCrypto.solve());
		String[] cr = {"A" ,"=","A"};
		Cryptarithm cr1 = new Cryptarithm(cr);
		System.out.println(cr1.solve());
	}
	/*
	 * 
	 * /** Find solutions to the cryptarithm
	 * 
	 * @return a list of all possible solutions to the given cryptarithm. A solution
	 * is a map that provides the value for each alphabet in the cryptarithm.
	 */

	public List<Map<Character, Integer>> solve() throws NoSolutionException {
		// TODO implement this method
		List<Map<Character, Integer>> result = new ArrayList<Map<Character, Integer>>();
		
		Set<Integer[]> digitSubset = Cryptarithm.generateSubsets(letters.size());
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
			letters.get(i).store(arr[i]);
		}
	}

	public Map<Character, Integer> generateMap(Integer[] values) {
		Map<Character, Integer> result = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < values.length; i++) {
			result.put(letters.get(i).name().charAt(0), values[i]);
		}
		return result;
	}

	private boolean checkSol() {
		if(lhs.eval()==rhs.eval()&&noZero(firstLetters)) {
			return true;
		}
		return false;
	}

	private boolean noZero(List<VariableExpression> words) {
		for(VariableExpression var : words) {
			if(var.eval()==0) {
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

	

	// You will need more methods
}