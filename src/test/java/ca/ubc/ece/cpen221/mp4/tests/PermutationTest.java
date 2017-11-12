package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.permutation.Permutation;

public class PermutationTest {
	@Test
	public void test0() {

		Integer[] arr = { 0, 1, 2 };
		Permutation<Integer> perms = new Permutation<Integer>(arr);
		assertEquals(3,perms.getLength());
		Set<Integer[]> allCombinations = perms.generateAllPermutations(perms.getLength());
		assertEquals(6, allCombinations.size());
		Integer[] oneComb= perms.getOnePermutation();
		assertEquals(3, oneComb.length);
	}
}
