package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.avltree.AvlTreeSet;

public class AVLTreeTest {
	@Test
	public void test1() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(1);
		assertEquals(1, tree.size());
	}
}
