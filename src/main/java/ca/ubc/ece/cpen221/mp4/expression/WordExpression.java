package ca.ubc.ece.cpen221.mp4.expression;

import java.util.*;

public class WordExpression implements Expression{
	private List<VariableExpression> letters;
	private int size;
	private String word;
	
	public WordExpression(String word, Map<Character, VariableExpression> map) {
		this.word = word;
		this.size = word.length();
		this.letters = new ArrayList<VariableExpression>();
		for(int i = 0; i < word.length(); i++) {
			letters.add(map.get(word.charAt(i)));
		}
	}
	
	public List<VariableExpression> getLetters(){
		return letters;
	}
	
	public double eval() {
		double result = 0;
		for(int i = 0; i < size; i++) {
			result += Math.pow(10, size-i-1)*letters.get(i).eval();
		}
		return result;
	}
	
	@Override
	public String toString() {
		return word;
	}
}
