package com.ares.service.algorithms.leetcode.easy;

/**
 * @author fansheng
 * @date 2020/3/26
 */
public class Demo3 {

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
