package com.ares.service.algorithms.binarytree;

/**
 * @author 0xZzzz
 */
public class BSTTest {

    public static void main(String[] args) {
        BST tree = new BST(55);
        tree.add(35);
        tree.add(25);
        tree.add(15);
        tree.add(45);
        tree.add(65);
        tree.add(75);
        tree.add(87);
        tree.add(98);
        tree.add(28);
        tree.add(68);
        tree.inOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();
        tree.preOrder();
        System.out.println();

        tree.printLeaves();
        System.out.println();
        System.out.println(tree.countLeaves());

        System.out.println(tree.contains(100));
    }

}
