package ca.ubc.ece.cpen221.mp4.cryptarithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	private NonVariableExpression lhs;
	private NonVariableExpression rhs;
	private List<VariableExpression> letters;

	/**
	 * Cryptarithm constructor
	 * 
	 * @param cryptarithm
	 *            where each element is a String that represents part of the
	 *            cryptarithm
	 */
	// ** CAN WE ASSUME THAT THEY PASS A VALID CRYPTARITHM?
	public Cryptarithm(String[] cryptarithm) {
		letters = new ArrayList<VariableExpression>();
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
		VariableExpression letter;
		VariableExpression magnitude = new VariableExpression("magnitude");
		NonVariableExpression parsedLetter;
		NonVariableExpression parsedWord = null;

		int iterator = word.length() - 1;

		for (char c : word.toCharArray()) {

			magnitude.store(Math.pow(10, iterator--));
			letter = new VariableExpression(String.valueOf(c));
			if (!letters.contains(letter)) {
				letters.add(letter);
			}
			//bug: *currently every letter in the same word has the same magnitude*
			//need to make a new copy of magnitude somehow... and use it for each parsedLetter
			parsedLetter = new NonVariableExpression(new Multiplication(), letter, magnitude);

			if (parsedWord == null) {
				parsedWord = parsedLetter;
			} else {
				parsedWord = new NonVariableExpression(new Addition(), parsedWord, parsedLetter);
			}
		}
		return parsedWord;
	}
	
	//test constructor
	public static void main(String[] args) {
		String[] crypto = {"SEND", "+", "MORE", "=" ,"MONEY"};
		@SuppressWarnings("unused")
		Cryptarithm parsedCrypto = new Cryptarithm(crypto);
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
		return null; // change this
	}

	// You will need more methods
}
