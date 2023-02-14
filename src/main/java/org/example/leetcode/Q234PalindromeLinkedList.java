package org.example.leetcode;

import org.example.leetcode.util.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q234PalindromeLinkedList {

    public static void main(String[] args) {
        int [] nums = {1,2,2,1};
//        int [] nums = {1,2};
        ListNode head = createList(nums);
        printLL(head);
        System.out.println("Is Palindrome: " + isPalindrome(head));

    }


    public static boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        Stack<Integer> stack = new Stack();
        Queue<Integer> queue = new LinkedList<>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp.val);
            queue.add(temp.val);
            temp = temp.next;
        }

        while(stack.size() > 0){
            int stackVal = stack.pop();
            int queueVal = queue.remove();
            if(stackVal != queueVal)
                return false;
        }
        return true;
    }

    public static void printLL(ListNode head){

        while(head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode createList(int [] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;

        for(int i = 1; i < nums.length; i++){
            ListNode newNode = new ListNode(nums[i]);
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }
}
