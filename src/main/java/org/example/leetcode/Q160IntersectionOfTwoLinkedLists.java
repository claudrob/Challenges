package org.example.leetcode;

import org.example.leetcode.util.ListNode;

public class Q160IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

        int [] listA = {4,1,8,4,5};
        int [] listB = {5,6,1,8,4,5};

        ListNode headA = createList(listA);

        ListNode headB = createList(listB);

        ListNode inter = getIntersectionNode(headA, headB);

        if(inter != null)
        System.out.println("InterSection: " + inter.val);


    }


        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode intersection = null;
            ListNode tempA = headA;
            ListNode tempB = headB;

            while(tempA != null){

                tempB =headB;

                while(tempB != null){
                    if(tempA == tempB){
                        intersection = tempA;
                        return intersection;
                    }
                    tempB = tempB.next;

                }
                tempA = tempA.next;

            }
            return intersection;

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
