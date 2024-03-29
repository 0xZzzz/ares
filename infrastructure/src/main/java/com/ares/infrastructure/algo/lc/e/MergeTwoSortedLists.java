package com.ares.infrastructure.algo.lc.e;

/**
 * 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * <p>
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * @author 0xZzzz
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

//        solution1(l1, l2).print();
//        solution2(l1, l2).print();
        self(l1, l2).print();
    }

    /**
     * 暴力解法
     * <p>
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
     * <p>
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

    /**
     * 时间复杂度：O(n + m) ，其中 n 和 m 分别为两个链表的长度
     * 空间复杂度：O(1)
     */
    private static ListNode self(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (list1 != null || list2 != null) {
            int v1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            int v2 = list2 == null ? Integer.MAX_VALUE : list2.val;
            if (v1 < v2) {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            }
        }
        return head.next;
    }

}
