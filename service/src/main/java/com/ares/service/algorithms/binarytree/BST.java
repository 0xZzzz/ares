package com.ares.service.algorithms.binarytree;

import lombok.Data;

import java.util.Stack;

/**
 * Binary Search Tree
 *
 * @author 0xzzzz
 */
public class BST {

    private Node root;

    public BST(int data) {
        root = new Node(data);
    }

    public void add(int data) {
        root.addNode(data);
    }

    /**
     * O(1)
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * O(1)
     */
    public void clear() {
        root = null;
    }

    /**
     * O(n)
     */
    public int size() {
        Node current = root;
        int size = 0;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                size++;
                current = stack.pop();
                current = current.right;
            }
        }
        return size;
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        order(root, Order.IN);
    }

    /**
     * 先序遍历
     */
    public void preOrder() {
        order(root, Order.PRE);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        order(root, Order.POST);
    }

    /**
     * 遍历
     */
    private void order(Node node, Order order) {
        if (node == null) {
            return;
        }
        if (order == Order.PRE) {
            System.out.printf("%s ", node.data);
        }
        order(node.left, order);
        if (order == Order.IN) {
            System.out.printf("%s ", node.data);
        }
        order(node.right, order);
        if (order == Order.POST) {
            System.out.printf("%s ", node.data);
        }
    }

    /**
     * 遍历，不使用递归
     */
    private void orderWithoutRecursion(Order order) {
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            Node current = nodes.pop();
            if (order == Order.PRE) {
                System.out.printf("%s ", current.data);
            }
            if (current.right != null) {
                nodes.push(current.right);
            }
            if (order == Order.IN) {
                System.out.printf("%s ", current.data);
            }
            if (current.left != null) {
                nodes.push(current.left);
            }
            if (order == Order.POST) {
                System.out.printf("%s ", current.data);
            }
        }
    }

    /**
     * 遍历方式
     */
    private enum Order {
        /**
         * 前中后
         */
        PRE,
        IN,
        POST
    }

    @Data
    private static class Node {

        private int data;

        private Node left, right;

        private Node(int data) {
            this.data = data;
        }

        private void addNode(int data) {
            // 满足条件则代表该数据应放在当前节点左侧
            if (this.data > data) {
                // 如果当前节点左子树为空, 则创建该数据为当前节点的左子树
                if (this.left == null) {
                    this.left = new BST.Node(data);
                } else {
                    // 如果当前节点的左子树不为空，则继续判断该数据与当前节点左子树数据的关系
                    this.left.addNode(data);
                }
                // 满足条件则代表该数据应放在当前节点的右侧
            } else {
                // 如果当前节点的右子树为空, 则创建该数据为当前节点的右子树
                if (this.right == null) {
                    this.right = new BST.Node(data);
                } else {
                    // 如果当前节点的右子树不为空，则继续判断该数据与当前节点右子树的关系
                    this.right.addNode(data);
                }
            }
        }
    }

}
