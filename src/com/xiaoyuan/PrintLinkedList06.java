/**
 * @Author: zhengjiayuan
 * @Date: 2019/1/4 12:38
 * @Version 1.0
 */
package com.xiaoyuan;

import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class PrintLinkedList06 {

    static class Node{
        public int key;
        public Node next;
        Node(int key, Node next){
            this.key = key;
            this.next = next;
        }
    }

    /**
     * 不修改链表 时间O(n) 空间O(n)
     * @param head
     */
    public static void printLinkedList1(Node head){
        if (head == null) return;
        Stack<Node> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        while(!stack.empty()){
            System.out.print(" " + stack.pop().key + " ");
        }
        System.out.println();
    }

    /**
     * 修改链表
     * @param head
     */
    public static void printLinkedList2(Node head){
        int length = 0;
        Node p1 = head, p2 = head.next;
        while (p1 != null) {
            length++;
            p1 = p1.next;
        }
        p1 = head;
        for (int i = length - 1 ; i >= 0; i++){
            head = head.next;
            while (p1.next != null){
                p1.next = p2.next;
                p2.next = p1;
                p2 = p1.next;
            }
            p1 = head;
            p2 = head.next;
        }
        p1 = head;
        while (p1 != null){
            System.out.print(" " + p1.key + " ");
            p1 = p1.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        printLinkedList1(head);
        printLinkedList1(new Node(1, null));
        printLinkedList1(null);
        printLinkedList2(head);
    }
}
