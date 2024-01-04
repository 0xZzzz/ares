package com.ares.infrastructure.algo.binarytree;

/**
 * binary tree test
 *
 * @author 0xZzzz
 */
public class TestBinaryTree {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.print();
		bt.add(11);
		bt.add(1);
		bt.add(6);
		bt.add(4);
		bt.add(87);
		bt.add(33);
		bt.add(44);
		bt.print();
	}
}