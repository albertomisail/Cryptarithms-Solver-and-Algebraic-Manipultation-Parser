package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.cryptarithm.Cryptarithm;
import ca.ubc.ece.cpen221.mp4.cryptarithm.InvalidCryptarithmException;
import ca.ubc.ece.cpen221.mp4.cryptarithm.NoSolutionException;

public class CryptarithmTest {
	@Test
	public void test0() throws InvalidCryptarithmException, NoSolutionException {
		String[] crypto1 = { "SEND", "+", "MORE", "=", "MONEY" };
		Cryptarithm parsedCrypto1 = new Cryptarithm(crypto1);
		List<Map<Character, Integer>> sol1 = parsedCrypto1.solve();
		System.out.println(sol1);

		String[] crypto2 = { "WINTER", "+", "IS", "+", "WINDIER", "+", "SUMMER", "+", "IS", "=", "SUNNIER" };
		Cryptarithm parsedCrypto2 = new Cryptarithm(crypto2);
		List<Map<Character, Integer>> sol2 = parsedCrypto2.solve();
		System.out.println(sol2);

		String[] crypto3 = { "NORTH", "/", "SOUTH", "=", "EAST", "/", "WEST" };
		Cryptarithm parsedCrypto3 = new Cryptarithm(crypto3);
		List<Map<Character, Integer>> sol3 = parsedCrypto3.solve();
		System.out.println(sol3);

		String[] crypto4 = { "JEDER", "+", "LIEBT", "=", "BERLIN" };
		Cryptarithm parsedCrypto4 = new Cryptarithm(crypto4);
		List<Map<Character, Integer>> sol4 = parsedCrypto4.solve();
		System.out.println(sol4);

		try {
			String[] crypto5 = { "I", "+", "CANT", "+", "GET", "=", "NO", "+", "SATISFACTION" };
			Cryptarithm parsedCrypto5 = new Cryptarithm(crypto5);
			List<Map<Character, Integer>> sol5 = parsedCrypto5.solve();
			System.out.println(sol5);
		} catch (NoSolutionException e) {
			System.out.println("Expected no solution");
		}
		
		String[] crypto6 = { "STOP", "-", "PAST", "=", "POST" };
		Cryptarithm parsedCrypto6 = new Cryptarithm(crypto6);
		List<Map<Character, Integer>> sol6 = parsedCrypto6.solve();
		System.out.println(sol6);
	}

	//tests various cases of invalid cryptarithms
	@Test
	public void test1() {
		Boolean invalid = false;
		try {
			String[] crypto1 = { "+" };
			Cryptarithm parsedCrypto1 = new Cryptarithm(crypto1);
		} catch (InvalidCryptarithmException e) {
			invalid = true;
		}
		try {
			String[] crypto2 = { "A", "=", "A", "+" };
			Cryptarithm parsedCrypto2 = new Cryptarithm(crypto2);
			invalid = false;
		} catch (InvalidCryptarithmException e) {
			invalid = true;
		}
		try {
			String[] crypto3 = { "ABCDEFGHIJKLMN", "=", "A" };
			Cryptarithm parsedCrypto3 = new Cryptarithm(crypto3);
			invalid = false;
		} catch (InvalidCryptarithmException e) {
			invalid = true;
		}
		try {
			String[] crypto4 = { "", "=", "A" };
			Cryptarithm parsedCrypto4 = new Cryptarithm(crypto4);
			invalid = false;
		} catch (InvalidCryptarithmException e) {
			invalid = true;
		}
		try {
			String[] crypto5 = { "A", "C", "B", "=", "A" };
			Cryptarithm parsedCrypto5 = new Cryptarithm(crypto5);
			invalid = false;
		} catch (InvalidCryptarithmException e) {
			invalid = true;
		}
		try {
			String[] crypto6 = { "", "=", "" };
			Cryptarithm parsedCrypto6 = new Cryptarithm(crypto6);
			invalid = false;
		} catch (InvalidCryptarithmException e) {
			invalid = true;
		}
		assertEquals(true, invalid);
	}

	@Test(expected = NoSolutionException.class)
	public void test2() throws NoSolutionException, InvalidCryptarithmException {
		String[] crypto = { "a", "*", "b", "*", "c", "=", "a", "/", "b", "/", "c" };
		Cryptarithm parsedCrypto = new Cryptarithm(crypto);
		parsedCrypto.solve();
	}
}