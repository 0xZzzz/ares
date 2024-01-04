package com.ares.infrastructure.algo.lc.m;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * @author fansheng
 * @date 2022/6/11
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        print(self(n3));
    }

    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     */
    private static ListNode self(ListNode l) {
        if (l == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        tmp.next = l;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode n = tmp.next;
            ListNode nn = n.next;
            n.next = nn.next;
            nn.next = n;
            tmp.next = nn;
            tmp = n;
        }
        return head.next;
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
