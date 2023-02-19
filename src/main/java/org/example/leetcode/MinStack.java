package org.example.leetcode;

import org.example.leetcode.util.ListNode;

import java.util.Stack;

public class MinStack {


    private void printStack(){
        System.out.println("\nStack: ");
        ListNode temp = top;
        while (temp != null){
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void printMinStack(){
        System.out.println("\nMin Stack: ");
        ListNode temp = minTop;
        while (temp != null){
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static void test1() {
        System.out.println(2147483647);

        System.out.println(Integer.MAX_VALUE);
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.printStack();
        minStack.printMinStack();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public static void main(String[] args) {
        test1();
//        "MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
        //[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        //-----
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println("Check 1: " + minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


//        minStack.printStack();
//        minStack.printMinStack();

        System.out.println("\n** completed **");
        minStack.printStack();
        minStack.printMinStack();


    }

    class ListNode {
         int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private int minValue = Integer.MAX_VALUE;
    ListNode top = null;
    ListNode minTop = null;

    public MinStack() {
        minValue = Integer.MAX_VALUE;
        top = null;
        minTop = null;
    }

    public void push(int val) {
        ListNode newNode = new ListNode(val);
        if(val <= minValue){
            minValue = val;
            ListNode newMin = new ListNode(val);
            if(minTop == null){
                minTop = newMin;
            }else{
                newMin.next = minTop;
                minTop = newMin;
            }
        }

        if(top == null) {
            top = newNode;

        }else {
            newNode.next = top;
            top = newNode;
        }
    }

    public void pop() {

        if(top != null) {
            if(top.val == minValue){
                ListNode newMin = minTop.next;
                if(newMin != null){
                    minValue = newMin.val;
                }
                minTop.next = null;
                minTop = newMin;
                if(newMin == null){
                    minValue = Integer.MAX_VALUE;
                }


            }
            ListNode newTop = top.next;
            top.next = null;
            top = newTop;

        }



    }

    public int top() {
        if(top != null)
            return top.val;

        return 0;
    }

    public int getMin() {
        return minValue;
    }




}
