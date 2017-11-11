package ca.ubc.ece.cpen221.mp4.cryptarithm;

import java.util.Scanner;

import ca.ubc.ece.cpen221.mp4.expression.Expression;

public class SolveCryptarithm {

	public static void main(String[] args) {
		// TODO implement this main method
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a cryptarithm");
		String expression = scanner.nextLine();
		String[] cryptos = expression.split(" ");
		try {
			Cryptarithm crypto = new Cryptarithm(cryptos);
			System.out.println(crypto.solve());
		} catch (InvalidCryptarithmException e) {
			System.out.println("Invalid input");
		}catch(NoSolutionException e) {
			System.out.println("No solution for the cryptorithm");
		}
	}
	
}
