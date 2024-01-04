package com.ares.infrastructure.algo.linkedlist;

/**
 * 是否有循环
 *
 * @author 0xZzzz
 */
public class IsCyclic {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node node = new LinkedList.Node("2");
        linkedList.add("1");
        linkedList.add(node);
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add(node);
        // 这种链表不能这么调用，会无限递归
        //System.out.println("LinkedList: " + linkedList);
        System.out.println("is cyclic: " + linkedList.isCyclic());
    }

}
