package org.example.leetcode;

import org.example.leetcode.util.ListNode;

public class Q206ReverseLinkedList{

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;

        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        System.out.println("Input: ");
        printLL(head);

        System.out.println("Output: ");

        ListNode newHead = reverseList(head);
        printLL(newHead);



    }


    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode temp = head;
        ListNode next = temp.next;
        ListNode prev = null;

        while(temp.next != null){
            next = temp.next;
            temp.next= prev;
            prev = temp;
            temp = next;

        }
        temp.next = prev;
        head = temp;
        return head;


    }

    public static void printLL(ListNode head){

        while(head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }


}
