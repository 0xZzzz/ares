package com.ares.service.algorithms.linkedlist;

/**
 * 反转测试
 *
 * @author 0xZzzz
 */
public class Reverse {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        System.out.println("LinkedList: " + linkedList);
        linkedList.reverse();
        System.out.println("after reverse: " + linkedList);
    }

}
