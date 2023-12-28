package com.ares.service.algorithms.lc.m;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * @author fansheng
 * @date 2022/6/2
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        print(self(n4, 2));
        print(algorithms1(n4, 1));
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

    /**
     * 双指针法：
     * 使用两个指针 first 和 second 同时对链表进行遍历，并且 first 比 second 超前 n 个节点。
     * 当 first 遍历到链表的末尾时，second 就恰好处于倒数第 n 个节点。
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     */
    private static ListNode algorithms1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     */
    private static ListNode self(ListNode head, int n) {
        ListNode c = head;
        int l = 1;
        while (c.next != null) {
            c = c.next;
            l++;
        }
        if (l == 1) {
            return null;
        }
        if (l == n) {
            return head.next;
        }
        c = head;
        int i = 1;
        while (c.next != null) {
            if (l - i == n) {
                c.next = c.next.next;
                break;
            }
            i++;
            c = c.next;
        }
        return head;
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
