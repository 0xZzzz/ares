package com.ares.service.algorithms.linkedlist;

/**
 * 查找链表的中值
 *
 * @author 0xZzzz
 */
public class FindMiddle {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        System.out.println(linkedList);
        System.out.println(findMiddle(linkedList));
    }

    public static String findMiddle(LinkedList linkedList) {
        LinkedList.Node middle = linkedList.head();
        // 用于遍历
        LinkedList.Node current = linkedList.head();
        int length = 0;
        while (current.next() != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.next();
            }
            current = current.next();
        }
        if (length % 2 == 1) {
            middle = middle.next();
        }
        return middle.data();
    }

}
