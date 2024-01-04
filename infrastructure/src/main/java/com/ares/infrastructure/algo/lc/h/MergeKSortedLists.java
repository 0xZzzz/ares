package com.ares.infrastructure.algo.lc.h;

/**
 * 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * @author fansheng
 * @date 2022/6/11
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(5);
        print(self(l1, l2, l3));
    }

    private static void print(ListNode head) {
        if (head == null) {
            System.out.println("null");
        } else {
            StringBuilder sb = new StringBuilder().append(head.val);
            while (head.next != null) {
                head = head.next;
                sb.append(head.val);
            }
            System.out.println(sb);
        }
    }

    private static ListNode self(ListNode... lists) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        for (ListNode l : lists) {
            ListNode tmp;
            while (l != null) {
                tmp = l.next;
                append(head, l);
                l = tmp;
            }
        } 
        return head.next;
    }

    private static void append(ListNode l1, ListNode l2) {
        ListNode tmp = l1;
        while (true) {
            if (l2.val <= l1.val) {
                tmp.next = l2;
                l2.next = l1;
                return;
            }
            if (l1.next == null) {
                l1.next = l2;
                l2.next = null;
                return;
            }
            tmp = l1;
            l1 = l1.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
