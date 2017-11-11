package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.avltree.AvlTreeSet;
import ca.ubc.ece.cpen221.mp4.avltree.AvlTreeSet;

public class AVLTreeTest {
	@Test
	public void test1() {
		AvlTreeSet tree = new AvlTreeSet();
		assertEquals(0, tree.size());
	}
	
	@Test
	public void test2() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		assertEquals(3, tree.size());
	}
	
	@Test
	public void test3() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(1);
		assertEquals(1, tree.size());
	}
	
	@Test
	public void test4() {
		AvlTreeSet tree = new AvlTreeSet();
		assertEquals(false, tree.contains(-1));
		tree.insert(-1);
		assertEquals(true, tree.contains(-1));
	}
	
	@Test
	public void test5() {
		AvlTreeSet tree = new AvlTreeSet();
		assertEquals(true, tree.isEmpty());
		tree.insert(1);
		assertEquals(false, tree.isEmpty());
		tree.remove(1);
		assertEquals(0, tree.size());
		assertEquals(true, tree.isEmpty());
	}
	
	@Test
	public void test6() {
		AvlTreeSet tree = new AvlTreeSet();
		assertEquals(0, tree.size());
		assertEquals(true, tree.isEmpty());
		tree.insert(1);
		assertEquals(false, tree.isEmpty());
		assertEquals(1, tree.size());
		tree.insert(1);
		assertEquals(false, tree.isEmpty());
		assertEquals(1, tree.size());
		tree.remove(1);
		assertEquals(0, tree.size());
		assertEquals(true, tree.isEmpty());
	}
	
	@Test
	public void test7() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(1);
		tree.insert(2);
		tree.insert(4);
		assertEquals(true, tree.contains(1));
		assertEquals(true, tree.contains(2));
		assertEquals(true, tree.contains(4));
		assertEquals(false, tree.contains(0));
		assertEquals(false, tree.contains(3));
		assertEquals(false, tree.contains(5));
	}
	
	@Test(expected = IllegalStateException.class)
	public void test8() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(1);
		tree.remove(0);
	}
	
	@Test
	public void test9() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(1);
		tree.insert(2);
		tree.insert(4);
		tree.remove(2);
		assertEquals(false, tree.contains(2));
	}
	
	@Test
	public void test10() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(4);
		tree.insert(3);
		tree.insert(5);
		tree.insert(7);
		assertEquals(true, tree.contains(7));
	}
	
	@Test
	public void test11() {
		AvlTreeSet tree = new AvlTreeSet();
		assertEquals(-1, tree.getHeight());
		tree.insert(4);
		assertEquals(0, tree.getHeight());
	}
	
	@Test
	public void test12() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(4);
		tree.insert(3);
		tree.insert(5);
		tree.insert(7);
		assertEquals(7, tree.getMax());
		assertEquals(3, tree.getMin());
		assertEquals(2, tree.getHeight());
		tree.remove(7);
		assertEquals(5, tree.getMax());
		assertEquals(1, tree.getHeight());
	}
	
	@Test
	public void test13() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(8);
		tree.insert(15);
		tree.insert(6);
		tree.insert(7);
		tree.insert(9);
		//TODO
		//change this
		System.out.println(tree);
	}
	
	/*Rotation test*/
	@Test
	public void test14() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(6);
		tree.insert(7);
		tree.insert(9);
		assertEquals(1, tree.getHeight());
		tree.insert(5);
		tree.insert(4);
		assertEquals(2, tree.getHeight());
	}
	
	@Test
	public void test15() {
		AvlTreeSet tree1 = new AvlTreeSet();
		tree1.insert(3);
		tree1.insert(1);
		tree1.insert(2);
		assertEquals(1, tree1.getHeight());
		AvlTreeSet tree2 = new AvlTreeSet();
		tree2.insert(1);
		tree2.insert(3);
		tree2.insert(2);
		assertEquals(1, tree1.getHeight());	
	}
	
	@Test (expected = IllegalStateException.class)
	public void test16() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.getMax();
	}
	
	@Test (expected = IllegalStateException.class)
	public void test17() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.getMin();
	}
	
	@Test
	public void test18() {
		AvlTreeSet tree = new AvlTreeSet();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.remove(2);
		assertEquals(2, tree.size());
		tree.insert(2);
		tree.remove(3);
		tree.remove(2);
		assertEquals(1, tree.size());
	}
}
