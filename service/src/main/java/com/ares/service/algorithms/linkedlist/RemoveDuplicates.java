package com.ares.service.algorithms.linkedlist;

/**
 * 移除重复的元素
 *
 * @author 0xZzzz
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("2");
        linkedList.add("4");
        System.out.println("LinkedList: " + linkedList);
        linkedList.removeDuplicate();
        System.out.println("remove duplicates: " + linkedList);
    }

}
