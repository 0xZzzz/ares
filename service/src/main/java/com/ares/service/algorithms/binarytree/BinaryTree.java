package com.ares.service.algorithms.binarytree;

/**
 * 二叉树实现
 */
public class BinaryTree {

    private Node root;

    public void add(int data) {
        if (this.root == null) {
            root = new Node(data);
        } else {
            root.addNode(data);
        }
    }

    public void print() {
        if (root != null) {
            root.printNode();
        } else {
            System.out.println("树是空的");
        }
    }

    private class Node {
        private int data;
        private Node left;
        private Node right;

        private Node(int data) {
            this.data = data;
        }

        /**
         * 添加节点
         *
         * @param data 要添加的数据
         */
        private void addNode(int data) {
            // 满足条件则代表该数据应放在当前节点左侧
            if (this.data > data) {
                // 如果当前节点左子树为空, 则创建该数据为当前节点的左子树
                if (this.left == null) {
                    this.left = new Node(data);
                } else {
                    // 如果当前节点的左子树不为空，则继续判断该数据与当前节点左子树数据的关系
                    this.left.addNode(data);
                }
            // 满足条件则代表该数据应放在当前节点的右侧
            } else {
                // 如果当前节点的右子树为空, 则创建该数据为当前节点的右子树
                if (this.right == null) {
                    this.right = new Node(data);
                } else {
                    // 如果当前节点的右子树不为空，则继续判断该数据与当前节点右子树的关系
                    this.right.addNode(data);
                }
            }
        }

        /**
         * 中序遍历(左中右)
         */
        private void printNode() {
            if (this.left != null) {
                this.left.printNode();
            }
            System.out.print(this.data + " ");
            if (this.right != null) {
                this.right.printNode();
            }
        }
    }
}
