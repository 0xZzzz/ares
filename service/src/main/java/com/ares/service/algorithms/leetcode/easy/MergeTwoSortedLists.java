package com.ares.service.algorithms.leetcode.easy;

/**
 * leetcode 21
 *
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author  0xZzzz
 * @date 2020/5/1
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        solution1(l1, l2).print();
        solution2(l1, l2).print();
    }

    /**
     * 暴力解法
     *
     * 时间复杂度：O(n + m) ，其中 n 和 m 分别为两个链表的长度
     * 空间复杂度：O(1)
     */
    private static ListNode solution1(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        head.next = l1 != null ? l1 : l2;
        return dummyNode.next;
    }

    /**
     * 递归
     *
     * 时间复杂度：O(n + m)
     * 空间复杂度：：O(n + m)，其中 n 和 m 分别为两个链表的长度。递归调用需要消耗栈空间
     */
    private static ListNode solution2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = solution2(l1.next, l2);
            return l1;
        }
        l2.next = solution2(l1, l2.next);
        return l2;
    }

    static class ListNode {

        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        void print() {
            StringBuilder sb = new StringBuilder(String.valueOf(val));
            ListNode temp = next;
            while (temp != null) {
                sb.append(" --> ").append(temp.val);
                temp = temp.next;
            }
            System.out.println(sb);
        }

    }

}
