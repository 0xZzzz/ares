package com.ares.infrastructure.algo.lc.h;

/**
 * 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * <p>
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 *
 * @author fansheng
 * @date 2022/6/11
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        print(self(l1, 2));
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

    private static ListNode self(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = head;
            for (int i = 1; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) {
                pre.next = head;
                break;
            }
            ListNode next = tail.next;
            tail.next = null;
            pre.next = reverse(head);
            pre = head;
            head = next;
        }
        return hair.next;
    }

    private static ListNode reverse(ListNode l) {
        ListNode pre = null;
        while (l != null) {
            ListNode tmp = l;
            l = l.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
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
