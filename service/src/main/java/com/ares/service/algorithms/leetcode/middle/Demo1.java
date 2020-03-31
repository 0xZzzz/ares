package com.ares.service.algorithms.leetcode.middle;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author fansheng
 * @date 2020/3/26
 */
public class Demo1 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        algorithms(l1, l4);
    }

    /**
     * 时间复杂度 O(n) 空间复杂度 O(n)
     */
    private static void algorithms(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(0);
        ListNode l1 = n1, l2 = n2, curr = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        head.next.print();
    }

    /**
     * 链表节点
     */
    static class ListNode {
        /**
         * 值
         */
        int val;

        /**
         * 下个节点
         */
        ListNode next;

        ListNode(int x) { val = x; }

        void print() {
            StringBuilder str = new StringBuilder(String.valueOf(val)).append(" ");
            ListNode n = next;
            while (n != null) {
                str.append(String.valueOf(n.val)).append(" ");
                n = n.next;
            }
            System.out.println(str.toString());
        }

    }

}
