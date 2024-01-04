package com.ares.infrastructure.algo.linkedlist;

import java.util.HashSet;

/**
 * 链表
 *
 * @author 0xZzzz
 */
public class LinkedList {

    private Node head;

    private Node tail;

    public void add(String data) {
        add(new Node(data));
    }

    public void add(Node node) {
        // first
        if (head == null) {
            head = node;
            tail = head;
            return;
        }
        tail.next = node;
        tail = tail.next;
    }

    public Node head() {
        return head;
    }

    public boolean isCyclic() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 反转，遍历将head指针移向最后一个节点，将所有节点的next节点指向前一个节点，即可完成反转
     */
    public void reverse() {
        Node pointer = head, previous = null, current;
        while (pointer != null) {
            current = pointer;
            pointer = pointer.next;
            // 反转
            current.next = previous;
            previous = current;
            head = current;
        }
    }

    private Node reverseRecursively(Node node) {
        Node newHead;
        // 到最后一个节点
        if (node.next == null) {
            return node;
        }
        newHead = reverseRecursively(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    /**
     * 使用递归将链表反转
     */
    public void reverseRecursively() {
        head = reverseRecursively(head);
    }

    /**
     * 链表长度
     */
    public int length() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next();
        }
        return count;
    }

    /**
     * 链表长度，递归
     */
    public int lengthRecursively() {
        return lengthRecursively(head);
    }

    private int lengthRecursively(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + lengthRecursively(current.next());
    }

    /**
     * 两次循环去重
     *
     * 时间复杂度：O(n^2)
     */
    public void removeDuplicates() {
        Node ptr1 = head, ptr2;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.data.equals(ptr2.next.data)) {
                    ptr2.next = ptr2.next.next;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    /**
     * Set去重
     *
     * 时间复杂度：平均为O(n)，假设哈希表访问时间平均为O(1)
     */
    public void removeDuplicate() {
        HashSet<String> hs = new HashSet<>();
        Node current = head;
        Node prev = head;
        while (current != null) {
            String curVal = current.data;
            if (hs.contains(curVal)) {
                prev.next = current.next;
            } else {
                hs.add(curVal);
                prev = current;
            }
            current = current.next;
        }
    }

    /**
     * 从最后一个节点向前拿到第n个节点的数据 使fast和slow之前相隔n，然后两者指针同时向后移动
     * 这样当fast移动到最后一个节点的时候slow的值就是我们需要的值
     * 时间复杂度：O(n)
     */
    public String getLastNode(int n) {
        Node fast = head;
        Node slow = head;
        int start = 1;
        while (fast.next != null) {
            fast = fast.next;
            start++;
            if (start > n) {
                slow = slow.next;
            }
        }
        return slow.data;
    }

    @Override
    public String toString() {
        if (head == null) {
            return null;
        }
        Node current = head;
        StringBuilder stringBuilder = new StringBuilder(head.data);
        while (current.next != null) {
            current = current.next;
            stringBuilder.append(" --> ").append(current.data);
        }
        return stringBuilder.toString();
    }

    public static class Node {

        private String data;

        private Node next;

        public Node(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public String data() {
            return data;
        }

        @Override
        public String toString() {
            return data;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Node && data.equals(((Node)obj).data);
        }
    }

}
